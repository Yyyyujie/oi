package cn.zx.dao;

import cn.zx.pojo.CompanyTaskType;
import cn.zx.pojo.CompanyTaskTypeExample;
import cn.zx.tool.DeptList;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyTaskTypeMapper {
    long countByExample(CompanyTaskTypeExample example);

    int deleteByExample(CompanyTaskTypeExample example);

    int deleteByPrimaryKey(Integer task_type_id);

    int insert(CompanyTaskType record);

    int insertSelective(CompanyTaskType record);

    List<CompanyTaskType> selectByExample(CompanyTaskTypeExample example);

    CompanyTaskType selectByPrimaryKey(Integer task_type_id);

    int updateByExampleSelective(@Param("record") CompanyTaskType record, @Param("example") CompanyTaskTypeExample example);

    int updateByExample(@Param("record") CompanyTaskType record, @Param("example") CompanyTaskTypeExample example);

    int updateByPrimaryKeySelective(CompanyTaskType record);

    int updateByPrimaryKey(CompanyTaskType record);
    
    List<DeptList> gettasktype(Integer company_id);
}