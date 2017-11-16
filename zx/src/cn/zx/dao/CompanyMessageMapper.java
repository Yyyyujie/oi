package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyMessage;
import cn.zx.pojo.CompanyMessageExample;

public interface CompanyMessageMapper {
    long countByExample(CompanyMessageExample example);

    int deleteByExample(CompanyMessageExample example);

    int deleteByPrimaryKey(Integer m_id);

    int insert(CompanyMessage record);

    int insertSelective(CompanyMessage record);

    List<CompanyMessage> selectByExample(CompanyMessageExample example);

    CompanyMessage selectByPrimaryKey(Integer m_id);

    int updateByExampleSelective(@Param("record") CompanyMessage record, @Param("example") CompanyMessageExample example);

    int updateByExample(@Param("record") CompanyMessage record, @Param("example") CompanyMessageExample example);

    int updateByPrimaryKeySelective(CompanyMessage record);

    int updateByPrimaryKey(CompanyMessage record);
    /**
	 * 查询企业信息
	 * @param companyMessage
	 * @return
	 */
   public List<CompanyMessage> selectMessage(CompanyMessage companyMessage);
   
   /**
    * 修改企业信息根据ID
    * @param companyMessage
    * @return
    */
   public int updateMessageByID(CompanyMessage companyMessage);

}