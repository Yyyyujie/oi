package cn.zx.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyAdminMapper;
import cn.zx.pojo.CompanyAdmin;
import cn.zx.service.CompanyAdminService;

@Service("companyAdminService")
public class CompanyAdminServiceImpl implements CompanyAdminService {
	@Autowired
	CompanyAdminMapper companyAdminMapper;
	
	
	public List<CompanyAdmin> login(CompanyAdmin companyAdmin) {
		return companyAdminMapper.login(companyAdmin);
	}	

	public List<CompanyAdmin> selectAdmin(CompanyAdmin companyAdmin) {
		return companyAdminMapper.selectAdmin(companyAdmin);
	}

	@Override
	public int insertSelective(CompanyAdmin record) {
		// TODO Auto-generated method stub
		return companyAdminMapper.insertSelective(record);
	}

	@Override
	public CompanyAdmin selectByPrimaryKey(Integer admin_id) {
		// TODO Auto-generated method stub
		return companyAdminMapper.selectByPrimaryKey(admin_id);
	}

	@Override
	public int updateByPrimaryKeySelective(CompanyAdmin record) {
		// TODO Auto-generated method stub
		return companyAdminMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<CompanyAdmin> selectAdminByName(String username, String phone) {
		// TODO Auto-generated method stub
		return companyAdminMapper.selectAdminByName(username,phone);
	}

	@Override
	public int updatePasswordByUsername(CompanyAdmin companyAdmin) {
		// TODO Auto-generated method stub
		return companyAdminMapper.updatePasswordByUsername(companyAdmin);
	}

	

}
