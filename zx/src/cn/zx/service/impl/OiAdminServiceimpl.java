package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.OiAdminMapper;
import cn.zx.pojo.OiAdmin;
import cn.zx.pojo.OiAdminExample;
import cn.zx.service.OiAdminService;
@Service("OiAdminService")
public class OiAdminServiceimpl implements OiAdminService {
@Autowired
OiAdminMapper oiAdminMapper;

	@Override
	public OiAdmin getOiAdminByid(Integer admin_id) {
		// TODO Auto-generated method stub
		return oiAdminMapper.selectByPrimaryKey(admin_id);
	}

	@Override
	public int removeAdmin(OiAdmin oiAdmin) {
		// TODO Auto-generated method stub
		return oiAdminMapper.updateByPrimaryKeySelective(oiAdmin);
	}

	@Override
	public int updateAdmin(OiAdmin oiAdmin) {
		// TODO Auto-generated method stub
		return oiAdminMapper.updateByPrimaryKeySelective(oiAdmin);
	}

	@Override
	public int addAdmin(OiAdmin oiAdmin) {
		// TODO Auto-generated method stub
		return oiAdminMapper.insertSelective(oiAdmin);
	}

	@Override
	public List<OiAdmin> getAdmin(OiAdminExample example) {
		// TODO Auto-generated method stub
		return oiAdminMapper.selectByExample(example);
	}

	@Override
	public OiAdmin checkLogin(String username) {
		// TODO Auto-generated method stub
		return oiAdminMapper.CheckLoginName(username);
	}
}
