package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.OiRoleMapper;
import cn.zx.pojo.OiRole;
import cn.zx.pojo.OiRoleExample;
import cn.zx.service.OiRoleService;
@Service("OiRoleService")
public class OiRoleServiceimpl implements OiRoleService {
@Autowired
OiRoleMapper oiRoleMapper;

	@Override
	public OiRole getOiRoleByid(Integer role_id) {
		// TODO Auto-generated method stub
		return oiRoleMapper.selectByPrimaryKey(role_id);
	}

	@Override
	public int removeRole(OiRole role) {
		// TODO Auto-generated method stub
		return oiRoleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public int updateRole(OiRole role) {
		// TODO Auto-generated method stub
		return oiRoleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public int addRole(OiRole role) {
		// TODO Auto-generated method stub
		return oiRoleMapper.insertSelective(role);
	}

	@Override
	public List<OiRole> getAllRole(OiRoleExample example) {
		// TODO Auto-generated method stub
		return oiRoleMapper.selectByExample(example);
	}

}
