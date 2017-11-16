package cn.zx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyTaskServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/staffer")
public class OiStafferTaskController {
	@Autowired
	CompanyTaskServiceImpl companyTaskService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 个人统计
	 * @param session
	 * @return
	 */
	@RequestMapping("/stafferTaskPersonal.do")
	@ResponseBody
	public Object stafferTaskPersonal(HttpSession session,HttpServletRequest request){
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		//已完成
		CompanyTask accomplish=companyTaskService.selectStafferComplete(staffer.getUser_id(),staffer.getUser_id());
		//进行
		CompanyTask carry=companyTaskService.selectStafferCarry(staffer.getUser_id(),staffer.getUser_id());
		//待接收
		CompanyTask receive=companyTaskService.selectStafferReceive(staffer.getUser_id(),staffer.getUser_id());
		
		
		JSONObject json = new JSONObject();
		
		//已完成
		json.put("accomplish", JSONArray.toJSON(accomplish));
		//进行中
		json.put("carry", JSONArray.toJSON(carry));
		//接收
		json.put("reception", JSONArray.toJSON(receive));
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyTask");
		log.setTable_remarks("公司任务表");
		log.setUid(staffer.getUser_id());
		log.setuName(staffer.getRealname());
		log.setOperate("个人统计");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
			
		logService.insertSelective(log);
		//添加日志结束

		
		return json;
		
	}
	
	/**
	 * 当月统计
	 * @param session
	 * @return
	 */
	@RequestMapping("/stafferTaskPersonalMonth.do")
	@ResponseBody
	public Object stafferTaskPersonalMonth(HttpSession session,HttpServletRequest request){
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		
		JSONObject json = new JSONObject();
		
		//总数
		List<CompanyTask> count=companyTaskService.selectStafferCountDay(staffer.getUser_id(),staffer.getUser_id());
		//已完成
		List<CompanyTask> accomplish=companyTaskService.selectStafferCompleteDay(staffer.getUser_id(),staffer.getUser_id());
		//进行
		List<CompanyTask> carry=companyTaskService.selectStafferCarryDay(staffer.getUser_id(),staffer.getUser_id());
		
		json.put("count", count);
		json.put("accomplish", accomplish);
		json.put("carry", carry);
		
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyTask");
				log.setTable_remarks("公司任务表");
				log.setUid(staffer.getUser_id());
				log.setuName(staffer.getRealname());
				log.setOperate("公司当月统计");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
		return json;
		
	}
	
	
}
