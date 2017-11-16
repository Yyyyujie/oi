package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyTaskProgress;
import cn.zx.pojo.CompanyTaskProgressExample;

public interface CompanyTaskProgressMapper {
    long countByExample(CompanyTaskProgressExample example);

    int deleteByExample(CompanyTaskProgressExample example);

    int deleteByPrimaryKey(Integer pro_id);

    int insert(CompanyTaskProgress record);

    int insertSelective(CompanyTaskProgress record);

    List<CompanyTaskProgress> selectByExample(CompanyTaskProgressExample example);

    CompanyTaskProgress selectByPrimaryKey(Integer pro_id);

    int updateByExampleSelective(@Param("record") CompanyTaskProgress record, @Param("example") CompanyTaskProgressExample example);

    int updateByExample(@Param("record") CompanyTaskProgress record, @Param("example") CompanyTaskProgressExample example);

    int updateByPrimaryKeySelective(CompanyTaskProgress record);

    int updateByPrimaryKey(CompanyTaskProgress record);
}