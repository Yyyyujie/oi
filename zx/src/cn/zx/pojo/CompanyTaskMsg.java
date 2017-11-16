package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class CompanyTaskMsg {
    private Integer message_id;

    private Integer company_id;

    private Integer user_id;

    private Integer to_user;

    private String title;

    private String content;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date create_time;

    private Integer is_read;

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTo_user() {
        return to_user;
    }

    public void setTo_user(Integer to_user) {
        this.to_user = to_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getIs_read() {
        return is_read;
    }

    public void setIs_read(Integer is_read) {
        this.is_read = is_read;
    }

	@Override
	public String toString() {
		return "CompanyTaskMsg [message_id=" + message_id + ", company_id="
				+ company_id + ", user_id=" + user_id + ", to_user=" + to_user
				+ ", title=" + title + ", content=" + content
				+ ", create_time=" + create_time + ", is_read=" + is_read + "]";
	}
    
}