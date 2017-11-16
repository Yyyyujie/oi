package cn.zx.service;

import java.util.List;

import cn.zx.pojo.OiAdmin;
import cn.zx.pojo.OiAdminExample;


public interface OiAdminService {
	public List<OiAdmin> getAdmin(OiAdminExample example);
	
	public OiAdmin getOiAdminByid(Integer admin_id);
	
	public int removeAdmin(OiAdmin oiAdmin);
	
	public int updateAdmin(OiAdmin oiAdmin);
	
	public int addAdmin(OiAdmin oiAdmin);

	public OiAdmin checkLogin(String username);
}
