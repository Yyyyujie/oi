package cn.zx.service;

import java.util.List;

import cn.zx.pojo.StaffTaskLog;
import cn.zx.pojo.StaffTaskLogExample;

public interface StaffTaskLogService {
	/**
	 * 添加任务进度日志
	 */
	boolean addTaskProgressLog(StaffTaskLog staffTaskLog);
	
	/**
	 * 根据任务ID查询任务日志
	 */
	List<StaffTaskLog> selectTaskLogByTaskId(StaffTaskLogExample staffTaskLogExample);
}
