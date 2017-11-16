package cn.zx.service;

import java.util.List;

import cn.zx.pojo.DataEchart;
import cn.zx.pojo.OiCompany;
import cn.zx.pojo.OiCompanyExample;

public interface OiCompanyService {
	
	
	public OiCompany getCompanyById(Integer company_id);

	public int updateExamineCompany(OiCompany company);
	
	public int removecompany(OiCompany company);
	
	public int addcompany(OiCompany company);

	public List<DataEchart> selectTaskCount();
	
	public List<DataEchart> selectCompanyTypeCount();
	
	public List<DataEchart> selectCompanyProvinceCount();

	List<OiCompany> getCompanyWithType();

	List<OiCompany> getCheckCompanyWithType();


	List<OiCompany> selectMessage(Integer company_id);

	 int insertSelective(OiCompany record);
	 
	 List<OiCompany> selectMessageOwn();
	 
	 List<OiCompany> selectCompanyByExample(OiCompanyExample example);

}
