package cn.zx.pojo;

public class CompanyRole {
    private Integer user_id;

    private Integer admin_id;

    private String title;

    private Integer status;

    private String rules;
    
    private Integer company_id;

    
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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
    }

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	@Override
	public String toString() {
		return "CompanyRole [user_id=" + user_id + ", admin_id=" + admin_id
				+ ", title=" + title + ", status=" + status + ", rules="
				+ rules + ", company_id=" + company_id + "]";
	}
    
}