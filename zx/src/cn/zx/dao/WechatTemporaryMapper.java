package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.WechatTemporary;
import cn.zx.pojo.WechatTemporaryExample;

public interface WechatTemporaryMapper {
    long countByExample(WechatTemporaryExample example);

    int deleteByExample(WechatTemporaryExample example);

    int deleteByPrimaryKey(Integer touristid);

    int insert(WechatTemporary record);

    int insertSelective(WechatTemporary record);

    List<WechatTemporary> selectByExample(WechatTemporaryExample example);

    WechatTemporary selectByPrimaryKey(Integer touristid);

    int updateByExampleSelective(@Param("record") WechatTemporary record, @Param("example") WechatTemporaryExample example);

    int updateByExample(@Param("record") WechatTemporary record, @Param("example") WechatTemporaryExample example);

    int updateByPrimaryKeySelective(WechatTemporary record);

    int updateByPrimaryKey(WechatTemporary record);
}