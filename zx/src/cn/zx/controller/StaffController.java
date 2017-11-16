package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	CompanyTaskServiceImpl companyTaskService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 个人数据
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/selectStaffer.do",method=RequestMethod.POST)
	@ResponseBody
	public Object selectStaffer(HttpSession session,HttpServletRequest request){
		
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		
		/**
		 * 个人接收
		 */
		//个人接收完成
		CompanyTask completeReceive=companyTaskService.selectStafferComplete(staffer.getUser_id(),null);
		//个人接收进行
		CompanyTask receiveReceive=companyTaskService.selectStafferReceive(staffer.getUser_id(),null);
		//个人接收接收
		CompanyTask carryReceive=companyTaskService.selectStafferCarry(staffer.getUser_id(),null);
		
		/**
		 * 个人发布
		 */
		//个人发布完成
		CompanyTask completePublish=companyTaskService.selectStafferComplete(null,staffer.getUser_id());
		//个人发布进行
		CompanyTask receivePublish=companyTaskService.selectStafferReceive(null,staffer.getUser_id());
		//个人发布接收
		CompanyTask carryPublish=companyTaskService.selectStafferCarry(null,staffer.getUser_id());
		
		JSONObject json = new JSONObject();
		System.out.println(JSONArray.toJSON(completePublish));
		System.out.println(JSONArray.toJSON(receivePublish));
		System.out.println( JSONArray.toJSON(carryPublish));
		
		/**
		 * 个人接收
		 */
		json.put("completeReceive", JSONArray.toJSON(completeReceive));
		json.put("receiveReceive", JSONArray.toJSON(receiveReceive));
		json.put("carryReceive", JSONArray.toJSON(carryReceive));
		/**
		 * 个人发布
		 */
		json.put("completePublish", JSONArray.toJSON(completePublish));
		json.put("receivePublish", JSONArray.toJSON(receivePublish));
		json.put("carryPublish", JSONArray.toJSON(carryPublish));
		
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyTask");
				log.setTable_remarks("公司任务表");
				log.setUid(staffer.getUser_id());
				log.setuName(staffer.getRealname());
				log.setOperate("根据ID查询个人数据");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
		
		return json;
		
	}
	/**
	 * 个人数据根据ID查寻
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/selectStafferByID.do",method=RequestMethod.POST)
	@ResponseBody
	public Object selectStafferByID(String id,HttpSession session,HttpServletRequest request){
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		
		//个人完成
		CompanyTask complete=companyTaskService.selectStafferComplete(Integer.parseInt(id),Integer.parseInt(id));
		//个人进行
		CompanyTask receive=companyTaskService.selectStafferReceive(Integer.parseInt(id),Integer.parseInt(id));
		//个人接收
		CompanyTask carry=companyTaskService.selectStafferCarry(Integer.parseInt(id),Integer.parseInt(id));
		//个人接收总数
		CompanyTask count=companyTaskService.selectStafferCount(Integer.parseInt(id),Integer.parseInt(id));
		
		JSONObject json = new JSONObject();
		
		json.put("complete", JSONArray.toJSON(complete));
		json.put("receive", JSONArray.toJSON(receive));
		json.put("carry", JSONArray.toJSON(carry));
		json.put("count", JSONArray.toJSON(count));
		
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyTask");
		log.setTable_remarks("公司任务表");
		log.setUid(staffer.getUser_id());
		log.setuName(staffer.getRealname());
		log.setOperate("根据ID查询个人数据");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
			
		logService.insertSelective(log);
		//添加日志结束

		return json;
		
	}
	/**
	 * 个人月数据
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/selectStafferDay.do",method=RequestMethod.POST)
	@ResponseBody
	public Object selectStafferDay(HttpSession session,HttpServletRequest request){
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		
		List<Integer> month=new ArrayList<Integer>();
		month.add(1);month.add(2);month.add(3);month.add(4);
		month.add(5);month.add(6);month.add(7);month.add(8);
		month.add(9);month.add(10);month.add(11);month.add(12);
		
		List<Integer> count=new ArrayList<Integer>();
		count.add(0);count.add(0);count.add(0);count.add(0);
		count.add(0);count.add(0);count.add(0);count.add(0);
		count.add(0);count.add(0);count.add(0);count.add(0);
		
		List<Integer> complete=new ArrayList<Integer>();
		complete.add(0);complete.add(0);complete.add(0);complete.add(0);	
		complete.add(0);complete.add(0);complete.add(0);complete.add(0);
		complete.add(0);complete.add(0);complete.add(0);complete.add(0);

		
		List<Integer> carry=new ArrayList<Integer>();
		carry.add(0);carry.add(0);carry.add(0);carry.add(0);
		carry.add(0);carry.add(0);carry.add(0);carry.add(0);
		carry.add(0);carry.add(0);carry.add(0);carry.add(0);
		
		//个人月完成
		List<CompanyTask> listComplete=companyTaskService.selectStafferCompleteDay(staffer.getUser_id(),staffer.getUser_id());
		//个人月进行
		List<CompanyTask> listCarry=companyTaskService.selectStafferCarryDay(staffer.getUser_id(),staffer.getUser_id());
		//个人月总数
		List<CompanyTask> listCount=companyTaskService.selectStafferCountDay(staffer.getUser_id(),staffer.getUser_id());
				
		for (int i = 0; i < month.size(); i++) {
			for (int j = 0; j < listCount.size(); j++) {				
				if(month.get(i)==listCount.get(j).getMonth()){
					count.set(i, listCount.get(j).getCount());
				}
			}
			for (int j = 0; j < listComplete.size(); j++) {
				if(month.get(i) == listComplete.get(j).getMonth()){
					complete.set(i, listComplete.get(j).getCount());					
				}
			}
			for (int j = 0; j < listCarry.size(); j++) {				
				if(month.get(i) == listCarry.get(j).getMonth()){
					carry.set(i, listCarry.get(j).getCount());					
				}
			}			
		}
		
		
		JSONObject json = new JSONObject();
		
		json.put("month", JSONArray.toJSON(month));
		json.put("complete", JSONArray.toJSON(complete));		
		json.put("carry", JSONArray.toJSON(carry));
		json.put("count", JSONArray.toJSON(count));
		
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyTask");
				log.setTable_remarks("公司任务表");
				log.setUid(staffer.getUser_id());
				log.setuName(staffer.getRealname());
				log.setOperate("查看个人月数据");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
				
		return json;		
	}
	/**
	 * 公司汇总
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectGather.do")
	@ResponseBody
	public Object selectGather(HttpSession session,HttpServletRequest request){
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		
		List<Integer> month=new ArrayList<Integer>();
		month.add(1);month.add(2);month.add(3);month.add(4);
		month.add(5);month.add(6);month.add(7);month.add(8);
		month.add(9);month.add(10);month.add(11);month.add(12);
		
		List<Integer> count=new ArrayList<Integer>();
		count.add(0);count.add(0);count.add(0);count.add(0);
		count.add(0);count.add(0);count.add(0);count.add(0);
		count.add(0);count.add(0);count.add(0);count.add(0);
		
		List<Integer> accomp=new ArrayList<Integer>();
		accomp.add(0);accomp.add(0);accomp.add(0);accomp.add(0);
		accomp.add(0);accomp.add(0);accomp.add(0);accomp.add(0);
		accomp.add(0);accomp.add(0);accomp.add(0);accomp.add(0);
		
		List<Integer> carry=new ArrayList<Integer>();
		carry.add(0);carry.add(0);carry.add(0);carry.add(0);
		carry.add(0);carry.add(0);carry.add(0);carry.add(0);
		carry.add(0);carry.add(0);carry.add(0);carry.add(0);
		
		//总数
		List<CompanyTask> listCount=companyTaskService.selectCountMonth(staffer.getCompany_id());
		//完成
		List<CompanyTask> listAccomp=companyTaskService.selectAccomplishMonth(staffer.getCompany_id());
		//进行
		List<CompanyTask> listCarry=companyTaskService.selectCarryMonth(staffer.getCompany_id());
		
		for (int i = 0; i < month.size(); i++) {
			for (int j = 0; j < listCount.size(); j++) {				
				if(month.get(i)==listCount.get(j).getMonth()){
					count.set(i, listCount.get(j).getCount());
				}
			}
			for (int j = 0; j < listAccomp.size(); j++) {
				if(month.get(i) == listAccomp.get(j).getMonth()){
					accomp.set(i, listAccomp.get(j).getCount());					
				}
			}
			for (int j = 0; j < listCarry.size(); j++) {				
				if(month.get(i) == listCarry.get(j).getMonth()){
					carry.set(i, listCarry.get(j).getCount());					
				}
			}			
		}
		JSONObject json = new JSONObject();
		
		json.put("month", month);
		json.put("count", count);
		json.put("accomp", accomp);
		json.put("carry", carry);
		
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyTask");
		log.setTable_remarks("公司任务表");
		log.setUid(staffer.getUser_id());
		log.setuName(staffer.getRealname());
		log.setOperate("查看公司汇总数据");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
			
		logService.insertSelective(log);
		//添加日志结束
		return json;		
	}
	/**
	 * 员工Top10
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectTop.do")
	@ResponseBody
	public Object selectTop(HttpSession session,HttpServletRequest request){
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		List<CompanyTask> list=companyTaskService.selectTop(staffer.getCompany_id());
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyTask");
				log.setTable_remarks("公司任务表");
				log.setUid(staffer.getUser_id());
				log.setuName(staffer.getRealname());
				log.setOperate("查看员工TOP10数据");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
		return JSONArray.toJSON(list);	
		
	}
}
