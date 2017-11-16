package cn.zx.service;

import java.util.List;

import cn.zx.pojo.OiDistrict;
import cn.zx.pojo.OiDistrictExample;

public interface OiDistrictService {
	
	public List<OiDistrict> getDistrict(OiDistrictExample example);
	
	public OiDistrict getDistrictById(Integer district_id);
	
	public int addDistrict(OiDistrict district);
	
	public int removeDistrict(OiDistrict district);
	
	public int updateDistrict(OiDistrict district);
	
}
