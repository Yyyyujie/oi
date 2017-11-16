package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyWeixinAccess;
import cn.zx.pojo.CompanyWeixinAccessExample;

public interface CompanyWeixinAccessMapper {
    long countByExample(CompanyWeixinAccessExample example);

    int deleteByExample(CompanyWeixinAccessExample example);

    int deleteByPrimaryKey(Integer acc_id);

    int insert(CompanyWeixinAccess record);

    int insertSelective(CompanyWeixinAccess record);

    List<CompanyWeixinAccess> selectByExample(CompanyWeixinAccessExample example);

    CompanyWeixinAccess selectByPrimaryKey(Integer acc_id);

    int updateByExampleSelective(@Param("record") CompanyWeixinAccess record, @Param("example") CompanyWeixinAccessExample example);

    int updateByExample(@Param("record") CompanyWeixinAccess record, @Param("example") CompanyWeixinAccessExample example);

    int updateByPrimaryKeySelective(CompanyWeixinAccess record);

    int updateByPrimaryKey(CompanyWeixinAccess record);
}