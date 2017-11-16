package cn.zx.util;

import java.util.HashMap;
import java.util.Map;

public class CompanyInfoMap {
	public static Map<String, Comparable> getCompany(){
		Map<String, Comparable> map = new HashMap<String, Comparable>();
		map.put("company_id",1);
		map.put("company_name","董晨");
		map.put("phone","123456789" );
		map.put("appid","wx4916e88df481faa3");
		map.put("secret","ead637a8a7210bcc31881c23efd1c6e9");
		return map;
	}
}
