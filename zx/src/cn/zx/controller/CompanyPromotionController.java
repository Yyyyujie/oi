package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyPost;
import cn.zx.pojo.CompanyPromotion;
import cn.zx.pojo.CompanyPromotionMsg;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyDepartServiceImpl;
import cn.zx.service.impl.CompanyPostServiceImpl;
import cn.zx.service.impl.CompanyPromotionMsgServiceImpl;
import cn.zx.service.impl.CompanyPromotionServiceImpl;
import cn.zx.service.impl.CompanyStafferServiceImpl;
import cn.zx.service.impl.CompanyTaskServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/staff")
public class CompanyPromotionController {
	@Autowired
	CompanyPromotionServiceImpl companyPromotionService;
	@Autowired
	CompanyStafferServiceImpl companyStafferService;
	@Autowired
	CompanyDepartServiceImpl companyDepartService;
	@Autowired
	CompanyPostServiceImpl companyPostService;
	@Autowired
	CompanyTaskServiceImpl companyTaskService;
	@Autowired
	CompanyPromotionMsgServiceImpl companyPromotionMsgService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 跳转到晋级页面
	 * @return
	 */
	@RequestMapping("/selectPromotion.html")
	public String selectPromotion(){
		return "staff/yj-promotion";
		
	}
	/**
	 * 查询投票信息
	 * @param companyID
	 * @return
	 */
	@RequestMapping("/selectPromotion.do")
	@ResponseBody
	public Object selectPromotion(Integer limit,Integer pager,HttpSession session){
		List<CompanyPromotion> listP=new ArrayList<CompanyPromotion>();
		List<CompanyPromotionMsg> listPM=new ArrayList<CompanyPromotionMsg>();
		List<CompanyPromotion> list=new ArrayList<CompanyPromotion>();
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		
		//根据登录者公司ID获取所有被投票员工
		listP=companyPromotionService.selectByPrimaryCompanyId(null,companyStaffer.getCompany_id(),pager-1,limit);
		
		
		//循环
		if(listP !=null || listP.size()>=0){
			for (int i = 0; i < listP.size(); i++) {	
				//判断是否有关系
				listPM=companyPromotionMsgService.selectPMByuid(companyStaffer.getUser_id(), listP.get(i).getPromotion_id());
				for (int j = 0; j < listPM.size(); j++) {
					Date date=new Date();
					int day=(int) ((listP.get(i).getEnd_time().getTime() - date.getTime()) / (1000*3600*24))+1;
					if(companyStaffer.getUser_id()==listPM.get(j).getUser_id() && day>0){
						list.add(listP.get(i));
					}
				}
				
			}
		}
		
		return JSONArray.toJSON(list);
		
	}
	
	//跳转到投票页面
	@RequestMapping("/staffVote.html")
	public String staffVote(String id,HttpSession session,HttpServletRequest request){
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		List<CompanyPromotion> list=new ArrayList<CompanyPromotion>();
		
		list=companyPromotionService.selectByPrimaryCompanyId(Integer.parseInt(id),null,null,null);
		request.setAttribute("promotion", list.get(0));
		
		
		//查询剩余几天
		int day=0;
		Date date=new Date();
		day=(int) ((list.get(0).getEnd_time().getTime() - date.getTime()) / (1000*3600*24))+1;
		if(day <=0){
			request.setAttribute("day", "已过期");
		}else{
			request.setAttribute("day", "剩余"+day+"天");
		}
		
		
		//获取员工信息
		CompanyStaffer staff=companyStafferService.selectStafferByUserId(list.get(0).getUser_id());
		if(staff == null){
			request.setAttribute("depart", "部门");
			request.setAttribute("post", "职系");
		}else{
			//获取部门信息
			List<CompanyDepart> listDepart=companyDepartService.selectDeptName(staff.getDepart(), null);
			if(listDepart == null){
				request.setAttribute("depart", "部门");
			}else{
				request.setAttribute("depart", listDepart.get(0));
				//获取职系表
				List<CompanyPost>  listPost=companyPostService.selectPost(staff.getPost(), null);
				if(listPost == null){
					request.setAttribute("post", "职系");
				}else{
					request.setAttribute("post", listPost.get(0));
				}			
			}
		}
		
		//判断是否存在数据
		if(list !=null){
			for (int i = 0; i < list.size(); i++) {
				//查询是否投过票
				List<CompanyPromotionMsg> listPM=companyPromotionMsgService.selectPMByuid(companyStaffer.getUser_id(),list.get(i).getPromotion_id());
				
				//如果投过或者没数据返回no
				if(listPM !=null && listPM.size() !=0){
					for (int j = 0; j < listPM.size(); j++) {
						if(listPM.get(i).getUpdate_time() !=null){
							request.setAttribute("isVote", "no");
						}else{
							request.setAttribute("isVote", "ok");
						}		
					}							
				}else{
					request.setAttribute("isVote", "no");
				}
			}
		}
		
		
		//个人完成
		CompanyTask complete=companyTaskService.selectStafferComplete(staff.getUser_id(),null);
		request.setAttribute("complete", complete);		
		//个人进行
		CompanyTask receive=companyTaskService.selectStafferReceive(staff.getUser_id(),null);
		request.setAttribute("receive", receive);	
		//个人接收
		CompanyTask carry=companyTaskService.selectStafferCarry(staff.getUser_id(),null);
		request.setAttribute("carry", carry);	
		//个人接收总数
		CompanyTask count=companyTaskService.selectStafferCount(staff.getUser_id(),null);
		request.setAttribute("count", count);	
		
		//查询工作质量跟工作效率
		CompanyStaffer conCompanyStaffer = companyStafferService.selectStaffByDepartAndPost(staff.getUser_id(),companyStaffer.getCompany_id());
		request.setAttribute("conCompanyStaffer", conCompanyStaffer);
		
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyTask");
		log.setTable_remarks("公司投票表");
		log.setData_id(list.get(0).getPromotion_id());
		log.setUid(companyStaffer.getUser_id());
		log.setuName(companyStaffer.getRealname());
		log.setOperate("查询投票表");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(3);
					
		logService.insertSelective(log);
				//添加日志结束
		
		return "/staff/oi_staff_vote";
		
	}
	
	
	
	
}
