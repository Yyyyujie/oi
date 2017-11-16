package cn.zx.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.Log;
import cn.zx.pojo.OiSite;
import cn.zx.pojo.WechatSetting;
import cn.zx.service.OiSiteService;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.service.impl.WechatSettingServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/weChatSet")
public class WechatSettingController {
	@Autowired
	WechatSettingServiceImpl wechatSettingService;
	@Autowired
	OiSiteService oiSiteService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 查询微信基础设置
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectWechat.html")
	public String selectWechart(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		WechatSetting wechatSetting=wechatSettingService.selectWechat(companyAdmin.getCompany_id());
		if(wechatSetting ==null || wechatSetting.getSortname()== null ||  wechatSetting.getSortname().equals("")){
			OiSite oiSite = oiSiteService.getoiSite().get(0);
			String sortName=oiSite.getS_edition()+"?cid="+companyAdmin.getCompany_id();
			request.setAttribute("sortName", sortName);
		}
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("WechatSetting");
		log.setTable_remarks("公司微信基础表");
		log.setData_id(wechatSetting.getSet_id());
		log.setUid(companyAdmin.getAdmin_id());
		log.setuName(companyAdmin.getUsername());
		log.setOperate("查看微信基础表");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
			
		logService.insertSelective(log);
		//添加日志结束
		
		request.setAttribute("wechatSetting", wechatSetting);
		return "/company/info/oi_enter_weChat";
	}
	/**
	 * 修改微信基础设置信息
	 * @param wechatSetting
	 * @return
	 */
	@RequestMapping("/updateWechat.html")
	public String updateWechat(WechatSetting wechatSetting,HttpSession session,
			HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		System.out.println(wechatSetting.getSortname());
		if(wechatSetting.getSet_id() != null){
			int row=wechatSettingService.updateWechatByID(wechatSetting);
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("WechatSetting");
			log.setTable_remarks("公司微信基础表");
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("根据微信基础ID修改微信基础表");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
			if(row==1){
				return "redirect:/company/weChatSet/selectWechat.html";
			}else{
				return "/company/info/oi_enter_weChat";
			}
		}else{
			wechatSetting.setCompany_id(companyAdmin.getCompany_id());
			
			wechatSettingService.insertWechatSet(wechatSetting);
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("WechatSetting");
			log.setTable_remarks("公司微信基础表");
			log.setData_id(wechatSetting.getSet_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("添加微信基础表");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
			return "/company/info/oi_enter_weChat";
		}
		
		
		
	}
}
