package cn.zx.tool;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import cn.zx.pojo.SmsMessage;

public class SmsTool {
	public String sendSMS(SmsMessage sms){
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");// 在头文件中设置转码  
		NameValuePair[] data = { new NameValuePair("Uid", sms.getUid()),//注册用户名
		new NameValuePair("Key", sms.getKey()),//注册成功后登录网站的密码
		new NameValuePair("smsMob", sms.getSmsmob()),//手机号码
		new NameValuePair("smsText", sms.getSmtext()) };//设置短信内容
		post.setRequestBody(data);
		String result=null;
		try {
			client.executeMethod(post);
			result = new String(post.getResponseBodyAsString().getBytes("utf8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
