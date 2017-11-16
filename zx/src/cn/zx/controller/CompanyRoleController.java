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
import cn.zx.pojo.CompanyRole;
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyRoleServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/role")
public class CompanyRoleController {
	@Autowired
	CompanyRoleServiceImpl companyRoleService;
	@Autowired
	LogServiceImpl logService;
	
	
	/**
	 * 查询信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectRole.html")
	public String selectPro(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyRole> list=companyRoleService.selectRole(null,companyAdmin.getCompany_id());
		request.setAttribute("listRole", list);
		return "/company/user/oi_enter_character";
		
	}
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insertRole(){
				return "/company/user/oi_admin_chara_edite";
		
	}
	/**
	 * 编辑
	 * @param dataType
	 * @param record
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/edit.html")
	public String editRole(String dataType,CompanyRole record,
			HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getUser_id() == null){
			record.setAdmin_id(companyAdmin.getAdmin_id());
			record.setStatus(1);
			record.setCompany_id(companyAdmin.getCompany_id());
			companyRoleService.insertSelective(record);
			

			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyRole");
			log.setTable_remarks("公司角色表");
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("添加公司角色");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}else{
			List<CompanyRole> list=new ArrayList<CompanyRole>();
			list.add(record);
			companyRoleService.updateByPrimaryKeySelective(list);
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyRole");
			log.setTable_remarks("公司角色表");
			log.setData_id(record.getUser_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("根据角色ID修改角色");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}
		return "/company/user/oi_enter_character";
		
	}
	
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/update.html")
	public String updateRole(String id,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyRole> list=companyRoleService.selectRole(Integer.parseInt(id),companyAdmin.getCompany_id());
		request.setAttribute("propa", list.get(0));
		return "/company/user/oi_admin_chara_edite";
		
	}
}
