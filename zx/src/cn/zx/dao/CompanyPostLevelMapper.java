package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyPostLevelExample;

public interface CompanyPostLevelMapper {
    long countByExample(CompanyPostLevelExample example);

    int deleteByExample(CompanyPostLevelExample example);

    int deleteByPrimaryKey(Integer post_le_id);

    int insert(CompanyPostLevel record);

    int insertSelective(CompanyPostLevel record);

    List<CompanyPostLevel> selectByExample(CompanyPostLevelExample example);

    CompanyPostLevel selectByPrimaryKey(Integer post_le_id);

    int updateByExampleSelective(@Param("record") CompanyPostLevel record, @Param("example") CompanyPostLevelExample example);

    int updateByExample(@Param("record") CompanyPostLevel record, @Param("example") CompanyPostLevelExample example);

    int updateByPrimaryKeySelective(CompanyPostLevel record);

    int updateByPrimaryKey(CompanyPostLevel record);

/**
     * 查询数据
     * @param post_le_id
     * @param company_id
     * @return
     */
    public List<CompanyPostLevel> selectPostlevel(@Param("post_le_id")Integer post_le_id, @Param("company_id")Integer company_id);
}