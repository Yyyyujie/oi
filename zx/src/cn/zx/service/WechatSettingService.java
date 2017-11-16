package cn.zx.service;

import cn.zx.pojo.WechatSetting;

public interface WechatSettingService {
	/**
	 * 查询公司微信设置
	 * @return
	 */
    public WechatSetting selectWechat(Integer company_id);
    /**
     * 修改公司微信设置根据ID
     * @param wechatSetting
     * @return
     */
    public int updateWechatByID(WechatSetting wechatSetting);
    /**
     * 添加微信设置
     * @param wechatSetting
     * @return
     */
    public int insertWechatSet(WechatSetting wechatSetting);
}
