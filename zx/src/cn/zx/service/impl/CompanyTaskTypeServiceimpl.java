package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyTaskTypeMapper;
import cn.zx.pojo.CompanyTaskType;
import cn.zx.pojo.CompanyTaskTypeExample;
import cn.zx.service.CompanyTaskTypeService;
import cn.zx.tool.DeptList;

@Service("CompanyTaskTypeService")
public class CompanyTaskTypeServiceimpl implements CompanyTaskTypeService {
@Autowired
CompanyTaskTypeMapper mapper;

@Override
public List<DeptList> gettaksTypes(Integer company_id) {
	// TODO Auto-generated method stub
	return mapper.gettasktype(company_id);
}

@Override
public CompanyTaskType selectTypeName(Integer task_obj) {
	// TODO Auto-generated method stub
	return mapper.selectByPrimaryKey(task_obj);
}
	
	
}
