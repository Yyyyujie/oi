package cn.zx.controller;

import java.io.UnsupportedEncodingException;
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
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyPostServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("company/post")
public class CompanyPostController {
	@Autowired
	CompanyPostServiceImpl companyPostService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 查询信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectPost.html")
	public String selectPost(HttpServletRequest request,HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPost>  list=companyPostService.selectPost(null,companyAdmin.getCompany_id());
		request.setAttribute("list", list);
		return "company/manage/oi_enter_grade";
		
	}
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insert(){
		return "company/manage/oi_enter_grade_edit";
		
	}
	
	/**
	 * 编辑
	 * @param record
	 * @return
	 */
	@RequestMapping("/editPost.html")
	public String editPost(CompanyPost record,HttpSession session,HttpServletRequest request){
		if(record.getPost_name() !=null && !record.getPost_name().equals("")){
			try {
				record.setPost_name(new String(record.getPost_name().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getPost_remark() !=null && !record.getPost_remark().equals("")){
			try {
				record.setPost_remark(new String(record.getPost_remark().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getPost_id()==null){
			
			record.setCreate_time(new Date());
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setIsdelete(1);
			companyPostService.insertPost(record);
			

			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyPost");
			log.setTable_remarks("公司职务表");
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("添加职务");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
			
		}else{
			List<CompanyPost> list=new ArrayList<CompanyPost>();
			
			record.setUpdate_time(new Date());
			list.add(record);
			companyPostService.updateByPrimaryKeySelective(list);
			
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyPost");
			log.setTable_remarks("公司职务表");
			log.setData_id(record.getPost_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("根据职务ID修改职务");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}
		
		
		return "company/manage/oi_enter_grade";
		
	}
	
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String id,
			HttpServletRequest request,HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPost>  list=companyPostService.selectPost(Integer.parseInt(id),companyAdmin.getCompany_id());
		request.setAttribute("post", list.get(0));
		return "company/manage/oi_enter_grade_edit";
		
	}
	
}
