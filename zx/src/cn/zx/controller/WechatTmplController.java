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
import cn.zx.pojo.Log;
import cn.zx.pojo.WechatTmpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.service.impl.WechatTmplServiceImpl;
import cn.zx.tool.ObtainIp;

@Controller
@RequestMapping("/company/weChatTpl")
public class WechatTmplController {
	@Autowired
	WechatTmplServiceImpl wechatTmplService;
	@Autowired
	LogServiceImpl logService;
	
	/**
	 * 查询
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/selectWechatTpl.html")
	public String selectWechatTpl(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		WechatTmpl record=new WechatTmpl();
		record.setCompany_id(companyAdmin.getCompany_id());
		
		List<WechatTmpl> listWechatTmpl=wechatTmplService.selectWechatTmpl(record);
		request.setAttribute("listWechatTmpl", listWechatTmpl);
		
		return "/company/info/oi_enter_weChatTpl_list";
		
	}
	/**
	 * 跳转到添加页面
	 * @param dataType
	 * @return
	 */
	@RequestMapping("/insert.html")
	public String insert(String dataType){
		return "/company/info/oi_enter_wxTplEdit";
		
	}
	/**
	 * 编辑
	 * @param dataType
	 * @return
	 */
	@RequestMapping("/editWeChat.html")
	public String editWeChat(WechatTmpl record,
			HttpSession session,HttpServletRequest request){
		if(record.getTitle() !=null && !record.getTitle().equals("")){
			try {
				record.setTitle(new String(record.getTitle().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getType() !=null && !record.getType().equals("")){
			try {
				record.setType(new String(record.getType().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getTemplate_id() !=null && !record.getTemplate_id().equals("")){
			try {
				record.setTemplate_id(new String(record.getTemplate_id().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getSerial() !=null && !record.getSerial().equals("")){
			try {
				record.setSerial(new String(record.getSerial().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getRemark() !=null && !record.getRemark().equals("")){
			try {
				record.setRemark(new String(record.getRemark().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getFirstdata() !=null && !record.getFirstdata().equals("")){
			try {
				record.setFirstdata(new String(record.getFirstdata().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getKeyword1() !=null && !record.getKeyword1().equals("")){
			try {
				record.setKeyword1(new String(record.getKeyword1().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getKeyword2() !=null && !record.getKeyword2().equals("")){
			try {
				record.setKeyword2(new String(record.getKeyword2().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getKeyword3() !=null && !record.getKeyword3().equals("")){
			try {
				record.setKeyword3(new String(record.getKeyword3().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getKeyword4() !=null && !record.getKeyword4().equals("")){
			try {
				record.setKeyword4(new String(record.getKeyword4().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getKeyword5() !=null && !record.getKeyword5().equals("")){
			try {
				record.setKeyword5(new String(record.getKeyword5().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		
		
		
		int row=0;
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		if(record.getTmpl_id()== null){
			record.setCompany_id(companyAdmin.getCompany_id());
			record.setStatus(1);
			record.setCreate_time(new Date());
			row=wechatTmplService.insertWechatTmpl(record);
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("WechatTmpl");
			log.setTable_remarks("公司微信模板表");
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("添加微信模板数据");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}else{
			List<WechatTmpl> list=new ArrayList<WechatTmpl>();
			record.setUpdate_time(new Date());
			list.add(record);
			row=wechatTmplService.updateByPrimaryKeySelective(list);
			//添加日志开始
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("WechatTmpl");
			log.setTable_remarks("公司微信模板表");
			log.setData_id(record.getTmpl_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("根据微信模板ID修改微信模板");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
				
			logService.insertSelective(log);
			//添加日志结束
		}
		request.setAttribute("row", row);
		return "redirect:/company/weChatTpl/selectWechatTpl.html";
		
	}
	
	
	/**
	 * 跳转到添加页面
	 * @param dataType
	 * @return
	 */
	@RequestMapping("/update.html")
	public String update(String dataType,String id,
			HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		WechatTmpl record=new WechatTmpl();
		record.setTmpl_id(Integer.parseInt(id));
		record.setCompany_id(companyAdmin.getCompany_id());
		List<WechatTmpl> list=wechatTmplService.selectWechatTmpl(record);
		request.setAttribute("WechatTmpl", list.get(0));
		return "/company/info/oi_enter_wxTplEdit";		
	}
}
