package cn.zx.service;

import cn.zx.pojo.CompanyBasic;

/**
 * 公司基础信息业务逻辑接口
 * @author admin
 *
 */
public interface CompanyBasicService {
	/**
	 * 查询公司基础信息
	 * @param company_id
	 * @return
	 */
    public CompanyBasic selectBasic(Integer company_id);
    /**
     * 修改企业信息根据ID
     * @param companyBasic
     * @return
     */
    public int updateBasicByID(CompanyBasic companyBasic);
    /**
     * 添加信息
     * @param companyBasic
     * @return
     */
    int insertBasic(CompanyBasic companyBasic);
}
