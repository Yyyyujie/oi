package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyTaskRemark;
import cn.zx.pojo.CompanyTaskRemarkExample;

public interface CompanyTaskRemarkMapper {
    long countByExample(CompanyTaskRemarkExample example);

    int deleteByExample(CompanyTaskRemarkExample example);

    int deleteByPrimaryKey(Integer task_id);

    int insert(CompanyTaskRemark record);

    int insertSelective(CompanyTaskRemark record);

    List<CompanyTaskRemark> selectByExample(CompanyTaskRemarkExample example);

    CompanyTaskRemark selectByPrimaryKey(Integer task_id);

    int updateByExampleSelective(@Param("record") CompanyTaskRemark record, @Param("example") CompanyTaskRemarkExample example);

    int updateByExample(@Param("record") CompanyTaskRemark record, @Param("example") CompanyTaskRemarkExample example);

    int updateByPrimaryKeySelective(CompanyTaskRemark record);

    int updateByPrimaryKey(CompanyTaskRemark record);
}