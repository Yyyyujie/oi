package cn.zx.service;

import java.util.List;
import java.util.Map;

import cn.zx.pojo.DataEchart;

public interface DataEchartService {
			//员工端 获取部门任务统计
			public List<DataEchart> getTaskSumByDept(Integer company_id);

			public DataEchart getselfInfo(Integer user_id);

			List<DataEchart> getTaskStaffBydept(Integer dept_id);

			List<DataEchart> getTaskByuserid(Integer user_id);

			DataEchart DataCenterFirst(Map<String, Object> map);

			List<DataEchart> DataCenterList(Map<String, Object> map);
			
			List<DataEchart> DataCenter2(Integer dept_id, Integer company_id,Integer status);

			List<DataEchart> DataCenterBar(Integer dept_id, Integer status);
			/*==============================旧版开始===============================*/
			public List<DataEchart> DataCenterLoop(Map<String, Object> map);

			public List<DataEchart> DataCenterBar(Map<String, Object> map);
			
			/*==============================旧版结束===============================*/
			
}
