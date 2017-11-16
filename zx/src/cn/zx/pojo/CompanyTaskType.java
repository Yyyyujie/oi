package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class CompanyTaskType {
    private Integer task_type_id;

    private Integer company_id;

    private String task_type;

    private String task_type_remarks;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date create_time;

    private Integer creater;

    private Integer status;

    public Integer getTask_type_id() {
        return task_type_id;
    }

    public void setTask_type_id(Integer task_type_id) {
        this.task_type_id = task_type_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type == null ? null : task_type.trim();
    }

    public String getTask_type_remarks() {
        return task_type_remarks;
    }

    public void setTask_type_remarks(String task_type_remarks) {
        this.task_type_remarks = task_type_remarks == null ? null : task_type_remarks.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}