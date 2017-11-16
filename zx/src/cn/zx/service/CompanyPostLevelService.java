package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyPostLevel;

public interface CompanyPostLevelService {
	 /**
     * 查询数据
     * @param post_le_id
     * @param company_id
     * @return
     */
    public List<CompanyPostLevel> selectPostlevel(Integer post_le_id, Integer company_id);
    
    /**
     * 添加
     * @param record
     * @return
     */
    public int insertSelective(CompanyPostLevel record);
    /**
     * 添加
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(List<CompanyPostLevel> list);
}
