package cn.zx.service;

import java.util.List;

import cn.zx.pojo.OiSite;

public interface OiSiteService {
	
	/**
	 * 根据公司id查看信息
	 * @param company_id
	 * @return
	 */
	public List<OiSite> getoiSite();
	
	/**
	 * 修改公司设置信息
	 * @param oiSite
	 * @return
	 */
	public int updateSite(OiSite oiSite);
}
