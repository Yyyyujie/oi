package cn.zx.dao;

import cn.zx.pojo.CompanyNewsType;
import cn.zx.pojo.CompanyNewsTypeExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyNewsTypeMapper {
    long countByExample(CompanyNewsTypeExample example);

    int deleteByExample(CompanyNewsTypeExample example);

    int deleteByPrimaryKey(Integer news_type_id);

    int insert(CompanyNewsType record);

    int insertSelective(CompanyNewsType record);

    List<CompanyNewsType> selectByExample(CompanyNewsTypeExample example);

    CompanyNewsType selectByPrimaryKey(Integer news_type_id);

    int updateByExampleSelective(@Param("record") CompanyNewsType record, @Param("example") CompanyNewsTypeExample example);

    int updateByExample(@Param("record") CompanyNewsType record, @Param("example") CompanyNewsTypeExample example);

    int updateByPrimaryKeySelective(CompanyNewsType record);

    int updateByPrimaryKey(CompanyNewsType record);
    
    List<CompanyNewsType> selectNewsType(@Param("news_type_id") Integer news_type_id);
}