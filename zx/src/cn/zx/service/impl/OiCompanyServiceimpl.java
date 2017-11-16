package cn.zx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.DataEchartMapper;
import cn.zx.dao.OiCompanyMapper;
import cn.zx.pojo.DataEchart;
import cn.zx.pojo.OiCompany;
import cn.zx.pojo.OiCompanyExample;
import cn.zx.service.OiCompanyService;
@Service("OiCompanyService")
public class OiCompanyServiceimpl implements OiCompanyService {
@Autowired
OiCompanyMapper oiCompanyMapper;
@Autowired
DataEchartMapper dataEchartMapper;


	@Override
	public int updateExamineCompany(OiCompany company){
		// TODO Auto-generated method stub
		return oiCompanyMapper.updateByPrimaryKeySelective(company);
	}
	@Override
	public OiCompany getCompanyById(Integer company_id) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectByPrimaryKey(company_id);
	}
	@Override
	public int removecompany(OiCompany company) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.updateByPrimaryKeySelective(company);
	}
	@Override
	public int addcompany(OiCompany company) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.insertSelective(company);
	}
	@Override
	public List<OiCompany> getCompanyWithType() {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectCompanyWithType();
	}
	@Override
	public List<OiCompany> getCheckCompanyWithType() {
		// TODO Auto-generated method stub
		return oiCompanyMapper.getCheckCompanyWithType();
	}
	@Override
	public List<DataEchart> selectTaskCount() {
		// TODO Auto-generated method stub
		return dataEchartMapper.task_count();
	}
	@Override
	public List<DataEchart> selectCompanyTypeCount() {
		// TODO Auto-generated method stub
		return dataEchartMapper.type_count();
	}
	@Override
	public List<DataEchart>  selectCompanyProvinceCount() {
		// TODO Auto-generated method stub
		return dataEchartMapper.district_count();
	}
	@Override
	public List<OiCompany> selectMessage(Integer company_id) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectMessage(company_id);
	}
	@Override
	public int insertSelective(OiCompany record) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.insertSelective(record);
	}
	@Override
	public List<OiCompany> selectMessageOwn() {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectMessageOwn();
	}
	@Override
	public List<OiCompany> selectCompanyByExample(OiCompanyExample example) {
		// TODO Auto-generated method stub
		return oiCompanyMapper.selectByExample(example);
	}
}
