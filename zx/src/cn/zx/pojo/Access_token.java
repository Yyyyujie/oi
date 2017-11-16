package cn.zx.pojo;


public class Access_token {
  private int company_id;
  private String access_token;
  private int expir_time;
public int getCompany_id() {
	return company_id;
}
public void setCompany_id(int company_id) {
	this.company_id = company_id;
}
public String getAccess_token() {
	return access_token;
}
public void setAccess_token(String access_token) {
	this.access_token = access_token;
}
public int getExpir_time() {
	return expir_time;
}
public void setExpir_time(int expir_time) {
	this.expir_time = expir_time;
}
@Override
public String toString() {
	return "Access_token "  + ", company_id=" + company_id + ", access_token=" + access_token
			+ ", expir_time=" + expir_time + "]";
}




}
