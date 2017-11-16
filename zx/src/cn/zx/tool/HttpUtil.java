package cn.zx.tool;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpUtil {

	final public static int getHttpPostStatusCode(String url){
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		try {
			HttpResponse response_ = client.execute(post);
			int statusCode = response_.getStatusLine().getStatusCode();
			return statusCode;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return 500;
	}
	
	
	  /** 
     * 发送http请求取得返回的输入流 
     *  
     * @param requestUrl 请求地址 
     * @return InputStream 
     */  
	public static InputStream httpRequest(String requestUrl) {  
        InputStream inputStream = null;  
        try {  
            URL url = new URL(requestUrl);  
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setRequestMethod("GET");  
            httpUrlConn.connect();  
            // 获得返回的输入流  
            inputStream = httpUrlConn.getInputStream();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return inputStream;  
    }
}
