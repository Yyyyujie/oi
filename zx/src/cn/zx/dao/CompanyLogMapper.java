package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyLog;
import cn.zx.pojo.CompanyLogExample;

public interface CompanyLogMapper {
    long countByExample(CompanyLogExample example);

    int deleteByExample(CompanyLogExample example);

    int deleteByPrimaryKey(Integer l_id);

    int insert(CompanyLog record);

    int insertSelective(CompanyLog record);

    List<CompanyLog> selectByExample(CompanyLogExample example);

    CompanyLog selectByPrimaryKey(Integer l_id);

    int updateByExampleSelective(@Param("record") CompanyLog record, @Param("example") CompanyLogExample example);

    int updateByExample(@Param("record") CompanyLog record, @Param("example") CompanyLogExample example);

    int updateByPrimaryKeySelective(CompanyLog record);

    int updateByPrimaryKey(CompanyLog record);
}