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
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsType;
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyNewsServiceImpl;
import cn.zx.service.impl.CompanyNewsTypeServiceimpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/news/")
public class CompanyNewsController {
	@Autowired
	CompanyNewsServiceImpl companyNewsService;
	@Autowired
	CompanyNewsTypeServiceimpl companyNewsTypeService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 查询企业新闻
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/slectNews.html")
	public String slectPostLevel(HttpServletRequest request,
			HttpSession session){		
		return "/company/manage/oi_enter_news";
	}
	
	
	/**
	 * 查询平台新闻
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectOINews.html")
	public String selectOINews(HttpServletRequest request,
			HttpSession session){		
		return "/company/news/oi_enter_news";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insert(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		
		List<CompanyNewsType>  listNewsType=companyNewsTypeService.selectNewsType(null);
		request.setAttribute("listNewsType", listNewsType);
		
		request.setAttribute("company_id", companyAdmin.getCompany_id());
		return "/company/manage/oi_enter_enterNews_eidt";
	}
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping("/edit.html")
	public String edit(CompanyNews record,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getNew_id() == null){
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(1);
			record.setType("企业公告");
			record.setCreate_time(new Date());
			record.setAuthor(companyAdmin.getUsername());
			companyNewsService.insertSelective(record);
			
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyNews");
			log.setTable_remarks("公司新闻表");
			log.setData_id(record.getNew_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("添加一条新闻");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
			
		}else{
			List<CompanyNews> list=new ArrayList<CompanyNews>();
			
			//record.setCreate_time(new Date());
			list.add(record);
			companyNewsService.updateByPrimaryKeySelective(list);
			
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyNews");
			log.setTable_remarks("公司新闻表");
			log.setData_id(record.getNew_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("根据公司ID修改公司新闻表");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}
		return "/company/manage/oi_enter_news";
	}
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String id,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyNews> list=companyNewsService.selectNews(Integer.parseInt(id), companyAdmin.getCompany_id(),null);
		request.setAttribute("news", list.get(0));
		request.setAttribute("company_id", companyAdmin.getCompany_id());
		
		List<CompanyNewsType>  listNewsType=companyNewsTypeService.selectNewsType(null);
		request.setAttribute("listNewsType", listNewsType);
		
		return "/company/manage/oi_enter_enterNews_eidt";
	}
}
