package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyNewsTypeMapper;
import cn.zx.pojo.CompanyNewsType;
import cn.zx.service.CompanyNewsTypeService;

@Service("CompanyNewsTypeService")
public class CompanyNewsTypeServiceimpl implements CompanyNewsTypeService {
	@Autowired
	CompanyNewsTypeMapper mapper;

	@Override
	public int addCompanyNewsType(CompanyNewsType type) {
		return mapper.insertSelective(type);
	}

	@Override
	public List<CompanyNewsType> selectNewsType(Integer news_type_id) {
		// TODO Auto-generated method stub
		return mapper.selectNewsType(news_type_id);
	}

	@Override
	public int updateByPrimaryKeySelective(CompanyNewsType record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}
	
}
