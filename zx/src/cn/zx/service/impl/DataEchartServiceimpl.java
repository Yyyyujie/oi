package cn.zx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.zx.dao.CompanyDepartMapper;
import cn.zx.dao.DataEchartMapper;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.DataEchart;
import cn.zx.service.DataEchartService;

@Service("DataEchartService")
public class DataEchartServiceimpl implements DataEchartService {
	@Autowired
	DataEchartMapper dataEchartMapper;
	@Autowired
	CompanyDepartMapper companyDepartMapper;

	@Override
	public List<DataEchart> getTaskSumByDept(Integer company_id) {
		// TODO Auto-generated method stub
		return dataEchartMapper.staff_task_dept_sum(company_id);
	}

	@Override
	public DataEchart getselfInfo(Integer user_id) {
		// TODO Auto-generated method stub
		return dataEchartMapper.staff_task_sum(user_id);
	}
	
	@Override
	public List<DataEchart> getTaskStaffBydept(Integer dept_id) {
		// TODO Auto-generated method stub
		return dataEchartMapper.get_task_staff_bydept(dept_id);
	}
	
	@Override
	public List<DataEchart> getTaskByuserid(Integer user_id) {
		// TODO Auto-generated method stub
		return dataEchartMapper.get_task_byuserid(user_id);
	}

	@Override
	public DataEchart DataCenterFirst(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dataEchartMapper.DataCenterFirst(map);
	}
	
	
	
	
	@Override
	public List<DataEchart> DataCenterBar(Integer dept_id,Integer status) {
		System.out.println(dept_id);
		Map<String,Object>map=new HashMap<String, Object>();
		int[] task_status1={3,4,5,6};
		int[] task_status2={2};
		map.put("dept_id", dept_id);
		if(status==1){
			map.put("task_status", task_status2);
		}else{
			map.put("task_status", task_status1);
		}
		List<DataEchart> dataCenterFirst1 = dataEchartMapper.DataCenterBar(map);
	
		  return dataCenterFirst1;
	}
	
	@Override
	public List<DataEchart> DataCenterList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dataEchartMapper.DataCenterList(map);
	}

	@Override
	public List<DataEchart> DataCenter2(Integer dept_id,Integer company_id,Integer status) {
		CompanyDepartExample departExample = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = departExample.createCriteria();
		createCriteria.andCompany_idEqualTo(company_id);
		createCriteria.andIsdeleteEqualTo(1);
		createCriteria.andStatusEqualTo(1);

		List<CompanyDepart> departs = companyDepartMapper.selectByExample(departExample);
		//获得子部门
		List<DataEchart> sonDept = dataEchartMapper.getSonDept2(dept_id);
		boolean sonDeptCount=sonDept.size()!=0;
		//
		if(sonDeptCount){
			for (DataEchart dataEchart : sonDept) {
				Integer getdeptids = getdeptids2(departs, dataEchart.getValue(),status);
				dataEchart.setValue_b(getdeptids);
			}
		}
		
		
		return sonDept;
	}
	

	
	public Integer getdeptids2(List<CompanyDepart>departs,Integer dept_id,Integer status) {
		List<Integer> list1 = new ArrayList<Integer>();// 最后返回的
		list1.add(dept_id);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(dept_id);
		List<Integer> list3 = new ArrayList<Integer>();// 每次接收的
		this.rlist(list1, list2, list3,departs);
		//任务状态
		int[] task_status1 = {3,4,5,6};
		int[] task_status2 = {2};
		// 传入的map
		Map<String, Object> map = new HashMap<String, Object>();
		if(list1.size()==0){
			return 0;
		}else{
		map.put("depts", list1);
		if (status == 1) {
			map.put("task_status", task_status2);
		} else {
			map.put("task_status", task_status1);
		}
		return  dataEchartMapper.DataCenterLoop2(map);
		}
	}

	public void rlist(List<Integer> list1, List<Integer> list2, List<Integer> list3,List<CompanyDepart> departs) {
		if (!CollectionUtils.isEmpty(list2)) {
		for (int j = 0; j < list2.size(); j++) {
			for (int i = 0; i < departs.size(); i++) {
				if (departs.get(i).getPid() == list2.get(j)) {
					list3.add(departs.get(i).getDept_id());
				}
			}
		}
		list2.clear();
		list2.addAll(list3);
		list1.addAll(list3);
		list3.clear();
		rlist(list1, list2,list3, departs);
		}
	}
	/*==============================旧版开始===============================*/
	@Override
	public List<DataEchart> DataCenterLoop(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dataEchartMapper.DataCenterLoop(map);
	}
	
	@Override
	public List<DataEchart> DataCenterBar(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dataEchartMapper.DataCenterBar(map);
	}
	/*==============================旧版结束===============================*/
	
	
	
}
