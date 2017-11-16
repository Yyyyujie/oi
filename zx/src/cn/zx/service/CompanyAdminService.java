package cn.zx.service;

import java.util.List;

import cn.zx.pojo.CompanyAdmin;

public interface CompanyAdminService {
	  /**
     * 登录
     * @param companyAdmin
     * @return
     */
    public List<CompanyAdmin> login(CompanyAdmin companyAdmin);
	 /**
     * 登录
     * @param companyAdmin
     * @return
     */
    public List<CompanyAdmin> selectAdmin(CompanyAdmin companyAdmin);
    
    /**
     * 添加企业管理员
     * @param record
     * @return
     */
    public int insertSelective(CompanyAdmin record);
    
    /**
     * 根据ID查询信息
     * @param admin_id
     * @return
     */
    public CompanyAdmin selectByPrimaryKey(Integer admin_id);
    
    /**
     * 根据ID修改企业管理员信息
     * @param record
     * @param example
     * @return
     */
    public int updateByPrimaryKeySelective(CompanyAdmin record);
    /**
     * 注册及添加验证
     * @param username
     * @return
     */
    public List<CompanyAdmin> selectAdminByName(String username,String phone);
    
    /**
     * 修改密码及忘记密码
     * @param companyAdmin
     * @return
     */
    public int updatePasswordByUsername(CompanyAdmin companyAdmin);
}
