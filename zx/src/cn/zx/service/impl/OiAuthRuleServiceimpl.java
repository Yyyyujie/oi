package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.OiAuthRuleMapper;
import cn.zx.pojo.OiAuthRule;
import cn.zx.pojo.OiAuthRuleExample;
import cn.zx.service.OiAuthRuleService;
@Service("OiAuthRuleService")
public class OiAuthRuleServiceimpl implements OiAuthRuleService {
@Autowired
OiAuthRuleMapper oiAuthRuleMapper;
	@Override
	public List<OiAuthRule> getMenu(OiAuthRuleExample example) {
		// TODO Auto-generated method stub
		return oiAuthRuleMapper.selectByExample(example);
	}
	@Override
	public int addRule(OiAuthRule oiAuthRule) {
		// TODO Auto-generated method stub
		return oiAuthRuleMapper.insertSelective(oiAuthRule);
	}
	@Override
	public int removeRule(OiAuthRule oiAuthRule) {
		// TODO Auto-generated method stub
		return oiAuthRuleMapper.updateByPrimaryKeySelective(oiAuthRule);
	}
	@Override
	public int updateRule(OiAuthRule oiAuthRule) {
		// TODO Auto-generated method stub
		return oiAuthRuleMapper.updateByPrimaryKeySelective(oiAuthRule);
	}
	@Override
	public OiAuthRule getRuleById(Integer menu_id) {
		// TODO Auto-generated method stub
		return oiAuthRuleMapper.selectByPrimaryKey(menu_id);
	}
	
}
