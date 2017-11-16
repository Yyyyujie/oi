package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyPromotion;
import cn.zx.pojo.CompanyPromotionExample;

public interface CompanyPromotionMapper {
    long countByExample(CompanyPromotionExample example);

    int deleteByExample(CompanyPromotionExample example);

    int deleteByPrimaryKey(Integer promotion_id);

    int insert(CompanyPromotion record);

    int insertSelective(CompanyPromotion record);

    List<CompanyPromotion> selectByExample(CompanyPromotionExample example);

    CompanyPromotion selectByPrimaryKey(Integer promotion_id);

    int updateByExampleSelective(@Param("record") CompanyPromotion record, @Param("example") CompanyPromotionExample example);

    int updateByExample(@Param("record") CompanyPromotion record, @Param("example") CompanyPromotionExample example);

    int updateByPrimaryKeySelective(CompanyPromotion record);

    int updateByPrimaryKey(CompanyPromotion record);
    
    /**
     * 根据公司ID查询
     * @param company_id
     * @return
     */
    List<CompanyPromotion> selectByPrimaryCompanyId(@Param("promotion_id") Integer promotion_id,
    		@Param("company_id") Integer company_id,@Param("pager") Integer pager,@Param("limit") Integer limit);
}