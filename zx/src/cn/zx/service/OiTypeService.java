package cn.zx.service;

import java.util.List;

import cn.zx.pojo.OiType;
import cn.zx.pojo.OiTypeExample;

public interface OiTypeService {
	
	public List<OiType> getType(OiTypeExample example);

	public int addType(OiType oiType);
	
	public int removeType(OiType oiType);
	
	public int updateType(OiType oiType);
	
	public OiType getTypeById(Integer type_id);
}
