package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyTaskType;
import cn.zx.pojo.CompanyTaskTypeExample;
import cn.zx.tool.DeptList;

public interface CompanyTaskTypeService {
	List<DeptList> gettaksTypes(Integer company_id);

	CompanyTaskType selectTypeName(Integer task_obj);
}
