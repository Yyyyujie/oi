package cn.zx.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class CompanyStaffer {

    private String sf_password;

    private Integer user_id;

    private Integer company_id;

    private String account;

    private String realname;

    private String face;

    private String ext0;

    private String nickname;

    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date reg_time;

    private Date in_time;

    private String reg_ip;

    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date last_time;

    private String last_ip;

    private Integer status;

    private String email;

    private String phone;

    private Integer post;

    private Integer depart;

    private Integer postlevel;

    private Integer audit;

    private String open_id;

    private String token;

    private String header;

    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date hire_date;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date next_promotion_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date last_promotion_time;
    
    private String post_name;
    private String level_name;
    private String dept_name;
    private String company_name;
    private Integer task_quality;
    private Integer task_efficiency;
    
	private double qualityavg;
    private double efficiencyavg;
    
    
    private String py;

    public String getPy() {
		return py;
	}
	public void setPy(String py) {
		this.py = py;
	}
	
	public String getSf_password() {
		return sf_password;
	}
	public void setSf_password(String sf_password) {
		this.sf_password = sf_password;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getExt0() {
		return ext0;
	}
	public void setExt0(String ext0) {
		this.ext0 = ext0;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getReg_time() {
		return reg_time;
	}
	public void setReg_time(Date reg_time) {
		this.reg_time = reg_time;
	}
	public Date getIn_time() {
		return in_time;
	}
	public void setIn_time(Date in_time) {
		this.in_time = in_time;
	}
	public String getReg_ip() {
		return reg_ip;
	}
	public void setReg_ip(String reg_ip) {
		this.reg_ip = reg_ip;
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
		this.last_ip = last_ip;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	public Integer getDepart() {
		return depart;
	}
	public void setDepart(Integer depart) {
		this.depart = depart;
	}
	public Integer getPostlevel() {
		return postlevel;
	}
	public void setPostlevel(Integer postlevel) {
		this.postlevel = postlevel;
	}
	public Integer getAudit() {
		return audit;
	}
	public void setAudit(Integer audit) {
		this.audit = audit;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public Date getNext_promotion_time() {
		return next_promotion_time;
	}
	public void setNext_promotion_time(Date next_promotion_time) {
		this.next_promotion_time = next_promotion_time;
	}
	public Date getLast_promotion_time() {
		return last_promotion_time;
	}
	public void setLast_promotion_time(Date last_promotion_time) {
		this.last_promotion_time = last_promotion_time;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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
	public double getQualityavg() {
		return qualityavg;
	}
	public void setQualityavg(double qualityavg) {
		this.qualityavg = qualityavg;
	}
	public double getEfficiencyavg() {
		return efficiencyavg;
	}
	public void setEfficiencyavg(double efficiencyavg) {
		this.efficiencyavg = efficiencyavg;
	}
	@Override
	public String toString() {
		return "CompanyStaffer [sf_password=" + sf_password + ", user_id="
				+ user_id + ", company_id=" + company_id + ", account="
				+ account + ", realname=" + realname + ", face=" + face
				+ ", ext0=" + ext0 + ", nickname=" + nickname + ", reg_time="
				+ reg_time + ", in_time=" + in_time + ", reg_ip=" + reg_ip
				+ ", last_time=" + last_time + ", last_ip=" + last_ip
				+ ", status=" + status + ", email=" + email + ", phone="
				+ phone + ", post=" + post + ", depart=" + depart
				+ ", postlevel=" + postlevel + ", audit=" + audit
				+ ", open_id=" + open_id + ", token=" + token + ", header="
				+ header + ", hire_date=" + hire_date
				+ ", next_promotion_time=" + next_promotion_time
				+ ", last_promotion_time=" + last_promotion_time
				+ ", post_name=" + post_name + ", level_name=" + level_name
				+ ", dept_name=" + dept_name + ", company_name=" + company_name
				+ ", task_quality=" + task_quality + ", task_efficiency="
				+ task_efficiency + ", qualityavg=" + qualityavg
				+ ", efficiencyavg=" + efficiencyavg + ", py=" + py + "]";
	}
    
}