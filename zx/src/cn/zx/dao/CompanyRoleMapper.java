package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyRole;
import cn.zx.pojo.CompanyRoleExample;

public interface CompanyRoleMapper {
    long countByExample(CompanyRoleExample example);

    int deleteByExample(CompanyRoleExample example);

    int deleteByPrimaryKey(Integer user_id);

    int insert(CompanyRole record);

    int insertSelective(CompanyRole record);

    List<CompanyRole> selectByExample(CompanyRoleExample example);

    CompanyRole selectByPrimaryKey(Integer user_id);

    int updateByExampleSelective(@Param("record") CompanyRole record, @Param("example") CompanyRoleExample example);

    int updateByExample(@Param("record") CompanyRole record, @Param("example") CompanyRoleExample example);

    int updateByPrimaryKeySelective(CompanyRole record);

    int updateByPrimaryKey(CompanyRole record);
    
    public List<CompanyRole> selectRole(@Param("user_id") Integer user_id,@Param("company_id") Integer company_id);
    
}