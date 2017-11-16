package cn.zx.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zx.dao.CompanyPostLevelMapper;
import cn.zx.dao.CompanyStafferMapper;
import cn.zx.dao.DataEchartMapper;
import cn.zx.pojo.CompanyPostLevel;
import cn.zx.pojo.CompanyPostLevelExample;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.CompanyStafferExample;
import cn.zx.pojo.DataEchart;
import cn.zx.service.CompanyStafferService;

@Service("companyStafferService")
public class CompanyStafferServiceImpl implements CompanyStafferService {
	@Autowired
	CompanyStafferMapper companyStafferMapper;
	@Autowired
	DataEchartMapper dataEchartMapper;
	@Autowired
	CompanyPostLevelMapper companyPostLevelMapper;
	
	@Override
	public List<CompanyStaffer> selectStaffer(
			 Integer user_id,
			 Integer company_id) {
		// TODO Auto-generated method stub
		return companyStafferMapper.selectStaffer(user_id, company_id);
	}

	@Override
	public int insertSelective(CompanyStaffer record) {
		// TODO Auto-generated method stub
		return companyStafferMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(List<CompanyStaffer> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i=companyStafferMapper.updateByPrimaryKeySelective(list.get(i));
			row+=i;
		}
		return row;
	}
	@Override
	public List<CompanyStaffer> selectStaffByCompanyIdAndDepartId(CompanyStafferExample companyStafferExample) {
		return companyStafferMapper.selectByExample(companyStafferExample);
	}

	@Override
	public boolean staffUpdateEmailOrTelphone(CompanyStaffer companyStaffer) {
		return companyStafferMapper.updateByPrimaryKeySelective(companyStaffer)==1;
	}

	@Override
	public CompanyStaffer selectStafferByUserId(Integer user_id) {
		
		return companyStafferMapper.selectByPrimaryKey(user_id);
	}

	@Override
	public List<CompanyStaffer> staffLogin(CompanyStafferExample companyStafferExample) {
		return companyStafferMapper.selectByExample(companyStafferExample);
	}

	@Override
	public CompanyStaffer selectStaffByDepartAndPost(Integer user_id, Integer company_id) {
		return companyStafferMapper.selectStaffByDepartAndPost(user_id, company_id);
	}

	@Override
	public List<CompanyStaffer> selectStaffByCompanyId(Integer company_id) {
		return companyStafferMapper.selectStaffByCompanyId(company_id);
	}

	@Override
	public List<CompanyStaffer> selectHiredateByCompanyId() {
		return companyStafferMapper.selectHiredateByCompanyId();
	}

	@Override
	public int updatePWDByuseID(@Param("user_id") Integer user_id,
			@Param("sf_password") String sf_password) {
		// TODO Auto-generated method stub
		return companyStafferMapper.updatePWDByuseID(user_id, sf_password);
	}

	@Override
	public CompanyStaffer staffLoginsession(Integer user_id) {
		// TODO Auto-generated method stub
		return companyStafferMapper.selectByPrimaryKeyAllInfo(user_id);
	}

	@Override
	public DataEchart getselfInfso(Integer user_id) {
		// TODO Auto-generated method stub
		return dataEchartMapper.staff_task_sum(user_id);
	}

	@Override
	public List<CompanyPostLevel> queryNextLevel(CompanyPostLevelExample example) {
		// TODO Auto-generated method stub
		return companyPostLevelMapper.selectByExample(example);
	}

	@Override
	public CompanyPostLevel queryLevel(Integer level_id) {
		// TODO Auto-generated method stub
		return companyPostLevelMapper.selectByPrimaryKey(level_id);
	}

	@Override
	public List<CompanyStaffer> selectExample(
			CompanyStafferExample companyStafferExample) {
		// TODO Auto-generated method stub
		return companyStafferMapper.selectByExample(companyStafferExample);
	}

	@Override
	public DataEchart getselfInfo(Integer user_id) {
		// TODO Auto-generated method stub
		return dataEchartMapper.staff_task_sum(user_id);
	}

	@Override
	public int updatestaffer(CompanyStaffer staffer2) {
		// TODO Auto-generated method stub
		return companyStafferMapper.updateByPrimaryKeySelective(staffer2);
	}
	@Override
	public List<CompanyStaffer> selectByDepart(Integer depart,
			Integer company_id) {
		// TODO Auto-generated method stub
		return companyStafferMapper.selectByDepart(depart, company_id);
	}

	@Override
	public CompanyStaffer selectByPrimaryKey(Integer user_id) {
		System.out.println("selectByPrimaryKey"+user_id);
		return companyStafferMapper.selectByPrimaryKey(user_id);
	}

}
