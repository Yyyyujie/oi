package cn.zx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyTask;
import cn.zx.service.impl.CompanyDepartServiceImpl;
import cn.zx.service.impl.CompanyStafferServiceImpl;
import cn.zx.service.impl.CompanyTaskServiceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/company/task")
public class CompanyTaskController {
	@Autowired
	CompanyTaskServiceImpl companyTaskService;
	@Autowired
	CompanyDepartServiceImpl companyDepartService;
	@Autowired
	CompanyStafferServiceImpl companyStafferService;
	
	/**
	 * 查询
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectTask.html")
	public String selectTask(HttpSession session,
			HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyTask> list=companyTaskService.selectTask(companyAdmin.getCompany_id());
		request.setAttribute("listTask", list);
		
		return "/company/manage/oi_enter_taskCenter";
	}
	/**
	 * 查询
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectData.html")
	public String selectData(){		
		return "/company/manage/oi_enter_data_center";
	}
	
	/**
	 * 公司汇总
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectGather.do")
	@ResponseBody
	public Object selectGather(HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		int id=0;
		if(companyAdmin == null){
			id=staffer.getUser_id();
		}else{
			id=companyAdmin.getCompany_id();
		}
		
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
		List<CompanyTask> listCount=companyTaskService.selectCountMonth(id);
		//完成
		List<CompanyTask> listAccomp=companyTaskService.selectAccomplishMonth(id);
		//进行
		List<CompanyTask> listCarry=companyTaskService.selectCarryMonth(id);
		
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
		
		return json;		
	}
	/**
	 * 员工Top10
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectTop.do")
	@ResponseBody
	public Object selectTop(HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		CompanyStaffer staffer=(CompanyStaffer) session.getAttribute("companyStaffer");
		int id=0;
		if(companyAdmin == null){
			if(staffer ==null){
				id=0;
			}else{
				id=staffer.getUser_id();
			}
			
		}else{
			id=companyAdmin.getCompany_id();
		}
		List<CompanyTask> list=companyTaskService.selectTop(id);
		System.out.println(JSONArray.toJSON(list));
		return JSONArray.toJSON(list);	
		
	}
	/**
	 * 所占百分比
	 * @param session
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping("/selectPercentage.do")
	@ResponseBody
	public Object selectPercentage(HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		
		//所有
		CompanyTask count=companyTaskService.selectCount(companyAdmin.getCompany_id());
		//已取消
		CompanyTask remove=companyTaskService.selectRemove(companyAdmin.getCompany_id());
		//已完成
		CompanyTask accomplish=companyTaskService.selectAccomplish(companyAdmin.getCompany_id());
		//已退回
		CompanyTask back=companyTaskService.selectBack(companyAdmin.getCompany_id());
		//进行
		CompanyTask carry=companyTaskService.selectCarry(companyAdmin.getCompany_id());
		//待接收
		CompanyTask receive=companyTaskService.selectReceive(companyAdmin.getCompany_id());
		//待接收
		CompanyTask evaluate=companyTaskService.selectEvaluate(companyAdmin.getCompany_id());
		
		
		JSONObject json = new JSONObject();
		
		json.put("count", JSONArray.toJSON(count));//所有
		json.put("remove", JSONArray.toJSON(remove));//取消
		json.put("accomplish", JSONArray.toJSON(accomplish));//完成
		json.put("back", JSONArray.toJSON(back));//退回
		json.put("carry", JSONArray.toJSON(carry));//进行
		json.put("receive", JSONArray.toJSON(receive));//待接收
		json.put("evaluate", JSONArray.toJSON(evaluate));//待评价
		
		System.out.println(json);
		return json;			
	}
	/**
	 * 所占百分比
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectPicture.do")
	@ResponseBody
	public Object selectPicture(HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		
		//所有
		CompanyTask count=companyTaskService.selectCount(companyAdmin.getCompany_id());
		
		//已完成
		CompanyTask accomplish=companyTaskService.selectAccomplish(companyAdmin.getCompany_id());

		JSONObject json = new JSONObject();
		
		
		json.put("accomplish", JSONArray.toJSON(accomplish));//完成
		json.put("rough", JSONArray.toJSON(count.getCount()-accomplish.getCount()));//所有
		
		System.out.println(json);
		return json;			
	}
	/*数据下钻开始*/
	/**
	 * 数据下钻
	 * @param dept_id
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectGoing.do")
	@ResponseBody
	public Object selectGoing(Integer task_status,Integer dept_id,Integer user_id,HttpSession session){
		//获取session中的用户对象
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		
		//查询所有下级部门
		List<CompanyDepart> listDeoart=companyDepartService.selectDeptByPid(dept_id,companyAdmin.getCompany_id());
		//查询部门下的所有人
		List<CompanyStaffer>  listStaff=companyStafferService.selectByDepart(dept_id, companyAdmin.getCompany_id());
		CompanyTask task=null;//部门
		CompanyTask taskStaff=null;//员工
		List<CompanyTask> list=new ArrayList<CompanyTask>();
		
		//判断是否有下级部门，如果有的话显示部门
		//否则显示部门下的人		
		if(listDeoart !=null){
			for (int i = 0; i < listDeoart.size(); i++) {
				//查询各部门的数据
				task=companyTaskService.selectGoingTask(task_status, listDeoart.get(i).getDept_id(), null, companyAdmin.getCompany_id());
				list.add(task);
			}
			//当前部门下有人也返回
			if(listStaff !=null){
				for (int i = 0; i < listStaff.size(); i++) {
					taskStaff=companyTaskService.selectGoingTask(task_status, null, listStaff.get(i).getUser_id(), companyAdmin.getCompany_id());
				}
			}else{
				//根据接受人查询
				taskStaff=companyTaskService.selectGoingTask(task_status, null, user_id, companyAdmin.getCompany_id());
			}
			
		}else{
			if(listStaff !=null){
				for (int i = 0; i < listStaff.size(); i++) {
					task=companyTaskService.selectGoingTask(task_status, null, listStaff.get(i).getUser_id(), companyAdmin.getCompany_id());
					list.add(task);
				}
			}else{
				//根据接受人查询
				taskStaff=companyTaskService.selectGoingTask(task_status, null, user_id, companyAdmin.getCompany_id());
			}
		}
		JSONObject json = new JSONObject();
		
		json.put("list", list);//部门
		json.put("taskStaff", taskStaff);//员工
		
		return json;
	
	}	
	/*数据下钻结束*/
}
