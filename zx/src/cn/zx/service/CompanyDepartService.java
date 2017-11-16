package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.TreeModel;
import cn.zx.tool.DeptList;

public interface CompanyDepartService {
	
	/**
	 * 树形结构
	 * @param id
	 * @param containsDept
	 * @return
	 */
	 public TreeModel selectTree(String id,Integer company_id, boolean containsDept);

	   
	    /**
		 * 根据根据公司ID查询公司部门
		 */
		List<CompanyDepart> selectDepartByCompanyId(CompanyDepartExample companyDepartExample);

		/**
	     * 查询所有名称
	     * @param company_id
	     * @return
	     */
	    public List<CompanyDepart> selectDeptName(Integer dept_id, Integer company_id);
	    /**
		 * 添加
		 * @param record
		 * @return
		 */
		int insertSelective(CompanyDepart record);
		
		int updateByPrimaryKeySelective(List<CompanyDepart> list);


		public List<DeptList> selectTaskUserTree(Integer company_id,Integer user_id);


		List<Integer> getdeptids(Integer company_id, Integer dept_id);

		/**
	     * 根据父ID查询部门
	     * @param dept_id
	     * @param company_id
	     * @return
	     */
	    List<CompanyDepart> selectDeptByPid(Integer pid,Integer company_id);

		

}
