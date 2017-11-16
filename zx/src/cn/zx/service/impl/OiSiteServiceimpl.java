package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.OiSiteMapper;
import cn.zx.pojo.OiSite;
import cn.zx.service.OiSiteService;
@Service("OiSiteService")
public class OiSiteServiceimpl implements OiSiteService {

	@Autowired
	OiSiteMapper oiSiteMapper;
	
	@Override
	public List<OiSite> getoiSite() {
		// TODO Auto-generated method stub
		return oiSiteMapper.selectByExample(null);
	}

	@Override
	public int updateSite(OiSite oiSite) {
		// TODO Auto-generated method stub
		return oiSiteMapper.updateByPrimaryKeySelective(oiSite);
	}

}
