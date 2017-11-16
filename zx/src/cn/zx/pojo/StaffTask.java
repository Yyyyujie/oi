package cn.zx.pojo;

public class StaffTask {
    private Integer s_t_id;

    private Integer use_id;

    private String task_title;

    private String use_task;

    private Integer task_status;

    private Integer task_point;

    private Integer company_id;

    public Integer getS_t_id() {
        return s_t_id;
    }

    public void setS_t_id(Integer s_t_id) {
        this.s_t_id = s_t_id;
    }

    public Integer getUse_id() {
        return use_id;
    }

    public void setUse_id(Integer use_id) {
        this.use_id = use_id;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title == null ? null : task_title.trim();
    }

    public String getUse_task() {
        return use_task;
    }

    public void setUse_task(String use_task) {
        this.use_task = use_task == null ? null : use_task.trim();
    }

    public Integer getTask_status() {
        return task_status;
    }

    public void setTask_status(Integer task_status) {
        this.task_status = task_status;
    }

    public Integer getTask_point() {
        return task_point;
    }

    public void setTask_point(Integer task_point) {
        this.task_point = task_point;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }
}