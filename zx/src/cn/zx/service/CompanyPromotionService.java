package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyPromotion;


public interface CompanyPromotionService {
	/**
	 * 添加一条信息
	 * @param record
	 * @return
	 */
	int insertSelective(CompanyPromotion record);
	/**
	 * 修改根据ID
	 * @param record
	 * @return
	 */
	 int updateByPrimaryKeySelective(CompanyPromotion record);
	 
	 /**
	  * 查询
	  * @param promotion_id
	  * @return
	  */
	 CompanyPromotion selectByPrimaryKey(Integer promotion_id);
	 
	 /**
	  * 根据公司ID查询
	  * @param company_id
	  * @return
	  */
	 List<CompanyPromotion> selectByPrimaryCompanyId(Integer promotion_id,Integer company_id,Integer pager,Integer limit);
}
