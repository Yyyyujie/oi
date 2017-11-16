package cn.zx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyPromotionMsg;

public interface CompanyPromotionMsgService {
	
	/**
	 * 添加一条信息
	 * @param record
	 * @return
	 */
	int insertSelective(CompanyPromotionMsg record);
	 /**
     * 查询投票总数
     * @return
     */
    List<CompanyPromotionMsg> selectVote();
    /**
     * 查询同意总数
     * @return
     */
    List<CompanyPromotionMsg> selectAgree();
    /**
     * 查询拒绝总数
     * @return
     */
    List<CompanyPromotionMsg> selectFirm();
	/**
     * 查询是否存在
     * @param user_id
     * @return
     */
    List<CompanyPromotionMsg> selectPMByuid(Integer user_id,Integer promotion_id);
    
    /**
     * 根据主键ID修改投票
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CompanyPromotionMsg record);
}
