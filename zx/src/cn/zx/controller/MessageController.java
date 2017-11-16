package cn.zx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.Log;
import cn.zx.pojo.OiCompany;
import cn.zx.pojo.OiType;
import cn.zx.pojo.OiTypeExample;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.service.impl.OiCompanyServiceimpl;
import cn.zx.service.impl.OiTypeServiceimpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/message")
public class MessageController {
	@Autowired 
	OiCompanyServiceimpl OiCompanyService;
	@Autowired
	OiTypeServiceimpl OiTypeService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 查询企业信息
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/selectMessage.html")
	public String selectMessage(HttpSession session,HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		
		List<OiCompany> listMessage=OiCompanyService.selectMessage(companyAdmin.getCompany_id());
		
		OiTypeExample example=new OiTypeExample();
		cn.zx.pojo.OiTypeExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiType> type = OiTypeService.getType(example);
		
		request.setAttribute("type",type );
		
		if(listMessage.size()>0){
			request.setAttribute("Message", listMessage.get(0));
		}else{
			request.setAttribute("Message", null);
		}
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("OiCompany");
				log.setTable_remarks("公司信息表");
				log.setData_id(listMessage.get(0).getCompany_id());
				log.setUid(companyAdmin.getAdmin_id());
				log.setuName(companyAdmin.getUsername());
				log.setOperate("查询公司信息表");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
					
				logService.insertSelective(log);
				//添加日志结束
		
		return "/company/info/oi_enter_infolist";
	}
	/**
	 * 修改企业信息根据ID
	 * @param companyMessage
	 * @return
	 */
	@RequestMapping(value="/updateMessage.html")
	public String updateMessage(OiCompany recorde,
			String pro_id,String city_id,String area_id,String addre,
			HttpSession session, HttpServletRequest request){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		recorde.setAddr(addre);
		
		if(recorde.getLicense_img() == null || recorde.getLicense_img().equals("")){
			recorde.setLicense_img(null);
		}
		
		int row=OiCompanyService.updateExamineCompany(recorde);
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("OiCompany");
		log.setTable_remarks("公司信息表");
		log.setData_id(recorde.getCompany_id());
		log.setUid(companyAdmin.getAdmin_id());
		log.setuName(companyAdmin.getUsername());
		log.setOperate("修改企业信息根据ID");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
			
		logService.insertSelective(log);
		//添加日志结束
		if(row==1){
			return "redirect:/company/message/selectMessage.html";
		}else{
			return "/company/info/oi_enter_infolist";
		}
		
		
	}
}
