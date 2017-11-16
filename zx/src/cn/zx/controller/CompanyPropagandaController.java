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
import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyPropagandaServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/propaganda")
public class CompanyPropagandaController {
	@Autowired
	CompanyPropagandaServiceImpl companyPropagandaService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 查询信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectPropaganda.html")
	public String selectPro(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPropaganda> listPropa=companyPropagandaService.selectPropaganda(null,companyAdmin.getCompany_id());
		request.setAttribute("listPropa", listPropa);
		return "/company/info/oi_enter_publicity";
		
	}
	/**
	 * 跳转到添加页面
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insertPro(){
				return "/company/info/oi_enter_public_edit";
		
	}
	/**
	 * 修改及添加
	 * @param dataType
	 * @param record
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/edit.html")
	public String editPro(String dataType,CompanyPropaganda record,
			HttpServletRequest request,
			HttpSession session){
		if(record.getP_title() !=null && !record.getP_title().equals("")){
			try {
				record.setP_title(new String(record.getP_title().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getP_id() == null){
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(1);
			companyPropagandaService.insertPropaganda(record);
			
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyPropaganda");
			log.setTable_remarks("公司广告表");
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("添加广告");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}else{
			List<CompanyPropaganda> list=new ArrayList<CompanyPropaganda>();
			record.setCompany_id(companyAdmin.getCompany_id());
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
			log.setOperate("根据广告ID修改广告");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}
		return "/company/info/oi_enter_publicity";
		
	}
	
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/update.html")
	public String updatePro(String id,HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		List<CompanyPropaganda> listPropa=companyPropagandaService.selectPropaganda(Integer.parseInt(id),companyAdmin.getCompany_id());
		request.setAttribute("propa", listPropa.get(0));
		return "/company/info/oi_enter_public_edit";
		
	}
	
	
	
}
