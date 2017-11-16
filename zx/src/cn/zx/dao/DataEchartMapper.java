package cn.zx.dao;

import java.util.List;
import java.util.Map;

import cn.zx.pojo.DataEchart;

public interface DataEchartMapper {
    List<DataEchart> type_count();
    List<DataEchart> district_count();
    List<DataEchart> task_count();
	DataEchart staff_task_sum(Integer user_id);
	List<DataEchart> staff_task_dept_sum(Integer user_id);
	List<DataEchart> get_task_staff_bydept(Integer dept_id);
	List<DataEchart>get_task_byuserid(Integer user_id);
	DataEchart DataCenterFirst(Map<String, Object> map);
	Integer DataCenterLoop2(Map<String, Object> map);
	
	List<DataEchart> DataCenterBar(Map<String, Object> map);
	
	List<DataEchart> DataCenterList(Map<String, Object> map);
	
	List<DataEchart> getSonDept2(Integer dept_id);
	/*==============================旧版开始===============================*/
	List<DataEchart> DataCenterLoop(Map<String, Object> map);
	/*==============================旧版结束===============================*/
}