package cn.zx.service;

import java.util.List;

import cn.zx.pojo.OiAuthRule;
import cn.zx.pojo.OiAuthRuleExample;

public interface OiAuthRuleService {
	public List<OiAuthRule> getMenu(OiAuthRuleExample example);

	public int addRule(OiAuthRule oiAuthRule);
	
	public int removeRule(OiAuthRule oiAuthRule);
	
	public int updateRule(OiAuthRule oiAuthRule);
	
	public OiAuthRule getRuleById(Integer menu_id);

}
