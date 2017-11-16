package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.StaffTask;
import cn.zx.pojo.StaffTaskExample;

public interface StaffTaskMapper {
    long countByExample(StaffTaskExample example);

    int deleteByExample(StaffTaskExample example);

    int deleteByPrimaryKey(Integer s_t_id);

    int insert(StaffTask record);

    int insertSelective(StaffTask record);

    List<StaffTask> selectByExample(StaffTaskExample example);

    StaffTask selectByPrimaryKey(Integer s_t_id);

    int updateByExampleSelective(@Param("record") StaffTask record, @Param("example") StaffTaskExample example);

    int updateByExample(@Param("record") StaffTask record, @Param("example") StaffTaskExample example);

    int updateByPrimaryKeySelective(StaffTask record);

    int updateByPrimaryKey(StaffTask record);
}