package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyPostMapper;
import cn.zx.pojo.CompanyPost;
import cn.zx.service.CompanyPostService;

@Service("companyPostService")
public class CompanyPostServiceImpl implements CompanyPostService {
	@Autowired
	CompanyPostMapper companyPostMapper;
	
	@Override
	public int updateByPrimaryKeySelective(List<CompanyPost> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i=companyPostMapper.updateByPrimaryKeySelective(list.get(i));
			row+=i;
		}
		return row;
	}

	@Override
	public List<CompanyPost> selectPost(Integer post_id,Integer company_id) {
		// TODO Auto-generated method stub
		return companyPostMapper.selectPost(post_id,company_id);
	}

	@Override
	public int insertPost(CompanyPost record) {
		// TODO Auto-generated method stub
		return companyPostMapper.insertPost(record);
	}

}
