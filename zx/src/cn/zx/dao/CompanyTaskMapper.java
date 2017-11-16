package cn.zx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyTask;
import cn.zx.pojo.CompanyTaskExample;

public interface CompanyTaskMapper {
    long countByExample(CompanyTaskExample example);

    int deleteByExample(CompanyTaskExample example);

    int deleteByPrimaryKey(Integer task_id);

    int insert(CompanyTask record);

    int insertSelective(CompanyTask record);

    List<CompanyTask> selectByExample(CompanyTaskExample example);

    CompanyTask selectByPrimaryKey(Integer task_id);

    int updateByExampleSelective(@Param("record") CompanyTask record, @Param("example") CompanyTaskExample example);

    int updateByExample(@Param("record") CompanyTask record, @Param("example") CompanyTaskExample example);

    int updateByPrimaryKeySelective(CompanyTask record);

    int updateByPrimaryKey(CompanyTask record);
    
    /*List<CompanyTask> selectTaskByVaguename(@Param("vaguename") String vaguename);*/
    
    List<CompanyTask> selectTaskByUserId(@Param("company_id") Integer company_id,@Param("to_user") Integer to_user);
    
    List<CompanyTask> selectTaskByToUser(@Param("company_id") Integer company_id,@Param("user_id") Integer user_id);
    
    List<CompanyTask> selectToDOTaskByUserId(@Param("company_id") Integer company_id,@Param("user_id") Integer user_id);
    
    List<CompanyTask> selectToDOTaskByToUser(@Param("company_id") Integer company_id,@Param("user_id") Integer user_id);
    
    List<CompanyTask> selectTaskByStatusAndUserId(@Param("company_id") Integer company_id,@Param("user_id") Integer user_id,@Param("task_status") Integer task_status);
    
    List<CompanyTask> selectTaskByStatusAndToUserId(@Param("company_id") Integer company_id,@Param("to_user") Integer to_user,@Param("task_status") Integer task_status);

    /*企业*/
    /**
     * 查询信息
     * @param company_id
     * @return
     */
    List<CompanyTask> selectTask(@Param("company_id") Integer company_id);
    
    /**
     * 按月查询总数 
     * @param company_id
     * @return
     */
    List<CompanyTask> selectCountMonth(@Param("company_id") Integer company_id);
    
    /**
     * 完成按月查询
     * @param company_id
     * @return
     */
    List<CompanyTask> selectAccomplishMonth(@Param("company_id") Integer company_id);
    /**
     * 进行按月查询
     * @param company_id
     * @return
     */
    List<CompanyTask> selectCarryMonth(@Param("company_id") Integer company_id);
    
    /**
     * 员工Top10
     * @param company_id
     * @return
     */
    List<CompanyTask> selectTop(@Param("company_id") Integer company_id);
    /*所占百分比开始*/
    /**
     * 所有
     * @param company_id
     * @return
     */
    CompanyTask selectCount(@Param("company_id") Integer company_id);
    /**
     * 已取消
     * @param company_id
     * @return
     */
    CompanyTask selectRemove(@Param("company_id") Integer company_id);
    /**
     * 已完成
     * @param company_id
     * @return
     */
    CompanyTask selectAccomplish(@Param("company_id") Integer company_id);
    /**
     * 已退回
     * @param company_id
     * @return
     */
    CompanyTask selectBack(@Param("company_id") Integer company_id);
    /**
     * 进行中
     * @param company_id
     * @return
     */
    CompanyTask selectCarry(@Param("company_id") Integer company_id);
    /**
     * 带接收
     * @param company_id
     * @return
     */
    CompanyTask selectReceive(@Param("company_id") Integer company_id);
    /**
     * 待评价
     * @param company_id
     * @return
     */
    CompanyTask selectEvaluate(@Param("company_id") Integer company_id);
    /*所占百分比结束*/
    
    /*个人数据开始*/
    /**
     * 查询个人完成
     * @param to_user
     * @param user_id
     * @return
     */
    CompanyTask selectStafferComplete(@Param("to_user") Integer to_user,
    		@Param("user_id") Integer user_id);
    /**
     * 查询个人进行
     * @param to_user
     * @param user_id
     * @return
     */
    CompanyTask selectStafferReceive(@Param("to_user") Integer to_user,
    		@Param("user_id") Integer user_id);
    /**
     * 查询个人接收
     * @param to_user
     * @param user_id
     * @return
     */
    CompanyTask selectStafferCarry(@Param("to_user") Integer to_user,
    		@Param("user_id") Integer user_id);
    /**
     * 查询个人总数
     * @param to_user
     * @param user_id
     * @return
     */
    CompanyTask selectStafferCount(@Param("to_user") Integer to_user,
    		@Param("user_id") Integer user_id);
    /*个人数据结束*/
    
    /*个人月数据开始*/
    /**
     * 进行
     * @param to_user
     * @param user_id
     * @return
     */
    List<CompanyTask> selectStafferCarryDay(@Param("to_user") Integer to_user,
    		@Param("user_id") Integer user_id);
    /**
     * 完成
     * @param to_user
     * @param user_id
     * @return
     */
    List<CompanyTask> selectStafferCompleteDay(@Param("to_user") Integer to_user,
    		@Param("user_id") Integer user_id);
    /**
     * 总数
     * @param to_user
     * @param user_id
     * @return
     */
    List<CompanyTask> selectStafferCountDay(@Param("to_user") Integer to_user,
	@Param("user_id") Integer user_id);
    /*个人月数据结束*/
    
    
    List<CompanyTask> selectByExampleWithOther(Map<String, Object> map);
    /**
     * 查询跟用户ID有关系的
     * @param to_user
     * @return
     */
    List<CompanyTask> selectByObjID(@Param("to_user") Integer to_user);

	Map<String, Object> radar(Integer user_id);

	Object innovate(Integer user_id);

	String task_communion_pub(Integer user_id);

	String task_communion_rec(Integer user_id);

	long selectTaskCount(Map<String, Object> map);
	/*企业端数据下钻开始*/
	/**
	 * 数据下钻
	 * @param task_status
	 * @param depart
	 * @param to_user
	 * @param company_id
	 * @return
	 */
	CompanyTask selectGoingTask(@Param("task_status") Integer task_status,@Param("depart") Integer depart,
			@Param("to_user") Integer to_user,@Param("company_id") Integer company_id);
	
	/*企业端数据下钻结束*/
}