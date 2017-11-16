package cn.zx.util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.zx.message.SendMessage;
import cn.zx.pojo.Tmpl;
import cn.zx.refreshAccessToken.AccessToken;
import cn.zx.templateMessage.TemplateMessageData;

public class MainWechat {

	/**
	 * 
	 * @param company_id 公司id
	 * @param user_id    员工id
	 * @param tmpl_id    模板的主键
	 */
	public void task(int company_id,int user_id,int tmpl_id){
		SendMessage sm = new SendMessage();
    	String url=sm.findUrl(company_id);
		AccessToken a = new AccessToken();
		String wx_openid= SendMessage.findopenid(user_id);
		String tpl_id=SendMessage.findtmpl(tmpl_id);
		List<Tmpl> list = SendMessage.findkeyword(tmpl_id);
		Tmpl t = list.get(0);
		Map<String, TemplateMessageData> dateMap = new HashMap<String, TemplateMessageData>();
		dateMap.put("first",new TemplateMessageData(t.getFirstdata()));
		dateMap.put("keyword1",new TemplateMessageData(t.getKeyword1()));
		dateMap.put("keyword2",new TemplateMessageData(t.getKeyword2()));
		dateMap.put("keyword3", new TemplateMessageData(t.getKeyword3()));
		dateMap.put("keyword4", new TemplateMessageData(t.getKeyword4()));
		dateMap.put("keyword5", new TemplateMessageData(t.getKeyword5()));
		dateMap.put("remark",new TemplateMessageData(t.getRemark())	);
		Map tempMap = SendMessage.sendTpl(wx_openid, tpl_id, 
				url, dateMap,company_id);
		System.out.println(tempMap);
		
	}
}
