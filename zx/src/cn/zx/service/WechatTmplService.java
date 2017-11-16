package cn.zx.service;

import java.util.List;

import cn.zx.pojo.WechatTmpl;
import cn.zx.pojo.WechatTmplExample;


public interface WechatTmplService {
	/**
	 * 修改信息根据ID
	 * @param record
	 * @return
	 */
	 public int updateByPrimaryKeySelective(List<WechatTmpl> list);
	 /**
	  * 根据模板ID修改信息
	  * @param tmpl_id
	  * @return
	  */
	 public int updateBywechatTmpl(WechatTmpl wechatTmpl);
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
     * 根据公司id和类别查找模版
     * @param example
     * @return
     */
    public List<WechatTmpl>selectWechatTmplByCidAndType(WechatTmplExample example);
    
    
}
