package cn.zx.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;
import cn.zx.pojo.CompanyTaskImg;
import cn.zx.pojo.CompanyTaskImgExample;
import cn.zx.pojo.CompanyTaskProgress;
import cn.zx.pojo.CompanyTaskRemark;
import cn.zx.tool.RadarEcharts;
import cn.zx.tool.TaskInfo;
import cn.zx.tool.TaskInformation;

public interface CompanyTaskService {
	public List<CompanyTask> selectTask(@Param("company_id") Integer company_id);

	/**
	 * 职员发布任务
	 * 
	 * @param companyTask
	 * @return
	 */
	boolean staffAddTask(CompanyTask companyTask);

	/**
	 * 根据职员Id查询所属所有任务
	 */
	List<CompanyTask> selectAllTaskByToUserId(CompanyTaskExample companyTaskExample);

	/**
	 * 根据任务Id查询详细内容
	 */
	CompanyTask selectTaskByTaskId(Integer task_id);

	/**
	 * 职员接收任务
	 */
	boolean updateTaskStatus(CompanyTask companyTask);

	/**
	 * 编辑任务进度
	 */
	boolean updateTaskProgress(CompanyTask companyTask);

	/**
	 * 转发任务
	 */
	boolean updateToUser(CompanyTask companyTask);

	/**
	 * 查询接受任务职员待办任务
	 */
	List<CompanyTask> selectAllToDOTaskByToUser(CompanyTaskExample companyTaskExample);

	/**
	 * 查询职员待办任务
	 */
	List<CompanyTask> selectAllToDOTaskByUserId(CompanyTaskExample companyTaskExample);

	/**
	 * 根据职员Id查询发布的所有任务
	 */
	List<CompanyTask> selectAllTaskByUserId(CompanyTaskExample companyTaskExample);

	/**
	 * 职员退回任务
	 */
	boolean returnTask(CompanyTask companyTask);

	/**
	 * 多字段模糊
	 */
	/*
	 * List<CompanyTask> selectTaskByVaguename(@Param("vaguename") String
	 * vaguename);
	 */

	/**
	 * 根据任务状态查询任务列表
	 */
	List<CompanyTask> selectAllTaskByTaskStatus(CompanyTaskExample companyTaskExample);

	/**
	 * 查询发布的任务
	 * 
	 * @param company_id
	 * @param user_id
	 * @return
	 */
	List<CompanyTask> selectTaskByUserId(@Param("company_id") Integer company_id, @Param("to_user") Integer to_user);

	/**
	 * 查询接收的任务
	 * 
	 * @param company_id
	 * @param to_user
	 * @return
	 */
	List<CompanyTask> selectTaskByToUser(@Param("company_id") Integer company_id, @Param("user_id") Integer user_id);

	List<CompanyTask> selectToDOTaskByUserId(@Param("company_id") Integer company_id,
			@Param("user_id") Integer user_id);

	List<CompanyTask> selectToDOTaskByToUser(@Param("company_id") Integer company_id,
			@Param("user_id") Integer user_id);

	List<CompanyTask> selectTaskByStatusAndUserId(@Param("company_id") Integer company_id,
			@Param("user_id") Integer user_id, @Param("task_status") Integer task_status);

	List<CompanyTask> selectTaskByStatusAndToUserId(@Param("company_id") Integer company_id,
			@Param("to_user") Integer to_user, @Param("task_status") Integer task_status);
	
	/**
	 * 按月查询总数
	 * @param company_id
	 * @return
	 */
	List<CompanyTask> selectCountMonth(Integer company_id);
	 /**
     * 完成按月查询
     * @param company_id
     * @return
     */
	List<CompanyTask> selectAccomplishMonth(Integer company_id);
    /**
     * 进行按月查询
     * @param company_id
     * @return
     */
	List<CompanyTask> selectCarryMonth(Integer company_id);
	
	 /**
     * 员工Top10
     * @param company_id
     * @return
     */
    List<CompanyTask> selectTop( Integer company_id);
    
    /*所占百分比开始*/
    /**
     * 所有
     * @param company_id
     * @return
     */
    CompanyTask selectCount( Integer company_id);
    /**
     * 已取消
     * @param company_id
     * @return
     */
    CompanyTask selectRemove( Integer company_id);
    /**
     * 已完成
     * @param company_id
     * @return
     */
    CompanyTask selectAccomplish( Integer company_id);
    /**
     * 已退回
     * @param company_id
     * @return
     */
    CompanyTask selectBack( Integer company_id);
    /**
     * 进行中
     * @param company_id
     * @return
     */
    CompanyTask selectCarry( Integer company_id);
    /**
     * 带接收
     * @param company_id
     * @return
     */
    CompanyTask selectReceive( Integer company_id);
    /**
     * 待评价
     * @param company_id
     * @return
     */
    CompanyTask selectEvaluate( Integer company_id);
    /*所占百分比结束*/
    
    /*个人数据开始*/
    /**
     * 查询个人完成
     * @param to_user
     * @param user_id
     * @return
     */
    CompanyTask selectStafferComplete(Integer to_user,Integer user_id);
    /**
     * 查询个人进行
     * @param to_user
     * @param user_id
     * @return
     */
    CompanyTask selectStafferReceive(Integer to_user, Integer user_id);
    /**
     * 查询个人接收
     * @param to_user
     * @param user_id
     * @return
     */
    CompanyTask selectStafferCarry(Integer to_user,Integer user_id);
    /**
     * 查询个人总数
     * @param to_user
     * @param user_id
     * @return
     */
    CompanyTask selectStafferCount(Integer to_user,Integer user_id);
    /*个人数据结束*/
    /*个人月数据开始*/
    /**
     * 进行
     * @param to_user
     * @param user_id
     * @return
     */
    List<CompanyTask> selectStafferCarryDay(Integer to_user, Integer user_id);
    /**
     * 完成
     * @param to_user
     * @param user_id
     * @return
     */
    List<CompanyTask> selectStafferCompleteDay(Integer to_user, Integer user_id);
    /**
     * 总数
     * @param to_user
     * @param user_id
     * @return
     */
    List<CompanyTask> selectStafferCountDay(Integer to_user,Integer user_id);
    /*个人月数据结束*/
    

	public List<CompanyTask> selectByOther(Map<String, Object> map);

	public long gettaskcount(CompanyTaskExample example);

	public int updatetask(CompanyTask task);
	
	public List<TaskInfo> Taskgenerate(List<CompanyTask> list);

	public TaskInformation getTaskInfoById(Integer task_id, Integer user_id) throws ParseException;

	int updatetaskimg(CompanyTaskImg newtaskImg, CompanyTaskImgExample example);

	int  addtask(CompanyTask task);
	
	int  addtaskimg(CompanyTaskImg img);

	int addtaskprogress(CompanyTaskProgress progress);

	int updatetaskRemark(CompanyTaskRemark taskRemark);
	/**
	 * 获取图片信息
	 * @param example
	 * @return
	 */
	List<CompanyTaskImg> getimgid(CompanyTaskImgExample example);
	/**
     * 查询跟用户ID有关系的
     * @param to_user
     * @return
     */
    List<CompanyTask> selectByObjID(@Param("to_user") Integer to_user);
    
    int addtaskRemark(CompanyTaskRemark taskRemark);

	public List<RadarEcharts> getSelfInfo(Integer user_id);

	public long selectTaskCount(Map<String, Object> map);
	
	/*企业端数据下钻开始*/
	/**
	 * 数据下钻
	 * @param task_status
	 * @param depart
	 * @param to_user
	 * @param company_id
	 * @return
	 */
	CompanyTask selectGoingTask(Integer task_status,Integer depart,
			Integer to_user,Integer company_id);
	
	/*企业端数据下钻结束*/
}
