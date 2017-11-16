package cn.zx.tool;

import java.io.UnsupportedEncodingException;

public class UrlUtf8 {
	public String urlEncodeUTF8(String source){
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
