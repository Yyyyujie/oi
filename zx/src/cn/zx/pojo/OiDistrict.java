package cn.zx.pojo;


public class OiDistrict {
    private Integer district_id;

    private Integer pid;

    private String district;

    private Integer level;

    private Integer status;
    

	@Override
	public String toString() {
		return "OiDistrict [district_id=" + district_id + ", pid=" + pid + ", district=" + district + ", level=" + level
				+ ", status=" + status + "]";
	}

	public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}