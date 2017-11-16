package cn.zx.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsType;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.pojo.DataEchart;
import cn.zx.pojo.Log;
import cn.zx.pojo.OiAdmin;
import cn.zx.pojo.OiAdminExample;
import cn.zx.pojo.OiAuthRule;
import cn.zx.pojo.OiAuthRuleExample;
import cn.zx.pojo.OiAuthRuleExample.Criteria;
import cn.zx.pojo.OiCompany;
import cn.zx.pojo.OiCompanyExample;
import cn.zx.pojo.OiDistrict;
import cn.zx.pojo.OiDistrictExample;
import cn.zx.pojo.OiRole;
import cn.zx.pojo.OiRoleExample;
import cn.zx.pojo.OiSite;
import cn.zx.pojo.OiType;
import cn.zx.pojo.OiTypeExample;
import cn.zx.service.CompanyDepartService;
import cn.zx.service.CompanyNewsService;
import cn.zx.service.CompanyStafferService;
import cn.zx.service.LogService;
import cn.zx.service.OiAdminService;
import cn.zx.service.OiAuthRuleService;
import cn.zx.service.OiCompanyService;
import cn.zx.service.OiDistrictService;
import cn.zx.service.OiRoleService;
import cn.zx.service.OiSiteService;
import cn.zx.service.OiTypeService;
import cn.zx.service.impl.CompanyNewsTypeServiceimpl;
import cn.zx.tool.MD5Tool;
import cn.zx.tool.Msg;
import cn.zx.tool.ObtainIp;

import com.alibaba.fastjson.JSONArray;


@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	OiSiteService oiSiteService;
	@Autowired
	OiDistrictService oiDistrictService;
	@Autowired
	OiAuthRuleService oiAuthRuleService;
	@Autowired
	OiTypeService oiTypeService;
	@Autowired
	OiCompanyService oiCompanyService;
	@Autowired
	OiRoleService oiRoleService;
	@Autowired
	OiAdminService oiAdminService;
	@Autowired
	LogService logService;
	@Autowired
	CompanyDepartService companyDepartService;
	@Autowired
	CompanyStafferService companyStafferService;
	@Autowired
	CompanyNewsService companyNewsService;
	@Autowired
	CompanyNewsTypeServiceimpl companyNewsTypeService;
	
	/**
	 * 跳转到平台公告
	 * @return
	 */
	@RequestMapping("/oi_enter_oiNews.html")
	public String showNews(){
		return "admin/oi_enter_news";
		
	}
	/**
	 * 跳转到平台公告类型
	 * @return
	 */
	@RequestMapping("/oi_enter_oiNewsType.html")
	public String showNewsType(){
		return "admin/oi_enter_newsType";
		
	}
	/**
	 * 查询到平台公告类型
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getOiNewsType")
	public Object getNewsType(){
		List<CompanyNewsType> listType=companyNewsTypeService.selectNewsType(null);		
		return JSONArray.toJSON(listType);
		
	}
	
	
	/**
	 * 添加平台公告类型
	 * @return
	 */
	@RequestMapping("/insertOiNewsType.html")
	public Object insertOiNewsType(){	
		return "admin/oi_enter_news_Type_edit";
		
	}
	/**
	 * 修改平台公告类型
	 * @return
	 */
	@RequestMapping("/UpdateOiNewsType.html")
	public Object UpdateOiNewsType(Integer id,HttpServletRequest request){	
		List<CompanyNewsType> listType=companyNewsTypeService.selectNewsType(id);
		request.setAttribute("newsType", listType.get(0));
		return "admin/oi_enter_news_Type_edit";
		
	}
	/**
	 * 更新平台公告类型
	 * @return
	 */
	@RequestMapping("/editOiNewsType.html")
	public Object editOiNewsType(CompanyNewsType record){
		if(record.getNews_type() !=null && !record.getNews_type().equals("")){
			try {
				record.setNews_type(new String(record.getNews_type().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getNews_type_remarks() !=null && !record.getNews_type_remarks().equals("")){
			try {
				record.setNews_type_remarks(new String(record.getNews_type_remarks().getBytes("ISO8859-1"),"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
		if(record.getNews_type_id() == null){
			record.setCreate_time(new Date());
			record.setStatus(1);		
			companyNewsTypeService.addCompanyNewsType(record);
		}else{
			if(record.getNews_logo()==null || record.getNews_logo().equals("")){
				record.setNews_logo(null);
			}
			companyNewsTypeService.updateByPrimaryKeySelective(record);
		}
		return "admin/oi_enter_newsType";
		
	}
	/**
	 * 删除平台类型
	 * @param dataType
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteNewsType.do")
	public Msg deleteNewsType(@RequestParam("dataType")String dataType,@RequestParam("id")String id){
		try {
			CompanyNewsType record=new CompanyNewsType();
			record.setNews_type_id(Integer.parseInt(id));
			record.setStatus(0);
			companyNewsTypeService.updateByPrimaryKeySelective(record);
			return Msg.success();
		} catch (NumberFormatException e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 显示平台公告
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getOiNews")
	public Object getOiNews() {
		List<CompanyNews> listNews=companyNewsService.selectNews(null, null,null);
		List<CompanyNews> list=new ArrayList<CompanyNews>();
		//过滤
		if(listNews!=null){
			for (int i = 0; i < listNews.size(); i++) {
				if(listNews.get(i).getType()!=null && !listNews.get(i).getType().equals("企业公告")){
					list.add(listNews.get(i));
				}
			}
		}
		return list;
	}
	
	/**
	 * 更新平台公告（不加部门）
	 * @param session
	 * @param news
	 * @param user
	 * @return
	 */
	/*@RequestMapping(value = "/publishNotice",method=RequestMethod.POST)
	public String publishNotice(HttpSession session,CompanyNews news,@RequestParam(value="user",required=false)Integer user,
			@RequestParam(value="dept_id",required=false)Integer dept_id){
		OiAdmin admin=(OiAdmin) session.getAttribute("user");
		if(news.getNew_id()==null){
			if(user!=null){
				news.setUser_id(user);
			}else{
				news.setUser_id(0);
			}
			news.setType("平台公告");
			news.setCreate_time(new Date());
			news.setStatus(1);
			news.setPageView(0);
			news.setAuthor(admin.getUser_name());
			companyNewsService.insertSelective(news);
		}else{
			if(user!=null){
				news.setUser_id(user);
			}else{
				news.setUser_id(0);
			}
			companyNewsService.updateByPrimaryKeySelective(news);
		}
		return "admin/oi_enter_news";
	}*/
	
	/**
	 * 更新平台公告
	 * @param session
	 * @param news
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/publishNotice",method=RequestMethod.POST)
	public String publishNotice(HttpSession session,CompanyNews news,@RequestParam(value="user",required=false)Integer user,
			@RequestParam(value="dept_id",required=false)Integer dept_id){
		OiAdmin admin=(OiAdmin) session.getAttribute("user");
		//判断是否是添加
		if(news.getNew_id()==null){
			//部门ID是否不为空，员工ID不为空
			if((dept_id!=null && dept_id !=0) && (user!=null && user!=0)){
				news.setUser_id(user);
				news.setType("平台公告");
				news.setCreate_time(new Date());
				news.setStatus(1);
				news.setPageView(0);
				news.setAuthor(admin.getUser_name());
				companyNewsService.insertSelective(news);
			}else if((dept_id!=null && dept_id !=0) && (user==null || user==0)){
				//部门ID不为空，员工ID为空
				List<CompanyStaffer> listStaff = companyStafferService.selectByDepart(dept_id, news.getCompany_id());
				for (int i = 0; i < listStaff.size(); i++) {
					news.setUser_id(listStaff.get(i).getUser_id());
					news.setType("平台公告");
					news.setCreate_time(new Date());
					news.setStatus(1);
					news.setPageView(0);
					news.setAuthor(admin.getUser_name());
					companyNewsService.insertSelective(news);
				}
			}else{
				//部门ID，员工ID都为空
				news.setUser_id(0);
				news.setType("平台公告");
				news.setCreate_time(new Date());
				news.setStatus(1);
				news.setPageView(0);
				news.setAuthor(admin.getUser_name());
				companyNewsService.insertSelective(news);
			}			
		}else{
			//部门ID是否不为空，员工ID不为空
			if((dept_id!=null && dept_id !=0) && (user!=null && user!=0)){
				news.setUser_id(user);
				companyNewsService.updateByPrimaryKeySelective(news);
			}else if((dept_id!=null && dept_id !=0) && (user==null || user==0)){
				//部门ID不为空，员工ID为空
				List<CompanyStaffer> listStaff = companyStafferService.selectByDepart(dept_id, news.getCompany_id());
				
				for (int i = 0; i < listStaff.size(); i++) {
					news.setUser_id(listStaff.get(i).getUser_id());
					companyNewsService.updateByPrimaryKeySelective(news);
				}
			}else{
				//部门ID，员工ID都为空
				news.setUser_id(0);
				companyNewsService.updateByPrimaryKeySelective(news);
			}
		}
		return "admin/oi_enter_news";
	}
	/**
	 * 通过部门找员工
	 * @param dept_id
	 * @param company_id
	 * @return
	 */
	@RequestMapping(value = "/getstaffer/{dept_id}/{company_id}")
	@ResponseBody
	public Msg getstaffer(@PathVariable(value = "dept_id") Integer dept_id,@PathVariable(value = "company_id") Integer company_id) {
		CompanyStafferExample example=new CompanyStafferExample();
		cn.zx.pojo.CompanyStafferExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andAuditEqualTo(1);
		createCriteria.andStatusEqualTo(1);
		createCriteria.andCompanyIdEqualTo(company_id);
		createCriteria.andDepartEqualTo(dept_id);
		List<CompanyStaffer> staffers = companyStafferService.selectStaffByCompanyIdAndDepartId(example);
		System.out.println(staffers.size());
		return Msg.success().add("staffers", staffers);
	}
	
	/**
	 * 通过公司找部门
	 * @param company_id
	 * @return
	 */
	@RequestMapping(value = "/getdept/{company_id}")
	@ResponseBody
	public Msg getdept(@PathVariable(value = "company_id") Integer company_id) {
		CompanyDepartExample departExample = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = departExample.createCriteria();
		createCriteria.andStatusEqualTo(1);
		createCriteria.andIsdeleteEqualTo(1);
		createCriteria.andCompany_idEqualTo(company_id);
		List<CompanyDepart> depts = companyDepartService.selectDepartByCompanyId(departExample);
		System.out.println(depts.size());
		return Msg.success().add("depts", depts);
	}
	/**
	 * 修改及添加平台公告
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oi_enter_oiNews_Update.html")
	public String OiNewUpdate(String id,HttpServletRequest request) {
		OiCompanyExample example = new OiCompanyExample();
		cn.zx.pojo.OiCompanyExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andAuditEqualTo(1);
		createCriteria.andIsdeleteEqualTo(0);
		List<OiCompany> companys = oiCompanyService.selectCompanyByExample(example);
		System.out.println(companys.size());
		request.setAttribute("companys", companys);
		int new_id=0;
		List<CompanyNews> list=new ArrayList<CompanyNews>();
		if(id !=null){
			new_id=Integer.parseInt(id);
			list=companyNewsService.selectNews(new_id, null, null);
		}else{
			list=companyNewsService.selectNews(null, null, null);
		}
		
		List<CompanyNewsType>  listNewsType=companyNewsTypeService.selectNewsType(null);
		request.setAttribute("listNewsType", listNewsType);
		
		request.setAttribute("news",list.get(0) );
		return "/admin/oi_enter_oiNews_eidt";
	}
	
	/**
	 * 发布平台公告
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oi_enter_oiNews_eidt.html")
	public String OiNewEidt(HttpServletRequest request) {
		OiCompanyExample example = new OiCompanyExample();
		cn.zx.pojo.OiCompanyExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andAuditEqualTo(1);
		createCriteria.andIsdeleteEqualTo(0);
		List<OiCompany> companys = oiCompanyService.selectCompanyByExample(example);
		System.out.println(companys.size());
		request.setAttribute("companys", companys);
		
		List<CompanyNewsType>  listNewsType=companyNewsTypeService.selectNewsType(null);
		request.setAttribute("listNewsType", listNewsType);
		return "/admin/oi_enter_oiNews_eidt";
	}
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping(value="/oi_admin_index.html")
	public String indexPage(){
		return "/admin/index_v3";
	}
	/**
	 * 后台设置
	 * @return
	 */
	@RequestMapping(value="/oi_admin_siteSet.html")
	public String siteSetPage(){
		return "/admin/oi_admin_siteSet";
	}
	/**
	 * 企业类型
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_type.html")
	public String enterTypePage(){
		return "/admin/oi_admin_enter_type";
	}
	/**
	 * 企业地区
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_area.html")
	public String enterAreaPage(){
		return "/admin/oi_admin_enter_area";
	}
	/**
	 * 企业审核
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_list.html")
	public String enterListPage(){
		return "/admin/oi_admin_enter_list";
	}
	/**
	 * 系统管理员
	 * @return
	 */
	@RequestMapping(value="/oi_admin_manager.html")
	public String adminManagerPage(){
		return "/admin/oi_admin_manager";
	}
	/**
	 * 系统角色
	 * @return
	 */
	@RequestMapping(value="/oi_admin_character.html")
	public String adminCharacterPage(){
		return "/admin/oi_admin_character";
	}
	/**
	 * 全国数据
	 * @return
	 */
	@RequestMapping(value="/oi_admin_data_center.html")
	public String adminCenterPage(){
		return "/admin/oi_admin_data_center";
	}
	/**
	 * 弹出公司修改
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_edite.html")
	public String adminAddConpanyPage(@RequestParam(value="companyId",required=false) Integer companyId,HttpServletRequest request){
		OiTypeExample example=new OiTypeExample();
		cn.zx.pojo.OiTypeExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		createCriteria.andIsdeleteEqualTo(0);
		List<OiType> type = oiTypeService.getType(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看企业分类");
		log.setTableName("OiType");
		log.setTable_remarks("企业分类");
		logService.insertSelective(log);
		request.setAttribute("Type", type);
		request.setAttribute("company", companyId);
		return "/admin/oi_admin_enter_edite";
	}
	/**
	 * 审核页面
	 * @return
	 */
	@RequestMapping(value="/oi_admin_enter_check.html")
	public String adminCheckPage(){
		return "/admin/oi_admin_enter_check";
	}
	/**
	 * 添加类型
	 * @return
	 */
	@RequestMapping(value="/oi_admin_en_typeTree_edit.html")
	public String adminAddTypetPage(@RequestParam(value="type") String type,@RequestParam(value="type_id",required=false,defaultValue="1") Integer type_id,HttpServletRequest request){
		System.out.println(type);
		if(type.equals("edit")){
			OiType oitype = oiTypeService.getTypeById(type_id);
			request.setAttribute("type", oitype);
			request.setAttribute("type_id", oitype.getPid());
		}else{
			request.setAttribute("type_id", type_id);
		}
		return "/admin/oi_admin_en_typeTree_edit";
	}
	/**
	 * 添加地区
	 * @return
	 */
	@RequestMapping(value="/oi_admin_en_districtTree_edit.html")
	public String adminAddDistrictPage(@RequestParam(value="type") String type,@RequestParam(value="district_id",required=false,defaultValue="1") Integer district_id,HttpServletRequest request){
		System.out.println(type);
		if(type.equals("edit")){
			OiDistrict oiDistrict = oiDistrictService.getDistrictById(district_id);
			request.setAttribute("oidistrict", oiDistrict);
			request.setAttribute("district_id", oiDistrict.getPid());
			System.out.println(oiDistrict);
		}else{
			request.setAttribute("district_id", district_id);
		}
		return "/admin/oi_admin_en_districtTree_edit";
	}
	
	/**
	 * 管理员修改
	 * @param adminId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/oi_admin_mng_edite.html")
	public String updateRolePage(@RequestParam(value="adminId",required=false)Integer adminId,
			HttpServletRequest request){
			request.setAttribute("adminId", adminId);
			OiAdmin oiAdmin= oiAdminService.getOiAdminByid(adminId);
			request.setAttribute("oiAdmin", oiAdmin);
		return "/admin/oi_admin_mng_edite";
	}
	/**
	 * 角色修改
	 * @param roleId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/oi_admin_chara_edite.html")
	public String updateAdminPage(@RequestParam(value="roleId",required=false)Integer roleId,
			HttpServletRequest request){
		System.out.println(roleId);
			request.setAttribute("roleId", roleId);
		return "/admin/oi_admin_chara_edite";
	}
	/**
	 * 角色新增
	 * @param adminId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/oi_admin_chara_add.html")
	public String addAdminPage(){
		return "/admin/oi_admin_chara_add";
	}
	
	@RequestMapping(value="/getnav")
	@ResponseBody
	public Object getnav(HttpSession session){
		OiAdmin admin=(OiAdmin) session.getAttribute("user");
		return JSONArray.toJSONString(admin);
	}
	
	@RequestMapping(value="/AdminLogin.html")
	public String AdminLoginPage(HttpSession session,HttpServletRequest request){
		OiAdmin admin=(OiAdmin) session.getAttribute("user");
		if(admin==null){
			return "../../index";
		}else{
List<Integer> functions=new ArrayList<>();
			
			String[] functionsids =null;
			if(admin.getRules() !=null){
				functionsids= admin.getRules().split(",");
				for (String string : functionsids) {
					functions.add(Integer.parseInt(string));
				}
				OiAuthRuleExample example =new OiAuthRuleExample();
				Criteria createCriteria = example.createCriteria();
				createCriteria.andR_idIn(functions);
				createCriteria.andIslinkEqualTo(1);
				List<OiAuthRule> rules=oiAuthRuleService.getMenu(example);
				admin.setRules(null);
				admin.setRoles(rules);
			}
			
			
			System.out.println(admin);
			session.setAttribute("user",admin);
		return "/admin/index";

		}
	}
	/**
	 * 验证登录信息
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/AdminCheckLogin",method=RequestMethod.POST)
	@ResponseBody
	public Msg AdminCheckLogin(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session,HttpServletRequest request){
		OiAdmin admin=oiAdminService.checkLogin(username);
		
		MD5Tool md5=new MD5Tool();
		try {
			if(admin==null){
				return Msg.fail().add("message","输入的用户名不存在");
			}else{
				if(admin.getPassword().equals(md5.MD5(password))){
					session.setAttribute("user", admin);
					Log log=Log.AdminRecordLog(request);
					log.setOperate("管理员登录");
					log.setTableName("oiAdmin");
					log.setTable_remarks("平台管理员");
					logService.insertSelective(log);
					System.out.println("进入");
					return Msg.success().add("message","正在登录...");
				}else{
					return Msg.fail().add("message","密码不正确");
				}
			}
		} catch (Exception e) {
			return Msg.fail().add("message","系统错误");
		}
	}
	
	
	
	/**
	 * 修改准备
	 * @param roleid
	 * @return
	 */
	@RequestMapping(value="/getroleandrule/{roleid}",method=RequestMethod.POST)
	@ResponseBody
	public Object getroleandrule(@PathVariable("roleid")Integer roleid,HttpServletRequest request){
		OiRole role = oiRoleService.getOiRoleByid(roleid);
		List<Integer>  roles=new ArrayList<>();
		String[] str_ids = role.getRules().split(",");
		//组装id集合
		for ( String string: str_ids) {
			roles.add(Integer.parseInt(string));
		}
		role.setRules(null);
		role.setRule(roles);
		List<Object> list=new ArrayList<Object>();
		OiAuthRuleExample example=new OiAuthRuleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiAuthRule> menu = oiAuthRuleService.getMenu(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("获取权限");
		log.setTableName("OiAuthRule");
		log.setTable_remarks("权限表");
		logService.insertSelective(log);
		list.add(role);
		list.add(menu);
		return JSONArray.toJSONString(list);
		
	}
	
	/**
	 * 获取分类
	 * @param pro_id
	 * @return
	 */
	@RequestMapping(value="/findtype",method=RequestMethod.GET)
	@ResponseBody
	public Msg gettype(HttpServletRequest request){
		OiTypeExample example=new OiTypeExample();
		cn.zx.pojo.OiTypeExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		createCriteria.andIsdeleteEqualTo(0);
		List<OiType> types = oiTypeService.getType(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查找企业分类");
		log.setTableName("OiType");
		log.setTable_remarks("企业分类表");
		logService.insertSelective(log);
		return Msg.success().add("Types", types);
	}
	/**
	 * 审核公司
	 */
	@RequestMapping(value="/checkcompany.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg checkcompany(@RequestParam("company_id") Integer company_id,@RequestParam("type") String type,HttpServletRequest request){	
		//System.out.println(company_id+"======"+type);
		Integer audit;
		if(type.equals("pass")){
			audit=1;
		}else{
			audit=2;
		}
		OiCompany company;
		try {
			company = new OiCompany();
			company.setAudit(audit);
			company.setAudit_time(new Date());
			company.setCompany_id(company_id);
			oiCompanyService.updateExamineCompany(company);
			Log log=Log.AdminRecordLog(request);
			log.setOperate("审核企业"+company.toString());
			log.setTableName("oiCompany");
			log.setTable_remarks("企业表");
			logService.insertSelective(log);
			return Msg.success();
		} catch (Exception e) {
			return Msg.fail();
		}
		
	}
	/**
	 * 显示待审核列表
	 * @return
	 */
	@RequestMapping(value="/getcheckcompanylist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getCheckdCompany(HttpServletRequest request){	
		List<OiCompany> companys=oiCompanyService.getCheckCompanyWithType( );
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看待审核企业");
		log.setTableName("oiCompany");
		log.setTable_remarks("企业表");
		logService.insertSelective(log);
	String jsonString = JSONArray.toJSONString(companys);		
	return jsonString;
	}
	
	/**
	 * 获取省
	 * @param pro_id
	 * @return
	 */
	@RequestMapping(value="/companyready.do",method=RequestMethod.GET)
	@ResponseBody
	public Msg getpro(HttpServletRequest request){
		OiDistrictExample districtExample=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria2 = districtExample.createCriteria();
		createCriteria2.andPidEqualTo(1);
		createCriteria2.andStatusEqualTo(1);
		List<OiDistrict> district = oiDistrictService.getDistrict(districtExample);
		/*Log log=Log.AdminRecordLog(request);
		log.setOperate("查看省");
		log.setTableName("OiDistrict");
		log.setTable_remarks("地区表");
		logService.insertSelective(log);*/
		return Msg.success().add("district", district);
	}
	
	/**
	 * 获取城市
	 * @param pro_id
	 * @return
	 */
	@RequestMapping(value="/findcity",method=RequestMethod.GET)
	@ResponseBody
	public Msg getcity(@RequestParam("pro_id")Integer pro_id,HttpServletRequest request){
		OiDistrictExample districtExample=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria2 = districtExample.createCriteria();
		createCriteria2.andPidEqualTo(pro_id);
		List<OiDistrict> district = oiDistrictService.getDistrict(districtExample);
		/*Log log=Log.AdminRecordLog(request);
		log.setOperate("查看城市");
		log.setTableName("OiDistrict");
		log.setTable_remarks("地区表");
		logService.insertSelective(log);*/
		return Msg.success().add("districts", district);
	}
	
	/**
	 * 获取地区
	 * @param city_id
	 * @return
	 */
	@RequestMapping(value="/findarea",method=RequestMethod.GET)
	@ResponseBody
	public Msg getarea(@RequestParam("city_id")Integer city_id,HttpServletRequest request){
		OiDistrictExample districtExample=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria2 = districtExample.createCriteria();
		createCriteria2.andPidEqualTo(city_id);
		List<OiDistrict> district = oiDistrictService.getDistrict(districtExample);
		/*Log log=Log.AdminRecordLog(request);
		log.setOperate("查看城市");
		log.setTableName("OiDistrict");
		log.setTable_remarks("地区表");
		logService.insertSelective(log);*/
		return Msg.success().add("districts", district);
	}
	
	/**
	 * 数据中心获取企业分类信息
	 * @return
	 */
	@RequestMapping(value="/gettypedata",method=RequestMethod.GET)
	@ResponseBody
	public Object getData1(HttpServletRequest request){
		List<DataEchart> types=oiCompanyService.selectCompanyTypeCount();
		Log log=Log.AdminRecordLog(request);
				log.setOperate("数据中心获取企业分类信息");
				log.setTableName("oiCompany，oi_type");
				log.setTable_remarks("企业表，企业分类表");
				logService.insertSelective(log);
		String jsonString = JSONArray.toJSONString(types);		
		System.out.println(jsonString);
		return jsonString;
	}
	
	/**
	 * 数据中心获取省份信息
	 * @return
	 */
	@RequestMapping(value="/getprodata",method=RequestMethod.GET)
	@ResponseBody
	public Object getData2(	HttpServletRequest request){
		Log log=Log.AdminRecordLog(request);
				log.setOperate("数据中心获取省份信息");
				log.setTableName("oiCompany，oi_district");
				log.setTable_remarks("企业表,地区表");
				logService.insertSelective(log);
		List<DataEchart> pros=oiCompanyService.selectCompanyProvinceCount();
		String jsonString = JSONArray.toJSONString(pros);	
		System.out.println(jsonString);
		return jsonString;
	}
	
	/**
	 * 数据中心获取公司任务信息
	 * @return
	 */
	@RequestMapping(value="/gettaskdata",method=RequestMethod.GET)
	@ResponseBody
	public Object getData3(HttpServletRequest request){
		List<DataEchart> tasks=oiCompanyService.selectTaskCount();
		List<String> companyname=new ArrayList<String>();
		List<Integer> finish=new ArrayList<Integer>();
		List<Integer> unfinish=new ArrayList<Integer>();
		List<Object> taskdata=new ArrayList<Object>();
		Log log=Log.AdminRecordLog(request);
		log.setOperate("数据中心获取公司任务信息");
		log.setTableName("oiCompany，company_task");
		log.setTable_remarks("企业表，任务表");
		logService.insertSelective(log);
		for (DataEchart dataEchart : tasks) {
			companyname.add(dataEchart.getName());
			finish.add(dataEchart.getValue());
			unfinish.add(dataEchart.getValue_b());
		}
		taskdata.add(companyname);
		taskdata.add(finish);
		taskdata.add(unfinish);
		String jsonString = JSONArray.toJSONString(taskdata);		
		System.out.println(jsonString);
		return jsonString;
	}
	
	/**
	 * 获取管理员
	 * @param admin_id
	 * @return
	 */
	@RequestMapping(value="/getadmin.do/{admin_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAdminById(@PathVariable("admin_id")Integer admin_id,HttpServletRequest request){
		OiAdmin admin = oiAdminService.getOiAdminByid(admin_id);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("获取管理员信息，ID:"+admin_id);
		log.setTableName("oiAdmin");
		log.setTable_remarks("管理员表");
		logService.insertSelective(log);
		return Msg.success().add("Admin",admin);
	}
	
	/**
	 * 获取管理员列表
	 * @return
	 */
	@RequestMapping(value="/getadminlist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getAdmin(HttpServletRequest request){
		OiAdminExample example=new OiAdminExample();
		cn.zx.pojo.OiAdminExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiAdmin> admins=oiAdminService.getAdmin(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看管理员列表");
		log.setTableName("oiAdmin");
		log.setTable_remarks("管理员表");
		logService.insertSelective(log);
		String jsonString = JSONArray.toJSONString(admins);		
	return jsonString;
	}
	/**
	 * 修改管理员
	 * @param oiRole
	 * @return
	 */
	@RequestMapping(value="/updateadmin.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateAdmin(OiAdmin admin,HttpServletRequest request){
		
		ObtainIp ip=new ObtainIp();
		try{
			if(admin.getAdmin_id()==null){
				OiAdminExample example=new OiAdminExample();
				cn.zx.pojo.OiAdminExample.Criteria createCriteria = example.createCriteria();
				createCriteria.andPhoneEqualTo(admin.getPhone());
				List<OiAdmin> listAdmin=oiAdminService.getAdmin(example);
				if(listAdmin !=null && listAdmin.size() !=0){
					return Msg.fail().add("msg", "用户已存在");
				}else{
					admin.setCreate_ip(ip.getIpAddr(request));
					admin.setCreate_time(new Date());
					admin.setStatus(1);
					
					MD5Tool md5=new MD5Tool();
					if(admin.getPassword() != null){
						admin.setPassword(md5.MD5(admin.getPassword()));
					}
					oiAdminService.addAdmin(admin);
				}
				Log log=Log.AdminRecordLog(request);
				log.setOperate("增加管理员"+admin.toString());
				log.setTableName("oiAdmin");
				log.setTable_remarks("管理员表");
				logService.insertSelective(log);
			}else{				
				MD5Tool md5=new MD5Tool();
				if(admin.getPassword() != null && !admin.getPassword().equals("")){
					admin.setPassword(md5.MD5(admin.getPassword()));
				}else{
					OiAdmin oiAdminOld=oiAdminService.getOiAdminByid(admin.getAdmin_id());
					admin.setPassword(oiAdminOld.getPassword());
				}
				oiAdminService.updateAdmin(admin);
				Log log=Log.AdminRecordLog(request);
				log.setOperate("修改管理员"+admin.toString());
				log.setTableName("oiAdmin");
				log.setTable_remarks("管理员表");
				logService.insertSelective(log);
			}
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 删除管理员
	 * @param role_id
	 * @return
	 */
	@RequestMapping(value="/removeadmin.do/{admin_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeAdmin(@PathVariable("admin_id")Integer admin_id,HttpServletRequest request){
		System.out.println(admin_id);
		try{
			OiAdmin oiAdmin=new OiAdmin();
			oiAdmin.setAdmin_id(admin_id);
			oiAdmin.setStatus(0);
			oiAdminService.removeAdmin(oiAdmin);
			Log log=Log.AdminRecordLog(request);
			log.setOperate("删除管理员，ID:"+admin_id);
			log.setTableName("oiAdmin");
			log.setTable_remarks("管理员表");
			logService.insertSelective(log);
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	
	/**
	 * 获取角色
	 * @param role_id
	 * @return
	 */
	@RequestMapping(value="/getrole.do/{role_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getRoleById(@PathVariable("role_id")Integer role_id,HttpServletRequest request){
		OiRole oiRole = oiRoleService.getOiRoleByid(role_id);
		List<Integer> functions=new ArrayList<>();
		String[] functionsids = oiRole.getRules().split(",");
		for (String string : functionsids) {
			functions.add(Integer.parseInt(string));
		}
		OiAuthRuleExample example =new OiAuthRuleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiAuthRule> rules=oiAuthRuleService.getMenu(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("获取角色信息，ID:"+role_id+"，获取权限");
		log.setTableName("oiRole，oiAuthRule");
		log.setTable_remarks("角色表，权限表");
		logService.insertSelective(log);
		return Msg.success().add("Role",oiRole).add("Rules", rules);
	}
	/**
	 * 获取角色列表
	 * @return
	 */
	@RequestMapping(value="/getrolelist",method=RequestMethod.GET)
	@ResponseBody
	public Object getRoleList(HttpServletRequest request){
		OiRoleExample example=new OiRoleExample();
		cn.zx.pojo.OiRoleExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiRole> roles=oiRoleService.getAllRole(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("获取角色列表");
		log.setTableName("oiRole");
		log.setTable_remarks("角色表");
		logService.insertSelective(log);
	return Msg.success().add("Roles", roles);
	}
	
	
	/**
	 * 获取角色列表
	 * @param pn
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value="/getrolelist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getRole(HttpServletRequest request){
		OiRoleExample example=new OiRoleExample();
		cn.zx.pojo.OiRoleExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiRole> roles=oiRoleService.getAllRole(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("获取角色列表");
		log.setTableName("oiRole");
		log.setTable_remarks("角色表");
		logService.insertSelective(log);
		System.out.println("--->"+JSONArray.toJSONString(roles));
	return JSONArray.toJSONString(roles);
	}
	
	/**
	 * 修改角色
	 * @param oiRole
	 * @return
	 */
	@RequestMapping(value="/updaterole.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateRole(OiRole oiRole,HttpServletRequest request){
		try{
			oiRoleService.updateRole(oiRole);
			Log log=Log.AdminRecordLog(request);
			log.setOperate("修改角色"+oiRole.toString());
			log.setTableName("oiRole");
			log.setTable_remarks("角色表");
			logService.insertSelective(log);
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 删除角色
	 * @param role_id
	 * @return
	 */
	@RequestMapping(value="/removerole.do/{role_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeRole(@PathVariable("role_id")Integer role_id,HttpServletRequest request){
		try{
			OiRole oiRole=new OiRole();
			oiRole.setO_r_id(role_id);
			oiRole.setStatus(0);
			oiRoleService.removeRole(oiRole);
			Log log=Log.AdminRecordLog(request);
			log.setOperate("删除角色，ID:"+role_id);
			log.setTableName("oiRole");
			log.setTable_remarks("角色表");
			logService.insertSelective(log);
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 增加角色
	 * @param oiRole
	 * @return
	 */
	@RequestMapping(value="/addrole.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg addRole(OiRole oiRole,HttpServletRequest request){
		System.out.println(oiRole);
		try{
			oiRoleService.addRole(oiRole);
			Log log=Log.AdminRecordLog(request);
			log.setOperate("修改角色"+oiRole.toString());
			log.setTableName("oiRole");
			log.setTable_remarks("角色表");
			logService.insertSelective(log);
			return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
		
	}
	
	/**
	 * 删除公司
	 * @param company
	 * @return
	 */
	@RequestMapping(value="/removecompany.do/{companyId}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeCompany(@PathVariable("companyId") Integer companyId,HttpServletRequest request){
			try {
				OiCompany company=new OiCompany();
				company.setCompany_id(companyId);
				company.setIsdelete(1);
				oiCompanyService.removecompany(company);
				Log log=Log.AdminRecordLog(request);
				log.setOperate("删除公司，ID:"+companyId);
				log.setTableName("oiCompany");
				log.setTable_remarks("企业表");
				logService.insertSelective(log);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	/**
	 * 获取公司信息
	 * @param company
	 * @return
	 */
	@RequestMapping(value="/getcompany.do/{company_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getcompany(@PathVariable("company_id") Integer company_id,HttpServletRequest request){
		OiCompany company = oiCompanyService.getCompanyById(company_id);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("获取企业信息，ID:"+company_id);
		log.setTableName("oiCompany");
		log.setTable_remarks("企业表");
		logService.insertSelective(log);
		return Msg.success().add("company",company);
		}
	/**
	 * 公司审核
	 * @param company
	 * @return
	 */
	@RequestMapping(value="/updatecompany.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateExamineCompany(OiCompany company,HttpServletRequest request){
			try {
					company.setAudit_time(new Date());
					System.out.println(company);
					oiCompanyService.updateExamineCompany(company);
					Log log=Log.AdminRecordLog(request);
					log.setOperate("审核企业:"+company.toString());
					log.setTableName("oiCompany");
					log.setTable_remarks("企业表");
					logService.insertSelective(log);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	/**
	 * 显示审核列表
	 * @param pn
	 * @param search
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value="/getcompanylist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getCompany(HttpServletRequest request){	
		List<OiCompany> companys=oiCompanyService.getCompanyWithType( );
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看审核列表");
		log.setTableName("oiCompany");
		log.setTable_remarks("企业表");
		logService.insertSelective(log);
	String jsonString = JSONArray.toJSONString(companys);
	return jsonString;
	}
	

	
	/**
	 * 修改地区
	 * @return
	 */
	@RequestMapping(value="/updatedistrict.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateDistrictById(OiDistrict district,HttpServletRequest request){
		System.out.println(district);
		try{
			if(district.getDistrict_id()==null){
				OiDistrict district2 = oiDistrictService.getDistrictById(district.getPid());
				district.setLevel(district2.getLevel()+1);
				oiDistrictService.addDistrict(district);
				Log log=Log.AdminRecordLog(request);
				log.setOperate("增加地区:"+district.toString());
				log.setTableName("oiDistrict");
				log.setTable_remarks("地区表");
				logService.insertSelective(log);
			}else{
		oiDistrictService.updateDistrict(district);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("增加地区:"+district.toString());
		log.setTableName("oiDistrict");
		log.setTable_remarks("地区表");
		logService.insertSelective(log);
			}
		return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
	}
	
	/**
	 * 移除地区
	 * @return
	 */
	@RequestMapping(value="/removedistrict.do/{district_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeDistrictById(@PathVariable("district_id") Integer district_id,HttpServletRequest request){
		System.out.println(district_id);
		try{
		OiDistrict district=new OiDistrict();
		district.setDistrict_id(district_id);
		district.setStatus(0);
		oiDistrictService.removeDistrict(district);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("删除地区，ID:"+district_id);
		log.setTableName("oiDistrict");
		log.setTable_remarks("地区表");
		logService.insertSelective(log);
		return Msg.success();
		}catch (Exception e) {
			return Msg.fail();
		}
	}
	
	
	/**
	 * 获取地区
	 * @return
	 */
	@RequestMapping(value="/getdistrict.do/{district_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getDistrictById(@PathVariable("district_id") Integer district_id,HttpServletRequest request){
		OiDistrict district = oiDistrictService.getDistrictById(district_id);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看地区，ID:"+district_id);
		log.setTableName("oiDistrict");
		log.setTable_remarks("地区表");
		logService.insertSelective(log);
		return Msg.success().add("District", district);
	}
	
	/**
	 * 获取地区列表
	 * @return
	 */
	@RequestMapping(value="/getdistrictlist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getDistrict(HttpServletRequest request){
		OiDistrictExample districtExample=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria = districtExample.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiDistrict> district = oiDistrictService.getDistrict(districtExample);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看地区列表");
		log.setTableName("oiDistrict");
		log.setTable_remarks("地区表");
		logService.insertSelective(log);
		return JSONArray.toJSON(district);
	}
	/**
	 * 获取地区列表
	 * @return
	 */
	@RequestMapping(value="/getdistrictlist",method=RequestMethod.GET)
	@ResponseBody
	public Msg getDistrictMsg(HttpServletRequest request){
		OiDistrictExample example=new OiDistrictExample();
		cn.zx.pojo.OiDistrictExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiDistrict> childTreeNodes = oiDistrictService.getDistrict(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看地区列表");
		log.setTableName("oiDistrict");
		log.setTable_remarks("地区表");
		logService.insertSelective(log);
		return Msg.success().add("District",childTreeNodes);
	}
	
	
	
	
	
	/**
	 * 增加/修改企业类型
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/updatetype.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateType(OiType oiType,HttpServletRequest request){
		try {
			if(oiType.getType_id()==null){
				oiType.setIsdelete(0);
				oiTypeService.addType(oiType);
				Log log=Log.AdminRecordLog(request);
				log.setOperate("增加企业类型"+oiType.toString());
				log.setTableName("oiType");
				log.setTable_remarks("企业类型表");
				logService.insertSelective(log);
			}else{
				oiTypeService.updateType(oiType);
				Log log=Log.AdminRecordLog(request);
				log.setOperate("修改企业类型"+oiType.toString());
				log.setTableName("oiType");
				log.setTable_remarks("企业类型表");
				logService.insertSelective(log);
			}
			return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	
	/**
	 * 移除去企业类型
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/removetype.do/{type_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg removeType(@PathVariable("type_id") Integer type_id,HttpServletRequest request){
			try {
				OiType oiType=new OiType();
				oiType.setType_id(type_id);
				oiType.setIsdelete(1);
				oiType.setStatus(0);
				oiTypeService.updateType(oiType);
				Log log=Log.AdminRecordLog(request);
				log.setOperate("删除企业类型，ID"+type_id);
				log.setTableName("oiType");
				log.setTable_remarks("企业类型表");
				logService.insertSelective(log);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	
	
	/**
	 * 查看某个企业类型
	 * @param type_id
	 * @return
	 */
	@RequestMapping(value="/gettype.do/{type_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getType(@PathVariable("type_id") Integer type_id,HttpServletRequest request){
		OiType oiType = oiTypeService.getTypeById(type_id);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看企业类型信息，ID"+type_id);
		log.setTableName("oiType");
		log.setTable_remarks("企业类型表");
		logService.insertSelective(log);
		return Msg.success().add("OiType", oiType);
		
	}
	
	/**
	 * 获取企业类型列表
	 * @return
	 */
	@RequestMapping(value="/gettypelist.do",method=RequestMethod.GET)
	@ResponseBody
	public Object getType(HttpServletRequest request){
		OiTypeExample example=new OiTypeExample();
		cn.zx.pojo.OiTypeExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiType> type = oiTypeService.getType(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看企业类型列表");
		log.setTableName("oiType");
		log.setTable_remarks("企业类型表");
		logService.insertSelective(log);
		return JSONArray.toJSON(type);
	}
	
	

	
	
	/**
	 * 修改菜单
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/updaterule.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg updateRule(OiAuthRule oiAuthRule,HttpServletRequest request){
		try {
			oiAuthRuleService.updateRule(oiAuthRule);
			Log log=Log.AdminRecordLog(request);
			log.setOperate("修改权限"+oiAuthRule.toString());
			log.setTableName("oiAuthRule");
			log.setTable_remarks("权限表");
			logService.insertSelective(log);
			return Msg.success();
		} catch (Exception e) {
			return Msg.fail();
		}
	}
	
	/**
	 * 查看某条菜单
	 * @param menu_id
	 * @return
	 */
	@RequestMapping(value="/getrulebyid.do/{menu_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectRule(@PathVariable("menu_id") Integer menu_id,HttpServletRequest request){
		OiAuthRule oiAuthRule = oiAuthRuleService.getRuleById(menu_id);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看权限信息"+menu_id);
		log.setTableName("oiAuthRule");
		log.setTable_remarks("权限表");
		logService.insertSelective(log);
		return Msg.success().add("OiAuthRule", oiAuthRule);
		
	}
	
	/**
	 * 移除菜单
	 * @param menu_id
	 * @return
	 */
	@RequestMapping(value="/removerule.do/{menu_id}",method=RequestMethod.POST)
	@ResponseBody
	public Msg romoveRule(@PathVariable("menu_id") Integer menu_id,HttpServletRequest request){
		OiAuthRule oiAuthRule=new OiAuthRule();
		oiAuthRule.setR_id(menu_id);
		oiAuthRule.setStatus(0);
			try {
				oiAuthRuleService.removeRule(oiAuthRule);
				Log log=Log.AdminRecordLog(request);
				log.setOperate("删除权限"+menu_id);
				log.setTableName("oiAuthRule");
				log.setTable_remarks("权限表");
				logService.insertSelective(log);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	
	/**
	 * 增加菜单
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/addrule.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg addRule(OiAuthRule oiAuthRule,HttpServletRequest request){
			try {
				oiAuthRule.setStatus(1);
				oiAuthRuleService.addRule(oiAuthRule);
				Log log=Log.AdminRecordLog(request);
				log.setOperate("增加权限"+oiAuthRule.toString());
				log.setTableName("oiAuthRule");
				log.setTable_remarks("权限表");
				logService.insertSelective(log);
				return Msg.success();
			} catch (Exception e) {
				return Msg.fail();
			}
		}
	
	/**
	 * 获取显示菜单列表
	 * @param oiAuthRule
	 * @return
	 */
	@RequestMapping(value="/getrule.do",method=RequestMethod.GET)
	@ResponseBody
	public Object GetRule(HttpServletRequest request){
		OiAuthRuleExample example=new OiAuthRuleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(1);
		List<OiAuthRule> menu = oiAuthRuleService.getMenu(example);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看权限列表");
		log.setTableName("oiAuthRule");
		log.setTable_remarks("权限表");
		logService.insertSelective(log);
		return JSONArray.toJSON(menu);
	}
	/**
	 * 修改设置信息
	 * @param oiSite
	 * @return
	 */
	@RequestMapping(value="/updatesite.do",method=RequestMethod.POST)
	@ResponseBody
	public Msg getSite(OiSite oiSite,HttpServletRequest request){
		System.out.println(oiSite);
		try {
			oiSiteService.updateSite(oiSite);
			Log log=Log.AdminRecordLog(request);
			log.setOperate("修改平台信息");
			log.setTableName("oiSite");
			log.setTable_remarks("平台设置表");
			logService.insertSelective(log);
			return Msg.success();
		} catch (Exception e) {
			return Msg.fail();
		}
	}
	
	
	/**
	 * 获取后台信息
	 * @return
	 */
	@RequestMapping(value="/getsite.do",method=RequestMethod.GET)
	@ResponseBody
	public Msg getSite(HttpServletRequest request){
		OiSite oiSite = oiSiteService.getoiSite().get(0);
		Log log=Log.AdminRecordLog(request);
		log.setOperate("查看平台信息");
		log.setTableName("oiSite");
		log.setTable_remarks("平台设置表");
		logService.insertSelective(log);
		if(oiSite==null){
			return Msg.fail();
		}
		return Msg.success().add("OiSite", oiSite);
	}
	
}
