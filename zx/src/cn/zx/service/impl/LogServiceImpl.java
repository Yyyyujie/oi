package cn.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.LogMapper;
import cn.zx.pojo.Log;
import cn.zx.service.LogService;


@Service("logService")
public class LogServiceImpl implements LogService {
	@Autowired
	LogMapper logMapper;
	
	
	@Override
	public int insertSelective(Log record) {
		// TODO Auto-generated method stub
		return logMapper.insertSelective(record);
	}

}
