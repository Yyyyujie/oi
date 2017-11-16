package cn.zx.message;

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

import cn.zx.pojo.Access_token;
import cn.zx.pojo.Open;
import cn.zx.pojo.Tmpl;
import cn.zx.pojo.Url;
import cn.zx.templateMessage.TemplateMessageData;
import cn.zx.templateMessage.TemplateReqData;
import cn.zx.util.HttpServer;

import com.alibaba.fastjson.JSON;

public class SendMessage {
	   private static final String TPL_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send"; 

	public static Map sendTpl(String openid, String tpl_id, String url, Map<String, TemplateMessageData> tplData,int company_id)  {
		TemplateReqData tpl = new TemplateReqData();
		tpl.setTouser(openid);
		tpl.setTemplate_id(tpl_id);
		tpl.setUrl(url);
		tpl.setData(tplData);
		return sendTpl(tpl,company_id);
	}
	
	public static Map sendTpl(TemplateReqData tpl,int company_id) {
		//access_token 是动态刷新的
		 String resource = "mybatis-config.xml";
		   SqlSession sqlSession = null;
		   String token = "";
		   List<Access_token> tokenlist = new ArrayList<Access_token>();
		try {
			InputStream is = Resources.getResourceAsStream(resource);
	           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	           sqlSession = factory.openSession();
	           tokenlist = sqlSession.selectList("cn.zx.dao.TokenMapper.getToken",company_id); 
	           token = tokenlist.get(0).getAccess_token();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
          sqlSession.close();
      }						
        String sendTplUrl = TPL_SEND_URL + "?access_token=" +  token;
        String resJsonStringData = HttpServer.doPost(sendTplUrl,
                JSON.parseObject(JSON.toJSONString(tpl), HashMap.class));
        return JSON.parseObject(resJsonStringData, HashMap.class);
    }
	//单openid
	public static void send(String open_id,String tpl_id,int company_id,Map<String, TemplateMessageData> dateMap,String url){
		 	
		Map tempMap = SendMessage.sendTpl(open_id, tpl_id, 
				url, dateMap,company_id);//3是公司id
		System.out.println(tempMap);
	}
	
	//openid
	public static String  findopenid(int user_id){
		String resource = "mybatis-config.xml";
		   SqlSession sqlSession = null;
		   String open_id ="";
		   List<Open> openlist = new ArrayList<Open>();
		try {
			InputStream is = Resources.getResourceAsStream(resource);
	           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	           sqlSession = factory.openSession();
	           openlist = sqlSession.selectList("cn.zx.dao.TokenMapper.selesctopen",user_id); 
	           open_id = openlist.get(0).getOpen_id();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
      sqlSession.close();
  }	
		
		return open_id;
		
	}
	
	
	//模版Id
	public static String  findtmpl(int tmpl_id){
		String resource = "mybatis-config.xml";
		   SqlSession sqlSession = null;
		   String tpl_id ="";
		   List<Tmpl> tmpllist = new ArrayList<Tmpl>();
		try {
			InputStream is = Resources.getResourceAsStream(resource);
	           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	           sqlSession = factory.openSession();
	           tmpllist = sqlSession.selectList("cn.zx.dao.TokenMapper.selectTmpl",tmpl_id); 
	           tpl_id =tmpllist.get(0).getTemplate_id();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
   sqlSession.close();
}	
		System.out.println("模板id"+tpl_id);
		return tpl_id;
		
	}
	
	/*
	//修改keyword
	public static void updatekeyword(int tmpl_id,String first,String keyword1,
			String keyword2,String keyword3,String keyword4,
			String keyword5,String remark){
		 String resource = "mybatis-config.xml";
	        SqlSession sqlSession = null;
	        Tmpl tmpl = new Tmpl();
	        tmpl.setTmpl_id(tmpl_id);
	        tmpl.setFirstdata(first);
	        tmpl.setKeyword1(keyword1);
	        tmpl.setKeyword2(keyword2);
	        tmpl.setKeyword3(keyword3);
	        tmpl.setKeyword4(keyword4);
	        tmpl.setKeyword5(keyword5);
	        tmpl.setRemark(remark);
	        
	        try {
	            InputStream is = Resources.getResourceAsStream(resource);
	            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	            sqlSession = factory.openSession();
	            sqlSession.update("com.wechat.dao.TokenMapper.updatekeyword", tmpl);
	            System.out.println("123");
	            sqlSession.commit();
	            System.out.println("commit");
	        } catch (Exception e) {
	            e.printStackTrace();
	            sqlSession.rollback();
	        } finally {
	            sqlSession.close();
	        }
	        
	}
	*/
	//c查询keyword
	
	public static List<Tmpl>  findkeyword(int tmpl_id){
		String resource = "mybatis-config.xml";
		   SqlSession sqlSession = null;
		   List<Tmpl> tmpllist = new ArrayList<Tmpl>();
		try {
			InputStream is = Resources.getResourceAsStream(resource);
	           SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	           sqlSession = factory.openSession();
	           tmpllist = sqlSession.selectList("cn.zx.dao.TokenMapper.selectkeyword",tmpl_id); 
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
   sqlSession.close();
}	
		return tmpllist;
	}
	
	//查询Url
	 public String findUrl(int company_id) {
	        String resource = "mybatis-config.xml";
	        SqlSession sqlSession = null;
	        List<Url> urlList = new  ArrayList<Url>();
	        String url="";
	        try {
	            InputStream is = Resources.getResourceAsStream(resource);
	            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
	            sqlSession = factory.openSession();
	            urlList = sqlSession.selectList("cn.zx.dao.TokenMapper.selectUrl",company_id);
	             url=urlList.get(0).getURL();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            sqlSession.close();
	        }
			return url;
	 }
}
