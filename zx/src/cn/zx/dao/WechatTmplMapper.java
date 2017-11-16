package cn.zx.dao;

import java.util.List;

import cn.zx.pojo.WechatTmpl;
import cn.zx.pojo.WechatTmplExample;

public interface WechatTmplMapper {
	/**
	 * 修改信息根据ID
	 * @param wechatTmpl
	 * @return
	 */
    public int updateByPrimaryKeySelective(WechatTmpl wechatTmpl);
    
    /**
     * 查询信息
     * @param record
     * @return
     */
    public List<WechatTmpl> selectWechatTmpl(WechatTmpl record);
    /**
     * 添加一条信息
     * @param record
     * @return
     */
    public int insertWechatTmpl(WechatTmpl record);
    
    /**
     * 根据模板ID修改数据
     * @param wechatTmpl
     * @return
     */
    public int updateBywechatTmpl(WechatTmpl wechatTmpl);
    
    List<WechatTmpl> selectByExample(WechatTmplExample example);
    
}