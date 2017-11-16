package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyPost;

public interface CompanyPostService {
	/**
	 * 修改企业职系表ID
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(List<CompanyPost> list);
    /**
     * 查询企业职系表
     * @param company_id
     * @return
     */
    public List<CompanyPost> selectPost(Integer post_id,Integer company_id);
    /**
     * 插入数据
     * @param record
     * @return
     */
    public int insertPost(CompanyPost record);
}
