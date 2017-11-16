package cn.zx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.util.SignUtil;

public class WeChatServlet extends HttpServlet {

	private static final long serialVersionUID = 7204395413984843787L;

	/* 无参构造器 */
	public WeChatServlet() {
		super();
	}

	/* 微信服务器将发送 GET 对接服务器请求到此处 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		// 微信加密签名
		String signature = request.getParameter("signature");

		// 时间戳
		String timestamp = request.getParameter("timestamp");

		// 随机数
		String nonce = request.getParameter("nonce");

		// 随机字符串
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();

		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示对接成功，否则对接失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) 
			out.print(echostr);

		out.close();
		out = null;

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String echo = request.getParameter("echostr");
		echo = new String(echo.getBytes("ISO-8859-1"), "UTF-8");
		pw.println(echo);

	}

//	/* 微信服务器将会发送用户的 POST 信息到此处 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		// 微信给平台发送信息时会到这里
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//
//		String wxMsgXml = IOUtils.toString(request.getInputStream(), "utf-8");
//		RequestTextMessage textMsg = null;
//
//		try {
//			textMsg = getRequestTextMessage(wxMsgXml);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		/* 获取用户发送的消息 */
//		StringBuffer replyMsg = new StringBuffer();
//		String receive = textMsg.getContent().trim();
//		String returnXml = null;
//
//		if (textMsg != null && !receive.equals("")) {
//			
//			/* 做出对应的处理 */
//			if (receive.equals("summer") || receive.equals("爱summer")) {
//
//				replyMsg.append("你好~ 这里是绫濑小公举哟~ ");
//				replyMsg.append("\r\n0、HelloWord");
//				replyMsg.append("\r\n1、这是一双眼睛");
//				replyMsg.append("\r\n2、这是一枚模版");
//				replyMsg.append("\r\n3、这是一只颜狗");
//				replyMsg.append("\r\n其他、回音壁请直接输入文字信息");
//
//				returnXml = getReplyTextMessage(replyMsg.toString(),textMsg.getFromUserName(), textMsg.getToUserName());
//
//			} 
//			else if (receive.equals("0")) {
//				replyMsg.append(" 终于完成了不容易啊！~");
//				returnXml = getReplyTextMessage(replyMsg.toString(),textMsg.getFromUserName(), textMsg.getToUserName()); // 回复纯文本
//			} 
//			else if (receive.equals("1")) {
//				returnXml = getReplyTuwenMessage2(textMsg.getFromUserName(),textMsg.getToUserName());// 回复图文
//			}
//			else if (receive.equals("2")) {
//				returnXml = getReplyTuwenMessage(textMsg.getFromUserName(),textMsg.getToUserName());// 回复图文
//			}
//			else if (receive.equals("3")) {
//				returnXml = getReplyTuwenMessage3(textMsg.getFromUserName(),textMsg.getToUserName());	// 回复图文
//			} 
//			else {
//				replyMsg.append("您好，我们已经收到您发送的内容 “" + textMsg.getContent()+ "” ，请您耐心等待，您可回复“summer”或者“爱summer”查看菜单哦");
//				returnXml = getReplyTextMessage(replyMsg.toString(),textMsg.getFromUserName(), textMsg.getToUserName());
//			}
//		} 
//		else {
//			replyMsg.append("你说了什么？");
//			returnXml = getReplyTextMessage(replyMsg.toString(),textMsg.getFromUserName(), textMsg.getToUserName());
//		}
//
//		pw.println(returnXml);
//
//	}
//
//	// 获取推送文本消息
//	private RequestTextMessage getRequestTextMessage(String xml) {
//
//		XStream xstream = new XStream(new DomDriver());
//
//		xstream.alias("xml", RequestTextMessage.class);
//		xstream.aliasField("ToUserName", RequestTextMessage.class, "toUserName");
//		xstream.aliasField("FromUserName", RequestTextMessage.class,"fromUserName");
//		xstream.aliasField("CreateTime", RequestTextMessage.class, "createTime");
//		xstream.aliasField("MsgType", RequestTextMessage.class, "messageType");
//		xstream.aliasField("Content", RequestTextMessage.class, "content");
//		xstream.aliasField("MsgId", RequestTextMessage.class, "msgId");
//
//		RequestTextMessage requestTextMessage = (RequestTextMessage) xstream
//				.fromXML(xml);
//		return requestTextMessage;
//
//	}
//
//	// 回复文本消息
//	private String getReplyTextMessage(String content, String fromUserName,String toUserName) {
//
//		ReplyTextMessage we = new ReplyTextMessage();
//		we.setMessageType("text");
//		we.setFuncFlag("0");
//		we.setCreateTime(new Long(new Date().getTime()).toString());
//		we.setContent(content);
//		we.setToUserName(fromUserName);
//		we.setFromUserName(toUserName);
//		XStream xstream = new XStream(new DomDriver());
//		xstream.alias("xml", ReplyTextMessage.class);
//		xstream.aliasField("ToUserName", ReplyTextMessage.class, "toUserName");
//		xstream.aliasField("FromUserName", ReplyTextMessage.class,"fromUserName");
//		xstream.aliasField("CreateTime", ReplyTextMessage.class, "createTime");
//		xstream.aliasField("MsgType", ReplyTextMessage.class, "messageType");
//		xstream.aliasField("Content", ReplyTextMessage.class, "content");
//		xstream.aliasField("FuncFlag", ReplyTextMessage.class, "funcFlag");
//		String xml = xstream.toXML(we);
//		return xml;
//
//	}
//
//	/**
//	 * 回复图文消息
//	 */
//	private String getReplyTuwenMessage2(String fromUserName, String toUserName) {
//
//		ReplyTuwenMessage we = new ReplyTuwenMessage();
//		Articles articles = new Articles();
//		Item item = new Item();
//
//		we.setMessageType("news");
//		we.setCreateTime(new Long(new Date().getTime()).toString());
//		we.setToUserName(fromUserName);
//		we.setFromUserName(toUserName);
//		we.setFuncFlag("0");
//		we.setArticleCount(1);
//		
//		item.setTitle("爱summer 爱生活"); // 标题
//		item.setDescription("summer 的 眼睛 "); // 描述
//		item.setPicUrl("http://1.wechatne.applinzi.com/img/IMG_9103.JPG"); // 显示图片
//		item.setUrl("http://1.wechatne.applinzi.com/img/IMG_9103.JPG"); // 点进去查看的地址链接
//		articles.setItem(item);
//		we.setArticles(articles);
//		
//		XStream xstream = new XStream(new DomDriver());
//		xstream.alias("xml", ReplyTuwenMessage.class);
//		xstream.aliasField("ToUserName", ReplyTuwenMessage.class, "toUserName");
//		xstream.aliasField("FromUserName", ReplyTuwenMessage.class,"fromUserName");
//		xstream.aliasField("CreateTime", ReplyTuwenMessage.class, "createTime");
//		xstream.aliasField("MsgType", ReplyTuwenMessage.class, "messageType");
//		xstream.aliasField("Articles", ReplyTuwenMessage.class, "Articles");
//		xstream.aliasField("ArticleCount", ReplyTuwenMessage.class,"articleCount");
//		xstream.aliasField("FuncFlag", ReplyTuwenMessage.class, "funcFlag");
//		xstream.aliasField("item", Articles.class, "item");
//		xstream.aliasField("Title", Item.class, "title");
//		xstream.aliasField("Description", Item.class, "description");
//		xstream.aliasField("PicUrl", Item.class, "picUrl");
//		xstream.aliasField("Url", Item.class, "url");
//		String xml = xstream.toXML(we);
//		return xml;
//	}
//
//	// 回复图文消息
//	private String getReplyTuwenMessage(String fromUserName, String toUserName) {
//
//		ReplyTuwenMessage we = new ReplyTuwenMessage();
//		Articles articles = new Articles();
//		Item item = new Item();
//
//		we.setMessageType("news");
//		we.setCreateTime(new Long(new Date().getTime()).toString());
//		we.setToUserName(fromUserName);
//		we.setFromUserName(toUserName);
//		we.setFuncFlag("0");
//		we.setArticleCount(1);
//		item.setTitle("爱summer 爱生活");
//		item.setDescription("summer 的身体");
//		item.setPicUrl("http://1.wechatne.applinzi.com/img/IMG_9141.JPG");
//		item.setUrl("http://1.wechatne.applinzi.com/img/IMG_9141.JPG");
//		articles.setItem(item);
//		we.setArticles(articles);
//		XStream xstream = new XStream(new DomDriver());
//		xstream.alias("xml", ReplyTuwenMessage.class);
//		xstream.aliasField("ToUserName", ReplyTuwenMessage.class, "toUserName");
//		xstream.aliasField("FromUserName", ReplyTuwenMessage.class,"fromUserName");
//		xstream.aliasField("CreateTime", ReplyTuwenMessage.class, "createTime");
//		xstream.aliasField("MsgType", ReplyTuwenMessage.class, "messageType");
//		xstream.aliasField("Articles", ReplyTuwenMessage.class, "Articles");
//		xstream.aliasField("ArticleCount", ReplyTuwenMessage.class,"articleCount");
//		xstream.aliasField("FuncFlag", ReplyTuwenMessage.class, "funcFlag");
//		xstream.aliasField("item", Articles.class, "item");
//		xstream.aliasField("Title", Item.class, "title");
//		xstream.aliasField("Description", Item.class, "description");
//		xstream.aliasField("PicUrl", Item.class, "picUrl");
//		xstream.aliasField("Url", Item.class, "url");
//
//		String xml = xstream.toXML(we);
//		return xml;
//	}
//
//	// 回复图文消息
//	private String getReplyTuwenMessage3(String fromUserName, String toUserName) {
//
//		ReplyTuwenMessage we = new ReplyTuwenMessage();
//		Articles articles = new Articles();
//		Item item = new Item();
//
//		we.setMessageType("news");
//		we.setCreateTime(new Long(new Date().getTime()).toString());
//		we.setToUserName(fromUserName);
//		we.setFromUserName(toUserName);
//		we.setFuncFlag("0");
//		we.setArticleCount(1);
//		item.setTitle("爱summer 爱生活");
//		item.setDescription("summer の 颜");
//		item.setPicUrl("http://1.wechatne.applinzi.com/img/IMG_9212.PNG");
//		item.setUrl("http://1.wechatne.applinzi.com/img/IMG_9212.PNG");
//		articles.setItem(item);
//		we.setArticles(articles);
//		XStream xstream = new XStream(new DomDriver());
//		xstream.alias("xml", ReplyTuwenMessage.class);
//		xstream.aliasField("ToUserName", ReplyTuwenMessage.class, "toUserName");
//		xstream.aliasField("FromUserName", ReplyTuwenMessage.class,"fromUserName");
//		xstream.aliasField("CreateTime", ReplyTuwenMessage.class, "createTime");
//		xstream.aliasField("MsgType", ReplyTuwenMessage.class, "messageType");
//		xstream.aliasField("Articles", ReplyTuwenMessage.class, "Articles");
//		xstream.aliasField("ArticleCount", ReplyTuwenMessage.class,"articleCount");
//		xstream.aliasField("FuncFlag", ReplyTuwenMessage.class, "funcFlag");
//		xstream.aliasField("item", Articles.class, "item");
//		xstream.aliasField("Title", Item.class, "title");
//		xstream.aliasField("Description", Item.class, "description");
//		xstream.aliasField("PicUrl", Item.class, "picUrl");
//		xstream.aliasField("Url", Item.class, "url");
//
//		String xml = xstream.toXML(we);
//		return xml;
//	}

	/* 初始化 */
	public void init() throws ServletException {
	}

	/* 释放资源 */
	public void destroy() {
		super.destroy();
	}

}
