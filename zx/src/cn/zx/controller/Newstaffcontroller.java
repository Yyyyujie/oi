package cn.zx.controller;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.zx.message.SendMessage;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyPostLevelExample;
import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.CompanyPropagandaExample;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.CompanyTaskImgExample;
import cn.zx.pojo.CompanyTaskProgress;
import cn.zx.pojo.CompanyTaskType;
import cn.zx.pojo.CompanyTaskExample.Criteria;
import cn.zx.pojo.CompanyTaskImg;
import cn.zx.pojo.DataEchart;
import cn.zx.pojo.Log;
import cn.zx.pojo.WechatSetting;
import cn.zx.pojo.WechatTemporary;
import cn.zx.pojo.WechatTmpl;
import cn.zx.pojo.WechatTmplExample;
import cn.zx.service.CompanyDepartService;
import cn.zx.service.CompanyNewsService;
import cn.zx.service.CompanyNewsTypeService;
import cn.zx.service.CompanyPropagandaService;
import cn.zx.service.CompanyStafferService;
import cn.zx.service.CompanyTaskService;
import cn.zx.service.CompanyTaskTypeService;
import cn.zx.service.DataEchartService;
import cn.zx.service.LogService;
import cn.zx.service.WechatSettingService;
import cn.zx.service.WechatTemporaryService;
import cn.zx.service.WechatTmplService;
import cn.zx.templateMessage.TemplateMessageData;
import cn.zx.tool.Base64;
import cn.zx.tool.CookieUtil;
import cn.zx.tool.DeptList;
import cn.zx.tool.HttpsUtil;
import cn.zx.tool.MD5Tool;
import cn.zx.tool.Msg;
import cn.zx.tool.ObtainIp;
import cn.zx.tool.RadarEcharts;
import cn.zx.tool.TaskInfo;
import cn.zx.tool.TaskInformation;
import cn.zx.tool.UrlUtf8;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("Newstaff")
public class Newstaffcontroller {

	@Autowired
	CompanyTaskService companyTaskService;
	@Autowired
	CompanyStafferService companyStafferService;
	@Autowired
	WechatTemporaryService wechatTemporaryService;
	@Autowired
	WechatSettingService wechatService;
	@Autowired
	CompanyDepartService companyDepartService;
	@Autowired
	LogService logService;
	@Autowired
	CompanyPropagandaService companyPropagandaService;
	@Autowired
	CompanyTaskTypeService companyTaskTypeService;
	@Autowired
	CompanyNewsTypeService companyNewsTypeService;
	@Autowired
	CompanyNewsService companyNewsService;
	@Autowired
	DataEchartService dataEchartService;
	@Autowired
	WechatTmplService wechatTmplService;
	
	/**
	 * 催办模版
	 * @param task
	 * @param request
	 * @return
	 */
	public boolean pushWeChatTmpl2(CompanyTask task,HttpServletRequest request){
		Integer to_user = task.getTo_user();
		Integer user_id = task.getUser_id();
		CompanyStaffer to_userstaff = companyStafferService.selectByPrimaryKey(to_user);
		CompanyStaffer user_idstaff = companyStafferService.selectByPrimaryKey(user_id);
		Integer company_id = to_userstaff.getCompany_id();
		WechatTmplExample example=new WechatTmplExample();
		cn.zx.pojo.WechatTmplExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(company_id).andTypeEqualTo("task_urge").andTitleEqualTo("任务催办");
		List<WechatTmpl> WechatTmpls = wechatTmplService.selectWechatTmplByCidAndType(example);
		if(WechatTmpls.size()>0){
			WechatTmpl wechatTmpl = WechatTmpls.get(0);
			
			String requestURL = request.getRequestURL().toString();
			requestURL=requestURL.substring(0,requestURL.lastIndexOf("/"));
			String url=requestURL+"/tmplLogin?tid="+task.getTask_id();
			Date date=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Map<String, TemplateMessageData> dateMap = new HashMap<String, TemplateMessageData>();
			
			dateMap.put("first",new TemplateMessageData("任务催办"));
			dateMap.put("keyword1",new TemplateMessageData(task.getTask_title()));
			dateMap.put("keyword2",new TemplateMessageData(user_idstaff.getRealname()));
			dateMap.put("keyword3", new TemplateMessageData(formatter.format(date)));
			dateMap.put("keyword4", new TemplateMessageData(user_idstaff.getRealname()));
			dateMap.put("keyword5", new TemplateMessageData(null));
			dateMap.put("remark",new TemplateMessageData("提醒你尽快完成任务"));
			SendMessage.sendTpl(to_userstaff.getOpen_id(), wechatTmpl.getTemplate_id(),url, dateMap,company_id);
		return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 提醒模版
	 * @param task
	 * @param request
	 * @return
	 */
	public boolean pushWeChatTmpl1(CompanyTask task,HttpServletRequest request){
		Integer to_user = task.getTo_user();
		Integer user_id = task.getUser_id();
		CompanyStaffer to_userstaff = companyStafferService.selectByPrimaryKey(to_user);
		CompanyStaffer user_idstaff = companyStafferService.selectByPrimaryKey(user_id);
		Integer company_id = to_userstaff.getCompany_id();
		WechatTmplExample example=new WechatTmplExample();
		cn.zx.pojo.WechatTmplExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(company_id).andTypeEqualTo("task_new").andTitleEqualTo("任务提醒");
		List<WechatTmpl> WechatTmpls = wechatTmplService.selectWechatTmplByCidAndType(example);
		if(WechatTmpls.size()>0){
			WechatTmpl wechatTmpl = WechatTmpls.get(0);
			
			String requestURL = request.getRequestURL().toString();
			requestURL=requestURL.substring(0,requestURL.lastIndexOf("/"));
			String url=requestURL+"/tmplLogin?tid="+task.getTask_id();
			Date date=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Map<String, TemplateMessageData> dateMap = new HashMap<String, TemplateMessageData>();
			
			dateMap.put("first",new TemplateMessageData("任务提醒"));
			dateMap.put("keyword1",new TemplateMessageData(task.getTask_title()));
			dateMap.put("keyword2",new TemplateMessageData(user_idstaff.getRealname()));
			dateMap.put("keyword3", new TemplateMessageData(formatter.format(date)));
			dateMap.put("keyword4", new TemplateMessageData(user_idstaff.getRealname()));
			dateMap.put("keyword5", new TemplateMessageData(null));
			dateMap.put("remark",new TemplateMessageData("提醒你尽快接受任务"));
			SendMessage.sendTpl(to_userstaff.getOpen_id(), wechatTmpl.getTemplate_id(),url, dateMap,company_id);
		return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * 微信跳转任务页面
	 * @param tid
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toTaskUrl/{tid}")
	public String toTaskUrl(@PathVariable("tid") Integer tid,HttpServletRequest request,HttpSession session) throws Exception{
		CompanyTask task = companyTaskService.selectTaskByTaskId(tid);
		Integer user_id = task.getTo_user();
		TaskInformation information = companyTaskService.getTaskInfoById(tid,user_id);
		CompanyStaffer staffLoginsession = companyStafferService.staffLoginsession(user_id);
		session.setAttribute("companyStaffer", staffLoginsession);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("微信模版跳转任务页面,ID：" + tid);
		log.setTableName("CompanyTask");
		log.setTable_remarks("任务表");
		logService.insertSelective(log);
		request.setAttribute("information", information);
		return "staff/oi_staff_task_detail";
	}
	
	/**
	 * 微信模版跳公众号2
	 * @param tid
	 * @param code
	 * @return
	 */
	@RequestMapping("/getopenid/{tid}")
	public String getopenid(@PathVariable("tid") Integer tid, @RequestParam("code") String code) {
		CompanyTask task = companyTaskService.selectTaskByTaskId(tid);
		if (task != null) {
			Integer cid = task.getCompany_id();
			WechatSetting wechat = wechatService.selectWechat(cid);
			StringBuffer buffer = new StringBuffer();
			buffer.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
			buffer.append(wechat.getAppid());
			buffer.append("&secret=");
			buffer.append(wechat.getAppsecret());
			buffer.append("&code=" + code);
			buffer.append("&grant_type=authorization_code");
			System.out.println(buffer.toString());
			JSONObject jsss = HttpsUtil.httpRequest(buffer.toString(), "GET", null);
			String openid = jsss.get("openid").toString();
			if(openid==null){
				return "staff/oi_staff_register_pc";
			}else{
				CompanyStafferExample example = new CompanyStafferExample();
				cn.zx.pojo.CompanyStafferExample.Criteria createCriteria = example.createCriteria();
				createCriteria.andCompanyIdEqualTo(cid).andOpenIdEqualTo(openid);
				List<CompanyStaffer> selectExample = companyStafferService.selectExample(example);
				if (selectExample.size() != 0) {
					CompanyStaffer companyStaffer = selectExample.get(0);
					if (task.getTo_user() == companyStaffer.getUser_id()) {
						return "redirect:/Newstaff/toTaskUrl/"+tid;
					} else {
						return "staff/oi_staff_register_pc";
					}
				}else{
					return "staff/oi_staff_register_pc";
				}
			}
		}else{
			return "staff/oi_staff_register_pc";
		}
	}

	/**
	 * 微信模版跳公众号1
	 * @param request
	 * @param tid
	 * @return
	 */
	@RequestMapping("/tmplLogin")
	public String tmplLogin(HttpServletRequest request, @RequestParam("tid") Integer tid) {
		CompanyTask task = companyTaskService.selectTaskByTaskId(tid);
		if (task != null) {
			Integer cid = task.getCompany_id();
			WechatSetting Wechat = wechatService.selectWechat(cid);
			String ua = ((HttpServletRequest) request).getHeader("user-agent").toLowerCase();
			if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器
					UrlUtf8 utf8 = new UrlUtf8();
					StringBuffer buffer = new StringBuffer();
					buffer.append("redirect:https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
					buffer.append(Wechat.getAppid());
					buffer.append("&redirect_uri=");
					//buffer.append(utf8.urlEncodeUTF8("http://ngup.free.ngrok.cc/zx/Newstaff/getopenid?tid=" + tid));
					buffer.append(utf8.urlEncodeUTF8("http://oi.sxfs0351.com/zx/Newstaff/getopenid/" + tid));
					buffer.append("&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
					System.out.println(buffer.toString());
					return buffer.toString();
			}else{
				return "staff/oi_staff_register_pc";
			}

		}else{
			return "staff/oi_staff_register_pc";
		}
	}


	/**
	 * 任务进度
	 * 
	 * @param session
	 * @param status
	 * @param user_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/DataCenterList")
	public Msg DataCenterList(HttpServletRequest request, HttpSession session, @RequestParam("status") Integer status,
			@RequestParam("user_id") Integer user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int[] task_status1 = { 3, 4, 5, 6 };
		int[] task_status2 = { 2 };
		map.put("user_id", user_id);
		if (status == 1) {
			map.put("task_status", task_status2);
		} else {
			map.put("task_status", task_status1);
		}
		List<DataEchart> dataCenterFirst2 = dataEchartService.DataCenterList(map);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("查看数据中心");
		log.setTableName("CompanyTask，companyStaff，companyDepart");
		log.setTable_remarks("任务表,员工表,部门表");
		logService.insertSelective(log);
		return Msg.success().add("list", dataCenterFirst2);
	}

	/**
	 * 数据中心循环
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/DataCenterLoop2")
	public Msg DataCenterLoop2(HttpServletRequest request, HttpSession session, @RequestParam("status") Integer status,
			@RequestParam(value = "dept_id", required = false) Integer dept_id) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		if (dept_id == null) {
			dept_id = companyStaffer.getDepart();
		}
		List<DataEchart> dataCenterFirst2 = dataEchartService.DataCenter2(dept_id, companyStaffer.getCompany_id(),
				status);
		List<DataEchart> dataCenterBar = dataEchartService.DataCenterBar(dept_id, status);

		List<String> names = new ArrayList<String>();
		List<Integer> ids = new ArrayList<Integer>();
		List<Integer> counts = new ArrayList<Integer>();
		if (dataCenterBar.size() > 0) {
			for (int i = 0; i < dataCenterBar.size(); i++) {
				DataEchart dataEchart = dataCenterBar.get(i);
				names.add(dataEchart.getName());
				ids.add(dataEchart.getValue());
				counts.add(dataEchart.getValue_b());
			}
		}
		String[] listArray1 = (String[]) names.toArray(new String[dataCenterBar.size()]);
		Integer[] listArray2 = (Integer[]) ids.toArray(new Integer[dataCenterBar.size()]);
		Integer[] listArray3 = (Integer[]) counts.toArray(new Integer[dataCenterBar.size()]);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("查看数据中心");
		log.setTableName("CompanyTask，companyStaff，companyDepart");
		log.setTable_remarks("任务表,员工表,部门表");
		logService.insertSelective(log);
		return Msg.success().add("names", listArray1).add("ids", listArray2).add("counts", listArray3).add("cake",
				dataCenterFirst2);
	}

	/**
	 * 数据中心首页
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/DataCenterFirst")
	public Msg DataCenterFirst(HttpServletRequest request, HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> getdeptids = companyDepartService.getdeptids(companyStaffer.getCompany_id(),
				companyStaffer.getDepart());
		int[] task_status1 = { 3, 4, 5, 6 };
		int[] task_status2 = { 2 };
		map.put("depts", getdeptids);
		map.put("task_status", task_status2);
		DataEchart dataCenterFirst1 = dataEchartService.DataCenterFirst(map);
		dataCenterFirst1.setName("已完成");
		map.clear();
		map.put("depts", getdeptids);
		map.put("task_status", task_status1);
		DataEchart dataCenterFirst2 = dataEchartService.DataCenterFirst(map);
		dataCenterFirst2.setName("未完成");
		Log log = Log.StaffRecordLog(request);
		log.setOperate("查看任务中心");
		log.setTableName("CompanyTask，companyStaff，companyDepart");
		log.setTable_remarks("任务表,员工表,部门表");
		logService.insertSelective(log);
		return Msg.success().add("finish", dataCenterFirst1).add("unfinish", dataCenterFirst2);
	}

	/**
	 * 修改头像操作
	 * 
	 * @param image
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateheader", method = RequestMethod.POST)
	public Msg updatehead(@RequestParam("image") String image, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		
		String path = request.getSession().getServletContext().getRealPath("");
		String contextPath = request.getContextPath();
		contextPath = contextPath.substring(1, contextPath.length());
		String substring = path.substring(0, path.indexOf(contextPath));
		substring += "statics/face";
		String prefix = image.substring(image.indexOf("image/") + 6, image.indexOf(";"));// 原文件后缀
		String path2 = image.substring(0, image.indexOf(",") + 1);// 原文件后缀
		String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal." + prefix;
		String filepath = substring + "/" + fileName;
		image = image.replaceFirst(path2, "");
		try {
			if (Base64.GenerateImage(image, filepath)) {
				System.out.println(123);
				String substring2 = filepath.substring(filepath.lastIndexOf("statics"));
				CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
				CompanyStaffer staffer = new CompanyStaffer();
				staffer.setUser_id(companyStaffer.getUser_id());
				staffer.setFace("/" + substring2);
				companyStafferService.updatestaffer(staffer);
				CompanyStaffer newcompanyStaffer = companyStafferService.staffLoginsession(companyStaffer.getUser_id());
				session.setAttribute("companyStaffer", newcompanyStaffer);
				Log log = Log.StaffRecordLog(request);
				log.setOperate("修改个人头像");
				log.setTableName("companyStaff");
				log.setTable_remarks("员工表");
				logService.insertSelective(log);
				return Msg.success();
			}else{
				request.setAttribute("uploadFileError", " * 上传失败！");
				return Msg.fail();
			}			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("uploadFileError", " * 上传失败！");
			return Msg.fail();
		}
	}

	/**
	 * 修改头像页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updateheader.html")
	public String updateheader(HttpServletRequest request) {
		Log log = Log.StaffRecordLog(request);
		log.setOperate("修改个人头像页面");
		log.setTableName("companyStaff");
		log.setTable_remarks("员工表");
		logService.insertSelective(log);
		return "staff/updateheader";
	}

	/**
	 * 查看公告
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selectCompanyNews", method = RequestMethod.POST)
	public Object selectCompanyNews(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "pager", defaultValue = "1", required = false) Integer pager,
			@RequestParam(value = "search", required = false) String search) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limit", 10);
		map.put("offset", (pager - 1) * 10);
		map.put("search", search);
		map.put("company_id", companyStaffer.getCompany_id());
		map.put("user_id", companyStaffer.getUser_id());
		List<CompanyNews> news = companyNewsService.NewselectNewsWithALl(map);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("查看公告");
		log.setTableName("CompanyNews");
		log.setTable_remarks("公告表");
		logService.insertSelective(log);
		return news;
	}

	/**
	 * 任务接受任务对象
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getto_user", method = RequestMethod.GET)
	public Object getto_user(HttpSession session, HttpServletRequest request) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		List<DeptList> dl = companyDepartService.selectTaskUserTree(companyStaffer.getCompany_id(),
				companyStaffer.getUser_id());
		Log log = Log.StaffRecordLog(request);
		log.setOperate("发布任务获取接收人信息");
		log.setTableName("companyDepart，CompanyStaffer");
		log.setTable_remarks("部门表，员工表");
		logService.insertSelective(log);
		return dl;
	}

	/**
	 * 任务类型
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/gettasktype", method = RequestMethod.GET)
	public Object gettasktype(HttpSession session, HttpServletRequest request) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		List<DeptList> types = companyTaskTypeService.gettaksTypes(companyStaffer.getCompany_id());
		Log log = Log.StaffRecordLog(request);
		log.setOperate("发布任务获取任务类型");
		log.setTableName("CompanyNewsType");
		log.setTable_remarks("任务分类");
		logService.insertSelective(log);
		return types;
	}

	/**
	 * 上传图片
	 * 
	 * @param attach
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/upload.do")
	@ResponseBody
	public Msg insert(@RequestParam("file") MultipartFile attach, HttpServletRequest request,
			HttpServletResponse response) {
		String path = System.getProperty("catalina.home") + "/webapps/statics/images/task/";
		String oldFileName = attach.getOriginalFilename();// 原文件名
		String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
		String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal." + prefix;
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			attach.transferTo(targetFile);
			String url = targetFile.getPath().substring(path.lastIndexOf("statics"));
			CompanyTaskImg img = new CompanyTaskImg();
			img.setImg_url(url);
			companyTaskService.addtaskimg(img);
			Log log = Log.StaffRecordLog(request);
			log.setOperate("上传任务图片" + img.toString());
			log.setTableName("companyTaskimg");
			log.setTable_remarks("任务图片表");
			logService.insertSelective(log);
			return Msg.success().add("img_id", img.getImg_id());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("uploadFileError", " * 上传失败！");
			return Msg.fail();
		}
	}

	/**
	 * 改日期格式
	 * 
	 * @param time
	 * @return
	 * @throws Exception
	 */
	public Date changeDate(String time) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.parse(time);
	}

	/**
	 * 转发任务
	 * @param task
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/forwardtask", method = RequestMethod.POST)
	public Msg forwardtask(HttpServletRequest request, CompanyTask task,
			@RequestParam(value = "start_time", required = false) String start_time,
			@RequestParam(value = "end_time", required = false) String end_time, 
			@RequestParam(value="task_urgent",required = false,defaultValue="2") Integer task_urgent,
			@RequestParam(value="task_important",required = false,defaultValue="2") Integer task_important,
			@RequestParam("imgs") String imgs,HttpSession session) throws Exception {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		if (task.getTo_user() == null) {
			return Msg.fail().add("msg", "请选择接收者");
		} else if (task.getTo_user() == companyStaffer.getUser_id()) {
			return Msg.fail().add("msg", "不能给自己发任务");
		} else {
			try {
				if (start_time != null && start_time.length() != 0) {
					task.setTask_start_time(changeDate(start_time));
				}
				if (end_time != null && end_time.length() != 0) {
					task.setTask_end_time(changeDate(end_time));
				}
				task.setTask_progress(0);
				task.setTask_status(5);
				task.setIs_forward((byte) 1);
				task.setTask_urgent(task_urgent);
				task.setTask_important(task_important);
				companyTaskService.updatetask(task);
				CompanyTaskImg newtaskImg = new CompanyTaskImg();
				newtaskImg.setTask_id(task.getTask_id());
				CompanyTaskImgExample example = new CompanyTaskImgExample();
				cn.zx.pojo.CompanyTaskImgExample.Criteria createCriteria = example.createCriteria();
				if (imgs.contains(",")) {
					List<Integer> img_ids = new ArrayList<>();
					String[] str_ids = imgs.split(",");
					// 组装id集合
					for (String string : str_ids) {
						img_ids.add(Integer.parseInt(string));
					}
					createCriteria.andImg_idIn(img_ids);
					companyTaskService.updatetaskimg(newtaskImg, example);
				} else if (imgs.length() == 0 || imgs == null) {
				} else {
					createCriteria.andImg_idEqualTo(Integer.parseInt(imgs));
					companyTaskService.updatetaskimg(newtaskImg, example);
				}
				if (task.getTask_urgent() == 1 || task.getTask_important() == 1) {
					CompanyNews news = new CompanyNews();
					news.setCompany_id(companyStaffer.getCompany_id());
					news.setUser_id(task.getTo_user());
					news.setContent("<p>您有一条新任务，请到任务列表查看</p>");
					news.setTitle("新任务提醒");
					news.setCreate_time(new Date());
					news.setStatus(1);
					news.setPageView(0);
					news.setType_id(2);
					companyNewsService.insertSelective(news);
				}
				
				pushWeChatTmpl1(task, request);
				
				Log log = Log.StaffRecordLog(request);
				log.setOperate("转发任务" + task.toString());
				log.setTableName("companyTask，companyTaskimg");
				log.setTable_remarks("任务表,任务图片表");
				logService.insertSelective(log);
				return Msg.success().add("taskid", task.getTask_id());
			} catch (NumberFormatException e) {
				return Msg.fail().add("msg", "内部错误");
			}
		}
	}

	/**
	 * 发布任务
	 * 
	 * @param task
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/publishtask", method = RequestMethod.POST)
	public Msg publishtask(HttpServletRequest request, CompanyTask task, @RequestParam("start_time") String start_time,
			@RequestParam(value="task_urgent",required = false,defaultValue="2") Integer task_urgent,
			@RequestParam(value="task_important",required = false,defaultValue="2") Integer task_important,
			@RequestParam("end_time") String end_time,@RequestParam("imgs") String imgs, HttpSession session)
			throws Exception {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		if (task.getTo_user() == null) {
			return Msg.fail().add("msg", "请选择接收者");
		} else if (start_time == null || start_time.length() == 0 || end_time == null || end_time.length() == 0) {
			return Msg.fail().add("msg", "请选择任务开始和结束时间");
		} else if (task.getTo_user() == companyStaffer.getUser_id()) {
			return Msg.fail().add("msg", "不能给自己发任务");
		} else {
			try {

				task.setTask_start_time(changeDate(start_time));
				task.setTask_end_time(changeDate(end_time));
				task.setCompany_id(companyStaffer.getCompany_id());
				task.setUser_id(companyStaffer.getUser_id());
				task.setTask_progress(0);
				task.setTask_status(5);
				task.setIs_remark((byte) 0);
				task.setIs_forward((byte) 0);
				task.setTask_create_time(new Date());
				task.setTask_urgent(task_urgent);
				task.setTask_important(task_important);
				companyTaskService.addtask(task);
				if (task.getTask_urgent() == 1 || task.getTask_important() == 1) {
					CompanyNews news = new CompanyNews();
					news.setCompany_id(companyStaffer.getCompany_id());
					news.setUser_id(task.getTo_user());
					news.setContent("<p>您有一条新任务，请到任务列表查看</p>");
					news.setTitle("新任务提醒");
					news.setCreate_time(new Date());
					news.setStatus(1);
					news.setPageView(0);
					news.setType_id(2);
					companyNewsService.insertSelective(news);
				}
				CompanyTaskImg newtaskImg = new CompanyTaskImg();
				newtaskImg.setTask_id(task.getTask_id());
				CompanyTaskImgExample example = new CompanyTaskImgExample();
				cn.zx.pojo.CompanyTaskImgExample.Criteria createCriteria = example.createCriteria();
				if (imgs.contains(",")) {
					List<Integer> img_ids = new ArrayList<>();
					String[] str_ids = imgs.split(",");
					// 组装id集合
					for (String string : str_ids) {
						img_ids.add(Integer.parseInt(string));
					}
					createCriteria.andImg_idIn(img_ids);
					companyTaskService.updatetaskimg(newtaskImg, example);
				} else if (imgs.length() == 0 || imgs == null) {
				} else {
					createCriteria.andImg_idEqualTo(Integer.parseInt(imgs));
					companyTaskService.updatetaskimg(newtaskImg, example);
				}
				
				pushWeChatTmpl1(task, request);
				Log log = Log.StaffRecordLog(request);
				log.setOperate("发布任务" + task.toString());
				log.setTableName("companyTask，companyTaskimg");
				log.setTable_remarks("任务表,任务图片表");
				logService.insertSelective(log);
				return Msg.success().add("taskid", task.getTask_id());
			} catch (NumberFormatException e) {
				return Msg.fail().add("msg", "内部错误");
			}
		}
	}

	/**
	 * 跳转转发页面
	 * 
	 * @return
	 */
	@RequestMapping("/oi_staff_task_forward.html")
	public String oi_staff_task__forward(@RequestParam("task_id") Integer task_id, HttpServletRequest request,
			HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyTask Task = companyTaskService.selectTaskByTaskId(task_id);
		CompanyTaskImgExample imgExample = new CompanyTaskImgExample();
		cn.zx.pojo.CompanyTaskImgExample.Criteria createCriteria2 = imgExample.createCriteria();
		createCriteria2.andTask_idEqualTo(task_id);
		List<CompanyTaskImg> getimgid = companyTaskService.getimgid(imgExample);
		String imgs = "";
		for (CompanyTaskImg companyTaskImg : getimgid) {
			imgs += companyTaskImg.getImg_id() + ",";
		}
		if (imgs.length() != 0) {
			imgs = imgs.substring(0, imgs.length() - 1);
		}
		request.setAttribute("getimgid", getimgid);
		request.setAttribute("imgs", imgs);
		request.setAttribute("task", Task);
		CompanyTaskType type = companyTaskTypeService.selectTypeName(Task.getTask_obj());
		request.setAttribute("type", type);
		request.setAttribute("selfid", companyStaffer.getUser_id());
		Log log = Log.StaffRecordLog(request);
		log.setOperate("转发任务获取任务信息,ID:" + task_id);
		log.setTableName("companyTask，companyTaskimg");
		log.setTable_remarks("任务表,任务图片表");
		logService.insertSelective(log);
		return "staff/oi_staff_task_forward";
	}

	/**
	 * 跳转发布页面
	 * 
	 * @return
	 */
	@RequestMapping("/oi_staff_task_release.html")
	public String oi_staff_task_release(String userId, HttpServletRequest request, HttpSession session) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		// 按照公司查找部门
		CompanyDepartExample companyDepartExample = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = companyDepartExample.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		List<CompanyDepart> Companyepart = companyDepartService.selectDepartByCompanyId(companyDepartExample);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("转发页面获取部门");
		log.setTableName("CompanyDepart");
		log.setTable_remarks("部门表");
		logService.insertSelective(log);
		request.setAttribute("Companyepart", Companyepart);
		request.setAttribute("selfid", companyStaffer.getUser_id());
		List<CompanyStaffer> people = null;
		if (userId != null) {
			people = companyStafferService.selectStaffer(Integer.parseInt(userId), companyStaffer.getCompany_id());
			request.setAttribute("staff", people.get(0));
		} else {
			request.setAttribute("staff", null);
		}
		return "staff/oi_staff_task_release";
	}

	/**
	 * 查看任务
	 * @param task_id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/oi_staff_task_detail_pre.html")
	public String selectTaskByid(HttpSession session,@RequestParam(value = "task_id") Integer task_id, HttpServletRequest request)
			throws ParseException {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		TaskInformation information = companyTaskService.getTaskInfoById(task_id,companyStaffer.getUser_id());
		request.setAttribute("information", information);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("编辑任务页面信息,ID：" + task_id);
		log.setTableName("CompanyTask,ID");
		log.setTable_remarks("员工表，任务表");
		logService.insertSelective(log);
		return "staff/oi_staff_task_detail_pre";
	}

	/**
	 * 提交评论
	 * 
	 * @param task
	 * @return
	 */
	@RequestMapping("/submitcomment")
	public String submitcomment(CompanyTask task, HttpServletRequest request) {
		task.setIs_remark((byte) 1);
		task.setTask_status(2);
		companyTaskService.updatetask(task);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("提交任务评论" + task.toString());
		log.setTableName("companyTask");
		log.setTable_remarks("任务表");
		logService.insertSelective(log);
		return "redirect:/Newstaff/oi_staff_task_center.html";
	}

	/**
	 * 接收者评论页面
	 * 
	 * @param task_id
	 * @param request
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/oi_staff_task_evaluate.html")
	public String commentTaskByid(@RequestParam(value = "task_id") Integer task_id, HttpServletRequest request,
			HttpSession session) throws ParseException {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyPostLevelExample example = new CompanyPostLevelExample();
		cn.zx.pojo.CompanyPostLevelExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		createCriteria.andPost_idEqualTo(companyStaffer.getPost());
		createCriteria.andLevelEqualTo(companyStaffer.getPostlevel() + 1);
		TaskInformation information = companyTaskService.getTaskInfoById(task_id,companyStaffer.getUser_id());
		List<CompanyPostLevel> Levels = companyStafferService.queryNextLevel(example);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("评论页面获取任务及接收者信息");
		log.setTableName("companyStaffer，CompanyPostLevel，CompanyTask,ID：" + task_id);
		log.setTable_remarks("员工表，职级表，任务表");
		logService.insertSelective(log);
		CompanyPostLevel level = new CompanyPostLevel();
		if (Levels.size() == 0) {
			level = companyStafferService.queryLevel(companyStaffer.getPostlevel());
		} else {
			level = Levels.get(0);
		}
		Integer to_user = information.getCompanyTask().getTo_user();
		List<String> queryData = queryData(to_user);
		request.setAttribute("level", level);
		request.setAttribute("queryData1", queryData.get(0));
		request.setAttribute("queryData2", queryData.get(1));
		request.setAttribute("receiver", information.getReceiver());
		request.setAttribute("task_id", task_id);
		return "staff/oi_staff_task_evaluate";
	}

	/**
	 * 个人资料卡
	 * 
	 * @param session
	 * @param user_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selfInfo/{user_id}", method = RequestMethod.POST)
	public Object test(HttpSession session, @PathVariable("user_id") Integer user_id) {
		CompanyStaffer companyStaffer = companyStafferService.staffLoginsession(user_id);
		List<RadarEcharts> selfInfo = companyTaskService.getSelfInfo(user_id);
		List<Integer> month = new ArrayList<Integer>();
		month.add(1);
		month.add(2);
		month.add(3);
		month.add(4);
		month.add(5);
		month.add(6);
		month.add(7);
		month.add(8);
		month.add(9);
		month.add(10);
		month.add(11);
		month.add(12);

		List<Integer> count = new ArrayList<Integer>();
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);
		count.add(0);

		List<Integer> complete = new ArrayList<Integer>();
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);
		complete.add(0);

		List<Integer> carry = new ArrayList<Integer>();
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);
		carry.add(0);

		// 个人月完成
		List<CompanyTask> listComplete = companyTaskService.selectStafferCompleteDay(user_id, null);
		// 个人月进行
		List<CompanyTask> listCarry = companyTaskService.selectStafferCarryDay(user_id, null);
		// 个人月总数
		List<CompanyTask> listCount = companyTaskService.selectStafferCountDay(user_id, null);

		for (int i = 0; i < month.size(); i++) {
			for (int j = 0; j < listCount.size(); j++) {
				if (month.get(i) == listCount.get(j).getMonth()) {
					count.set(i, listCount.get(j).getCount());
				}
			}
			for (int j = 0; j < listComplete.size(); j++) {
				if (month.get(i) == listComplete.get(j).getMonth()) {
					complete.set(i, listComplete.get(j).getCount());
				}
			}
			for (int j = 0; j < listCarry.size(); j++) {
				if (month.get(i) == listCarry.get(j).getMonth()) {
					carry.set(i, listCarry.get(j).getCount());
				}
			}
		}

		return Msg.success().add("Radar", selfInfo).add("staffer", companyStaffer).add("month", month)
				.add("complete", complete).add("carry", carry).add("count", count);

	}

	/**
	 * 生成工作效率&工作质量
	 * 
	 * @param session
	 * @return
	 */
	public List<String> queryData(Integer user_id) {
		List<String> list = new ArrayList<String>();
		DataEchart selfInfo = dataEchartService.getselfInfo(user_id);
		CompanyTaskExample example = new CompanyTaskExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTo_userEqualTo(user_id);
		double count = companyTaskService.gettaskcount(example);
		double quality = selfInfo.getValue();
		double efficiency = selfInfo.getValue_b();
		double qualitys = quality * 100 / count / 100;
		double efficiencys = efficiency * 100 / count / 100;
		DecimalFormat df = new DecimalFormat("######0.00");
		list.add(df.format(qualitys));
		list.add(df.format(efficiencys));
		return list;
	}

	/**
	 * 编辑任务页面
	 * 
	 * @param task_id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/oi_staff_task_detail.html")
	public String updateTaskByid(@RequestParam(value = "task_id") Integer task_id, HttpServletRequest request,HttpSession session)
			throws ParseException {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		TaskInformation information = companyTaskService.getTaskInfoById(task_id,companyStaffer.getUser_id());
		Log log = Log.StaffRecordLog(request);
		log.setOperate("编辑任务页面信息,ID：" + task_id);
		log.setTableName("CompanyTask");
		log.setTable_remarks("任务表");
		logService.insertSelective(log);
		request.setAttribute("information", information);
		return "staff/oi_staff_task_detail";
	}

	/**
	 * 接受任务页面
	 * 
	 * @param task_id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/oi_staff_task_detail_receive.html")
	public String oi_staff_task_detail_receive(HttpSession session,@RequestParam(value = "task_id") Integer task_id,
			HttpServletRequest request) throws ParseException {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		TaskInformation information = companyTaskService.getTaskInfoById(task_id,companyStaffer.getUser_id());		request.setAttribute("information", information);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("编辑任务页面信息,ID：" + task_id);
		log.setTableName("CompanyTask,ID");
		log.setTable_remarks("员工表，任务表");
		logService.insertSelective(log);
		return "staff/oi_staff_task_detail_receive";
	}

	/**
	 * 提交任务&插入备注
	 * 
	 * @param task
	 * @param task_text
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/submittask", method = RequestMethod.POST)
	public String submittask(HttpServletRequest request, CompanyTask task, @RequestParam("task_text") String task_text,
			HttpSession session) {
		if (task.getTask_progress() == 100) {
			task.setTask_status(6);
			task.setTask_complete_time(new Date());
		}
		companyTaskService.updatetask(task);
		CompanyTaskProgress progress = new CompanyTaskProgress();
		progress.setTask_id(task.getTask_id());
		progress.setTask_progress(task.getTask_progress());
		progress.setUpdate_time(new Date());
		progress.setTask_text(task_text);
		companyTaskService.addtaskprogress(progress);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("评论页面获取任务及接收者信息" + task.toString());
		log.setTableName("CompanyTask,CompanyTaskProgress");
		log.setTable_remarks("任务表,任务日志表");
		logService.insertSelective(log);
		return "redirect:/Newstaff/oi_staff_task_center.html";
	}

	/**
	 * 更改任务状态
	 * 
	 * @param task_id
	 * @param status
	 * @param reasion
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateTaskState", method = RequestMethod.POST)
	public Msg updateTaskState(HttpServletRequest request, @RequestParam("task_id") Integer task_id,
			@RequestParam("status") Integer status, @RequestParam(value = "reasion", required = false) String reasion) {
		CompanyTask task = new CompanyTask();
		task.setTask_id(task_id);
		task.setTask_status(status);
		if (reasion != null) {
			task.setTask_del_reasion(reasion);
		}
		try {
			companyTaskService.updatetask(task);
			Log log = Log.StaffRecordLog(request);
			log.setOperate("修改任务状态,ID:" + task_id + "状态：" + status);
			log.setTableName("CompanyTask");
			log.setTable_remarks("员工表，任务表");
			logService.insertSelective(log);
			return Msg.success();
		} catch (Exception e) {
			return Msg.fail();
		}
	}

	/**
	 * 任务信息
	 * 
	 * @param session
	 * @param request
	 * @param pager
	 * @param search
	 * @param column
	 * @param order
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getTask", method = RequestMethod.POST)
	public Object getTask(HttpSession session, HttpServletRequest request,
			@RequestParam(value = "pager", defaultValue = "1", required = false) Integer pager,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "sequencing", required = false) String sequencing,
			@RequestParam(value = "order", required = false) String order) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		Map<String, Object> jsonmap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", companyStaffer.getUser_id());
		map.put("search", search);
		map.put("limit", 10);
		map.put("offset", (pager - 1) * 10);
		map.put("column", sequencing);
		map.put("order", order);
		List<CompanyTask> selectByExample = companyTaskService.selectByOther(map);
		List<TaskInfo> taskgenerate = companyTaskService.Taskgenerate(selectByExample);
		long count = companyTaskService.selectTaskCount(map);
		Log log = Log.StaffRecordLog(request);
		log.setOperate("获取任务");
		log.setTableName("CompanyTask，companyStaff");
		log.setTable_remarks("任务表,员工表");
		logService.insertSelective(log);
		jsonmap.put("TaskInfo", taskgenerate);
		jsonmap.put("sum", count);
		return jsonmap;
	}

	/**
	 * 跳转任务中心
	 */
	@RequestMapping("/oi_staff_task_center.html")
	public String task_center() {
		return "staff/oi_staff_task_center";

	}

	/***
	 * 欢迎页
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/oi_staff_welPage.html")
	public String redirectEvaluateTask(HttpSession session, HttpServletRequest request) {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		Integer user_id = companyStaffer.getUser_id();
		CompanyStaffer staffer2 = new CompanyStaffer();
		staffer2.setUser_id(user_id);
		staffer2.setLast_time(new Date());
		ObtainIp getIp = new ObtainIp();
		staffer2.setLast_ip(getIp.getIpAddr(request));
		companyStafferService.updatestaffer(staffer2);
		return "staff/oi_staff_welPage";
	}

	/**
	 * 员工端首页
	 * 
	 * @return
	 */
	@RequestMapping("/yj-index.html")
	public String index() {
		return "staff/oi_staff_msg";
	}

	/**
	 * 获取公司定制图片
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/getcompanypic", method = RequestMethod.GET)
	public Msg WelPage(HttpSession session) throws Exception {
		CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
		CompanyPropagandaExample example = new CompanyPropagandaExample();
		cn.zx.pojo.CompanyPropagandaExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCreate_timeLessThanOrEqualTo(new Date());
		createCriteria.andEnd_timeGreaterThanOrEqualTo(new Date());
		createCriteria.andStatusEqualTo(1);
		createCriteria.andCompany_idEqualTo(companyStaffer.getCompany_id());
		List<CompanyPropaganda> selectPropaganda = companyPropagandaService.selectPropaganda(example);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currenttime = new Date();
		Date reg_time = companyStaffer.getReg_time();
		Date beginDate = format.parse(format.format(reg_time));
		Date endDate = format.parse(format.format(currenttime));
		long day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		List<String> PicUrl = new ArrayList<String>();
		for (CompanyPropaganda companyPropaganda : selectPropaganda) {
			PicUrl.add(companyPropaganda.getPic_URL());
		}
		return Msg.success().add("backpic", PicUrl).add("day", day + 1).add("companyname",
				companyStaffer.getCompany_name());
	}

	/**
	 * 微信注册员工
	 * 
	 * @param request
	 * @param response
	 * @param reg_id
	 * @param realname
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/regstaff", method = RequestMethod.POST)
	public String regstaff(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("reg_id") Integer reg_id, @RequestParam("realname") String realname,
			@RequestParam("phone") String phone) {
		if (reg_id == null) {
			// 系统错误
			return "staff/404error";
		} else {
			try {
				WechatTemporary wechatTemporary = wechatTemporaryService.getWechatTemporary(reg_id);
				WechatSetting wechat = wechatService.selectWechat(wechatTemporary.getCompanyId());
				CompanyStaffer staffer = new CompanyStaffer();
				MD5Tool md5Tool = new MD5Tool();
				staffer.setCompany_id(wechatTemporary.getCompanyId());
				staffer.setSf_password(md5Tool.MD5(wechat.getPassword()));
				staffer.setAudit(0);
				staffer.setStatus(1);
				staffer.setRealname(realname);
				staffer.setPhone(phone);
				staffer.setOpen_id(wechatTemporary.getOpenId());
				staffer.setHeader(wechatTemporary.getHeader());
				staffer.setNickname(wechatTemporary.getNickname());
				staffer.setReg_time(wechatTemporary.getRegTime());
				staffer.setReg_ip(wechatTemporary.getRegIp());
				companyStafferService.insertSelective(staffer);
				CookieUtil cookieUtil = new CookieUtil();
				cookieUtil.addCookie(response, "uid", staffer.getUser_id() + "", 365 * 24 * 60 * 60);
				return "staff/oi_checking";
			} catch (Exception e) {
				// 系统错误
				return "staff/404error";
			}
		}
	}
}
