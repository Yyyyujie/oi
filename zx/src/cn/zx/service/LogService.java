package cn.zx.service;

import cn.zx.pojo.Log;

public interface LogService {
	
	/**
	 * 添加一条日志信息
	 * @param record
	 * @return
	 */
	int insertSelective(Log record);
}
