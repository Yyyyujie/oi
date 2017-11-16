package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class StaffTaskLog {
    private Integer s_t_id;

    private Integer company_id;

    private Integer task_id;

    private Integer task_progress;

    private String nod_desc;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date sub_time;

    public Integer getS_t_id() {
        return s_t_id;
    }

    public void setS_t_id(Integer s_t_id) {
        this.s_t_id = s_t_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Integer getTask_progress() {
        return task_progress;
    }

    public void setTask_progress(Integer task_progress) {
        this.task_progress = task_progress;
    }

    public String getNod_desc() {
        return nod_desc;
    }

    public void setNod_desc(String nod_desc) {
        this.nod_desc = nod_desc == null ? null : nod_desc.trim();
    }

    public Date getSub_time() {
        return sub_time;
    }

    public void setSub_time(Date sub_time) {
        this.sub_time = sub_time;
    }
}