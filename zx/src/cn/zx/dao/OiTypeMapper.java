package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.OiType;
import cn.zx.pojo.OiTypeExample;

public interface OiTypeMapper {
    long countByExample(OiTypeExample example);

    int deleteByExample(OiTypeExample example);

    int deleteByPrimaryKey(Integer type_id);

    int insert(OiType record);

    int insertSelective(OiType record);

    List<OiType> selectByExample(OiTypeExample example);

    OiType selectByPrimaryKey(Integer type_id);

    int updateByExampleSelective(@Param("record") OiType record, @Param("example") OiTypeExample example);

    int updateByExample(@Param("record") OiType record, @Param("example") OiTypeExample example);

    int updateByPrimaryKeySelective(OiType record);

    int updateByPrimaryKey(OiType record);
    
}