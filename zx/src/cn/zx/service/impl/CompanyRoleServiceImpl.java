package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyRoleMapper;
import cn.zx.pojo.CompanyRole;
import cn.zx.service.CompanyRoleService;

@Service("companyRoleService")
public class CompanyRoleServiceImpl implements CompanyRoleService {
	@Autowired
	CompanyRoleMapper companyRoleMapper;
	
	@Override
	public List<CompanyRole> selectRole( Integer user_id,
			 Integer company_id) {
		// TODO Auto-generated method stub
		return companyRoleMapper.selectRole(user_id, company_id);
	}

	@Override
	public int updateByPrimaryKeySelective(List<CompanyRole> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i=companyRoleMapper.updateByPrimaryKeySelective(list.get(i));
			row +=i;
		}
		return row;
	}

	@Override
	public int insertSelective(CompanyRole record) {
		// TODO Auto-generated method stub
		return companyRoleMapper.insert(record);
	}

}
