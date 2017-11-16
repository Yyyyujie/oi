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
import cn.zx.pojo.CompanyPost;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyPostLevelServiceImpl;
import cn.zx.service.impl.CompanyPostServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/postLevel")
public class CompanyPostLevelController {
	@Autowired
	CompanyPostLevelServiceImpl companyPostLevelService;
	@Autowired
	CompanyPostServiceImpl companyPostService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 查询
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/slectPostLevel.html")
	public String slectPostLevel(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPostLevel> list=companyPostLevelService.selectPostlevel(null, companyAdmin.getCompany_id());
		request.setAttribute("listPostLevel", list);
		return "/company/manage/oi_enter_rank";
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insert(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPost> listPost=companyPostService.selectPost(null, companyAdmin.getCompany_id());
		request.setAttribute("listPost", listPost);
		return "/company/manage/oi_enter_rank_edit";
	}
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping("/edit.html")
	public String edit(CompanyPostLevel record,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getPost_le_id() == null){
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(1);
			record.setIsdelete(1);
			record.setCreate_time(new Date());
			companyPostLevelService.insertSelective(record);
			
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyPostLevel");
			log.setTable_remarks("公司职级表");
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("添加职级");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}else{
			List<CompanyPostLevel> list=new ArrayList<CompanyPostLevel>();
			record.setUpdate_time(new Date());
			list.add(record);
			companyPostLevelService.updateByPrimaryKeySelective(list);
			
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyPostLevel");
			log.setTable_remarks("公司职级表");
			log.setData_id(record.getPost_le_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("根据职级ID修改职级");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}
		return "/company/manage/oi_enter_rank";
	}
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String id,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPostLevel> list=companyPostLevelService.selectPostlevel(Integer.parseInt(id), companyAdmin.getCompany_id());
		request.setAttribute("postLevel", list.get(0));
		
		List<CompanyPost> listPost=companyPostService.selectPost(null, companyAdmin.getCompany_id());
		request.setAttribute("listPost", listPost);
		return "/company/manage/oi_enter_rank_edit";
	}
}
