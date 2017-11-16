package cn.zx.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.Log;
import cn.zx.pojo.OiCompany;
import cn.zx.pojo.SmsMessage;
import cn.zx.service.impl.CompanyAdminServiceImpl;
import cn.zx.service.impl.CompanyStafferServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.service.impl.OiCompanyServiceimpl;
import cn.zx.tool.MD5Tool;
import cn.zx.tool.Msg;
import cn.zx.tool.ObtainIp;
import cn.zx.tool.SmsTool;
import cn.zx.tool.ThrimTask;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/company/admin")
public class CompanyAdminController {
	@Autowired
	CompanyAdminServiceImpl companyAdminService;
	@Autowired 
	OiCompanyServiceimpl OiCompanyService;
	@Autowired
	CompanyStafferServiceImpl companyStafferService;
	@Autowired
	LogServiceImpl logService;
	 
	
	private static int random;
	
	
	/**
	 * 企业管理员登录
	 * @param phone
	 * @param password
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/dologin.html")
	public String dologin(@RequestParam(required=false) String phone,
			@RequestParam(required=false) String password,
			HttpServletRequest request,
			HttpSession session){
		if(session.getId() == null){
			return "../../login";		
		}
		CompanyAdmin companyAdmin=new CompanyAdmin();
		MD5Tool md5=new MD5Tool();
		companyAdmin.setPhone(phone);
		
		List<CompanyAdmin> list=companyAdminService.selectAdminByName(null,phone);
		for (int i = 0; i <list.size(); i++) {
			if(list.get(i).getPhone()== phone){
				if(password !=null && !password.equals("")){					
					companyAdmin.setPassword(md5.MD5(password+list.get(i).getRandom()));
				}
			}
			
		}
		List<CompanyAdmin> companyAdminGet=companyAdminService.login(companyAdmin);
		if(companyAdminGet!=null && companyAdminGet.size()==1){
			List<OiCompany> listOc=OiCompanyService.selectMessage(companyAdminGet.get(0).getCompany_id());
			if(listOc !=null){
								
				if(listOc.get(0).getAudit()==0 || listOc.get(0).getIsdelete()==1){
					return "../../login";	
				}else{
					ObtainIp obtainIp=new ObtainIp();
					companyAdminGet.get(0).setCreate_ip(obtainIp.getIpAddr(request));
					companyAdminGet.get(0).setLast_time(new Date());
					int row=companyAdminService.updateByPrimaryKeySelective(companyAdminGet.get(0));
					session.setAttribute("companyAdmin", companyAdminGet.get(0));
					
					
					Log log=new Log();
					log.setTableName("CompanyAdmin");
					log.setTable_remarks("公司管理员表");
					log.setData_id(companyAdminGet.get(0).getAdmin_id());
					log.setUid(companyAdminGet.get(0).getAdmin_id());
					log.setuName(companyAdminGet.get(0).getUsername());
					log.setOperate("企业管理员登陆");
					log.setCreateDate(new Date());
					log.setCreateIP(obtainIp.getIpAddr(request));
					log.setCharact(2);
					
					logService.insertSelective(log);
					return "company/index";
				}
				
			}else{
				return "../../login";
			}	
		}else{
			return "../../login";		
		}	

		
	}
	/**
	 * 发送验证码
	 * @param companyAdmin
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/sendSms.do")
	@ResponseBody
	public Object SendSms(String telNumber,String code){
				
				List<CompanyAdmin> listAdmin=companyAdminService.selectAdminByName(null,telNumber);
				if(listAdmin.size()!=0){
					SmsTool smsTool=new SmsTool();
					SmsMessage sms=new SmsMessage();			
					int random=(int)((Math.random()*9+1)*100000);
					
					this.setRandom(random);
					
					sms.setUid("yxm123");
					sms.setKey("034fefeef2b8acfd58bf");
					sms.setSmsmob(telNumber);
					sms.setSmtext(String.valueOf(random));
					String result=smsTool.sendSMS(sms);
							
					
					if(result !=null){
						return JSONArray.toJSON(result);
					}else{
						return JSONArray.toJSON("发送验证码失败");
					}
					
				}else{
					//-1表示暂无此人
					return JSONArray.toJSON("查无此人");
				}
	}
	/**
	 * 跳转到忘记密码页
	 * @return
	 */
	@RequestMapping(value="/updatePassword.html")
	public String updatePassword(){
		return "/company/index_forget";
	}
	/**
	 * 修改密码及忘记密码
	 * @param companyAdmin
	 * @return
	 */
	@RequestMapping(value="/updateAdmin.html")
	public String updateAdmin(String phone,String password,String code,
			HttpServletRequest request){
		
		int random=(int)((Math.random()*9+1)*100000);
		MD5Tool md5=new MD5Tool();
		if(Integer.parseInt(code)==this.getRandom()){
			CompanyAdmin companyAdmin=new CompanyAdmin();
			companyAdmin.setPhone(phone);
			companyAdmin.setPassword(md5.MD5(password+random));
			companyAdmin.setRandom(String.valueOf(random));
			
			int row=companyAdminService.updatePasswordByUsername(companyAdmin);
			
			ObtainIp obtainIp=new ObtainIp();
			Log log=new Log();
			log.setTableName("CompanyAdmin");
			log.setTable_remarks("公司管理员表");
			log.setData_id(companyAdmin.getAdmin_id());
			log.setUid(companyAdmin.getAdmin_id());
			log.setuName(companyAdmin.getUsername());
			log.setOperate("修改企业管理员密码根据ID");
			log.setCreateDate(new Date());
			log.setCreateIP(obtainIp.getIpAddr(request));
			log.setCharact(2);
			
			logService.insertSelective(log);
			
			if(row==1){
				return "../../login";
			}else{
				//0表示无返回结果
				return "/company/index_forget";
			}
		}else{
			return "/company/index_forget";
		}
		
	}
	
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	
	@RequestMapping(value="/selectAdmin.html")
	public String selectAdmin(HttpServletRequest request,
			HttpSession session){
		CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
		companyAdmin.setPhone(null);
		companyAdmin.setPassword(null);
		companyAdmin.setUsername(null);
		
		List<CompanyAdmin> listAdmin=companyAdminService.selectAdmin(companyAdmin);
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyAdmin");
		log.setTable_remarks("公司管理员表");
		log.setData_id(companyAdmin.getAdmin_id());
		log.setUid(companyAdmin.getAdmin_id());
		log.setuName(companyAdmin.getUsername());
		log.setOperate("查询所有管理员");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
		
		logService.insertSelective(log);
		
		request.setAttribute("companyAdmins", listAdmin);
		return "/company/user/oi_enter_manager";
	}
	/**
	 * 查询所有管理员
	 * @return
	 */
	@RequestMapping(value="/selectAdmin.do")
	@ResponseBody
	public Msg selectAdmin(String value,
			String pageSize,HttpServletRequest request,
			@RequestParam(value="pn",defaultValue="1") Integer pn){
		CompanyAdmin companyAdmin=new CompanyAdmin();
		companyAdmin.setAdmin_id(Integer.parseInt(value));
		PageHelper.startPage(pn, Integer.parseInt(pageSize));
		List<CompanyAdmin> listAdmin=companyAdminService.selectAdmin(companyAdmin);
		
		//添加日志开始
		ObtainIp obtainIp=new ObtainIp();
		Log log=new Log();
		log.setTableName("CompanyAdmin");
		log.setTable_remarks("公司管理员表");
		log.setData_id(companyAdmin.getAdmin_id());
		log.setUid(companyAdmin.getAdmin_id());
		log.setuName(companyAdmin.getUsername());
		log.setOperate("查询所有管理员");
		log.setCreateDate(new Date());
		log.setCreateIP(obtainIp.getIpAddr(request));
		log.setCharact(2);
		
		logService.insertSelective(log);
		//添加日志结束
		
		
		PageInfo<CompanyAdmin> page=new PageInfo<>(listAdmin, 3);
		return Msg.success().add("pageinfo", page);
	}
	
	/**
	 * 根据ID查询企业管理员
	 * @param admin_id
	 * @return
	 */
	@RequestMapping(value="/selectAdminByID.do")
	@ResponseBody
	public Object selectAdminByID(int admin_id,HttpServletRequest request){
		CompanyAdmin companyAdmin=companyAdminService.selectByPrimaryKey(admin_id);
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyAdmin");
				log.setTable_remarks("公司管理员表");
				log.setData_id(companyAdmin.getAdmin_id());
				log.setUid(companyAdmin.getAdmin_id());
				log.setuName(companyAdmin.getUsername());
				log.setOperate("根据ID查询企业管理员");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
				
				logService.insertSelective(log);
				//添加日志结束
		if(companyAdmin !=null){
			return JSONArray.toJSON(companyAdmin);
		}else{
			return "../../login";
		}
	}
	/**
	 * 根据ID修改企业管理员
	 * @param record
	 * @return
	 */
	@RequestMapping(value="/UpdateAdminByID.do")
	@ResponseBody
	public Object UpdateAdminByID(CompanyAdmin record,HttpServletRequest request){
		//CompanyAdmin record=new CompanyAdmin();
		int row=companyAdminService.updateByPrimaryKeySelective(record);
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyAdmin");
				log.setTable_remarks("公司管理员表");
				log.setData_id(record.getAdmin_id());
				log.setUid(record.getAdmin_id());
				log.setuName(record.getUsername());
				log.setOperate("根据ID修改企业管理员");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
				
				logService.insertSelective(log);
				//添加日志结束
		if(row ==1){
			return JSONArray.toJSON(row);
		}else{
			return "../../login";
		}
	}
	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping("/register.html")
	public String register(){
		return "company/register";
	}
	
	/**
	 * 根据ID修改企业管理员
	 * @param record
	 * @return
	 */
	@RequestMapping(value="/register.do")
	@ResponseBody
	public Object register(String license_id,
			String phone,String password,
			HttpServletRequest request,
			HttpSession session){
		int random=(int)((Math.random()*9+1)*100000);
		MD5Tool md5=new MD5Tool();
		ObtainIp ip=new ObtainIp();
		int row=0;
		
		List<CompanyAdmin> listAdmin=companyAdminService.selectAdminByName(null,phone);
		if(listAdmin.size() !=0){
			return "/company/user/oi_enter_manager";
		}else{
			OiCompany company=new OiCompany();
			company.setIsdelete(0);
			company.setPhone(phone);
			company.setLicense_id(license_id);
			company.setCreate_time(new Date());
			company.setAudit(0);
			OiCompanyService.insertSelective(company);
			if(company.getCompany_id() != null){
				CompanyAdmin record=new CompanyAdmin();
				if(password != null){
					record.setPassword(md5.MD5(record.getPassword()+random));
				}
				record.setRole(1);
				record.setCreate_ip(ip.getIpAddr(request));
				record.setCompany_id(company.getCompany_id());
				record.setPhone(phone);
				record.setRandom(String.valueOf(random));
				record.setCreate_time(new Date());
				
				//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyAdmin");
				log.setTable_remarks("公司管理员表");
				log.setData_id(record.getAdmin_id());
				log.setUid(record.getAdmin_id());
				log.setuName(record.getUsername());
				log.setOperate("根据ID修改企业管理员");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
				
				logService.insertSelective(log);
				//添加日志结束
				
				row=companyAdminService.insertSelective(record);
			}			
		}
		return JSONArray.toJSON(row);
		
	}
	
	/**
	 * 跳转到注册账号
	 * @return
	 */
	@RequestMapping(value="/insert.html")
	public String insert(){
		return "company/user/oi_enter_mng_edite";
	}
	/**
	 * 注册及添加
	 * @param record
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/edit.html")
	public String InsertAdmin(CompanyAdmin record,
			HttpServletRequest request
			,HttpSession session) throws IOException{
		int random=(int)((Math.random()*9+1)*100000);
		MD5Tool md5=new MD5Tool();
		if(record.getUsername() !=null){
			try {
				record.setUsername(new String(record.getUsername().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}	
		}
		
		if(record.getAdmin_id() == null){
			List<CompanyAdmin> listAdmin=companyAdminService.selectAdminByName(null,record.getPhone());
			if(listAdmin.size() !=0){
				return "/company/user/oi_enter_manager";
			}else{
				CompanyAdmin companyAdmin=(CompanyAdmin) session.getAttribute("companyAdmin");
				record.setRole(1);
				ObtainIp obtainIp=new ObtainIp();
				record.setCreate_ip(obtainIp.getIpAddr(request));
				record.setCreate_time(new Date());
				record.setRandom(String.valueOf(random));
				record.setPassword(md5.MD5(record.getPassword()+random));
				record.setCompany_id(companyAdmin.getCompany_id());
				
				companyAdminService.selectAdmin(record);
				
				//添加日志开始
				Log log=new Log();
				log.setTableName("CompanyAdmin");
				log.setTable_remarks("公司管理员表");
				log.setData_id(record.getAdmin_id());
				log.setUid(record.getAdmin_id());
				log.setuName(record.getUsername());
				log.setOperate("添加公司管理员");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
				
				logService.insertSelective(log);
				//添加日志结束
				
				int row=companyAdminService.insertSelective(record);
			}
		}else{
			List<CompanyAdmin> listAdmin=companyAdminService.selectAdminByName(null,record.getPhone());
			if(listAdmin.size() ==0){
				return "/company/user/oi_enter_manager";
			}else{
				record.setRole(1);
				ObtainIp obtainIp=new ObtainIp();
				record.setCreate_ip(obtainIp.getIpAddr(request));
				record.setPassword(md5.MD5(record.getPassword()+listAdmin.get(0).getRandom()));
				
				companyAdminService.selectAdmin(record);
				
				//添加日志开始
				Log log=new Log();
				log.setTableName("CompanyAdmin");
				log.setTable_remarks("公司管理员表");
				log.setData_id(record.getAdmin_id());
				log.setUid(record.getAdmin_id());
				log.setuName(record.getUsername());
				log.setOperate("修改公司管理员根据ID");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(2);
				
				logService.insertSelective(log);
				//添加日志结束
				
				int row=companyAdminService.updateByPrimaryKeySelective(record);
				}
		}		
		return "/company/user/oi_enter_manager";
	}
	
	/**
	 * 跳转到修改账号
	 * @return
	 */
	@RequestMapping(value="/update.html")
	public String update(String id,HttpServletRequest request){
		
		CompanyAdmin companyAdmin=companyAdminService.selectByPrimaryKey(Integer.parseInt(id));
		request.setAttribute("companyAdmin1", companyAdmin);
		return "company/user/oi_enter_mng_edite";
	}
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/loginOut.html")
	public String loginOut(HttpSession session){
		session.invalidate();
		return "../../login";
		
	}
	public static int getRandom() {
		return random;
	}
	public static void setRandom(int random) {
		CompanyAdminController.random = random;
	}
	
}
