package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyPromotionMapper;
import cn.zx.pojo.CompanyPromotion;
import cn.zx.service.CompanyPromotionService;

@Service("companyPromotionService")
public class CompanyPromotionServiceImpl implements CompanyPromotionService {
	@Autowired
	CompanyPromotionMapper companyPromotionMapper;
	
	@Override
	public int insertSelective(CompanyPromotion record) {
		
		return companyPromotionMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(CompanyPromotion record) {
		// TODO Auto-generated method stub
		return companyPromotionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public CompanyPromotion selectByPrimaryKey(Integer promotion_id) {
		// TODO Auto-generated method stub
		return companyPromotionMapper.selectByPrimaryKey(promotion_id);
	}

	@Override
	public List<CompanyPromotion> selectByPrimaryCompanyId(Integer promotion_id,Integer company_id,Integer pager,Integer limit) {
		// TODO Auto-generated method stub
		return companyPromotionMapper.selectByPrimaryCompanyId(promotion_id,company_id,pager,limit);
	}

}
