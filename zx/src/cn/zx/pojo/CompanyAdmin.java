package cn.zx.pojo;

import java.util.Date;


public class CompanyAdmin {
    @Override
	public String toString() {
		return "CompanyAdmin [admin_id=" + admin_id + ", username=" + username
				+ ", password=" + password + ", role=" + role + ", company_id="
				+ company_id + ", email=" + email + ", phone=" + phone
				+ ", create_time=" + create_time + ", create_ip=" + create_ip
				+ ", last_time=" + last_time + ", last_ip=" + last_ip
				+ ", random=" + random + "]";
	}

	private Integer admin_id;

    private String username;

    private String password;

    private Integer role;
    
    private Integer company_id;

    private String email;

    private String phone;

    private Date create_time;

    private String create_ip;

    private Date last_time;

    private String last_ip;
    
    private String random;

    
    
    
    public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public Integer getAdmin_id() {
        return admin_id;
    }

    public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
}