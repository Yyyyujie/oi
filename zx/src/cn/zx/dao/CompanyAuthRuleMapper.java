package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyAuthRule;
import cn.zx.pojo.CompanyAuthRuleExample;

public interface CompanyAuthRuleMapper {
    long countByExample(CompanyAuthRuleExample example);

    int deleteByExample(CompanyAuthRuleExample example);

    int deleteByPrimaryKey(Integer r_id);

    int insert(CompanyAuthRule record);

    int insertSelective(CompanyAuthRule record);

    List<CompanyAuthRule> selectByExampleWithBLOBs(CompanyAuthRuleExample example);

    List<CompanyAuthRule> selectByExample(CompanyAuthRuleExample example);

    CompanyAuthRule selectByPrimaryKey(Integer r_id);

    int updateByExampleSelective(@Param("record") CompanyAuthRule record, @Param("example") CompanyAuthRuleExample example);

    int updateByExampleWithBLOBs(@Param("record") CompanyAuthRule record, @Param("example") CompanyAuthRuleExample example);

    int updateByExample(@Param("record") CompanyAuthRule record, @Param("example") CompanyAuthRuleExample example);

    int updateByPrimaryKeySelective(CompanyAuthRule record);

    int updateByPrimaryKeyWithBLOBs(CompanyAuthRule record);

    int updateByPrimaryKey(CompanyAuthRule record);
}