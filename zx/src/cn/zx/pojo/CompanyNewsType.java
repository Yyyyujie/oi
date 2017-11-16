package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CompanyNewsType {
    private Integer news_type_id;

    private String news_type;

    private String news_type_remarks;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")	
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date create_time;

    private Integer status;

    private String news_logo;

    public Integer getNews_type_id() {
        return news_type_id;
    }

    public void setNews_type_id(Integer news_type_id) {
        this.news_type_id = news_type_id;
    }

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type == null ? null : news_type.trim();
    }

    public String getNews_type_remarks() {
        return news_type_remarks;
    }

    public void setNews_type_remarks(String news_type_remarks) {
        this.news_type_remarks = news_type_remarks == null ? null : news_type_remarks.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNews_logo() {
        return news_logo;
    }

    public void setNews_logo(String news_logo) {
        this.news_logo = news_logo == null ? null : news_logo.trim();
    }
}