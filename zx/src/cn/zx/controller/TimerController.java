package cn.zx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zx.pojo.CompanyStaffer;
import cn.zx.service.CompanyStafferService;
import cn.zx.tool.ThrimTask;

@Controller
@RequestMapping("/staff")
public class TimerController {
	@Autowired
	CompanyStafferService companyStafferService;
	
	@RequestMapping("/Trimer.hour")
	public void ceshi(){
		ThrimTask tm=new ThrimTask();
		tm.showTimer();
	}
	
}
