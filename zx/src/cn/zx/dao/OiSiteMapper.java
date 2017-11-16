package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.OiSite;
import cn.zx.pojo.OiSiteExample;

public interface OiSiteMapper {
    long countByExample(OiSiteExample example);

    int deleteByExample(OiSiteExample example);

    int deleteByPrimaryKey(Integer s_id);

    int insert(OiSite record);

    int insertSelective(OiSite record);

    List<OiSite> selectByExample(OiSiteExample example);

    OiSite selectByPrimaryKey(Integer s_id);

    int updateByExampleSelective(@Param("record") OiSite record, @Param("example") OiSiteExample example);

    int updateByExample(@Param("record") OiSite record, @Param("example") OiSiteExample example);

    int updateByPrimaryKeySelective(OiSite record);

    int updateByPrimaryKey(OiSite record);
}