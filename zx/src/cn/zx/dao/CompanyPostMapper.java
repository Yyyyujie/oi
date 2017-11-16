package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyPost;
import cn.zx.pojo.CompanyPostExample;

public interface CompanyPostMapper {
    long countByExample(CompanyPostExample example);

    int deleteByExample(CompanyPostExample example);

    int deleteByPrimaryKey(Integer post_id);

    int insert(CompanyPost record);

    int insertSelective(CompanyPost record);

    List<CompanyPost> selectByExample(CompanyPostExample example);

    CompanyPost selectByPrimaryKey(Integer post_id);

    int updateByExampleSelective(@Param("record") CompanyPost record, @Param("example") CompanyPostExample example);

    int updateByExample(@Param("record") CompanyPost record, @Param("example") CompanyPostExample example);

    int updateByPrimaryKeySelective(CompanyPost record);

    int updateByPrimaryKey(CompanyPost record);
    /**
     * 查询企业职系表
     * @param company_id
     * @return
     */
    public List<CompanyPost> selectPost(@Param("post_id") Integer post_id,@Param("company_id") Integer company_id);

	 /**
     * 插入数据
     * @param record
     * @return
     */
    public int insertPost(CompanyPost record);
}