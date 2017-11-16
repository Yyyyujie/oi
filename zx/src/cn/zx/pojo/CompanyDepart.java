package cn.zx.pojo;

public class CompanyDepart {
    private Integer dept_id;

    private Integer company_id;

    private Integer pid;

    private String dept_name;

    private Integer status;

    private Integer com_id;

    private Integer o;

    private String pingyin;

    private Integer level;

    private Integer isdelete;

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name == null ? null : dept_name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCom_id() {
        return com_id;
    }

    public void setCom_id(Integer com_id) {
        this.com_id = com_id;
    }

    public Integer getO() {
        return o;
    }

    public void setO(Integer o) {
        this.o = o;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin == null ? null : pingyin.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

	@Override
	public String toString() {
		return "CompanyDepart [dept_id=" + dept_id + ", company_id="
				+ company_id + ", pid=" + pid + ", dept_name=" + dept_name
				+ ", status=" + status + ", com_id=" + com_id + ", o=" + o
				+ ", pingyin=" + pingyin + ", level=" + level + ", isdelete="
				+ isdelete + "]";
	}
    
}