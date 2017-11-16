package cn.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyBasicMapper;
import cn.zx.pojo.CompanyBasic;
import cn.zx.service.CompanyBasicService;

@Service("companyBasicService")
public class CompanyBasicServiceImpl implements CompanyBasicService {
	@Autowired
	CompanyBasicMapper companyBasicMapper;
	
	@Override
	public CompanyBasic selectBasic(Integer company_id) {
		// TODO Auto-generated method stub
		return companyBasicMapper.selectBasic(company_id);
	}

	@Override
	public int updateBasicByID(CompanyBasic companyBasic) {
		// TODO Auto-generated method stub
		return companyBasicMapper.updateBasicByID(companyBasic);
	}

	@Override
	public int insertBasic(CompanyBasic companyBasic) {
		// TODO Auto-generated method stub
		return companyBasicMapper.insertBasic(companyBasic);
	}

}
