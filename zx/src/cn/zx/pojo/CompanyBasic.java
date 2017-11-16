package cn.zx.pojo;

public class CompanyBasic {
    private Integer b_id;

    private String company_name;

    private String URL;

    private String slogan;

    private Integer period;

    private Integer standard;

    private Integer days;

    private Integer panel_point;

    private String password;
    
    private Integer company_id;

    
    public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name == null ? null : company_name.trim();
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL == null ? null : URL.trim();
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan == null ? null : slogan.trim();
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getPanel_point() {
        return panel_point;
    }

    public void setPanel_point(Integer panel_point) {
        this.panel_point = panel_point;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	@Override
	public String toString() {
		return "CompanyBasic [b_id=" + b_id + ", company_name=" + company_name
				+ ", URL=" + URL + ", slogan=" + slogan + ", period=" + period
				+ ", standard=" + standard + ", days=" + days
				+ ", panel_point=" + panel_point + ", password=" + password
				+ ", company_id=" + company_id + "]";
	}
    
}