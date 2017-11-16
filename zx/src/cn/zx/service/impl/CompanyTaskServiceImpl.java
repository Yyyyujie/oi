package cn.zx.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyStafferMapper;
import cn.zx.dao.CompanyTaskImgMapper;
import cn.zx.dao.CompanyTaskMapper;
import cn.zx.dao.CompanyTaskProgressMapper;
import cn.zx.dao.CompanyTaskRemarkMapper;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.CompanyTaskImg;
import cn.zx.pojo.CompanyTaskImgExample;
import cn.zx.pojo.CompanyTaskImgExample.Criteria;
import cn.zx.pojo.CompanyTaskProgress;
import cn.zx.pojo.CompanyTaskProgressExample;
import cn.zx.pojo.CompanyTaskRemark;
import cn.zx.service.CompanyTaskService;
import cn.zx.tool.RadarEcharts;
import cn.zx.tool.TaskInfo;
import cn.zx.tool.TaskInformation;

@Service("companyTaskService")
public class CompanyTaskServiceImpl implements CompanyTaskService {
	@Autowired
	CompanyTaskMapper companyTaskMapper;
	@Autowired
	CompanyStafferMapper companyStafferMapper;
	@Autowired
	CompanyTaskImgMapper companyTaskImgMapper;
	@Autowired
	CompanyTaskRemarkMapper companyTaskRemarkMapper;
	@Autowired
	CompanyTaskProgressMapper companyTaskProgressMapper;
	
	@Override
	public List<CompanyTask> selectTask(@Param("company_id") Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectTask(company_id);
	}
	@Override
	public boolean staffAddTask(CompanyTask companyTask) {
		return companyTaskMapper.insertSelective(companyTask)==1;
	}

	@Override
	public List<CompanyTask> selectAllTaskByToUserId(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public CompanyTask selectTaskByTaskId(Integer task_id) {
		return companyTaskMapper.selectByPrimaryKey(task_id);
	}

	@Override
	public boolean updateTaskStatus(CompanyTask companyTask) {
		return companyTaskMapper.updateByPrimaryKeySelective(companyTask)==1;
	}

	@Override
	public boolean updateTaskProgress(CompanyTask companyTask) {
		return companyTaskMapper.updateByPrimaryKeySelective(companyTask)==1;
	}

	@Override
	public boolean updateToUser(CompanyTask companyTask) {
		return companyTaskMapper.updateByPrimaryKeySelective(companyTask)==1;
	}

	@Override
	public List<CompanyTask> selectAllToDOTaskByToUser(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public List<CompanyTask> selectAllToDOTaskByUserId(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public List<CompanyTask> selectAllTaskByUserId(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public boolean returnTask(CompanyTask companyTask) {
		return companyTaskMapper.updateByPrimaryKeySelective(companyTask)==1;
	}

	@Override
	public List<CompanyTask> selectAllTaskByTaskStatus(CompanyTaskExample companyTaskExample) {
		return companyTaskMapper.selectByExample(companyTaskExample);
	}

	@Override
	public List<CompanyTask> selectTaskByUserId(Integer company_id, Integer to_user) {
		return companyTaskMapper.selectTaskByUserId(company_id, to_user);
	}

	@Override
	public List<CompanyTask> selectTaskByToUser(Integer company_id, Integer user_id) {
		return companyTaskMapper.selectTaskByToUser(company_id, user_id);
	}

	@Override
	public List<CompanyTask> selectToDOTaskByUserId(Integer company_id, Integer user_id) {
		return companyTaskMapper.selectToDOTaskByUserId(company_id, user_id);
	}

	@Override
	public List<CompanyTask> selectToDOTaskByToUser(Integer company_id, Integer uesr_id) {
		return companyTaskMapper.selectToDOTaskByToUser(company_id, uesr_id);
	}

	@Override
	public List<CompanyTask> selectTaskByStatusAndUserId(Integer company_id, Integer user_id, Integer task_status) {	
		return companyTaskMapper.selectTaskByStatusAndUserId(company_id, user_id, task_status);
	}

	@Override
	public List<CompanyTask> selectTaskByStatusAndToUserId(Integer company_id, Integer to_user, Integer task_status) {
		return companyTaskMapper.selectTaskByStatusAndToUserId(company_id, to_user, task_status);
	}
	@Override
	public List<CompanyTask> selectCountMonth(Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectCountMonth(company_id);
	}
	@Override
	public List<CompanyTask> selectAccomplishMonth(Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectAccomplishMonth(company_id);
	}
	@Override
	public List<CompanyTask> selectCarryMonth(Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectCarryMonth(company_id);
	}
	@Override
	public List<CompanyTask> selectTop( Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectTop(company_id);
	}
	@Override
	public CompanyTask selectCount( Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectCount(company_id);
	}
	@Override
	public CompanyTask selectRemove( Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectRemove(company_id);
	}
	@Override
	public CompanyTask selectAccomplish( Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectAccomplish(company_id);
	}
	@Override
	public CompanyTask selectBack(Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectBack(company_id);
	}
	@Override
	public CompanyTask selectCarry( Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectCarry(company_id);
	}
	@Override
	public CompanyTask selectReceive(Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectReceive(company_id);
	}
	@Override
	public CompanyTask selectEvaluate(Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectEvaluate(company_id);
	}
	@Override
	public CompanyTask selectStafferComplete(Integer to_user, Integer user_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectStafferComplete(to_user,user_id);
	}
	@Override
	public CompanyTask selectStafferReceive(Integer to_user, Integer user_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectStafferReceive(to_user,user_id);
	}
	@Override
	public CompanyTask selectStafferCarry(Integer to_user, Integer user_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectStafferCarry(to_user,user_id);
	}
	@Override
	public CompanyTask selectStafferCount(Integer to_user,Integer user_id){
		return companyTaskMapper.selectStafferCount(to_user,user_id);
	}
	@Override
	public List<CompanyTask> selectStafferCarryDay(Integer to_user,
			Integer user_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectStafferCarryDay(to_user,user_id);
	}
	@Override
	public List<CompanyTask> selectStafferCompleteDay(Integer to_user,
			Integer user_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectStafferCompleteDay(to_user,user_id);
	}
	@Override
	public List<CompanyTask> selectStafferCountDay(Integer to_user,
			Integer user_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectStafferCountDay(to_user,user_id);
	}
	@Override
	public List<CompanyTask> selectByOther(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectByExampleWithOther(map);
	}
	@Override
	public long gettaskcount(CompanyTaskExample example) {
		// TODO Auto-generated method stub
		return companyTaskMapper.countByExample(example);
	}
	@Override
	public int updatetask(CompanyTask task) {
		// TODO Auto-generated method stub
		return companyTaskMapper.updateByPrimaryKeySelective(task);
	}
	@Override
	public List<TaskInfo> Taskgenerate(List<CompanyTask> list) {
		List<TaskInfo> tasks=new ArrayList<TaskInfo>();
		TaskInfo taskInfo=null;
		for (CompanyTask companyTask : list) {
			taskInfo=new TaskInfo();
			CompanyStaffer sender = companyStafferMapper.selectByPrimaryKeyAllInfo(companyTask.getUser_id());
			CompanyStaffer sendee = companyStafferMapper.selectByPrimaryKeyAllInfo(companyTask.getTo_user());
			taskInfo.setCompanyTask(companyTask);
			taskInfo.setReceiver(sendee);
			taskInfo.setPublisher(sender);
			tasks.add(taskInfo);
		}
		return tasks;
	}
	@Override
	public TaskInformation getTaskInfoById(Integer task_id,Integer user_id) throws ParseException {
		TaskInformation information=new TaskInformation();
		List<CompanyTaskImg> imgs=new ArrayList<CompanyTaskImg>();
		List<CompanyTaskProgress> progress=new ArrayList<CompanyTaskProgress>();
		CompanyTaskRemark companyTaskRemark=new CompanyTaskRemark();
		CompanyStaffer staffer=null;
		CompanyTask Task = companyTaskMapper.selectByPrimaryKey(task_id);
		if(Task.getUser_id()==user_id){
			staffer=companyStafferMapper.selectByPrimaryKeyAllInfo(Task.getTo_user());
		}else{
			staffer= companyStafferMapper.selectByPrimaryKeyAllInfo(Task.getUser_id());
		}
				
		CompanyTaskImgExample imgexample=new CompanyTaskImgExample();
		Criteria createCriteria = imgexample.createCriteria();
		createCriteria.andTask_idEqualTo(task_id);
		imgs=companyTaskImgMapper.selectByExample(imgexample);
		companyTaskRemark=companyTaskRemarkMapper.selectByPrimaryKey(task_id);
		
		CompanyTaskProgressExample progressExample=new CompanyTaskProgressExample();
		cn.zx.pojo.CompanyTaskProgressExample.Criteria createCriteria2 = progressExample.createCriteria();
		createCriteria2.andTask_idEqualTo(task_id);
		progressExample.setOrderByClause("update_time desc");
		progress=companyTaskProgressMapper.selectByExample(progressExample);
		
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");//如2016-08-10 20:40  
		String fromDate = simpleFormat.format(new Date());  
		String toDate = simpleFormat.format(Task.getTask_end_time());  
		long from = simpleFormat.parse(fromDate).getTime();  
		long to = simpleFormat.parse(toDate).getTime();  
		int days = (int) ((to - from)/(1000 * 60 * 60 * 24));  
		
		information.setCompanyTask(Task);
		information.setProgress(progress);
		information.setRemark(companyTaskRemark);
		information.setTaskimgs(imgs);
		information.setReceiver(staffer);
		information.setSurplusdays(days);
		
		return information;
	}
	@Override
	public int updatetaskimg(CompanyTaskImg newtaskImg,
			CompanyTaskImgExample example) {
		// TODO Auto-generated method stub
		return companyTaskImgMapper.updateByExampleSelective(newtaskImg, example);
	}
	@Override
	public int addtask(CompanyTask task) {
		// TODO Auto-generated method stub
		return companyTaskMapper.insertSelective(task);
	}
	@Override
	public int addtaskimg(CompanyTaskImg img) {
		// TODO Auto-generated method stub
		return companyTaskImgMapper.insertSelective(img);
	}
	@Override
	public int addtaskprogress(CompanyTaskProgress progress) {
		// TODO Auto-generated method stub
		return companyTaskProgressMapper.insertSelective(progress);
	}
	@Override
	public int updatetaskRemark(CompanyTaskRemark taskRemark) {
		// TODO Auto-generated method stub
		
		return companyTaskRemarkMapper.updateByPrimaryKeySelective(taskRemark);
	}
	@Override
	public List<CompanyTask> selectByObjID(@Param("to_user") Integer to_user) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectByObjID(to_user);
	}
	
	@Override
	public List<CompanyTaskImg> getimgid(CompanyTaskImgExample example) {
		// TODO Auto-generated method stub
		return companyTaskImgMapper.selectByExample(example);
	}
	@Override
	public int addtaskRemark(CompanyTaskRemark taskRemark) {
		// TODO Auto-generated method stub
		return companyTaskRemarkMapper.insertSelective(taskRemark);
	}
	
	@Override
	public List<RadarEcharts> getSelfInfo(Integer user_id) {
		Map<String, Object> radar = companyTaskMapper.radar(user_id);//雷达图
		List<RadarEcharts> list=new ArrayList<RadarEcharts>();
		Object task_quality = radar.get("task_quality");
		Object task_efficiency = radar.get("task_efficiency");
		Object task_study = radar.get("task_study");
		Object task_innovate = radar.get("task_innovate");
		Object innovate = companyTaskMapper.innovate(user_id);//领导
		String task_communion_pub = companyTaskMapper.task_communion_pub(user_id);//发布者的总沟通分
		String task_communion_rec = companyTaskMapper.task_communion_rec(user_id);//接收者的总沟通分
		Object communion=(Double.parseDouble(task_communion_pub)+Double.parseDouble(task_communion_rec))/2;
		Map<String,Object> radars=new HashMap<String,Object>();
		RadarEcharts re=null;
		re=new RadarEcharts();
		re.setName("质量");
		re.setMax(task_quality);
		list.add(re);
		re=new RadarEcharts();
		re.setName("效率");
		re.setMax(task_efficiency);
		list.add(re);
		re=new RadarEcharts();
		re.setName("学习");
		re.setMax(task_study);
		list.add(re);
		re=new RadarEcharts();
		re.setName("创新");
		re.setMax(task_innovate);
		list.add(re);
		re=new RadarEcharts();
		re.setName("领导");
		re.setMax(innovate);
		list.add(re);
		re=new RadarEcharts();
		re.setName("沟通");
		DecimalFormat df = new DecimalFormat("######0.00");
		re.setMax(df.format(communion));
		list.add(re);
		return list;
	}
	@Override
	public long selectTaskCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectTaskCount(map);
	}

	@Override
	public CompanyTask selectGoingTask(Integer task_status, Integer depart,
			Integer to_user, Integer company_id) {
		// TODO Auto-generated method stub
		return companyTaskMapper.selectGoingTask(task_status, depart, to_user, company_id);
	}

}
