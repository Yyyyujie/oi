package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyPost;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.CompanyRole;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.Log;
import cn.zx.pojo.OiCompany;
import cn.zx.pojo.WechatTmpl;
import cn.zx.service.impl.CompanyAdminServiceImpl;
import cn.zx.service.impl.CompanyNewsServiceImpl;
import cn.zx.service.impl.CompanyPostLevelServiceImpl;
import cn.zx.service.impl.CompanyPostServiceImpl;
import cn.zx.service.impl.CompanyPropagandaServiceImpl;
import cn.zx.service.impl.CompanyRoleServiceImpl;
import cn.zx.service.impl.CompanyStafferServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.service.impl.WechatTmplServiceImpl;
import cn.zx.tool.Msg;
import cn.zx.tool.ObtainIp;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/company/deleteInfo")
public class DeleteInfoController {
	@Autowired
	WechatTmplServiceImpl wechatTmplService;
	@Autowired
	CompanyPropagandaServiceImpl companyPropagandaService;
	@Autowired
	CompanyPostServiceImpl companyPostService;
	@Autowired
	CompanyPostLevelServiceImpl companyPostLevelService;
	@Autowired
	CompanyStafferServiceImpl companyStafferService;
	@Autowired
	CompanyNewsServiceImpl companyNewsService;
	@Autowired
	CompanyRoleServiceImpl companyRoleService;
	@Autowired
	CompanyAdminServiceImpl companyAdminService;
	@Autowired
	LogServiceImpl logService;
	
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public Msg deleteCompany(@RequestParam("dataType")String dataType,@RequestParam("id")String id
			,HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		try {
			if(dataType.equals("oi_enter_weList")){
				WechatTmpl record=new WechatTmpl();
				List<WechatTmpl> list=new ArrayList<WechatTmpl>();
				record.setTmpl_id(Integer.parseInt(id));
				record.setCompany_id(companyAdmin.getCompany_id());
				record.setStatus(0);
				record.setUpdate_time(new Date());
				list.add(record);
				wechatTmplService.updateByPrimaryKeySelective(list);
				
				//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("WechatTmpl");
				log.setTable_remarks("公司微信模板表");
				log.setData_id(record.getTmpl_id());
				log.setUid(companyAdmin.getAdmin_id());
				log.setuName(companyAdmin.getUsername());
				log.setOperate("根据微信模板ID删除微信模板");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
			}else if(dataType.equals("oi_enter_publicity")){
				CompanyPropaganda record=new CompanyPropaganda();
				List<CompanyPropaganda> list=new ArrayList<CompanyPropaganda>();
				record.setCompany_id(companyAdmin.getCompany_id());
				record.setP_id(Integer.parseInt(id));
				record.setStatus(0);
				list.add(record);
				companyPropagandaService.updateByPrimaryKeySelective(list);
				
				//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyPropaganda");
				log.setTable_remarks("公司广告表");
				log.setData_id(record.getP_id());
				log.setUid(companyAdmin.getAdmin_id());
				log.setuName(companyAdmin.getUsername());
				log.setOperate("根据广告ID删除广告");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
			}else if(dataType.equals("oi_enter_grade")){
				List<CompanyPost>  list=new ArrayList<CompanyPost>();
				CompanyPost record =new CompanyPost();
				record.setCompany_id(companyAdmin.getCompany_id());
				record.setIsdelete(0);
				record.setUpdate_time(new Date());
				record.setPost_id(Integer.parseInt(id));
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
				log.setOperate("根据职务ID删除职务");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
			}else if(dataType.equals("oi_enter_rank")){
				List<CompanyPostLevel> list=new ArrayList<CompanyPostLevel>();
				CompanyPostLevel record = new CompanyPostLevel();
				record.setPost_le_id(Integer.parseInt(id));
				record.setUpdate_time(new Date());
				record.setIsdelete(0);
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
				log.setOperate("根据职级ID删除职级");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
			}else if(dataType.equals("oi_enter_staffMng")){
				
				CompanyStaffer record=new CompanyStaffer();
				List<CompanyStaffer> list=new ArrayList<CompanyStaffer>();
				record.setUser_id(Integer.parseInt(id));
				record.setStatus(0);
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
				log.setOperate("根据员工ID删除员工");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
			}else if(dataType.equals("oi_enter_news_01")){
				CompanyNews record=new CompanyNews();
				List<CompanyNews> list=new ArrayList<CompanyNews>();
				record.setNew_id(Integer.parseInt(id));
				record.setStatus(0);
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
				log.setOperate("根据新闻ID删除新闻");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
			}else if(dataType.equals("oi_enter_news_02")){
				CompanyNews record=new CompanyNews();
				List<CompanyNews> list=new ArrayList<CompanyNews>();
				record.setNew_id(Integer.parseInt(id));
				record.setStatus(0);
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
				log.setOperate("根据新闻ID删除新闻");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束				
			}else if(dataType.equals("oi_enter_character_table")){
				CompanyRole record=new CompanyRole();
				List<CompanyRole> list=new ArrayList<CompanyRole>();
				record.setUser_id(Integer.parseInt(id));
				record.setStatus(0);
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
				log.setOperate("根据角色ID删除角色");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
			}else if(dataType.equals("oi_enter_mng_table")){
				CompanyAdmin record=new CompanyAdmin();
				record.setRole(0);
				record.setAdmin_id(Integer.parseInt(id));
				companyAdminService.updateByPrimaryKeySelective(record);
				
				//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyAdmin");
				log.setTable_remarks("公司管理员表");
				log.setData_id(record.getAdmin_id());
				log.setUid(companyAdmin.getAdmin_id());
				log.setuName(companyAdmin.getUsername());
				log.setOperate("根据管理员ID删除管理员");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
			}
			return Msg.success();
		} catch (NumberFormatException e) {
			return Msg.fail();
		}
	}
}
