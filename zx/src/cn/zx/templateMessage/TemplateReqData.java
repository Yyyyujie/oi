package cn.zx.templateMessage;

import java.util.Map;

/**
 * Created by zeject on 2017/4/12.
 */
public class TemplateReqData {

    // openid
    private String touser;
    // template_id
    private String template_id;
    // 模板跳转url
    private String url;
    //小程序使用
    //private Map<String, String> miniprogram;

    // 模板数据data
    private Map<String, TemplateMessageData> data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public Map<String, TemplateMessageData> getData() {
        return data;
    }

    public void setData(Map<String, TemplateMessageData> data) {
        this.data = data;
    }
}
