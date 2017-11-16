package cn.zx.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zx.pojo.CompanyPromotionMsg;
import cn.zx.pojo.CompanyStaffer;
import cn.zx.pojo.Log;
import cn.zx.service.impl.CompanyPromotionMsgServiceImpl;
import cn.zx.service.impl.LogServiceImpl;
import cn.zx.tool.ObtainIp;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/staff")
public class CompanyPromotionMsgController {
	@Autowired
	CompanyPromotionMsgServiceImpl companyPromotionMsgService;
	@Autowired
	LogServiceImpl logService;
	
	@RequestMapping("/insertCompanyPromotion.do")
	@ResponseBody
	public Object insertCompanyPromotion(String vote,String uid,
			String pid,String endTime,HttpSession session,HttpServletRequest request){
		CompanyStaffer companyStaff= (CompanyStaffer) session.getAttribute("companyStaffer");
		List<CompanyPromotionMsg>  listPM=companyPromotionMsgService.selectPMByuid(companyStaff.getUser_id(), Integer.parseInt(pid));
		CompanyPromotionMsg record=new CompanyPromotionMsg();
		if(listPM !=null){			
			record=listPM.get(0);
			System.out.println(record.getPromotion_msg_id());
			if(vote.equals("1")){
				record.setIs_vote(1);
			}else if(vote.equals("-1")){
				record.setIs_vote(-1);
			}else{
				record.setIs_vote(0);
			}
			record.setUpdate_time(new Date());
		}
		
		int row=companyPromotionMsgService.updateByPrimaryKeySelective(record);
		//添加日志开始
				ObtainIp obtainIp=new ObtainIp();
				Log log=new Log();
				log.setTableName("CompanyPromotionMsg");
				log.setTable_remarks("公司投票数据表");
				log.setData_id(record.getPromotion_msg_id());
				log.setUid(companyStaff.getUser_id());
				log.setuName(companyStaff.getRealname());
				log.setOperate("投票数据");
				log.setCreateDate(new Date());
				log.setCreateIP(obtainIp.getIpAddr(request));
				log.setCharact(3);
					
				logService.insertSelective(log);
				//添加日志结束	
		if(row==1){
			return JSONArray.toJSON("成功");
		}else{
			return JSONArray.toJSON("失败");
		}
		
	}
	
}
