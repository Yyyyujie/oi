package cn.zx.pojo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

import cn.zx.tool.ObtainIp;

public class Log {
    private Integer id;

    private String tableName;

    private String table_remarks;

    private String list;

    private String list_remarks;

    private Integer data_id;

    private Integer uid;

    private String uName;
    @DateTimeFormat( pattern="yyyy-MM-dd")
   	@JSONField(format ="yyyy-MM-dd")
    private Date createDate;

    private Integer charact;

    private String createIP;

    private String operate;
    
    public static Log AdminRecordLog(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	OiAdmin admin=(OiAdmin) session.getAttribute("user");
    	Log log=new Log();
    	ObtainIp ip=new ObtainIp();
		log.setCreateDate(new Date());
		log.setCreateIP(ip.getIpAddr(request));
		log.setUid(admin.getAdmin_id());
		log.setuName(admin.getUser_name());
		log.setCharact(1);
		return log; 
	}
    
    public static Log StaffRecordLog(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	CompanyStaffer companyStaffer = (CompanyStaffer) session.getAttribute("companyStaffer");
    	Log log=new Log();
    	ObtainIp ip=new ObtainIp();
		log.setCreateDate(new Date());
		log.setCreateIP(ip.getIpAddr(request));
		log.setUid(companyStaffer.getUser_id());
		log.setuName(companyStaffer.getRealname());
		log.setCharact(3);
		return log; 
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getTable_remarks() {
        return table_remarks;
    }

    public void setTable_remarks(String table_remarks) {
        this.table_remarks = table_remarks == null ? null : table_remarks.trim();
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list == null ? null : list.trim();
    }

    public String getList_remarks() {
        return list_remarks;
    }

    public void setList_remarks(String list_remarks) {
        this.list_remarks = list_remarks == null ? null : list_remarks.trim();
    }

    public Integer getData_id() {
        return data_id;
    }

    public void setData_id(Integer data_id) {
        this.data_id = data_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCharact() {
        return charact;
    }

    public void setCharact(Integer charact) {
        this.charact = charact;
    }

    public String getCreateIP() {
        return createIP;
    }

    public void setCreateIP(String createIP) {
        this.createIP = createIP == null ? null : createIP.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }
}