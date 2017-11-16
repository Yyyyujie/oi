package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.SmsMessage;
import cn.zx.pojo.SmsMessageExample;

public interface SmsMessageMapper {
    long countByExample(SmsMessageExample example);

    int deleteByExample(SmsMessageExample example);

    int deleteByPrimaryKey(Integer msg_id);

    int insert(SmsMessage record);

    int insertSelective(SmsMessage record);

    List<SmsMessage> selectByExample(SmsMessageExample example);

    SmsMessage selectByPrimaryKey(Integer msg_id);

    int updateByExampleSelective(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByExample(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByPrimaryKeySelective(SmsMessage record);

    int updateByPrimaryKey(SmsMessage record);
}