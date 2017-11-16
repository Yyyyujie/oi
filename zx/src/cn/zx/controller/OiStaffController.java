package cn.zx.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.message.SendMessage;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsExample;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.EmailMessage;
import cn.zx.pojo.Log;
import cn.zx.pojo.SmsMessage;
import cn.zx.pojo.StaffTaskLog;
import cn.zx.pojo.StaffTaskLogExample;
import cn.zx.pojo.WechatSetting;
import cn.zx.pojo.WechatTemporary;
import cn.zx.pojo.WechatTmpl;
import cn.zx.pojo.WechatTmplExample;
import cn.zx.service.CompanyDepartService;
import cn.zx.service.CompanyNewsService;
import cn.zx.service.CompanyStafferService;
import cn.zx.service.CompanyTaskService;
import cn.zx.service.StaffTaskLogService;
import cn.zx.service.WechatSettingService;
import cn.zx.service.WechatTemporaryService;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.service.impl.WechatTmplServiceImpl;
import cn.zx.templateMessage.TemplateMessageData;
import cn.zx.tool.CookieUtil;
import cn.zx.tool.EmainTool;
import cn.zx.tool.MD5Tool;
import cn.zx.tool.Msg;
import cn.zx.tool.ObtainIp;
import cn.zx.tool.SmsTool;
import cn.zx.util.MainWechat;
import cn.zx.util.MatrixToImageWriter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

@RequestMapping(value = "/staff")
@Controller
public class OiStaffController {
	@Autowired
	CompanyTaskService companyTaskService;
	@Autowired
	CompanyDepartService companyDepartService;
	@Autowired
	CompanyStafferService companyStafferService;
	@Autowired
	StaffTaskLogService staffTaskLogService;
	@Autowired
	CompanyNewsService companyNewsService;
	@Autowired
	WechatTemporaryService wechatTemporaryService;
	@Autowired
	WechatSettingService wechatService;
	@Autowired
	WechatTmplServiceImpl wechatTmplService;
	@Autowired
	LogServiceImpl logService;
	
	private static int redom;

	/**
	 * 催办模版
	 * @param task
	 * @param request
	 * @return
	 */
	public boolean pushWeChatTmpl2(CompanyTask task,HttpServletRequest request){
		Integer to_user = task.getTo_user();
		Integer user_id = task.getUser_id();
		CompanyStaffer to_userstaff = companyStafferService.selectByPrimaryKey(to_user);
		CompanyStaffer user_idstaff = companyStafferService.selectByPrimaryKey(user_id);
		Integer company_id = to_userstaff.getCompany_id();
		WechatTmplExample example=new WechatTmplExample();
		cn.zx.pojo.WechatTmplExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(company_id).andTypeEqualTo("task_urge").andTitleEqualTo("任务催办");
		List<WechatTmpl> WechatTmpls = wechatTmplService.selectWechatTmplByCidAndType(example);
		if(WechatTmpls.size()>0){
			WechatTmpl wechatTmpl = WechatTmpls.get(0);
			
			String requestURL = request.getRequestURL().toString();
			System.out.println(requestURL);
			requestURL=requestURL.substring(0,requestURL.lastIndexOf("/"));
			requestURL=requestURL.substring(0,requestURL.lastIndexOf("/")+1);
			System.out.println(requestURL);
			String url=requestURL+"Newstaff/tmplLogin?tid="+task.getTask_id();
			System.out.println(url);
			Date date=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Map<String, TemplateMessageData> dateMap = new HashMap<String, TemplateMessageData>();
			
			dateMap.put("first",new TemplateMessageData("任务催办"));
			dateMap.put("keyword1",new TemplateMessageData(task.getTask_title()));
			dateMap.put("keyword2",new TemplateMessageData(user_idstaff.getRealname()));
			dateMap.put("keyword3", new TemplateMessageData(formatter.format(date)));
			dateMap.put("keyword4", new TemplateMessageData(user_idstaff.getRealname()));
			dateMap.put("keyword5", new TemplateMessageData(null));
			dateMap.put("remark",new TemplateMessageData("提醒你尽快完成任务"));
			SendMessage.sendTpl(to_userstaff.getOpen_id(), wechatTmpl.getTemplate_id(),url, dateMap,company_id);
		return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 提醒模版
	 * @param task
	 * @param request
	 * @return
	 */
	public boolean pushWeChatTmpl1(CompanyTask task,HttpServletRequest request){
		Integer to_user = task.getTo_user();
		Integer user_id = task.getUser_id();
		CompanyStaffer to_userstaff = companyStafferService.selectByPrimaryKey(to_user);
		CompanyStaffer user_idstaff = companyStafferService.selectByPrimaryKey(user_id);
		Integer company_id = to_userstaff.getCompany_id();
		WechatTmplExample example=new WechatTmplExample();
		cn.zx.pojo.WechatTmplExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(company_id).andTypeEqualTo("task_new").andTitleEqualTo("任务提醒");
		List<WechatTmpl> WechatTmpls = wechatTmplService.selectWechatTmplByCidAndType(example);
		if(WechatTmpls.size()>0){
			WechatTmpl wechatTmpl = WechatTmpls.get(0);
			
			String requestURL = request.getRequestURL().toString();
			System.out.println(requestURL);
			requestURL=requestURL.substring(0,requestURL.lastIndexOf("/"));
			requestURL=requestURL.substring(0,requestURL.lastIndexOf("/")+1);
			System.out.println(requestURL);
			String url=requestURL+"Newstaff/tmplLogin?tid="+task.getTask_id();
			System.out.println(url);
			Date date=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Map<String, TemplateMessageData> dateMap = new HashMap<String, TemplateMessageData>();
			
			dateMap.put("first",new TemplateMessageData("任务提醒"));
			dateMap.put("keyword1",new TemplateMessageData(task.getTask_title()));
			dateMap.put("keyword2",new TemplateMessageData(user_idstaff.getRealname()));
			dateMap.put("keyword3", new TemplateMessageData(formatter.format(date)));
			dateMap.put("keyword4", new TemplateMessageData(user_idstaff.getRealname()));
			dateMap.put("keyword5", new TemplateMessageData(null));
			dateMap.put("remark",new TemplateMessageData("提醒你尽快接受任务"));
			SendMessage.sendTpl(to_userstaff.getOpen_id(), wechatTmpl.getTemplate_id(),url, dateMap,company_id);
		return true;
		}else{
			return false;
		}
	}
	
	
	//微信模板BySuper
			@RequestMapping(value="/tmpl")
			@ResponseBody
			public Msg tmpl(Integer tmplId,HttpSession session,Integer task_id,HttpServletRequest request){
				System.out.println(tmplId);
				CompanyTask task = companyTaskService.selectTaskByTaskId(task_id);
				try {
				if(tmplId==1){
					boolean pushWeChatTmpl1 = pushWeChatTmpl1(task, request);
					System.out.println(pushWeChatTmpl1);
				}
				if(tmplId==2){
					boolean pushWeChatTmpl2 = pushWeChatTmpl2(task, request);
					System.out.println(pushWeChatTmpl2);
				}
				return Msg.success();
				} catch (Exception e) {
					e.printStackTrace();
				return Msg.fail();
				}
				
			}
	
	
	//跳转手机页面
			@RequestMapping(value = "/yj-edit.html")
			public String staffphone(HttpServletRequest request,HttpSession session) throws ParseException {
				CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
				
				CompanyStaffer conCompanyStaffer = companyStafferService.selectStaffByDepartAndPost(companyStaff.getUser_id(),null);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date currenttime=new Date();
				Date reg_time= companyStaff.getReg_time();
				
				long day=0;
				Date beginDate;
				Date endDate;
				beginDate = format.parse(format.format(reg_time));
				endDate= format.parse(format.format(currenttime));    
				day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
				request.setAttribute("longtime",day);
				request.setAttribute("conCompanyStaffer", conCompanyStaffer);
				
				//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyStaffer");
				log.setTable_remarks("公司员工表");
				log.setData_id(companyStaff.getUser_id());
				log.setUid(companyStaff.getUser_id());
				log.setuName(companyStaff.getRealname());
				log.setOperate("手机登陆");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(3);
					
				logService.insertSelective(log);
				//添加日志结束
				
				return "staff/yj-edit";
			}
		
		/**
		 * 跳转到个人数据中
		 * @param id
		 * @return
		 */
		@RequestMapping("/getStafferByID.html")
		public String getStafferByID(int id,HttpServletRequest request){			
			CompanyStaffer staff= companyStafferService.selectStaffByDepartAndPost(id,null);
			request.setAttribute("staff", staff);
			
			
			return "/staff/yj-particulars";
		}
		
		//跳转邮箱页面
				@RequestMapping(value = "/yj-editem.html")
				public String staffemail(HttpServletRequest request,HttpSession session) throws ParseException {
					CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
					CompanyStaffer conCompanyStaffer = companyStafferService.selectStaffByDepartAndPost(companyStaff.getUser_id(),companyStaff.getCompany_id());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date currenttime=new Date();
					Date reg_time= companyStaff.getReg_time();
					
					long day=0;
					Date beginDate;
					Date endDate;
					beginDate = format.parse(format.format(reg_time));
					endDate= format.parse(format.format(currenttime));    
					day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
					request.setAttribute("longtime",day);
					request.setAttribute("conCompanyStaffer", conCompanyStaffer);
					
					//添加日志开始
					ObtainIp obtainIp=new ObtainIp();
					Log log=new Log();
					log.setTableName("CompanyStaffer");
					log.setTable_remarks("公司员工表");
					log.setData_id(conCompanyStaffer.getUser_id());
					log.setUid(companyStaff.getUser_id());
					log.setuName(companyStaff.getRealname());
					log.setOperate("查看邮箱");
					log.setCreateDate(new Date());
					log.setCreateIP(obtainIp.getIpAddr(request));
					log.setCharact(3);
						
					logService.insertSelective(log);
					//添加日志结束
					
					return "staff/yj-editem";
				}
				
				
				// 跳转手机号
				@RequestMapping(value = "/yj-edit-phone.html")
				public String staffUpdatephone() {
					return "staff/yj-edit-phone";
				}
				
				// 发送手机验证码
				@RequestMapping(value ="/sendStaffPhone.do")
				@ResponseBody
				public Object sendStaffPhone(String phone,HttpSession session) {
					SmsTool smsTool=new SmsTool();
					SmsMessage sms=new SmsMessage();			
					int random=(int)((Math.random()*9+1)*100000);
					
					this.setRedom(random);
					
					sms.setUid("yxm123");
					sms.setKey("034fefeef2b8acfd58bf");
					sms.setSmsmob(phone);
					sms.setSmtext(String.valueOf(random));
					String result=smsTool.sendSMS(sms);
							
					return JSONArray.toJSON(result);
				}
				
				// 修改手机号
				@RequestMapping(value ="/sendStaffPhone.html")
				public String sendStaffPhone(String phone,String code
				,HttpSession session,HttpServletRequest request) {
					CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
					List<CompanyStaffer> list=new ArrayList<CompanyStaffer>();
					
					int row=0;
					if(this.redom==Integer.parseInt(code)){
						companyStaff.setPhone(phone);
						list.add(companyStaff);
						row=companyStafferService.updateByPrimaryKeySelective(list);
						//添加日志开始
						ObtainIp obtainIp=new ObtainIp();
						Log log=new Log();
						log.setTableName("CompanyStaffer");
						log.setTable_remarks("公司员工表");
						log.setData_id(companyStaff.getUser_id());
						log.setUid(companyStaff.getUser_id());
						log.setuName(companyStaff.getRealname());
						log.setOperate("修改手机");
						log.setCreateDate(new Date());
						log.setCreateIP(obtainIp.getIpAddr(request));
						log.setCharact(3);
							
						logService.insertSelective(log);
						//添加日志结束
					}else{
						return "staff/yj-edit-phone";
					}
							
					if(row==1){
						return "redirect: /staff/yj-edit-phone.html";
					}else{
						return "staff/yj-edit-phone";
					}				
				}	
				
				// 跳转邮箱号
				@RequestMapping(value = "/yj-edit-email.html")
				public String staffUpdateemail() {
					return "staff/yj-edit-email";
				}
				// 发送邮箱验证码
				@RequestMapping(value ="/sendStaffEmail.do")
				@ResponseBody
				public Object sendStaffEmail(String email,HttpSession session) {
					EmailMessage send=new EmailMessage();
					EmainTool emailSend=new EmainTool();
					CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
					int random=(int)((Math.random()*9+1)*100000);
					this.setRedom(random);
					send.setEmail_smtp_host("smtp.163.com");//服务器地址
					send.setSend_mail("修改邮箱");//发件人
					send.setEmail_account("18295894749@163.com");//发件人邮箱
					send.setEmail_password("asd123");//发件人密码
					send.setContent(String.valueOf(random));//正文
					send.setRec_mail(companyStaff.getRealname());//收件人
					send.setRec_mail_account(email);//收件人邮箱			
					send.setSubject("修改邮箱验证码");//主题
					
					String result="";
					try {
						result=emailSend.createMimeMessage(send);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return JSONArray.toJSON(result);
				}			
				
				// 修改邮箱验证码
				@RequestMapping(value ="/sendStaffEmail.html")
				public String sendStaffEmail(String email,String code
						,HttpSession session,HttpServletRequest request) {
					CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
					List<CompanyStaffer> list=new ArrayList<CompanyStaffer>();
					int row=0;
					if(this.redom==Integer.parseInt(code)){
						
						companyStaff.setEmail(email);
						list.add(companyStaff);
						row=companyStafferService.updateByPrimaryKeySelective(list);
						//添加日志开始
						ObtainIp obtainIp=new ObtainIp();
						Log log=new Log();
						log.setTableName(companyStaff.toString());
						log.setTable_remarks("公司员工表");
						log.setData_id(companyStaff.getUser_id());
						log.setUid(companyStaff.getUser_id());
						log.setuName(companyStaff.getRealname());
						log.setOperate("修改邮箱");
						log.setCreateDate(new Date());
						log.setCreateIP(obtainIp.getIpAddr(request));
						log.setCharact(3);
							
						logService.insertSelective(log);
						//添加日志结束
					}else{
						return "staff/yj-edit-email";
					}
					
					if(row==1){
						return "redirect:/staff/yj-editem.html";
					}else{
						return "staff/yj-edit-email";
					}				
				}		
				
				//跳转修改密码页面
				/**
				 * 跳转到修改密码页
				 * @return
				 */
				@RequestMapping(value = "/yj-setold.html")
				public String updatePWD() {
			          return "staff/yj-setold";
				}						
				/**
				 * 修改密码时查询密码是否正确
				 * @param password
				 * @param session
				 * @return
				 */
				@RequestMapping(value ="/checkPassword.do")
				@ResponseBody
				public Object checkPassword(String password,HttpSession session) {
					CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
					CompanyStaffer staffer=companyStafferService.selectStafferByUserId(companyStaff.getUser_id());
					MD5Tool md5=new MD5Tool();
					boolean flag=false;
					if(password !=null &&  !password.equals("")){
						flag=staffer.getSf_password().equals(md5.MD5(password));
					}
					return JSONArray.toJSON(flag);
				}
				/**
				 * 修改密码
				 * @param sf_password
				 * @param session
				 * @return
				 */
				@RequestMapping(value ="/updatePassword.html")
				public String sf_clk_changePswd(String pass,HttpSession session) {
					CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
					MD5Tool md5=new MD5Tool();
					int row=0;
					if(pass != null && !pass.equals("")){
						row=companyStafferService.updatePWDByuseID(companyStaff.getUser_id(),md5.MD5(pass));
					}
					
					if(row >0){
						session.invalidate();
						return "redirect: /zx/WeChatLogin/go";
					}else{
						return "redirect: /staff/yj-setold.html";
					}				
				}
				
				// 跳转个人中心
				@RequestMapping(value = "/yj-member.html")
				public String redirectStaffInfo(HttpServletRequest request,HttpSession session) throws ParseException {
					CompanyStaffer conCompanyStaffer= (CompanyStaffer) session.getAttribute("companyStaffer");
					
					CompanyStaffer companyStaff = companyStafferService.selectStaffByDepartAndPost(conCompanyStaffer.getUser_id(),null);
					
					
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date currenttime=new Date();
					Date reg_time= companyStaff.getReg_time();
					long day=0;
					Date beginDate;
					Date endDate;
					beginDate = format.parse(format.format(reg_time));
					endDate= format.parse(format.format(currenttime));    
					day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
					request.setAttribute("longtime",day);
					request.setAttribute("conCompanyStaffer", companyStaff);
					
					//添加日志开始
					ObtainIp obtainIp=new ObtainIp();
					Log log=new Log();
					log.setTableName("CompanyStaffer");
					log.setTable_remarks("公司员工表");
					log.setData_id(companyStaff.getUser_id());
					log.setUid(companyStaff.getUser_id());
					log.setuName(companyStaff.getRealname());
					log.setOperate("查询个人中心");
					log.setCreateDate(new Date());
					log.setCreateIP(obtainIp.getIpAddr(request));
					log.setCharact(3);
						
					logService.insertSelective(log);
					//添加日志结束
					return "staff/yj-member";
				}	
				
				
				// 跳转通讯录
				@RequestMapping(value = "/yj-tongxun.html")
				public String redirectContact(HttpServletRequest request,HttpSession session) throws ParseException {
					CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
					CompanyStaffer conCompanyStaffer = companyStafferService.selectStaffByDepartAndPost(companyStaff.getUser_id(),companyStaff.getCompany_id());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date currenttime=new Date();
					Date reg_time= companyStaff.getReg_time();
					long day=0;
					Date beginDate;
					Date endDate;
					beginDate = format.parse(format.format(reg_time));
					endDate= format.parse(format.format(currenttime));    
					day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
					request.setAttribute("longtime",day);
					request.setAttribute("conCompanyStaffer", conCompanyStaffer);
					
					//添加日志开始
					ObtainIp obtainIp=new ObtainIp();
					Log log=new Log();
					log.setTableName("CompanyStaffer");
					log.setTable_remarks("公司员工表");
					log.setData_id(companyStaff.getUser_id());
					log.setUid(companyStaff.getUser_id());
					log.setuName(companyStaff.getRealname());
					log.setOperate("查询通讯录");
					log.setCreateDate(new Date());
					log.setCreateIP(obtainIp.getIpAddr(request));
					log.setCharact(3);
						
					logService.insertSelective(log);
					//添加日志结束
					return "staff/yj-tongxun";
				}		
				
				
				//跳转到安全
				@RequestMapping(value = "/yj-zhanghao.html")
				public String redirectStaffsafety(HttpServletRequest request,HttpSession session) throws ParseException {
					CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
					CompanyStaffer conCompanyStaffer = companyStafferService.selectStaffByDepartAndPost(companyStaff.getUser_id(),companyStaff.getCompany_id());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date currenttime=new Date();
					Date reg_time= companyStaff.getReg_time();
					
					long day=0;
					Date beginDate;
					Date endDate;
					beginDate = format.parse(format.format(reg_time));
					endDate= format.parse(format.format(currenttime));    
					day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
					request.setAttribute("longtime",day);
					request.setAttribute("conCompanyStaffer", conCompanyStaffer);
					//添加日志开始
					ObtainIp obtainIp=new ObtainIp();
					Log log=new Log();
					log.setTableName("CompanyStaffer");
					log.setTable_remarks("公司员工表");
					log.setData_id(companyStaff.getUser_id());
					log.setUid(companyStaff.getUser_id());
					log.setuName(companyStaff.getRealname());
					log.setOperate("跳转到安全页面");
					log.setCreateDate(new Date());
					log.setCreateIP(obtainIp.getIpAddr(request));
					log.setCharact(3);
						
					logService.insertSelective(log);
					//添加日志结束
					return "staff/yj-zhanghao";
				}			
				
				
	// 跳转发布任务
	@RequestMapping(value = "/oi_staff_publish.html")
	public String redirectAddTask(HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		String currentTime = sdf.format(new Date());
		request.setAttribute("currentTime", currentTime);
		return "staff/oi_staff_publish";
	}

	
	// 我接收的任务
	@RequestMapping(value = "/oi_staff_task_center.html")
	public String redirectSelectAllToUserTask() {
		return "staff/oi_staff_task_center";
	}

	// 根据公司ID查询公司部门
	@RequestMapping(value = "/oi_sf_branch.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectDepartByCompanyId(HttpSession session,HttpServletRequest request) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		cn.zx.pojo.CompanyDepartExample example = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		example.setOrderByClause("o");

		List<CompanyDepart> companyDeparts = companyDepartService.selectDepartByCompanyId(example);
		
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyDeparts");
		log.setTable_remarks("公司部门表");
		log.setData_id(companyStaffer.getUser_id());
		log.setUid(companyStaffer.getUser_id());
		log.setuName(companyStaffer.getRealname());
		log.setOperate("查询部门信息");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(3);
			
		logService.insertSelective(log);
		//添加日志结束
		
		return JSONArray.toJSONString(companyDeparts);
	}

	// 根据公司ID和部门ID查询员工
	@RequestMapping(value = "/oi_sf_branch_staff.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectStaffByCompanyIdAndDepartId(String selData,
			HttpSession session,HttpServletRequest request) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		cn.zx.pojo.CompanyStafferExample example = new CompanyStafferExample();
		cn.zx.pojo.CompanyStafferExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompanyIdEqualTo(companyStaffer.getCompany_id());
		createCriteria.andDepartEqualTo(Integer.parseInt(selData));

		List<CompanyStaffer> companyStaffers = companyStafferService.selectStaffByCompanyIdAndDepartId(example);
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyStaffers");
				log.setTable_remarks("公司部门表");
				log.setData_id(companyStaffer.getUser_id());
				log.setUid(companyStaffer.getUser_id());
				log.setuName(companyStaffer.getRealname());
				log.setOperate("根据公司ID和部门ID查询员工");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(3);
					
				logService.insertSelective(log);
				//添加日志结束
		
		return JSONArray.toJSONString(companyStaffers);
	}

	// 发布任务
	@RequestMapping(value = "/addTask.html", method = RequestMethod.POST)
	public String staffAddTask(String task_title, String to_user, String task_end_time, String task_urgent,
			String task_important, String task_content, HttpServletRequest request,HttpSession session) throws ParseException {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		Date end_time = sdf.parse(task_end_time);
		CompanyTask companyTask = new CompanyTask();
		companyTask.setCompany_id(companyStaffer.getCompany_id());
		companyTask.setUser_id(companyStaffer.getUser_id());
		companyTask.setTo_user(Integer.parseInt(to_user));
		companyTask.setTask_title(task_title);
		companyTask.setTask_end_time(end_time);
		companyTask.setTask_start_time(new Date());
		companyTask.setTask_status(5);
		companyTask.setTask_progress(0);
		companyTask.setTask_urgent(Integer.parseInt(task_urgent));
		companyTask.setTask_important(Integer.parseInt(task_important));
		companyTask.setTask_content(task_content);
		boolean flag = companyTaskService.staffAddTask(companyTask);
		
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyTask");
		log.setTable_remarks("公司任务表");
		log.setData_id(companyStaffer.getUser_id());
		log.setUid(companyStaffer.getUser_id());
		log.setuName(companyStaffer.getRealname());
		log.setOperate("根据公司ID和部门ID查询员工");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(3);
			
		logService.insertSelective(log);
		//添加日志结束
		if (flag) {
			return "staff/oi_staff_task_center";
		} else {
			String currentTime = sdf.format(new Date());
			request.setAttribute("currentTime", currentTime);
			return "staff/oi_staff_publish";
		}
	}

	// 查询当前员工的所有任务
	@RequestMapping(value = "/selectAllTaskByToUserId.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectAllTaskByToUserId(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTo_userEqualTo(companyStaffer.getUser_id());
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());// 公司ID
		example.setOrderByClause("task_start_time");

		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);*/
		
		List<CompanyTask> companyTasks = companyTaskService.selectTaskByUserId(companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// 查询当前员工发布的所有任务
	@RequestMapping(value = "/selectAllTaskByUserId.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectAllTaskByUserId(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUser_idEqualTo(companyStaffer.getUser_id());
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());// 公司ID
		example.setOrderByClause("task_start_time");

		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByUserId(example);*/
		List<CompanyTask> companyTasks = companyTaskService.selectTaskByToUser(companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// 接受任务用户查询详细内容
	@RequestMapping(value = "/oi_staff_tsk_detailToUser.html")
	public String selectTaskByTaskIdToUser(@RequestParam(required = false) String task_id,
			@RequestParam(required = false) String task_status, HttpServletRequest request) {
		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(Integer.parseInt(task_id));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式

		cn.zx.pojo.StaffTaskLogExample example = new StaffTaskLogExample();
		cn.zx.pojo.StaffTaskLogExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTask_idEqualTo(Integer.parseInt(task_id));
		example.setOrderByClause("sub_time");

		List<StaffTaskLog> staffTaskLogs = staffTaskLogService.selectTaskLogByTaskId(example);

		if (Integer.parseInt(task_status) == 1 || Integer.parseInt(task_status) == 2
				|| Integer.parseInt(task_status) == 3 || Integer.parseInt(task_status) == 5 || Integer.parseInt(task_status) == 6) {
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("task_start_time", startTime);
			request.setAttribute("task_end_time", endTime);
			request.setAttribute("staffTaskLogs", staffTaskLogs);
			return "staff/oi_staff_tsk_detail";
		} else {
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());
			// 格式化日期
			String currentTime = sdf.format(new Date());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("currentTime", currentTime);
			request.setAttribute("task_id", task_id);
			request.setAttribute("staffTaskLogs", staffTaskLogs);
			request.setAttribute("task_start_time", startTime);
			request.setAttribute("task_end_time", endTime);
			return "staff/oi_staff_edit";
		}

	}

	// 根据发布人查看任务详情
	@RequestMapping(value = "/oi_staff_tsk_detailUser.html")
	public String selectTaskByTaskIdUser(@RequestParam(required = false) String task_id,
			@RequestParam(required = false) String task_status, HttpServletRequest request) {
		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(Integer.parseInt(task_id));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式

		if (Integer.parseInt(task_status) == 3) {
			String currentTime = sdf.format(new Date());
			request.setAttribute("companyTask", companyTask);
			request.setAttribute("currentTime", currentTime);
			return "staff/oi_staff_transpond";
		} else {
			// 格式化日期
			String startTime = sdf.format(companyTask.getTask_start_time());
			String endTime = sdf.format(companyTask.getTask_end_time());

			request.setAttribute("companyTask", companyTask);
			request.setAttribute("task_start_time", startTime);
			request.setAttribute("task_end_time", endTime);
			/* request.setAttribute("staffTaskLogs",staffTaskLogs); */
			return "staff/oi_staff_tsk_detail";
		}

	}

	// 加载日志
	@RequestMapping(value = "/selectTaskLogByTaskId.json", method = RequestMethod.POST)
	@ResponseBody
	public String selectTaskLogByTaskId(String task_id) {
		cn.zx.pojo.StaffTaskLogExample example = new StaffTaskLogExample();
		cn.zx.pojo.StaffTaskLogExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTask_idEqualTo(Integer.parseInt(task_id));
		example.setOrderByClause("sub_time");

		List<StaffTaskLog> staffTaskLogs = staffTaskLogService.selectTaskLogByTaskId(example);
		return JSONArray.toJSONStringWithDateFormat(staffTaskLogs, "yyyy-MM-dd HH:mm");
	}

	// 修改任务状态
	@RequestMapping(value = "/oi_staff_edit.html")
	public String updateTaskStatus(String task_id, String task_status,
			HttpSession session,HttpServletRequest request) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(Integer.parseInt(task_id));
		if (Integer.parseInt(task_status) == 5) {
			companyTask.setTask_status(4);
		}
		boolean flag = companyTaskService.updateTaskStatus(companyTask);
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyTask");
				log.setTable_remarks("公司任务表");
				log.setData_id(companyTask.getTask_id());
				log.setUid(companyStaffer.getUser_id());
				log.setuName(companyStaffer.getRealname());
				log.setOperate("根据任务ID修改任务状态");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(3);
					
				logService.insertSelective(log);
				//添加日志结束
		if (flag) {
			return "staff/oi_staff_task_center";
		} else {
			return "";
		}

	}
	
	//取消任务
	@RequestMapping(value = "/oi_staff_cancel.json",method=RequestMethod.POST)
	@ResponseBody
	public boolean cancelTask(String task_id,
			HttpSession session,HttpServletRequest request) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(Integer.parseInt(task_id));
		companyTask.setTask_status(1);
		boolean flag = companyTaskService.updateTaskStatus(companyTask);
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyTask");
		log.setTable_remarks("公司任务表");
		log.setData_id(companyTask.getTask_id());
		log.setUid(companyStaffer.getUser_id());
		log.setuName(companyStaffer.getRealname());
		log.setOperate("取消任务");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(3);
			
		logService.insertSelective(log);
		//添加日志结束
		return flag;

	}
	
	// 退回任务和拒绝退回任务
	@RequestMapping(value = "/oi_staff_return.html")
	public String returnTask(@RequestParam(required = false) String task_id,
			@RequestParam(required = false) String task_status, @RequestParam(required = false) String task_reasion,
			@RequestParam(required = false) String task_reback_reasion,
			HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyTask companyTask = new CompanyTask();
		companyTask.setTask_id(Integer.parseInt(task_id));
		if (Integer.parseInt(task_status) == 5 || Integer.parseInt(task_status) == 4) {
			String task_del_reasion = new String(task_reasion.getBytes("ISO8859-1"), "UTF-8");
			companyTask.setTask_del_reasion(task_del_reasion);
			companyTask.setTask_status(3);
		} else if (Integer.parseInt(task_status) == 3) {
			String reback_reasion = new String(task_reback_reasion.getBytes("ISO8859-1"), "UTF-8");
			companyTask.setTask_reback_reasion(reback_reasion);
			companyTask.setTask_status(5);
			;
		}
		boolean flag = companyTaskService.returnTask(companyTask);
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyTask");
				log.setTable_remarks("公司任务表");
				log.setData_id(companyTask.getTask_id());
				log.setUid(companyStaffer.getUser_id());
				log.setuName(companyStaffer.getRealname());
				log.setOperate("退回任务和拒绝退回任务");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(3);
					
				logService.insertSelective(log);
				//添加日志结束
		if (flag) {
			return "staff/oi_staff_task_center";
		} else {
			return "";
		}

	}

	// 编辑任务进度
	@RequestMapping(value = "/updateTaskProgress.html", method = RequestMethod.POST)
	public String updateTaskProgress(String task_id, String task_progress, 
			String nod_desc,
			HttpSession session,
			HttpServletRequest request) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyTask companyTask = new CompanyTask();
		if (Integer.parseInt(task_progress) == 100) {
			companyTask.setTask_status(6);
		}
		companyTask.setTask_id(Integer.parseInt(task_id));
		companyTask.setTask_progress(Integer.parseInt(task_progress));
		StaffTaskLog staffTaskLog = new StaffTaskLog();
		staffTaskLog.setCompany_id(1);
		staffTaskLog.setTask_id(Integer.parseInt(task_id));
		staffTaskLog.setTask_progress(Integer.parseInt(task_progress));
		staffTaskLog.setNod_desc(nod_desc);
		staffTaskLog.setSub_time(new Date());

		boolean flag = companyTaskService.updateTaskProgress(companyTask);
		boolean flag1 = staffTaskLogService.addTaskProgressLog(staffTaskLog);
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyTask");
		log.setTable_remarks("公司任务表");
		log.setData_id(companyTask.getTask_id());
		log.setUid(companyStaffer.getUser_id());
		log.setuName(companyStaffer.getRealname());
		log.setOperate("编辑任务进度");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(3);
			
		logService.insertSelective(log);
		//添加日志结束
		if (flag == true && flag1 == true) {
			return "staff/oi_staff_task_center";
		} else {
			return "";
		}
	}
	
	//跳转评价任务
	@RequestMapping(value="/oi_staff_evaluate.html")
	public String redirectEvaluateTask(String task_id,String to_user,HttpSession session,HttpServletRequest request) throws ParseException{
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyTask companyTask = companyTaskService.selectTaskByTaskId(Integer.parseInt(task_id));
		CompanyStaffer  companyStaffer1 =companyStafferService.selectStaffByDepartAndPost(Integer.parseInt(to_user),companyStaffer.getCompany_id());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currenttime=new Date();
		Date reg_time= companyStaffer1.getReg_time();
		
		long day=0;
		Date beginDate;
		Date endDate;
		beginDate = format.parse(format.format(reg_time));
		endDate= format.parse(format.format(currenttime));    
		day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
		request.setAttribute("longtime",day);
		request.setAttribute("companyTask", companyTask);
		request.setAttribute("companyStaffer1", companyStaffer1);
		return "staff/oi_staff_evaluate";
	}
	
	//评价任务
	@RequestMapping(value="evaluateTask.do",method=RequestMethod.POST)
	public String evaluateTask(CompanyTask companyTask,
			HttpSession session,HttpServletRequest request){
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		companyTask.setTask_status(2);
		boolean flag = companyTaskService.updateTaskStatus(companyTask);
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyTask");
				log.setTable_remarks("公司任务表");
				log.setData_id(companyTask.getTask_id());
				log.setUid(companyStaffer.getUser_id());
				log.setuName(companyStaffer.getRealname());
				log.setOperate("评价任务");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(3);
					
				logService.insertSelective(log);
				//添加日志结束
		if(flag){
			return "staff/oi_staff_task_center";
		}else{
			return "";
		}
	}

	// 转发任务
	@RequestMapping(value = "/oi_staff_transpond.html", method = RequestMethod.POST)
	public String updateToUser(CompanyTask companyTask, String end_time,
			HttpSession session,HttpServletRequest request) throws ParseException {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置日期格式
		Date task_end_time = sdf.parse(end_time);
		companyTask.setTask_end_time(task_end_time);
		companyTask.setTask_status(5);
		boolean flag = companyTaskService.updateToUser(companyTask);
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyTask");
		log.setTable_remarks("公司任务表");
		log.setData_id(companyTask.getTask_id());
		log.setUid(companyStaffer.getUser_id());
		log.setuName(companyStaffer.getRealname());
		log.setOperate("转发任务");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(3);
			
		logService.insertSelective(log);
		//添加日志结束
		if (flag) {
			return "staff/oi_staff_task_center";
		} else {
			return "";
		}
	}

	// 查询接收任务职员待办任务
	@RequestMapping(value = "/selectAllToDOTaskByToUser.json")
	@ResponseBody
	public String selectAllToDOTaskByToUser(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria.andTo_userEqualTo(companyStaffer.getUser_id());
		createCriteria.andTask_statusBetween(4, 5);
		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);*/
		List<CompanyTask> companyTasks = companyTaskService.selectToDOTaskByToUser(companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// 查询职员待办任务
	@RequestMapping(value = "/selectAllToDOTaskByUserId.json")
	@ResponseBody
	public String selectAllToDOTaskByUserId(HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
/*		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria.andUser_idEqualTo(companyStaffer.getUser_id());
		createCriteria.andTask_statusBetween(3,5);

		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);*/
		List<CompanyTask> companyTasks = companyTaskService.selectToDOTaskByUserId(companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		for (int i = 0; i < companyTasks.size(); i++) {
			System.out.println(companyTasks.get(i).getRealname());
		}
		return JSONArray.toJSONStringWithDateFormat(companyTasks, "yyyy-MM-dd HH:mm");
	}

	// =========================================================================

	// 职员修改邮箱地址
	@RequestMapping(value = "/staffUpdateEmailOrPhone.json")
	@ResponseBody
	public boolean staffUpdateEmail(@RequestParam(required = false) String email,
			@RequestParam(required = false) String phone,HttpSession session,HttpServletRequest request) {
		CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyStaffer companyStaffer = new CompanyStaffer();
		companyStaffer.setUser_id(companyStaff.getUser_id());
		if (email != null) {
			companyStaffer.setEmail(email);
		}
		if (phone != null) {
			companyStaffer.setPhone(phone);
		}
		boolean flag = companyStafferService.staffUpdateEmailOrTelphone(companyStaffer);
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("companyStaffer");
				log.setTable_remarks("公司员工表");
				log.setData_id(companyStaffer.getUser_id());
				log.setUid(companyStaffer.getUser_id());
				log.setuName(companyStaffer.getRealname());
				log.setOperate("修改邮箱地址");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(3);
					
				logService.insertSelective(log);
				//添加日志结束
		return flag;
	}

	// 根据公司Id查询所有职员

	// 跳转消息中心
	@RequestMapping(value = "/oi_staff_msg.html")
	public String redirectStaffMsg() {
		return "staff/oi_staff_msg";
	}

	// 跳转统计
	@RequestMapping(value = "/oi_staff_data_center.html")
	public String redirectStaffDataCenter() {
		return "staff/oi_staff_data_center";
	}
	
	//企业公告信息
	@RequestMapping(value="/selectCompanyNews")
	@ResponseBody
	public Object selectCompanyNews(HttpSession session){
		CompanyStaffer companyStaffer= (CompanyStaffer) session.getAttribute("companyStaffer");
		List<CompanyNews> listNews1=companyNewsService.selectNews(null, companyStaffer.getCompany_id(),0);
		List<CompanyNews> listNews2=companyNewsService.selectNews(null, companyStaffer.getCompany_id(),companyStaffer.getUser_id());
		
		List<CompanyNews> listNews=new ArrayList<CompanyNews>();
		
		//循环添加有关的公告
		if(listNews1 !=null){
			for (int i = 0; i < listNews1.size(); i++) {
				listNews.add(listNews1.get(i));
			}
		}
		if(listNews2 !=null){
			for (int i = 0; i < listNews2.size(); i++) {
				listNews.add(listNews2.get(i));
			}
		}
		
		JSONObject json = new JSONObject();
		
		
		/*JSONArray.toJSONStringWithDateFormat(listNews,"yyyy-MM-dd");*/
		
		json.put("listNews", JSONArray.toJSON(listNews));
		return json;
	}
	
	//查询企业信息
	@RequestMapping("selectCompanyNewsID.html")
	public String selectCompanyNewsID(String id,HttpSession session,
			HttpServletRequest request){
		CompanyStaffer companyStaffer= (CompanyStaffer) session.getAttribute("companyStaffer");
		List<CompanyNews> listNews=companyNewsService.selectNews(Integer.parseInt(id), null,null);
		System.out.println(listNews);
		request.setAttribute("companyNews", listNews.get(0));
		
		
		
		//添加浏览量
		if(listNews !=null){
			List<CompanyNews> list=new ArrayList<CompanyNews>();
			CompanyNews news=listNews.get(0);
			news.setPageView(news.getPageView()+1);
			if(news.getViews() == null){
				news.setViews(companyStaffer.getUser_id()+",");
			}else{
				System.out.println("------->"+news.getViews());
				System.out.println("------->"+companyStaffer.getUser_id());
				news.setViews(news.getViews()+companyStaffer.getUser_id()+",");
			}
			list.add(news);
			companyNewsService.updateByPrimaryKeySelective(list);
		}	
		
		return "/staff/oi_staff_newsid";
		
	}
	
	
	
	//查询所有信息条数
	@RequestMapping(value="selectNewsCount.json",method=RequestMethod.POST)
	@ResponseBody
	public int selectNewsCount(HttpSession session){
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		cn.zx.pojo.CompanyTaskExample example = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria.andTo_userEqualTo(companyStaffer.getUser_id());
		createCriteria.andTask_statusBetween(4, 5);
		List<CompanyTask> companyTasks = companyTaskService.selectAllTaskByToUserId(example);
		
		
		cn.zx.pojo.CompanyTaskExample example1 = new CompanyTaskExample();
		cn.zx.pojo.CompanyTaskExample.Criteria createCriteria1 = example1.createCriteria();
		createCriteria1.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria1.andUser_idEqualTo(companyStaffer.getUser_id());
		createCriteria1.andTask_statusBetween(3,5);

		List<CompanyTask> companyTasks1 = companyTaskService.selectAllTaskByToUserId(example1);
		
		cn.zx.pojo.CompanyNewsExample example2 = new CompanyNewsExample();
		cn.zx.pojo.CompanyNewsExample.Criteria createCriteria2 = example2.createCriteria();
		createCriteria2.andCompany_idEqualTo(companyStaffer.getCompany_id());
		List<CompanyNews> companyNews = companyNewsService.selectAllCompanyNewsByCompanyId(example2);
		
		int TaskByToUserIdCount=companyTasks.size();
		int TaskByToUserId=companyTasks1.size();
		int CompanyNewsByCompanyIdCount=companyNews.size();
		
		int allNewsCount = TaskByToUserIdCount+TaskByToUserId+CompanyNewsByCompanyIdCount;
		return allNewsCount;
	}
	
	
	//根据公司Id查询所有人
	@RequestMapping(value="/selectStaffByCompanyId",method=RequestMethod.POST)
	@ResponseBody
	public String selectStaffByCompanyId(HttpSession session){
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		List<CompanyStaffer> companyStaffers = companyStafferService.selectStaffByCompanyId(companyStaffer.getCompany_id());
		return JSONArray.toJSONString(companyStaffers);
	}
	
	//微信模板
		
		/*@RequestMapping(value="/tmpl")
		@ResponseBody
		public Msg tmpl(Integer tmplId,HttpSession session,Integer task_id){
			CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
			String Usename =companyStaffer.getRealname();
			CompanyTask companyTask = companyTaskService.selectTaskByTaskId(task_id);
			System.out.println(companyTask);
			System.out.println(companyTask.getTask_title());
			String title=companyTask.getTask_title();
			WechatTmpl tmpl =new WechatTmpl();
			
			Date date=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			
			if(tmplId==1){
				tmpl.setTitle("任务提醒");
	    		tmpl.setFirstdata("任务提醒");
	    		tmpl.setKeyword1(title);
	    		tmpl.setKeyword2(Usename);
	    		tmpl.setKeyword3(formatter.format(date));
	    		tmpl.setKeyword4(null);
	    		tmpl.setTmpl_id(tmplId);
	    		tmpl.setKeyword5(null);
	    		tmpl.setRemark("提醒你尽快接受任务");
	    		tmpl.setCreate_time(new Date());
	    		tmpl.setUpdate_time(new Date());
			}
			if(tmplId==2){
				tmpl.setTitle("任务催办");
	    		tmpl.setFirstdata("任务催办");
	    		tmpl.setKeyword1(title);
	    		tmpl.setKeyword2(Usename);
	    		tmpl.setKeyword3(formatter.format(date));
	    		tmpl.setKeyword4(null);
	    		tmpl.setTmpl_id(tmplId);
	    		tmpl.setKeyword5(null);
	    		tmpl.setRemark("提醒你尽快完成任务");
	    		tmpl.setCreate_time(new Date());
	    		tmpl.setUpdate_time(new Date());
			}



	    	int row=wechatTmplService.updateBywechatTmpl(tmpl);
	    	
			try {
				MainWechat m = new MainWechat();
				m.task(companyStaffer.getCompany_id(),companyTask.getTo_user(),tmplId);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
			
		}*/
	
	//根据任务状态查询任务  
	@RequestMapping(value="/selectTaskByTaskStatus.json",method=RequestMethod.POST)
	@ResponseBody
	public String selectTaskByTaskStatus(String type,String task_status,HttpSession session){
		
		System.out.println(type);
		System.out.println(task_status);
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");

		List<CompanyTask> companyTasks = null;
		if(Integer.parseInt(type)==1){
			
			 companyTasks = companyTaskService.selectTaskByStatusAndUserId(companyStaffer.getCompany_id(),companyStaffer.getUser_id(),Integer.parseInt(task_status));
		}else if(Integer.parseInt(type)==2){
			
			 companyTasks = companyTaskService.selectTaskByStatusAndToUserId(companyStaffer.getCompany_id(),companyStaffer.getUser_id(),Integer.parseInt(task_status));
		}
		
		return JSONArray.toJSONStringWithDateFormat(companyTasks,"yyyy-MM-dd HH:mm");
		
	}
	


	public static int getRedom() {
		return redom;
	}


	public static void setRedom(int redom) {
		OiStaffController.redom = redom;
	}
	
	@RequestMapping(value = "/regstaff")
	public String regstaff(HttpServletRequest request,HttpServletResponse response,@RequestParam("reg_id")Integer reg_id,
			@RequestParam("realname")String realname,@RequestParam("phone")String phone) {
		if(reg_id==null){
			//系统错误
			return "staff/404error";
		}else{
			try {
				WechatTemporary wechatTemporary = wechatTemporaryService.getWechatTemporary(reg_id);
				WechatSetting wechat = wechatService.selectWechat(wechatTemporary.getCompanyId());
				CompanyStaffer staffer=new CompanyStaffer();
				 staffer.setCompany_id(wechatTemporary.getCompanyId());
				   staffer.setSf_password(wechat.getPassword());
				   staffer.setAudit(0);
				   staffer.setStatus(1);
				   staffer.setRealname(realname);
				   staffer.setPhone(phone);
				   staffer.setOpen_id(wechatTemporary.getOpenId());
				   staffer.setHeader(wechatTemporary.getHeader());
				   staffer.setNickname(wechatTemporary.getNickname());
				   staffer.setReg_time(wechatTemporary.getRegTime());
				   staffer.setReg_ip(wechatTemporary.getRegIp());
				  companyStafferService.insertSelective(staffer);
				  CookieUtil cookieUtil=new CookieUtil();
				  cookieUtil.addCookie(response, "uid",staffer.getUser_id()+"", 365*24*60*60);
				 
				  return "staff/oi_checking";
			} catch (Exception e) {
				//系统错误
				return "staff/404error";
			}
		}
	}
	/**
	 * 二维码生成
	 * @param request
	 * @param session
	 * @throws ParseException
	 */




	// 跳转我的名片
		@RequestMapping(value = "/yj-mingp.html")
		public String redirectStaffBusCard(HttpServletRequest request,HttpSession session) throws ParseException {
			
			CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
			System.out.println("二维码生成");
			Integer User_id=companyStaff.getUser_id();
			String name = companyStaff.getRealname();
			String emali=companyStaff.getEmail();
			String tel=companyStaff.getPhone();
			String ORG=companyStaff.getCompany_name();
			String TITLE=companyStaff.getDept_name();
			
			try {
			 String content = "BEGIN:VCARD\n" +
			     		"VERSION:3.0\n" +
			     		"N:"+name+"\n" +
			     		"EMAIL:"+emali+"\n" +
			     		"TEL:"+tel+"\n" +
			     		"ADR:住址\n" +
			     		"ORG:" +
			     		""+ORG+"\n" +
			     		"TITLE:"+TITLE+"\n" +
			     		"URL:www.sxfs0351.com/zx/WeChatLogin/go\n" +
			     		"NOTE:请保存在通讯录\n" +
			     		"END:VCARD";
			 String path=System.getProperty("catalina.home")+"/webapps//statics/images/CreQcode/";
			        System.out.println(System.getProperty("catalina.home")  );
			System.out.println(path);
			     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
			     Map hints = new HashMap();
			     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			     BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400,hints);
			     File file1 = new File(path,User_id+".jpg"); 
			     MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file1);
			
		} catch (Exception e) {
		     e.printStackTrace();
		 }
			CompanyStaffer conCompanyStaffer = companyStafferService.selectStaffByDepartAndPost(companyStaff.getUser_id(),companyStaff.getCompany_id());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date currenttime=new Date();
			Date reg_time= companyStaff.getReg_time();
			long day=0;
			Date beginDate;
			Date endDate;
			beginDate = format.parse(format.format(reg_time));
			endDate= format.parse(format.format(currenttime));    
			day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000); 
			request.setAttribute("longtime",day);
			request.setAttribute("conCompanyStaffer", conCompanyStaffer);
			return "staff/yj-mingp";
		}
}