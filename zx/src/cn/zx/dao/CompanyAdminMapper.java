package cn.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zx.pojo.CompanyAdmin;
import cn.zx.pojo.CompanyAdminExample;

public interface CompanyAdminMapper {
    long countByExample(CompanyAdminExample example);

    int deleteByExample(CompanyAdminExample example);

    int deleteByPrimaryKey(Integer admin_id);

    int insert(CompanyAdmin record);

    int insertSelective(CompanyAdmin record);

    List<CompanyAdmin> selectByExample(CompanyAdminExample example);

    CompanyAdmin selectByPrimaryKey(Integer admin_id);

    int updatebyexampleselective(@Param("record") CompanyAdmin record, @Param("example") CompanyAdminExample example);

    int updateByExample(@Param("record") CompanyAdmin record, @Param("example") CompanyAdminExample example);

    int updateByPrimaryKeySelective(CompanyAdmin record);

    int updateByPrimaryKey(CompanyAdmin record);
    
    /**
     * 登录
     * @param companyAdmin
     * @return
     */
    public List<CompanyAdmin> login(CompanyAdmin companyAdmin);
    
    /**
     * 查询企业管理员
     * @param companyAdmin
     * @return
     */
    public List<CompanyAdmin> selectAdmin(CompanyAdmin companyAdmin);
    
    /**
     * 注册及添加验证
     * @param username
     * @return
     */
    public List<CompanyAdmin> selectAdminByName(@Param("username") String username,@Param("phone") String phone);
    
    /**
     * 修改密码及忘记密码
     * @param companyAdmin
     * @return
     */
    public int updatePasswordByUsername(CompanyAdmin companyAdmin);
}