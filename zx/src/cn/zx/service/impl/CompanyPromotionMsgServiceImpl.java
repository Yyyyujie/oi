package cn.zx.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyPromotionMsgMapper;
import cn.zx.pojo.CompanyPromotionMsg;
import cn.zx.service.CompanyPromotionMsgService;

@Service("companyPromotionMsgService")
public class CompanyPromotionMsgServiceImpl implements
		CompanyPromotionMsgService {
	@Autowired
	CompanyPromotionMsgMapper companyPromotionMsgMapper;
	
	@Override
	public int insertSelective(CompanyPromotionMsg record) {
		// TODO Auto-generated method stub
		return companyPromotionMsgMapper.insertSelective(record);
	}

	@Override
	public List<CompanyPromotionMsg> selectVote() {
		// TODO Auto-generated method stub
		return companyPromotionMsgMapper.selectVote();
	}

	@Override
	public List<CompanyPromotionMsg> selectAgree() {
		// TODO Auto-generated method stub
		return companyPromotionMsgMapper.selectAgree();
	}

	@Override
	public List<CompanyPromotionMsg> selectFirm() {
		// TODO Auto-generated method stub
		return companyPromotionMsgMapper.selectFirm();
	}

	@Override
	public List<CompanyPromotionMsg> selectPMByuid(Integer user_id,Integer promotion_id) {
		// TODO Auto-generated method stub
		return companyPromotionMsgMapper.selectPMByuid(user_id,promotion_id);
	}

	@Override
	public int updateByPrimaryKeySelective(CompanyPromotionMsg record) {
		// TODO Auto-generated method stub
		return companyPromotionMsgMapper.updateByPrimaryKeySelective(record);
	}

}
