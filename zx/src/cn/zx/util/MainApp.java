package cn.zx.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.zx.message.SendMessage;
import cn.zx.pojo.Tmpl;
import cn.zx.refreshAccessToken.AccessToken;
import cn.zx.templateMessage.TemplateMessageData;

public class MainApp {
	

	public static void main(String[] args) throws IOException  {
    	AccessToken a = new AccessToken();
    								//URL
//    	Url url= a.updateUrl(3, "http://www.baidu.com");
//    	System.out.println("成功");
    	SendMessage sm = new SendMessage();
    	String url=sm.findUrl(1);
    	/*
    	a.addTmpl(8,"pD2LtmdKBfIuHTrQv4jSq6W7ZQ49qh7AMidRXk1cdkE");
    	System.out.println("成功");
    	*/
    	a.updataAccessToken1();//定时器自动循环，到时候去掉
		String wx_openid= SendMessage.findopenid(1);//1为员工id
		String tpl_id=SendMessage.findtmpl(1);//1为模板的自增长id
		//SendMessage.updatekeyword(4, "测试3", "这是一次测试", "这真的是一次测试", "这确实是一次测试", "你信不信这是测试", "准备好了么", "");
		List<Tmpl> list = SendMessage.findkeyword(1);//1为模板的自增长id
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
				url, dateMap,1);//3是公司id
		
		System.out.println(tempMap);
		
	}
	
//		SendMessage sm = new SendMessage();
//    	String url=sm.findUrl(1);
//		AccessToken a = new AccessToken();
//		String wx_openid= SendMessage.findopenid(1);
//		String tpl_id=SendMessage.findtmpl(1);
//		List<Tmpl> list = SendMessage.findkeyword(1);
//		Tmpl t = list.get(0);
//		Map<String, TemplateMessageData> dateMap = new HashMap<String, TemplateMessageData>();
//		dateMap.put("first",new TemplateMessageData(t.getFirstdata()));
//		dateMap.put("keyword1",new TemplateMessageData(t.getKeyword1()));
//		dateMap.put("keyword2",new TemplateMessageData(t.getKeyword2()));
//		dateMap.put("keyword3", new TemplateMessageData(t.getKeyword3()));
//		dateMap.put("keyword4", new TemplateMessageData(t.getKeyword4()));
//		dateMap.put("keyword5", new TemplateMessageData(t.getKeyword5()));
//		dateMap.put("remark",new TemplateMessageData(t.getRemark())	);
//		Map tempMap = SendMessage.sendTpl(wx_openid, tpl_id, 
//				url, dateMap,1);
//		System.out.println(tempMap);
//	}
}
