package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyMessageMapper;
import cn.zx.pojo.CompanyMessage;
import cn.zx.service.CompanyMessageService;

@Service("companyMessageService")
public class CompanyMessageServiceImpl implements CompanyMessageService {
	@Autowired
	CompanyMessageMapper companyMessageMapper;
	
	@Override
	public List<CompanyMessage> selectMessage(CompanyMessage companyMessage) {
		// TODO Auto-generated method stub
		return companyMessageMapper.selectMessage(companyMessage);
	}

	@Override
	public int updateMessageByID(CompanyMessage companyMessage) {
		// TODO Auto-generated method stub
		return companyMessageMapper.updateMessageByID(companyMessage);
	}

}
