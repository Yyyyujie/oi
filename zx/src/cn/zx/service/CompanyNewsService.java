package cn.zx.service;

import java.util.List;
import java.util.Map;

import cn.zx.pojo.CompanyNews;
import cn.zx.pojo.CompanyNewsExample;
import cn.zx.pojo.CompanyStaffer;

public interface CompanyNewsService {
	/**
	 * 查询
	 * @param new_id
	 * @param company_id
	 * @return
	 */
	public List<CompanyNews> selectNews(Integer new_id,Integer company_id,Integer user_id);
	
	public int updateByPrimaryKeySelective(List<CompanyNews> list);
	
	public int insertSelective(CompanyNews record);
	/**
	    * 企业公告信息
	    */
		List<CompanyNews> selectAllCompanyNewsByCompanyId(CompanyNewsExample companyNewsExample);

	public int updateByPrimaryKeySelective(CompanyNews news);

	public List<CompanyNews> selectNewsWithALl();

	public List<CompanyNews> NewselectNewsWithALl(Map<String, Object> map);


}
