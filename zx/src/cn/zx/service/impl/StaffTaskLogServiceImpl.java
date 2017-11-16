/**
 * 
 */
package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.StaffTaskLogMapper;
import cn.zx.pojo.StaffTaskLog;
import cn.zx.pojo.StaffTaskLogExample;
import cn.zx.service.StaffTaskLogService;

/**
 * @author AYao
 *
 */
@Service("staffTaskLogService")
public class StaffTaskLogServiceImpl implements StaffTaskLogService {
	
	@Autowired
	private StaffTaskLogMapper staffTaskLogMapper;
	/* (non-Javadoc)
	 * @see cn.zx.service.StaffTaskLogService#addTaskProgressLog(cn.zx.pojo.StaffTaskLog)
	 */
	@Override
	public boolean addTaskProgressLog(StaffTaskLog staffTaskLog) {
		return staffTaskLogMapper.insertSelective(staffTaskLog)==1;
	}
	@Override
	public List<StaffTaskLog> selectTaskLogByTaskId(StaffTaskLogExample staffTaskLogExample) {
		return staffTaskLogMapper.selectByExample(staffTaskLogExample);
	}

}
