package cn.zx.pojo;

public class CompanyMessage {
    private Integer m_id;

    private String company_name;

    private Integer type_id;

    private String type_name;

    private Integer company_num;

    private String city;

    private String addr;

    private String contacts;

    private String phone;

    private String license_id;

    private String license_img;

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name == null ? null : company_name.trim();
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name == null ? null : type_name.trim();
    }

    public Integer getCompany_num() {
        return company_num;
    }

    public void setCompany_num(Integer company_num) {
        this.company_num = company_num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicense_id() {
        return license_id;
    }

    public void setLicense_id(String license_id) {
        this.license_id = license_id == null ? null : license_id.trim();
    }

    public String getLicense_img() {
        return license_img;
    }

    public void setLicense_img(String license_img) {
        this.license_img = license_img == null ? null : license_img.trim();
    }

	@Override
	public String toString() {
		return "CompanyMessage [m_id=" + m_id + ", company_name="
				+ company_name + ", type_id=" + type_id + ", type_name="
				+ type_name + ", company_num=" + company_num + ", city=" + city
				+ ", addr=" + addr + ", contacts=" + contacts + ", phone="
				+ phone + ", license_id=" + license_id + ", license_img="
				+ license_img + "]";
	}
    
}