package cn.zx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyPostLevelExample;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.pojo.DataEchart;

public interface CompanyStafferService {
	/**
     * 查询
     * @param user_id
     * @param company_id
     * @return
     */
    public List<CompanyStaffer> selectStaffer( Integer user_id, Integer company_id);
    
    /**
     * 添加
     * @param record
     * @return
     */
    public int insertSelective(CompanyStaffer record);
    
    /**
     * 修改
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(List<CompanyStaffer> list);
    /**
     * 根据公司ID和部门ID查询员工
     */
	List<CompanyStaffer> selectStaffByCompanyIdAndDepartId(CompanyStafferExample companyStafferExample);
	
	/**
	 * 职员修改邮箱地址、手机号
	 */
	boolean staffUpdateEmailOrTelphone(CompanyStaffer companyStaffer);
	
	/**
	 * 根据职员Id查询当前职员信息
	 */
	CompanyStaffer selectStafferByUserId(Integer user_id);
	
	/**
	 * 登陆
	 */
	List<CompanyStaffer> staffLogin(CompanyStafferExample companyStafferExample);
	
	/**
	 * 查询职员所属部门职系职级
	 */
	CompanyStaffer selectStaffByDepartAndPost( Integer user_id,@Param("company_id") Integer company_id);
	
	/**
	 * 根据公司Id查询所有人
	 */
	 List<CompanyStaffer> selectStaffByCompanyId(Integer company_id);
	 /**
	  * 获取入职时间
	  * @param company_id
	  * @return
	  */
	public List<CompanyStaffer> selectHiredateByCompanyId();
	/**
	  * 根据员工ID修改密码
	  * @param list
	  * @return
	  */
	  int updatePWDByuseID(@Param("user_id")Integer user_id,@Param("sf_password")String sf_password);
	 
	  public CompanyStaffer staffLoginsession(Integer user_id);

		public DataEchart getselfInfso(Integer user_id);
		
		public List<CompanyPostLevel> queryNextLevel(CompanyPostLevelExample example);
		
		public CompanyPostLevel queryLevel(Integer level_id);
		
		List<CompanyStaffer> selectExample(CompanyStafferExample companyStafferExample);

		public DataEchart getselfInfo(Integer user_id);

		public int updatestaffer(CompanyStaffer staffer2);
		 /**
	     * 根据部门查询人数
	     * @param depart
	     * @param company_id
	     * @return
	     */
	    List<CompanyStaffer> selectByDepart(Integer depart,Integer company_id);

		public CompanyStaffer selectByPrimaryKey(Integer user_id);


}
