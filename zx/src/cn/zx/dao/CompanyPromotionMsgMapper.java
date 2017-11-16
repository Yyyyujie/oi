package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyPromotionMsg;
import cn.zx.pojo.CompanyPromotionMsgExample;

public interface CompanyPromotionMsgMapper {
    long countByExample(CompanyPromotionMsgExample example);

    int deleteByExample(CompanyPromotionMsgExample example);

    int deleteByPrimaryKey(Integer promotion_msg_id);

    int insert(CompanyPromotionMsg record);

    int insertSelective(CompanyPromotionMsg record);

    List<CompanyPromotionMsg> selectByExample(CompanyPromotionMsgExample example);

    CompanyPromotionMsg selectByPrimaryKey(Integer promotion_msg_id);

    int updateByExampleSelective(@Param("record") CompanyPromotionMsg record, @Param("example") CompanyPromotionMsgExample example);

    int updateByExample(@Param("record") CompanyPromotionMsg record, @Param("example") CompanyPromotionMsgExample example);

    int updateByPrimaryKeySelective(CompanyPromotionMsg record);

    int updateByPrimaryKey(CompanyPromotionMsg record);
    
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
    List<CompanyPromotionMsg> selectPMByuid(@Param("user_id") Integer user_id,@Param("promotion_id") Integer promotion_id);
    
}