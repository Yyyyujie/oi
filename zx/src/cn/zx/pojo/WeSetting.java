package cn.zx.pojo;

public class WeSetting {

	private int set_id;
	private int company_id;
	private String appid;
	private String appsecret;
	private String token;
	private String site;
	private int tixi;
	private String password;
	private String sortname;
	public int getSet_id() {
		return set_id;
	}
	public void setSet_id(int set_id) {
		this.set_id = set_id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getTixi() {
		return tixi;
	}
	public void setTixi(int tixi) {
		this.tixi = tixi;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	@Override
	public String toString() {
		return "WeSetting [set_id=" + set_id + ", company_id=" + company_id + ", appid=" + appid + ", appsecret="
				+ appsecret + ", token=" + token + ", site=" + site + ", tixi=" + tixi + ", password=" + password
				+ ", sortname=" + sortname + "]";
	}
	
	
}
