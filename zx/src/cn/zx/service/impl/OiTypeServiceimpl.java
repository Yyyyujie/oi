package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.OiTypeMapper;
import cn.zx.pojo.OiType;
import cn.zx.pojo.OiTypeExample;
import cn.zx.service.OiTypeService;
@Service("OiTypeService")
public class OiTypeServiceimpl implements OiTypeService{
@Autowired 
OiTypeMapper oiTypeMapper;
	@Override
	public List<OiType> getType(OiTypeExample example) {
		// TODO Auto-generated method stub
		return oiTypeMapper.selectByExample(example);
	}

	@Override
	public int addType(OiType oiType) {
		// TODO Auto-generated method stub
		return oiTypeMapper.insertSelective(oiType);
	}

	@Override
	public int removeType(OiType oiType) {
		// TODO Auto-generated method stub
		return oiTypeMapper.updateByPrimaryKeySelective(oiType);
	}

	@Override
	public int updateType(OiType oiType) {
		// TODO Auto-generated method stub
		return oiTypeMapper.updateByPrimaryKeySelective(oiType);
	}

	@Override
	public OiType getTypeById(Integer type_id) {
		// TODO Auto-generated method stub
		return oiTypeMapper.selectByPrimaryKey(type_id);
	}

	
}
