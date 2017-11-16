package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CompanyPostLevel {
    private Integer post_le_id;

    private Integer post_id;

    private Integer company_id;

    private Integer level;

    private String level_name;

    private Integer o;

    private Integer status;

    private String remark;

    private Integer isdelete;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")	
    private Date create_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")	
    private Date update_time;

    private String post_name;
    
    public String getPost_name() {
		return post_name;
	}

	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}

	public Integer getPost_le_id() {
        return post_le_id;
    }

    public void setPost_le_id(Integer post_le_id) {
        this.post_le_id = post_le_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name == null ? null : level_name.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
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

	@Override
	public String toString() {
		return "CompanyPostLevel [post_le_id=" + post_le_id + ", post_id="
				+ post_id + ", company_id=" + company_id + ", level=" + level
				+ ", level_name=" + level_name + ", o=" + o + ", status="
				+ status + ", remark=" + remark + ", isdelete=" + isdelete
				+ ", create_time=" + create_time + ", update_time="
				+ update_time + ", post_name=" + post_name + "]";
	}
    
}