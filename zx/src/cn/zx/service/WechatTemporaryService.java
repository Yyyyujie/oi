package cn.zx.service;

import cn.zx.pojo.WechatTemporary;

public interface WechatTemporaryService {
	int addWechatTemporary(WechatTemporary wechatTemporary);
	
	WechatTemporary getWechatTemporary(Integer touristid);
}
