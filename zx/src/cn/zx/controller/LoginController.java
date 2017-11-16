package cn.zx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.pojo.CompanyStafferExample.Criteria;
import cn.zx.pojo.WechatSetting;
import cn.zx.pojo.WechatTemporary;
import cn.zx.service.CompanyStafferService;
import cn.zx.service.OiSiteService;
import cn.zx.service.WechatSettingService;
import cn.zx.service.WechatTemporaryService;
import cn.zx.tool.CookieUtil;
import cn.zx.tool.HttpsUtil;
import cn.zx.tool.ObtainIp;
import cn.zx.tool.UrlUtf8;
import cn.zx.util.WeChatInfo;
import cn.zx.util.WeChatUserInfo;
import me.chanjar.weixin.common.exception.WxErrorException;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WeChatLogin")
public class LoginController {
	@Autowired
	WechatSettingService wechatService;
	@Autowired
	WechatTemporaryService wechatTemporaryService;
	@Autowired
	CompanyStafferService companyStafferService;

	@RequestMapping("/go")
	public String login(HttpSession session, HttpServletResponse response,
			@RequestParam(value = "cid", required = false) Integer cid, HttpServletRequest request) {
		CookieUtil cookieUtil = new CookieUtil();
		String ua = ((HttpServletRequest) request).getHeader("user-agent").toLowerCase();
		if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
			System.out.println("微信登录");
			if (cid != null) {// 是否携带公司id
				System.out.println("携带公司id:" + cid);
				String uid = cookieUtil.findCookieByName(request, "uid");
				if (uid == null||uid.equals("null")) {// 没有uid缓存
					System.out.println("未携带uid");
					WechatSetting Wechat = wechatService.selectWechat(cid);
					if (Wechat != null) {// 公司信息存在
						UrlUtf8 utf8 = new UrlUtf8();
						StringBuffer buffer = new StringBuffer();
						buffer.append("redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
						buffer.append(Wechat.getAppid());
						buffer.append("&redirect_uri=");
				        buffer.append(utf8.urlEncodeUTF8("http://oi.sxfs0351.com/zx/WeChatLogin/login/"+cid));
						//buffer.append(utf8.urlEncodeUTF8("http://ngup.free.ngrok.cc/zx/WeChatLogin/login?cid="+cid));
						buffer.append("&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
						System.out.println(buffer.toString());
						session.setAttribute("WechatSetting", Wechat);
						session.setAttribute("cid",cid);
						return buffer.toString();
					} else {
						// 公司不存在error
						System.out.println("公司不存在");
						cookieUtil.clearCookie(request, response, "uid");
						return "staff/companynotfound";
					}
				} else {// 有缓存直接登录
					System.out.println("uid=" + uid);
					CompanyStaffer staffer = companyStafferService.staffLoginsession(Integer.parseInt(uid));
					if (staffer != null && staffer.getAudit() == 0) {// 有员工信息&&在审核
						return "staff/oi_checking";
					} else if (staffer != null && staffer.getAudit() == 1 && staffer.getStatus() == 1) {// 有员工信息&&通过审核
						session.setAttribute("companyStaffer", staffer);
						System.out.println(staffer);
						return "redirect:../Newstaff/oi_staff_welPage.html";
					} else {// 无员工信息||离职
						System.out.println("用户没找到");
						cookieUtil.clearCookie(request, response, "uid");
						return "staff/usernotfound";
					}
				}
			} else {// 无公司信息
				System.out.println("没公司id");
				return "staff/oi_staff_register_pc";
			}
		} else {// PC登录
			System.out.println("PC端");
			return "staff/oi_staff_register_pc";
		}
	}

	@RequestMapping("/login/{cid}")
	public String login(@PathVariable("cid") Integer cid,HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws WxErrorException, Exception {
		CookieUtil cookieUtil = new CookieUtil();
		String code = request.getParameter("code");
		WechatSetting wechat = wechatService.selectWechat(cid);
		System.out.println(wechat);
		StringBuffer buffer = new StringBuffer();
		buffer.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
		buffer.append(wechat.getAppid());
		buffer.append("&secret=");
		buffer.append(wechat.getAppsecret());
		buffer.append("&code=" + code);
		buffer.append("&grant_type=authorization_code");
		System.out.println(buffer.toString());
		JSONObject jsss = HttpsUtil.httpRequest(buffer.toString(), "GET", null);
		String json = "[" + jsss.toString() + "]";
		System.out.println(json);
		WeChatInfo weChatInfo = JSON.parseArray(json, WeChatInfo.class).get(0);
		System.out.println("进行中");
		CompanyStafferExample example = new CompanyStafferExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andOpenIdEqualTo(weChatInfo.getOpenid());
		createCriteria.andCompanyIdEqualTo(wechat.getCompany_id());
		createCriteria.andStatusEqualTo(1);
		createCriteria.andAuditNotEqualTo(-1);
		List<CompanyStaffer> Staffers = new ArrayList<CompanyStaffer>();
		Staffers = companyStafferService.staffLogin(example);
		Integer count = Staffers.size();
		if (count == 1) { // open_ID查询是否存在
			CompanyStaffer Staffer = Staffers.get(0);
			if (Staffer.getAudit() == 0) {
				return "staff/oi_checking";
			} else if (Staffer.getAudit() == 1) {
				System.out.println(Staffer.getUser_id());
				CompanyStaffer staffer1 = companyStafferService.staffLoginsession(Staffer.getUser_id());
				session.setAttribute("companyStaffer", staffer1);
				System.out.println(staffer1);
				cookieUtil.addCookie(response, "uid", staffer1.getUser_id() + "", 365 * 24 * 60 * 60);
				return "redirect:../Newstaff/oi_staff_welPage.html";
			} else {
				return "staff/404error";
			}
		} else if (count == 0) { // open_ID不存在直接注册
			System.out.println("open_IDbu存在");
			StringBuffer bufferstr = new StringBuffer();
			bufferstr.append("https://api.weixin.qq.com/sns/userinfo?access_token=");
			bufferstr.append(weChatInfo.getAccess_token());
			bufferstr.append("&openid=");
			bufferstr.append(weChatInfo.getOpenid());
			bufferstr.append("&lang=zh_CN");
			JSONObject jsss2 = HttpsUtil.httpRequest(bufferstr.toString(), "GET", null);
			String json2 = "[" + jsss2.toString() + "]";
			System.out.println(json2);
			WeChatUserInfo weChatUserInfo = JSON.parseArray(json2, WeChatUserInfo.class).get(0);
			System.out.println(weChatUserInfo);
			try {
				System.out.println("注册");
				WechatTemporary temporary = new WechatTemporary();
				ObtainIp obtainIp = new ObtainIp();
				temporary.setCompanyId(wechat.getCompany_id());
				temporary.setOpenId(weChatUserInfo.getOpenid());
				temporary.setHeader(weChatUserInfo.getHeadimgurl());
				temporary.setNickname(weChatUserInfo.getNickname());
				temporary.setRegTime(new Date());
				temporary.setRegIp(obtainIp.getIpAddr(request));
				wechatTemporaryService.addWechatTemporary(temporary);
				Integer touristid = temporary.getTouristid();
				request.setAttribute("reg_id", touristid);
				System.out.println(touristid);
				request.setAttribute("img", weChatUserInfo.getHeadimgurl());
				System.out.println(touristid);
				return "staff/oi_staff_register_tel";
			} catch (Exception e) {
				cookieUtil.clearCookie(request, response, "uid");
				return "staff/404error";
			}
		} else {
			// 内部错误
			cookieUtil.clearCookie(request, response, "uid");
			return "staff/404error";
		}
	}

}
