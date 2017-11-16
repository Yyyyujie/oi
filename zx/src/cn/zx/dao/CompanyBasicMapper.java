package cn.zx.dao;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyBasic;

/**
 * 公司基础信息Dao层接口
 * @author admin
 *
 */
public interface CompanyBasicMapper {
	/**
	 * 查询公司基础信息
	 * @param company_id
	 * @return
	 */
    public CompanyBasic selectBasic(@Param("company_id") Integer company_id);
    
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