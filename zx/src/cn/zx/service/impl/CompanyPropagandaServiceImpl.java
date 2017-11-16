package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyPropagandaMapper;
import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.CompanyPropagandaExample;
import cn.zx.service.CompanyPropagandaService;

@Service("companyPropagandaService")
public class CompanyPropagandaServiceImpl implements CompanyPropagandaService {
	@Autowired
	CompanyPropagandaMapper companyPropagandaMapper;
	
	@Override
	public int updateByPrimaryKeySelective(List<CompanyPropaganda> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i=companyPropagandaMapper.updateByPrimaryKeySelective(list.get(i));
			row+=i;
		}
		return row;
	}

	@Override
	public List<CompanyPropaganda> selectPropaganda( Integer p_id,Integer company_id) {
		// TODO Auto-generated method stub
		return companyPropagandaMapper.selectPropaganda(p_id,company_id);
	}

	@Override
	public int insertPropaganda(CompanyPropaganda record) {
		// TODO Auto-generated method stub
		return companyPropagandaMapper.insertPropaganda(record);
	}

	@Override
	public List<CompanyPropaganda> selectPropaganda(
			CompanyPropagandaExample example) {
		// TODO Auto-generated method stub
		return companyPropagandaMapper.selectByExample(example);
	}

}
