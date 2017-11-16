package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyTaskMsg;
import cn.zx.pojo.CompanyTaskMsgExample;

public interface CompanyTaskMsgMapper {
    long countByExample(CompanyTaskMsgExample example);

    int deleteByExample(CompanyTaskMsgExample example);

    int deleteByPrimaryKey(Integer message_id);

    int insert(CompanyTaskMsg record);

    int insertSelective(CompanyTaskMsg record);

    List<CompanyTaskMsg> selectByExample(CompanyTaskMsgExample example);

    CompanyTaskMsg selectByPrimaryKey(Integer message_id);

    int updateByExampleSelective(@Param("record") CompanyTaskMsg record, @Param("example") CompanyTaskMsgExample example);

    int updateByExample(@Param("record") CompanyTaskMsg record, @Param("example") CompanyTaskMsgExample example);

    int updateByPrimaryKeySelective(CompanyTaskMsg record);

    int updateByPrimaryKey(CompanyTaskMsg record);
}