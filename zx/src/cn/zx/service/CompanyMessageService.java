package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyMessage;

public interface CompanyMessageService {
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
