package cn.zx.tool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import cn.zx.pojo.CompanyBasic;
import cn.zx.pojo.CompanyPromotion;
import cn.zx.pojo.CompanyPromotionMsg;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyTask;
import cn.zx.service.impl.CompanyBasicServiceImpl;
import cn.zx.service.impl.CompanyPromotionMsgServiceImpl;
import cn.zx.service.impl.CompanyPromotionServiceImpl;
import cn.zx.service.impl.CompanyStafferServiceImpl;
import cn.zx.service.impl.CompanyTaskServiceImpl;

@Controller
public class ThrimTask {
	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("SpringConfig.xml");
	/*
	 * CompanyStafferServiceImpl
	 * companyStafferService=(CompanyStafferServiceImpl
	 * )context.getBean("billService");
	 */
	// 定时器
	public static void showTimer() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				ApplicationContext context = new ClassPathXmlApplicationContext(
						"SpringConfig.xml");
				CompanyStafferServiceImpl companyStafferService = (CompanyStafferServiceImpl) context
						.getBean("companyStafferService");
				CompanyBasicServiceImpl companyBasicService = (CompanyBasicServiceImpl) context
						.getBean("companyBasicService");
				CompanyPromotionServiceImpl companyPromotionService = (CompanyPromotionServiceImpl) context
						.getBean("companyPromotionService");
				CompanyPromotionMsgServiceImpl companyPromotionMsgService = (CompanyPromotionMsgServiceImpl) context
						.getBean("companyPromotionMsgService");
				CompanyTaskServiceImpl companyTaskService = (CompanyTaskServiceImpl) context
						.getBean("companyTaskService");

				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");// 时间转换

				// 第一步，先获取所有员工入职时间

				List<CompanyStaffer> listStaff = companyStafferService
						.selectHiredateByCompanyId();
				System.out.println(listStaff);
				if (listStaff != null) {
					for (int i = 0; i < listStaff.size(); i++) {
						CompanyStaffer staff = new CompanyStaffer();
						int period = 0;// 公司晋级周期
						Date date = new Date();// 当前日期

						Date hire_date = new Date();// 入职日期
						String next_date = null;// 下一晋级时间
						int day = 0;// 晋级周期据当前日期的天数
						int surplus = 0;// 据下一晋级周期时间

						// 实例化员工
						staff = listStaff.get(i);
						System.out.println("*****" + staff.getHire_date());
						// 获取公司晋级周期
						CompanyBasic companyBasic = companyBasicService
								.selectBasic(staff.getCompany_id());

						// 判断公司不是否开启投票通道
						if (companyBasic.getPeriod() == null
								|| companyBasic.getPeriod() == 99999) {
							break;
						} else {
							// 公司晋级周期
							period = companyBasic.getPeriod();
							// 员工入职日期
							hire_date = staff.getHire_date();

							// 计算公式

							// 计算入职日期跟当前日期的相差天数
							if (hire_date != null) {
								day = (int) ((date.getTime() - hire_date
										.getTime()) / (1000 * 3600 * 24));
							}

							// 计算距离下一晋级周期的天数
							surplus = period - (day % period);

							// 下一晋级周期时间
							date.setDate(date.getDate() + surplus);
							next_date = fmt.format(date);

							// 判断是否是当天
							if (next_date.equals(fmt.format(new Date())
									.toString())) {
								CompanyPromotion record = new CompanyPromotion();
								record.setCompany_id(staff.getCompany_id());
								record.setUser_id(staff.getUser_id());
								record.setCurrent_post_level(staff
										.getPostlevel());

								record.setCreate_time(date);
								record.setStatus(1);

								// 获取公司投票天数
								int days = companyBasic.getDays();
								date.setDate(date.getDate() + days);
								record.setEnd_time(date);

								companyPromotionService.insertSelective(record);

								// 查询任务表中有关系的
								List<CompanyTask> listTaskToID = companyTaskService
										.selectByObjID(staff.getUser_id());
								if (listTaskToID != null) {
									for (int j = 0; j < listTaskToID.size(); j++) {
										// 循环添加投票数据
										CompanyPromotionMsg companyPM = new CompanyPromotionMsg();
										companyPM.setCompany_id(staff
												.getCompany_id());
										companyPM.setUser_id(listTaskToID
												.get(j).getTo_user());
										companyPM.setPromotion_id(record
												.getPromotion_id());
										companyPM.setObj_user(staff
												.getUser_id());
										companyPM.setTitle("投票");
										companyPM.setStatus(1);
										companyPM.setCreate_time(new Date());
										companyPM.setEnd_time(date);
										companyPM.setIs_vote(0);

										companyPromotionMsgService
												.insertSelective(companyPM);
									}

									// companyPromotionService.updateByPrimaryKeySelective(record);
								}

							}

						}
					}
				}

				List<CompanyPromotion> listPromotion = companyPromotionService
						.selectByPrimaryCompanyId(null, null,null,null);
				for (int j = 0; j < listPromotion.size(); j++) {

					CompanyPromotion record = listPromotion.get(j);
					// 把结束日期转成时间戳
					String endTime = fmt.format(listPromotion.get(j)
							.getEnd_time());
					if (endTime.equals(fmt.format(new Date()).toString())) {
						record.setStatus(0);
						// 查询总数
						List<CompanyPromotionMsg> listPV = companyPromotionMsgService
								.selectVote();
						// 查询同意总数
						List<CompanyPromotionMsg> listPA = companyPromotionMsgService
								.selectAgree();
						// 查询拒绝总数
						List<CompanyPromotionMsg> listPF = companyPromotionMsgService
								.selectFirm();

						for (int i = 0; i < listPV.size(); i++) {
							if (listPV.get(i).getPromotion_id() == record
									.getPromotion_id()) {
								record.setSum(listPV.get(i).getCount());
							}
						}
						for (int i = 0; i < listPA.size(); i++) {
							if (listPA.get(i).getPromotion_id() == record
									.getPromotion_id()) {
								record.setAgree(listPV.get(i).getCount());
							}
						}
						for (int i = 0; i < listPF.size(); i++) {
							if (listPF.get(i).getPromotion_id() == record
									.getPromotion_id()) {
								record.setOppose(listPV.get(i).getCount());
							}
						}
						companyPromotionService
								.updateByPrimaryKeySelective(record);
					}
				}
			}
		};
		// 设置执行时间
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);// 每天
		// 定制每天的21:09:00执行，
		calendar.set(year, month, day, 02, 00, 00);
		Date date = calendar.getTime();
		Timer timer = new Timer();
		System.out.println(date);

		int period = 2 * 1000;
		// 每天的date时刻执行task，每隔2秒重复执行
		// timer.schedule(task, date, period);
		// 每天的date时刻执行task, 仅执行一次
		timer.schedule(task, date);

	}
}
