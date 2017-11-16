package cn.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.WechatTemporaryMapper;
import cn.zx.pojo.WechatTemporary;
import cn.zx.service.WechatTemporaryService;
@Service("WechatTemporaryService")
public class WechatTemporaryServiceimpl implements WechatTemporaryService{
@Autowired
WechatTemporaryMapper wechatTemporaryMapper;
	@Override
	public int addWechatTemporary(WechatTemporary wechatTemporary) {
		// TODO Auto-generated method stub
		return wechatTemporaryMapper.insertSelective(wechatTemporary);
	}
	@Override
	public WechatTemporary getWechatTemporary(Integer touristid) {
		// TODO Auto-generated method stub
		return wechatTemporaryMapper.selectByPrimaryKey(touristid);
	}

}
