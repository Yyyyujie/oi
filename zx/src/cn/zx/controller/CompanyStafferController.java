package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyBasic;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyPost;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyBasicServiceImpl;
import cn.zx.service.impl.CompanyDepartServiceImpl;
import cn.zx.service.impl.CompanyPostLevelServiceImpl;
import cn.zx.service.impl.CompanyPostServiceImpl;
import cn.zx.service.impl.CompanyStafferServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/staffer")
public class CompanyStafferController {
	@Autowired
	CompanyStafferServiceImpl companyStafferService;
	@Autowired
	CompanyDepartServiceImpl companyDepartService;
	@Autowired
	CompanyPostServiceImpl companyPostService;
	@Autowired
	CompanyPostLevelServiceImpl companyPostLevelService;
	@Autowired
	LogServiceImpl logService;
	
	
	/**
	 * 查询
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/slectStaffer.html")
	public String slectStaffer(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyStaffer> list= companyStafferService.selectStaffer(null, companyAdmin.getCompany_id());
		request.setAttribute("listStaffer", list);
		return "/company/manage/oi_enter_staffMng";
	}
	
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping("/edit.html")
	public String edit(CompanyStaffer record,HttpServletRequest request,
			HttpSession session){
			CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
			List<CompanyStaffer> list=new ArrayList<CompanyStaffer>();
			
			
			list.add(record);
			companyStafferService.updateByPrimaryKeySelective(list);
			
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyStaffer");
			log.setTable_remarks("公司员工表");
			log.setData_id(record.getUser_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("根据员工ID修改员工");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		return "/company/manage/oi_enter_staffMng";
	}
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String id,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyStaffer> list=companyStafferService.selectStaffer(Integer.parseInt(id), companyAdmin.getCompany_id());
		request.setAttribute("staffer", list.get(0));
		
		List<CompanyDepart> listDepart=companyDepartService.selectDeptName(null, companyAdmin.getCompany_id());
		request.setAttribute("depart", listDepart);
		
		List<CompanyPost> listPost=companyPostService.selectPost(null, companyAdmin.getCompany_id());
		request.setAttribute("post", listPost);
		
		List<CompanyPostLevel> listPostLevel=companyPostLevelService.selectPostlevel(null, companyAdmin.getCompany_id());
		request.setAttribute("postLevel", listPostLevel);
		
		return "/company/manage/oi_enter_staff_edit";
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
		return "/company/manage/oi_enter_staffByID";
	}
	
}
