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

import com.alibaba.fastjson.JSONArray;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyPost;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.CompanyRole;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.Log;
import cn.zx.pojo.WechatTmpl;
import cn.zx.service.impl.CompanyAdminServiceImpl;
import cn.zx.service.impl.CompanyNewsServiceImpl;
import cn.zx.service.impl.CompanyPostLevelServiceImpl;
import cn.zx.service.impl.CompanyPostServiceImpl;
import cn.zx.service.impl.CompanyPropagandaServiceImpl;
import cn.zx.service.impl.CompanyRoleServiceImpl;
import cn.zx.service.impl.CompanyStafferServiceImpl;
import cn.zx.service.impl.CompanyTaskServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.service.impl.WechatTmplServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("company/Newcompany")
public class NewCompanyController {
	@Autowired
	WechatTmplServiceImpl wechatTmplService;
	@Autowired
	CompanyAdminServiceImpl companyAdminService;
	@Autowired
	CompanyNewsServiceImpl companyNewsService;
	@Autowired
	CompanyPostServiceImpl companyPostService;
	@Autowired
	CompanyPostLevelServiceImpl companyPostLevelService;
	@Autowired
	CompanyStafferServiceImpl companyStafferService;
	@Autowired
	CompanyPropagandaServiceImpl companyPropagandaService;
	@Autowired
	CompanyRoleServiceImpl companyRoleService;
	@Autowired
	CompanyTaskServiceImpl companyTaskService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 获取微信模版
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWechat")
	public Object getWechat(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		WechatTmpl record=new WechatTmpl();
		record.setCompany_id(companyAdmin.getCompany_id());
		List<WechatTmpl> listWechatTmpl=wechatTmplService.selectWechatTmpl(record);
		
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("WechatTmpl");
		log.setTable_remarks("公司微信模板表");
		log.setData_id(record.getTmpl_id());
		log.setUid(companyAdmin.getAdmin_id());
		log.setuName(companyAdmin.getUsername());
		log.setOperate("查询微信模板信息");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
					
		logService.insertSelective(log);
		//添加日志结束
		return listWechatTmpl;
	}
	
	/**
	 * 获取公司管理员
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAdmin")
	public Object getAdmin(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		companyAdmin.setPhone(null);
		companyAdmin.setPassword(null);
		companyAdmin.setUsername(null);
		List<CompanyAdmin> listAdmin=companyAdminService.selectAdmin(companyAdmin);
		
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("WechatTmpl");
				log.setTable_remarks("公司管理员表");
				log.setData_id(companyAdmin.getAdmin_id());
				log.setUid(companyAdmin.getAdmin_id());
				log.setuName(companyAdmin.getUsername());
				log.setOperate("查询管理员模板信息");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
							
				logService.insertSelective(log);
				//添加日志结束
		return listAdmin;
	}
	
	/**
	 * 获取企业新闻
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompanyNews")
	public Object getCompanyNews(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyNews> listNews=companyNewsService.selectNews(null, companyAdmin.getCompany_id(),null);
		
		List<CompanyNews> list=new ArrayList<CompanyNews>();
		//过滤
		if(listNews!=null){
			for (int i = 0; i < listNews.size(); i++) {
				if(listNews.get(i).getType()!=null && !listNews.get(i).getType().equals("平台公告")){
					list.add(listNews.get(i));
				}
			}
		}
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("WechatTmpl");
		log.setTable_remarks("公司新闻表");
		log.setData_id(list.get(0).getNew_id());
		log.setUid(companyAdmin.getAdmin_id());
		log.setuName(companyAdmin.getUsername());
		log.setOperate("查询企业新闻信息");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
					
		logService.insertSelective(log);
		//添加日志结束
		return list;
	}
	/**
	 * 获取平台新闻
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompanyOINews")
	public Object getCompanyOINews(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyNews> listNews=companyNewsService.selectNews(null, companyAdmin.getCompany_id(),null);
		
		List<CompanyNews> list=new ArrayList<CompanyNews>();
		//过滤
		if(listNews!=null){
			for (int i = 0; i < listNews.size(); i++) {
				if(listNews.get(i).getType()!=null && !listNews.get(i).getType().equals("企业公告")){
					list.add(listNews.get(i));
				}
			}
		}
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("WechatTmpl");
		log.setTable_remarks("公司新闻表");
		log.setData_id(list.get(0).getNew_id());
		log.setUid(companyAdmin.getAdmin_id());
		log.setuName(companyAdmin.getUsername());
		log.setOperate("查询平台新闻信息");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
					
		logService.insertSelective(log);
		//添加日志结束
		return list;
	}
	
	/**
	 * 获取职系
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompanyPost")
	public Object getCompanyPost(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPost>  list=companyPostService.selectPost(null,companyAdmin.getCompany_id());
		return list;
	}
	
	/**
	 * 获取职级
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompanyPostLevel")
	public Object getCompanyPostLevel(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPostLevel> list=companyPostLevelService.selectPostlevel(null, companyAdmin.getCompany_id());
		return list;
	}
	
	/**
	 * 获取员工
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompanyStaffer")
	public Object getCompanyStaffer(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyStaffer> list= companyStafferService.selectStaffer(null, companyAdmin.getCompany_id());
		return list;
	}
	
	/**
	 * 企业宣传
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompanyPropaganda")
	public Object getCompanyPropaganda(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPropaganda> listPropa=companyPropagandaService.selectPropaganda(null,companyAdmin.getCompany_id());
		return listPropa;
	}
	
	/**
	 * 获取角色
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompanyRole")
	public Object getCompanyRole(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyRole> list=companyRoleService.selectRole(null,companyAdmin.getCompany_id());
		return list;
	}
	/**
	 * 获取任务中心
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCompanyTask")
	public Object getCompanyTask(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyTask> list=companyTaskService.selectTask(companyAdmin.getCompany_id());
		return list;
	}
}
