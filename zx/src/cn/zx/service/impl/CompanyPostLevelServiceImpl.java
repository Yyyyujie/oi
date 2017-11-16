package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyPostLevelMapper;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.service.CompanyPostLevelService;
@Service("companyPostLevelService")
public class CompanyPostLevelServiceImpl implements CompanyPostLevelService {
	@Autowired
	CompanyPostLevelMapper companyPostLevelMapper;
	
	@Override
	public List<CompanyPostLevel> selectPostlevel(
			 Integer post_le_id,
			 Integer company_id) {
		// TODO Auto-generated method stub
		return companyPostLevelMapper.selectPostlevel(post_le_id, company_id);
	}

	@Override
	public int insertSelective(CompanyPostLevel record) {
		// TODO Auto-generated method stub
		return companyPostLevelMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(List<CompanyPostLevel> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i=companyPostLevelMapper.updateByPrimaryKeySelective(list.get(i));
		}
		return 0;
	}

}
