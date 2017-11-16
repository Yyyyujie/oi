package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class CompanyTaskRemark {
    private Integer task_id;

    private Integer company_id;

    private Integer user_id;

    private Integer task_ratio;

    private Integer task_quality;

    private String task_remark;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date create_time;

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
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

    public Integer getTask_ratio() {
        return task_ratio;
    }

    public void setTask_ratio(Integer task_ratio) {
        this.task_ratio = task_ratio;
    }

    public Integer getTask_quality() {
        return task_quality;
    }

    public void setTask_quality(Integer task_quality) {
        this.task_quality = task_quality;
    }

    public String getTask_remark() {
        return task_remark;
    }

    public void setTask_remark(String task_remark) {
        this.task_remark = task_remark == null ? null : task_remark.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

	@Override
	public String toString() {
		return "CompanyTaskRemark [task_id=" + task_id + ", company_id="
				+ company_id + ", user_id=" + user_id + ", task_ratio="
				+ task_ratio + ", task_quality=" + task_quality
				+ ", task_remark=" + task_remark + ", create_time="
				+ create_time + "]";
	}
    
}