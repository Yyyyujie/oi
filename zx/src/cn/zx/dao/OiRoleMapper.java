package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.OiRole;
import cn.zx.pojo.OiRoleExample;

public interface OiRoleMapper {
    long countByExample(OiRoleExample example);

    int deleteByExample(OiRoleExample example);

    int deleteByPrimaryKey(Integer o_r_id);

    int insert(OiRole record);

    int insertSelective(OiRole record);

    List<OiRole> selectByExample(OiRoleExample example);

    OiRole selectByPrimaryKey(Integer o_r_id);

    int updateByExampleSelective(@Param("record") OiRole record, @Param("example") OiRoleExample example);

    int updateByExample(@Param("record") OiRole record, @Param("example") OiRoleExample example);

    int updateByPrimaryKeySelective(OiRole record);

    int updateByPrimaryKey(OiRole record);
    
}