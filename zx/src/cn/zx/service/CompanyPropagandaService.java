package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyPropaganda;
import cn.zx.pojo.CompanyPropagandaExample;

public interface CompanyPropagandaService {
	/**
	 * 修改企业宣传
	 * @param record
	 * @return
	 */
    int updateByPrimaryKeySelective(List<CompanyPropaganda> list);
    /**
     * 查询企业宣传
     * @param company_id
     * @return
     */
    public List<CompanyPropaganda> selectPropaganda( Integer p_id,Integer company_id);
    /**
     * 插入信息
     * @param record
     * @return
     */
    public int insertPropaganda(CompanyPropaganda record);
	List<CompanyPropaganda> selectPropaganda(CompanyPropagandaExample example);
}
