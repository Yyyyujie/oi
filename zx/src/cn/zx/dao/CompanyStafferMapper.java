package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;

public interface CompanyStafferMapper {
    long countByExample(CompanyStafferExample example);

    int deleteByExample(CompanyStafferExample example);

    int deleteByPrimaryKey(Integer user_id);

    int insert(CompanyStaffer record);

    int insertSelective(CompanyStaffer record);

    List<CompanyStaffer> selectByExample(CompanyStafferExample example);

    CompanyStaffer selectByPrimaryKey(Integer user_id);

    int updateByExampleSelective(@Param("record") CompanyStaffer record, @Param("example") CompanyStafferExample example);

    int updateByExample(@Param("record") CompanyStaffer record, @Param("example") CompanyStafferExample example);

    int updateByPrimaryKeySelective(CompanyStaffer record);

    int updateByPrimaryKey(CompanyStaffer record);
    
    CompanyStaffer selectStaffByDepartAndPost(@Param("user_id") Integer user_id,@Param("company_id") Integer company_id);
    
    List<CompanyStaffer> selectStaffByCompanyId(@Param("company_id") Integer company_id);
    /**
     * 查询
     * @param user_id
     * @param company_id
     * @return
     */
    List<CompanyStaffer> selectStaffer(@Param("user_id") Integer user_id,@Param("company_id") Integer company_id);
    
    /**
     * 获取入职时间
     * @param company_id
     * @return
     */
    List<CompanyStaffer> selectHiredateByCompanyId();
    /**
     * 修改员工密码
     * @param user_id
     * @param sf_password
     * @return
     */
    int updatePWDByuseID(@Param("user_id")Integer user_id,@Param("sf_password")String sf_password);
    CompanyStaffer selectByPrimaryKeyAllInfo(Integer user_id);
    List<CompanyStaffer> selectByExampleAndTaskCount(@Param("company_id")Integer company_id);
    
    /**
     * 根据部门查询人数
     * @param depart
     * @param company_id
     * @return
     */
    List<CompanyStaffer> selectByDepart(@Param("depart")Integer depart,@Param("company_id")Integer company_id);
}