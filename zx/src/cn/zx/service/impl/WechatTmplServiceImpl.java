package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.WechatTmplMapper;
import cn.zx.pojo.WechatTmpl;
import cn.zx.pojo.WechatTmplExample;
import cn.zx.service.WechatTmplService;

@Service("wechatTmplService")
public class WechatTmplServiceImpl implements WechatTmplService {
	@Autowired
	WechatTmplMapper wechatTmplMapper;
	
	

	@Override
	public List<WechatTmpl> selectWechatTmpl(WechatTmpl record) {
		// TODO Auto-generated method stub
		return wechatTmplMapper.selectWechatTmpl(record);
	}

	@Override
	public int insertWechatTmpl(WechatTmpl record) {
		// TODO Auto-generated method stub
		return wechatTmplMapper.insertWechatTmpl(record);
	}

	@Override
	public int updateByPrimaryKeySelective(List<WechatTmpl> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i =wechatTmplMapper.updateByPrimaryKeySelective(list.get(i));
			row+=i;
		}
		return row;
	}

	@Override
	public int updateBywechatTmpl(WechatTmpl wechatTmpl) {
		return wechatTmplMapper.updateBywechatTmpl(wechatTmpl);
	}

	@Override
	public List<WechatTmpl> selectWechatTmplByCidAndType(WechatTmplExample example) {
		// TODO Auto-generated method stub
		return wechatTmplMapper.selectByExample(example);
	}

}
