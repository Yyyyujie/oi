package cn.zx.pojo;


public class OiType {
    private Integer type_id;

    private Integer pid;

    private String type_name;

    private Integer status;

    private Integer o;

    private Integer level;

    private Integer isdelete;
    


	@Override
	public String toString() {
		return "OiType [type_id=" + type_id + ", pid=" + pid + ", type_name=" + type_name + ", status=" + status
				+ ", o=" + o + ", level=" + level + ", isdelete=" + isdelete + "]";
	}

	public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name == null ? null : type_name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getO() {
        return o;
    }

    public void setO(Integer o) {
        this.o = o;
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
}