package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class WechatTmpl {
    private Integer tmpl_id;

    private Integer company_id;

    private String type;

    private String title;

    private String serial;

    private String template_id;

    private String firstdata;

    private String keyword1;

    private String keyword2;

    private String keyword3;

    private String keyword4;

    private String keyword5;

    private String remark;

    private Integer o;

    private Integer status;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date create_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date update_time;
    
    private String SERIAL;

    public String getSERIAL() {
		return SERIAL;
	}

	public void setSERIAL(String sERIAL) {
		SERIAL = sERIAL;
	}

	public Integer getTmpl_id() {
        return tmpl_id;
    }

    public void setTmpl_id(Integer tmpl_id) {
        this.tmpl_id = tmpl_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id == null ? null : template_id.trim();
    }

    public String getFirstdata() {
        return firstdata;
    }

    public void setFirstdata(String firstdata) {
        this.firstdata = firstdata == null ? null : firstdata.trim();
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1 == null ? null : keyword1.trim();
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2 == null ? null : keyword2.trim();
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3 == null ? null : keyword3.trim();
    }

    public String getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(String keyword4) {
        this.keyword4 = keyword4 == null ? null : keyword4.trim();
    }

    public String getKeyword5() {
        return keyword5;
    }

    public void setKeyword5(String keyword5) {
        this.keyword5 = keyword5 == null ? null : keyword5.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getO() {
        return o;
    }

    public void setO(Integer o) {
        this.o = o;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}