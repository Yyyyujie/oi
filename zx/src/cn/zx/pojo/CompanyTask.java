package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CompanyTask {
    private Integer task_id;

    private Integer company_id;

    private String task_title;

    private Integer to_user;

    private Integer user_id;

    private Integer task_obj;
    @DateTimeFormat( pattern="yyyy-MM-dd")
	@JSONField(format ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date task_create_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
	@JSONField(format ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date task_accept_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
	@JSONField(format ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date task_start_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
	@JSONField(format ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date task_end_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
	@JSONField(format ="yyyy-MM-dd")	
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date task_complete_time;

    private Integer task_progress;

    private Integer task_urgent;

    private Integer task_important;

    private String task_content;

    private Integer task_status;

    private String task_del_reasion;

    private String task_reback_reasion;

    private Byte is_remark;

    private Byte is_forward;

    private Integer is_delay;

    private Integer is_cui;

    private Integer task_quality;

    private Integer task_efficiency;

    private Integer task_communion_rec;

    private Integer task_communion_pub;

    private Integer task_study;

    private Integer task_innovate;

    private Integer task_leader;

    private String task_evaluate;
    
    private Integer ranking;
    private String releasename;
    private String receivename;
    private String realname;
    private String toName;//接收人
    private String userName;//发送人
    private Integer count;//数量
    private Integer month;//月份
    private String name;//员工姓名
    private String task_type;//任务类型
    
    @Override
	public String toString() {
		return "CompanyTask [task_id=" + task_id + ", company_id=" + company_id + ", task_title=" + task_title
				+ ", to_user=" + to_user + ", user_id=" + user_id + ", task_obj=" + task_obj + ", task_create_time="
				+ task_create_time + ", task_accept_time=" + task_accept_time + ", task_start_time=" + task_start_time
				+ ", task_end_time=" + task_end_time + ", task_complete_time=" + task_complete_time + ", task_progress="
				+ task_progress + ", task_urgent=" + task_urgent + ", task_important=" + task_important
				+ ", task_content=" + task_content + ", task_status=" + task_status + ", task_del_reasion="
				+ task_del_reasion + ", task_reback_reasion=" + task_reback_reasion + ", is_remark=" + is_remark
				+ ", is_forward=" + is_forward + ", is_delay=" + is_delay + ", is_cui=" + is_cui + ", task_quality="
				+ task_quality + ", task_efficiency=" + task_efficiency + ", task_communion_rec=" + task_communion_rec
				+ ", task_communion_pub=" + task_communion_pub + ", task_study=" + task_study + ", task_innovate="
				+ task_innovate + ", task_leader=" + task_leader + ", task_evaluate=" + task_evaluate + ", ranking="
				+ ranking + ", releasename=" + releasename + ", receivename=" + receivename + ", realname=" + realname
				+ ", toName=" + toName + ", userName=" + userName + ", count=" + count + ", month=" + month + ", name="
				+ name + ", task_type=" + task_type + "]";
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public String getReleasename() {
		return releasename;
	}

	public void setReleasename(String releasename) {
		this.releasename = releasename;
	}

	public String getReceivename() {
		return receivename;
	}

	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTask_type() {
		return task_type;
	}

	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}

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

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title == null ? null : task_title.trim();
    }

    public Integer getTo_user() {
        return to_user;
    }

    public void setTo_user(Integer to_user) {
        this.to_user = to_user;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTask_obj() {
        return task_obj;
    }

    public void setTask_obj(Integer task_obj) {
        this.task_obj = task_obj;
    }

    public Date getTask_create_time() {
        return task_create_time;
    }

    public void setTask_create_time(Date task_create_time) {
        this.task_create_time = task_create_time;
    }

    public Date getTask_accept_time() {
        return task_accept_time;
    }

    public void setTask_accept_time(Date task_accept_time) {
        this.task_accept_time = task_accept_time;
    }

    public Date getTask_start_time() {
        return task_start_time;
    }

    public void setTask_start_time(Date task_start_time) {
        this.task_start_time = task_start_time;
    }

    public Date getTask_end_time() {
        return task_end_time;
    }

    public void setTask_end_time(Date task_end_time) {
        this.task_end_time = task_end_time;
    }

    public Date getTask_complete_time() {
        return task_complete_time;
    }

    public void setTask_complete_time(Date task_complete_time) {
        this.task_complete_time = task_complete_time;
    }

    public Integer getTask_progress() {
        return task_progress;
    }

    public void setTask_progress(Integer task_progress) {
        this.task_progress = task_progress;
    }

    public Integer getTask_urgent() {
        return task_urgent;
    }

    public void setTask_urgent(Integer task_urgent) {
        this.task_urgent = task_urgent;
    }

    public Integer getTask_important() {
        return task_important;
    }

    public void setTask_important(Integer task_important) {
        this.task_important = task_important;
    }

    public String getTask_content() {
        return task_content;
    }

    public void setTask_content(String task_content) {
        this.task_content = task_content == null ? null : task_content.trim();
    }

    public Integer getTask_status() {
        return task_status;
    }

    public void setTask_status(Integer task_status) {
        this.task_status = task_status;
    }

    public String getTask_del_reasion() {
        return task_del_reasion;
    }

    public void setTask_del_reasion(String task_del_reasion) {
        this.task_del_reasion = task_del_reasion == null ? null : task_del_reasion.trim();
    }

    public String getTask_reback_reasion() {
        return task_reback_reasion;
    }

    public void setTask_reback_reasion(String task_reback_reasion) {
        this.task_reback_reasion = task_reback_reasion == null ? null : task_reback_reasion.trim();
    }

    public Byte getIs_remark() {
        return is_remark;
    }

    public void setIs_remark(Byte is_remark) {
        this.is_remark = is_remark;
    }

    public Byte getIs_forward() {
        return is_forward;
    }

    public void setIs_forward(Byte is_forward) {
        this.is_forward = is_forward;
    }

    public Integer getIs_delay() {
        return is_delay;
    }

    public void setIs_delay(Integer is_delay) {
        this.is_delay = is_delay;
    }

    public Integer getIs_cui() {
        return is_cui;
    }

    public void setIs_cui(Integer is_cui) {
        this.is_cui = is_cui;
    }

    public Integer getTask_quality() {
        return task_quality;
    }

    public void setTask_quality(Integer task_quality) {
        this.task_quality = task_quality;
    }

    public Integer getTask_efficiency() {
        return task_efficiency;
    }

    public void setTask_efficiency(Integer task_efficiency) {
        this.task_efficiency = task_efficiency;
    }

    public Integer getTask_communion_rec() {
        return task_communion_rec;
    }

    public void setTask_communion_rec(Integer task_communion_rec) {
        this.task_communion_rec = task_communion_rec;
    }

    public Integer getTask_communion_pub() {
        return task_communion_pub;
    }

    public void setTask_communion_pub(Integer task_communion_pub) {
        this.task_communion_pub = task_communion_pub;
    }

    public Integer getTask_study() {
        return task_study;
    }

    public void setTask_study(Integer task_study) {
        this.task_study = task_study;
    }

    public Integer getTask_innovate() {
        return task_innovate;
    }

    public void setTask_innovate(Integer task_innovate) {
        this.task_innovate = task_innovate;
    }

    public Integer getTask_leader() {
        return task_leader;
    }

    public void setTask_leader(Integer task_leader) {
        this.task_leader = task_leader;
    }

    public String getTask_evaluate() {
        return task_evaluate;
    }

    public void setTask_evaluate(String task_evaluate) {
        this.task_evaluate = task_evaluate == null ? null : task_evaluate.trim();
    }
}