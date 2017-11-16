package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.EmailMessage;
import cn.zx.pojo.EmailMessageExample;

public interface EmailMessageMapper {
    long countByExample(EmailMessageExample example);

    int deleteByExample(EmailMessageExample example);

    int deleteByPrimaryKey(Integer email_id);

    int insert(EmailMessage record);

    int insertSelective(EmailMessage record);

    List<EmailMessage> selectByExample(EmailMessageExample example);

    EmailMessage selectByPrimaryKey(Integer email_id);

    int updateByExampleSelective(@Param("record") EmailMessage record, @Param("example") EmailMessageExample example);

    int updateByExample(@Param("record") EmailMessage record, @Param("example") EmailMessageExample example);

    int updateByPrimaryKeySelective(EmailMessage record);

    int updateByPrimaryKey(EmailMessage record);
}