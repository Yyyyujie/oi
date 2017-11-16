package cn.zx.dao;

import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsExample;
import cn.zx.pojo.CompanyStaffer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CompanyNewsMapper {
    long countByExample(CompanyNewsExample example);

    int deleteByExample(CompanyNewsExample example);

    int deleteByPrimaryKey(Integer new_id);

    int insert(CompanyNews record);

    int insertSelective(CompanyNews record);

    List<CompanyNews> selectByExample(CompanyNewsExample example);

    CompanyNews selectByPrimaryKey(Integer new_id);

    int updateByExampleSelective(@Param("record") CompanyNews record, @Param("example") CompanyNewsExample example);

    int updateByExample(@Param("record") CompanyNews record, @Param("example") CompanyNewsExample example);

    int updateByPrimaryKeySelective(CompanyNews record);

    int updateByPrimaryKey(CompanyNews record);
    
    List<CompanyNews> selectNews(@Param("new_id") Integer new_id,@Param("company_id") Integer company_id,@Param("user_id") Integer user_id);

	List<CompanyNews> selectNewsWithAll();
	
	List<CompanyNews> NewselectNews(Map<String, Object> map);
	
}