package cn.zx.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OiCompany {
    private Integer company_id;

    private Integer user_id;
    
    private String user_name;

	private Integer pro_id;

    private Integer city_id;

    private Integer area_id;
    
    private String pro_name;

    private String city_name;

    private String area_name;

    private String addr;

    private String address;

    private String company_name;

    private Integer type_id;
    
    private String type_name;

    private Integer company_num;

    private String corporate_rep;

    private String contact;

    private String phone;

    private String license_id;

    private String license_img;

    private String logo;

    private Integer isdelete;

    private Integer audit;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date create_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date audit_time;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date update_time;
    
    
    
    @Override
	public String toString() {
		return "OiCompany [company_id=" + company_id + ", user_id=" + user_id + ", user_name=" + user_name + ", pro_id="
				+ pro_id + ", city_id=" + city_id + ", area_id=" + area_id + ", pro_name=" + pro_name + ", city_name="
				+ city_name + ", area_name=" + area_name + ", addr=" + addr + ", address=" + address + ", company_name="
				+ company_name + ", type_id=" + type_id + ", type_name=" + type_name + ", company_num=" + company_num
				+ ", corporate_rep=" + corporate_rep + ", contact=" + contact + ", phone=" + phone + ", license_id="
				+ license_id + ", license_img=" + license_img + ", logo=" + logo + ", isdelete=" + isdelete + ", audit="
				+ audit + ", create_time=" + create_time + ", audit_time=" + audit_time + ", update_time=" + update_time
				+ ", nodes=" + nodes + "]";
	}

	private List nodes = new ArrayList();

    public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

    
    public List getNodes() {
		return nodes;
	}

	public void setNodes(List nodes) {
		this.nodes = nodes;
	}

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

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public Integer getCompany_num() {
        return company_num;
    }

    public void setCompany_num(Integer company_num) {
        this.company_num = company_num;
    }

    public String getCorporate_rep() {
        return corporate_rep;
    }

    public void setCorporate_rep(String corporate_rep) {
        this.corporate_rep = corporate_rep == null ? null : corporate_rep.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getAudit_time() {
        return audit_time;
    }

    public void setAudit_time(Date audit_time) {
        this.audit_time = audit_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}