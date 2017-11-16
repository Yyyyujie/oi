package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.OiDistrict;
import cn.zx.pojo.OiDistrictExample;

public interface OiDistrictMapper {
    long countByExample(OiDistrictExample example);

    int deleteByExample(OiDistrictExample example);

    int deleteByPrimaryKey(Integer district_id);

    int insert(OiDistrict record);

    int insertSelective(OiDistrict record);

    List<OiDistrict> selectByExample(OiDistrictExample example);

    OiDistrict selectByPrimaryKey(Integer district_id);

    int updateByExampleSelective(@Param("record") OiDistrict record, @Param("example") OiDistrictExample example);

    int updateByExample(@Param("record") OiDistrict record, @Param("example") OiDistrictExample example);

    int updateByPrimaryKeySelective(OiDistrict record);

    int updateByPrimaryKey(OiDistrict record);
    
}