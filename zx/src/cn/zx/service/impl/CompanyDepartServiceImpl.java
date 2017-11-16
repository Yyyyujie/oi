package cn.zx.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.zx.dao.CompanyDepartMapper;
import cn.zx.dao.CompanyStafferMapper;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.TreeModel;
import cn.zx.service.CompanyDepartService;
import cn.zx.tool.DeptList;
import cn.zx.tool.TreeUtil;

@Service("companyDepartService")
public class CompanyDepartServiceImpl implements CompanyDepartService {
	@Autowired
	CompanyDepartMapper companyDepartMapper;
	@Autowired
	CompanyStafferMapper stafferMapper;

	// 构造单位及部门树形结构
	private List<CompanyDepart> selectChildren(String id, Integer company_id) {
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("company_id", company_id);
		para.put("pid", id);
		return companyDepartMapper.list(para);

	}

	@Override
	public TreeModel selectTree(String id, Integer company_id, boolean containsDept) {
		TreeModel tm = new TreeModel();
		// 在此只保留部门或单位的id及name属性,可拓展

		String[] s = new String[] { "getDept_id", "getDept_name" };// 存放你想获取的值
		List<CompanyDepart> li = this.selectChildren(id, company_id);
		this.tree(tm, li, s, containsDept, company_id);
		return tm;
	}

	private void tree(TreeModel tm, List<CompanyDepart> li, String[] s, boolean containsDept, Integer company_id) {
		if (!CollectionUtils.isEmpty(li)) {
			for (int i = 0; i < li.size(); i++) {
				TreeModel ntm = new TreeModel();
				CompanyDepart dept = li.get(i);

				TreeUtil.copyModel(ntm, dept, s);//  复制值到TreeModel  
				tm.getChildren().add(ntm);//  添加到孩子节点列表

				List<CompanyDepart> list = this.selectChildren(dept.getDept_id().toString(), company_id);
				tree(ntm, list, s, containsDept, company_id);//  递归，实现无限层级
			}
		}
	}

	@Override
	public List<CompanyDepart> selectDepartByCompanyId(CompanyDepartExample companyDepartExample) {
		return companyDepartMapper.selectByExample(companyDepartExample);
	}

	@Override
	public List<CompanyDepart> selectDeptName(Integer dept_id, Integer company_id) {
		// TODO Auto-generated method stub
		return companyDepartMapper.selectDeptName(dept_id, company_id);
	}

	@Override
	public int insertSelective(CompanyDepart record) {
		// TODO Auto-generated method stub
		return companyDepartMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(List<CompanyDepart> list) {
		// TODO Auto-generated method stub
		int row = 0;
		for (int i = 0; i < list.size(); i++) {
			i = companyDepartMapper.updateByPrimaryKeySelective(list.get(i));
			row += i;
		}
		return 0;
	}

	@Override
	public List<DeptList> selectTaskUserTree(Integer company_id,Integer user_id) {
		List<CompanyStaffer> staffs = stafferMapper.selectByExampleAndTaskCount(company_id);
		CompanyDepartExample departExample = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = departExample.createCriteria();
		createCriteria.andCompany_idEqualTo(company_id);
		createCriteria.andIsdeleteEqualTo(1);
		createCriteria.andStatusEqualTo(1);
		List<CompanyDepart> departs = companyDepartMapper.selectByExample(departExample);
		System.out.println(departs.size());

		List<DeptList> list = new ArrayList<DeptList>();
		for (int i = 0; i < departs.size(); i++) {
			CompanyDepart depart = departs.get(i);
			DeptList dept = new DeptList();
			List<DeptList> list2 = new ArrayList<DeptList>();
			dept.setValue(depart.getDept_id());
			dept.setText(depart.getDept_name());
			for (int j = 0; j < staffs.size(); j++) {
				CompanyStaffer staffer = staffs.get(j);
				DeptList s = null;
				if (staffer.getDepart() == depart.getDept_id()&&staffer.getUser_id()!=user_id ) {// 如果员工在部门下
					s = new DeptList();
					System.out.println(list2.size());
					s.setValue(staffer.getUser_id());
					s.setText(staffer.getRealname());
					list2.add(s);
				}
				dept.setChildren(list2);
			}
			System.out.println(dept.getText() + "下有" + list2.size() + "人");
			if( list2.size()!=0){
				list.add(dept);
			}
			
		}
		return list;
	}

	@Override
	public List<Integer> getdeptids(Integer company_id, Integer dept_id) {
		CompanyDepartExample departExample = new CompanyDepartExample();
		cn.zx.pojo.CompanyDepartExample.Criteria createCriteria = departExample.createCriteria();
		createCriteria.andCompany_idEqualTo(company_id);
		createCriteria.andIsdeleteEqualTo(1);
		createCriteria.andStatusEqualTo(1);

		List<CompanyDepart> departs = companyDepartMapper.selectByExample(departExample);
		List<Integer> list1 = new ArrayList<Integer>();// 最后返回的
		list1.add(dept_id);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(dept_id);
		List<Integer> list3 = new ArrayList<Integer>();// 每次接收的
		this.rlist(list1, list2, list3,departs);
		System.out.println(list1.toString());
		return list1;

	}

	public void rlist(List<Integer> list1, List<Integer> list2, List<Integer> list3,List<CompanyDepart> departs) {
		if (!CollectionUtils.isEmpty(list2)) {
		for (int j = 0; j < list2.size(); j++) {
			for (int i = 0; i < departs.size(); i++) {
				if (departs.get(i).getPid() == list2.get(j)) {
					list3.add(departs.get(i).getDept_id());
					System.out.println(departs.get(i).getDept_id());
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
	@Override
	public List<CompanyDepart> selectDeptByPid(Integer pid, Integer company_id) {
		// TODO Auto-generated method stub
		return companyDepartMapper.selectDeptByPid(pid, company_id);
	}
	  
}
