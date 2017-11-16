package cn.zx.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyBasic;
import cn.zx.pojo.Log;
import cn.zx.pojo.WechatSetting;
import cn.zx.service.impl.CompanyBasicServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.service.impl.WechatSettingServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/Basic")
public class CompanyBasicController {
	@Autowired
	CompanyBasicServiceImpl companyBasicService;
	@Autowired
	WechatSettingServiceImpl wechatSettingService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 查询公司基础信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectBasic.html")
	public String selectBasic(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		
		CompanyBasic companyBasic=companyBasicService.selectBasic(companyAdmin.getCompany_id());
		
		
		//添加日志结束
		
		if(companyBasic != null){
			request.setAttribute("companyBasic", companyBasic);
		}else{
			request.setAttribute("companyBasic", null);
		}
		return "company/info/oi_enter_basic";
		
	}
	/**
	 * 修改公司基础信息
	 * @param companyBasic
	 * @return
	 */
	@RequestMapping("updateBasic.html")
	public String updateBasic(HttpSession session,
			HttpServletRequest request,CompanyBasic companyBasic){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		companyBasic.setCompany_id(companyAdmin.getCompany_id());
		
		//判断晋级周期是否为空
		if(companyBasic.getPeriod()==null){
			companyBasic.setPeriod(99999);
		}
		//判断晋级标准是否为空
		if(companyBasic.getStandard()==null){
			companyBasic.setStandard(99999);
		}
		//判断投票天数是否为空
		if(companyBasic.getDays()==null){
			companyBasic.setDays(99999);
		}
		//判断提醒节点是否为空
		if(companyBasic.getPanel_point()==null){
			companyBasic.setPanel_point(99999);
		}
		//判断基础设置ID是否为空
		if(companyBasic.getB_id() == null){
			companyBasicService.insertBasic(companyBasic);
			return "redirect:/company/Basic/selectBasic.html";
		}else{
			
			int row=companyBasicService.updateBasicByID(companyBasic);
			
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyBasic");
			log.setTable_remarks("公司信息表");
			log.setData_id(companyBasic.getB_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("根据公司ID修改公司信息表");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
			if(row==1){
				return "redirect:/company/Basic/selectBasic.html";
			}else{
				return "company/info/oi_enter_basic";
			}
		}
	}
}
