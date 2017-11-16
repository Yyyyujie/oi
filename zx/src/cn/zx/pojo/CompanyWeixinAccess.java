package cn.zx.pojo;

public class CompanyWeixinAccess {
    private Integer acc_id;

    private Integer company_id;

    private String access_token;

    private Integer expir_time;

    public Integer getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Integer acc_id) {
        this.acc_id = acc_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token == null ? null : access_token.trim();
    }

    public Integer getExpir_time() {
        return expir_time;
    }

    public void setExpir_time(Integer expir_time) {
        this.expir_time = expir_time;
    }

	@Override
	public String toString() {
		return "CompanyWeixinAccess [acc_id=" + acc_id + ", company_id="
				+ company_id + ", access_token=" + access_token
				+ ", expir_time=" + expir_time + "]";
	}
    
}