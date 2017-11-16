package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.StaffTaskLog;
import cn.zx.pojo.StaffTaskLogExample;

public interface StaffTaskLogMapper {
    long countByExample(StaffTaskLogExample example);

    int deleteByExample(StaffTaskLogExample example);

    int deleteByPrimaryKey(Integer s_t_id);

    int insert(StaffTaskLog record);

    int insertSelective(StaffTaskLog record);

    List<StaffTaskLog> selectByExample(StaffTaskLogExample example);

    StaffTaskLog selectByPrimaryKey(Integer s_t_id);

    int updateByExampleSelective(@Param("record") StaffTaskLog record, @Param("example") StaffTaskLogExample example);

    int updateByExample(@Param("record") StaffTaskLog record, @Param("example") StaffTaskLogExample example);

    int updateByPrimaryKeySelective(StaffTaskLog record);

    int updateByPrimaryKey(StaffTaskLog record);
}