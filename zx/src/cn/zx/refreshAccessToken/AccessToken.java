package cn.zx.refreshAccessToken;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.zx.pojo.Access_token;
import cn.zx.pojo.Tmpl;
import cn.zx.pojo.Url;
import cn.zx.pojo.WeSetting;
import cn.zx.util.HttpServer;

import com.alibaba.fastjson.JSON;



/**
 * @author Administrator
 *
 */
@Component
public class AccessToken {
	static int i;
	@Scheduled(cron = "0/5 * *  * * ? ")
	public static void timer1() {  
		
		i=i+1;
                	//System.out.println("循环输出"+i);
                  
    }  

	public static Map getAccessTokenMap(String appid,String secret){
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
			String x = "";
			try {
				x = HttpServer.doGet(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Map map = JSON.parseObject(x, HashMap.class);
			return map;
			}
	//定时执行
//	@Scheduled(cron = "0/5 * *  * * ? ") //5秒一次
	@Scheduled(cron = "0 0 * * * ?")//一小时次
	public void updataAccessToken1() {
		System.out.println("获取AccessToken");
		 String resource = "mybatis-config.xml";
		 InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
         SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	     SqlSession sqlSession = factory.openSession();
		 List<WeSetting> empList = new  ArrayList<WeSetting>();
	     empList = sqlSession.selectList("cn.zx.dao.TokenMapper.selectsetting");
	     for (WeSetting weSetting : empList) {
	         System.out.println("1");
	   		 String appid= weSetting.getAppid();
	   		 String secret=weSetting.getAppsecret();
	   		 int company_id = weSetting.getCompany_id();
	   		 Map tokenMap = AccessToken.getAccessTokenMap(appid, secret);
	   		 String access_token = tokenMap.get("access_token").toString();
	   		 int ex_time = 7200;
	   		 Access_token a = new Access_token();
	   		 a.setAccess_token(access_token);
	   		 a.setCompany_id(company_id);
	   		 a.setExpir_time(ex_time);
	         sqlSession.update("cn.zx.dao.TokenMapper.updateToken",a);
	         System.out.println("成功"+sqlSession);
	         sqlSession.commit();
	        }
	         sqlSession.close();
		
}

	
	//插入模板id 
	public void addTmpl (int company_id,String template_id ){
		String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        Tmpl tmpl = new Tmpl();
        tmpl.setCompany_id(company_id);
        tmpl.setTemplate_id(template_id);

        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
            sqlSession.insert("cn.zx.dao.TokenMapper.addTmpl", tmpl);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
	}
	
	
	//修改网站
	public Url updateUrl(int company_id ,String uRL){
		 String resource = "mybatis-config.xml";
	        SqlSession sqlSession = null;
	        Url url = new Url();
	        url.setCompany_id(company_id);
	        url.setURL(uRL);
	        try {
	            InputStream is = Resources.getResourceAsStream(resource);
	            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	            sqlSession = factory.openSession();
	            sqlSession.update("cn.zx.dao.TokenMapper.updateUrl", url);
	            sqlSession.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            sqlSession.rollback();
	        } finally {
	            sqlSession.close();
	        }
			return url;
	}
	
	
}
