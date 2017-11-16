package cn.zx.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.service.CompanyStafferService;
import cn.zx.tool.MD5Tool;
import cn.zx.tool.Msg;

@RequestMapping("/staffLogin")
@Controller
public class OiStaffLoginController {
	@Autowired
	CompanyStafferService companyStafferService;
	
	//登陆
		@RequestMapping(value="/login.json")
		@ResponseBody
		public Msg staffLogin(String sf_username,String sf_password,HttpSession session){
			
			cn.zx.pojo.CompanyStafferExample example  = new CompanyStafferExample();
			cn.zx.pojo.CompanyStafferExample.Criteria criteria=example.createCriteria();
			MD5Tool md5Tool=new MD5Tool();
			criteria.andPhoneEqualTo(sf_username);
			criteria.andSfPasswordEqualTo(md5Tool.MD5(sf_password));
			criteria.andStatusEqualTo(1);
			criteria.andAuditEqualTo(1);
			List<CompanyStaffer> companyStaffers = companyStafferService.staffLogin(example);
			if(companyStaffers.size()!=0){
				CompanyStaffer Staffer= companyStaffers.get(0);
				CompanyStaffer companyStaffer = companyStafferService.staffLoginsession(Staffer.getUser_id());
				
				session.setAttribute("companyStaffer", companyStaffer);
				return Msg.success();
			}else{
				return Msg.fail();
			}
		}
	
	//注销
	@RequestMapping(value = "/oi_staff_login.html")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "staff/oi_staff_login";
	}
}
