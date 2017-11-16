package cn.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.WechatSettingMapper;
import cn.zx.pojo.WechatSetting;
import cn.zx.service.WechatSettingService;

@Service("wechatSettingService")
public class WechatSettingServiceImpl implements WechatSettingService {
	@Autowired
	WechatSettingMapper wechatSettingMapper;
	
	@Override
	public WechatSetting selectWechat(Integer company_id) {
		return wechatSettingMapper.selectWechat(company_id);
	}

	

	@Override
	public int insertWechatSet(WechatSetting wechatSetting) {
		// TODO Auto-generated method stub
		return wechatSettingMapper.insertWechatSet(wechatSetting);
	}



	@Override
	public int updateWechatByID(WechatSetting wechatSetting) {
		// TODO Auto-generated method stub
		return wechatSettingMapper.updateWechatByID(wechatSetting);
	}



	
}
