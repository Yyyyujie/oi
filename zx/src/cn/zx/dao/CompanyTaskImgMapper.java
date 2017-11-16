package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyTaskImg;
import cn.zx.pojo.CompanyTaskImgExample;

public interface CompanyTaskImgMapper {
    long countByExample(CompanyTaskImgExample example);

    int deleteByExample(CompanyTaskImgExample example);

    int deleteByPrimaryKey(Integer img_id);

    int insert(CompanyTaskImg record);

    int insertSelective(CompanyTaskImg record);

    List<CompanyTaskImg> selectByExample(CompanyTaskImgExample example);

    CompanyTaskImg selectByPrimaryKey(Integer img_id);

    int updateByExampleSelective(@Param("record") CompanyTaskImg record, @Param("example") CompanyTaskImgExample example);

    int updateByExample(@Param("record") CompanyTaskImg record, @Param("example") CompanyTaskImgExample example);

    int updateByPrimaryKeySelective(CompanyTaskImg record);

    int updateByPrimaryKey(CompanyTaskImg record);
}