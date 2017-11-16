package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class OiAdmin {
    private Integer admin_id;

    private String user_name;

    private String password;

    private String head;

    private Integer role;
    
    private String role_name;

    private String email;

    private String phone;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date create_time;

    private String create_ip;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date last_time;

    private String last_ip;

    private Integer status;
    
    private String rules;

    private List<OiAuthRule> roles = new ArrayList<OiAuthRule>();

	@Override
	public String toString() {
		return "OiAdmin [admin_id=" + admin_id + ", user_name=" + user_name + ", password=" + password + ", head="
				+ head + ", role=" + role + ", role_name=" + role_name + ", email=" + email + ", phone=" + phone
				+ ", create_time=" + create_time + ", create_ip=" + create_ip + ", last_time=" + last_time
				+ ", last_ip=" + last_ip + ", status=" + status + ", rules=" + rules + ", roles=" + roles + "]";
	}


	public String getRules() {
		return rules;
	}


	public void setRules(String rules) {
		this.rules = rules;
	}


	public List<OiAuthRule> getRoles() {
		return roles;
	}


	public void setRoles(List<OiAuthRule> roles) {
		this.roles = roles;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_ip() {
        return create_ip;
    }

    public void setCreate_ip(String create_ip) {
        this.create_ip = create_ip == null ? null : create_ip.trim();
    }

    public Date getLast_time() {
        return last_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip == null ? null : last_ip.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}