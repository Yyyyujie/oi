package cn.zx.service;


import java.util.List;

import cn.zx.pojo.CompanyNewsType;
import cn.zx.pojo.CompanyNewsTypeExample;

public interface CompanyNewsTypeService {
	/**
	 * 添加
	 * @param type
	 * @return
	 */
	int addCompanyNewsType (CompanyNewsType type);
	
	/**
	 * 查询
	 * @param news_type_id
	 * @return
	 */
	 List<CompanyNewsType> selectNewsType(Integer news_type_id);
	 /**
	  * 修改
	  * @param record
	  * @return
	  */
	 int updateByPrimaryKeySelective(CompanyNewsType record);
}
