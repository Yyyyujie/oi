package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.OiDistrictMapper;
import cn.zx.pojo.OiDistrict;
import cn.zx.pojo.OiDistrictExample;
import cn.zx.service.OiDistrictService;
@Service("OiDistrictService")
public class OiDistrictServiceimpl implements OiDistrictService {
@Autowired
OiDistrictMapper oiDistrictMapper;

	@Override
	public List<OiDistrict> getDistrict(OiDistrictExample example) {
		// TODO Auto-generated method stub
		return oiDistrictMapper.selectByExample(example);
	}
	@Override
	public OiDistrict getDistrictById(Integer district_id) {
		// TODO Auto-generated method stub
		return oiDistrictMapper.selectByPrimaryKey(district_id);
	}
	@Override
	public int addDistrict(OiDistrict district) {
		// TODO Auto-generated method stub
		return oiDistrictMapper.insertSelective(district);
	}
	@Override
	public int removeDistrict(OiDistrict district) {
		// TODO Auto-generated method stub
		return oiDistrictMapper.updateByPrimaryKeySelective(district);
	}
	@Override
	public int updateDistrict(OiDistrict district) {
		// TODO Auto-generated method stub
		return oiDistrictMapper.updateByPrimaryKeySelective(district);
	}
	
	
}
