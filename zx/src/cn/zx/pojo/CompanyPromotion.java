package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CompanyPromotion {
    private Integer promotion_id;

    private Integer company_id;

    private Integer user_id;

    private Integer current_post_level;

    private Integer next_post_level;

    private Integer last_post_level;

    private Integer sum;

    private Integer agree;

    private Integer oppose;

    @DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format ="yyyy-MM-dd")
    private Date create_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")	
    private Date end_time;

    private Integer status;

    private String realname;
    private String level_name;
    private String face;
    private String header;
    
    
    public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getLevel_name() {
		return level_name;
	}

	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

	public Integer getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Integer promotion_id) {
        this.promotion_id = promotion_id;
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

    public Integer getCurrent_post_level() {
        return current_post_level;
    }

    public void setCurrent_post_level(Integer current_post_level) {
        this.current_post_level = current_post_level;
    }

    public Integer getNext_post_level() {
        return next_post_level;
    }

    public void setNext_post_level(Integer next_post_level) {
        this.next_post_level = next_post_level;
    }

    public Integer getLast_post_level() {
        return last_post_level;
    }

    public void setLast_post_level(Integer last_post_level) {
        this.last_post_level = last_post_level;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    public Integer getOppose() {
        return oppose;
    }

    public void setOppose(Integer oppose) {
        this.oppose = oppose;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "CompanyPromotion [promotion_id=" + promotion_id
				+ ", company_id=" + company_id + ", user_id=" + user_id
				+ ", current_post_level=" + current_post_level
				+ ", next_post_level=" + next_post_level + ", last_post_level="
				+ last_post_level + ", sum=" + sum + ", agree=" + agree
				+ ", oppose=" + oppose + ", create_time=" + create_time
				+ ", end_time=" + end_time + ", status=" + status
				+ ", realname=" + realname + ", level_name=" + level_name
				+ ", face=" + face + ", header=" + header + "]";
	}
    
}