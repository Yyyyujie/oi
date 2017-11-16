package cn.zx.service;

import java.util.List;

import cn.zx.pojo.OiRole;
import cn.zx.pojo.OiRoleExample;

public interface OiRoleService {
	
	public OiRole getOiRoleByid(Integer role_id);
	
	public int removeRole(OiRole role);
	
	public int updateRole(OiRole role);
	
	public int addRole(OiRole role);
	
	public List<OiRole> getAllRole(OiRoleExample example);
	
}
