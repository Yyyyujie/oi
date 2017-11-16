package cn.zx.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tool {
	public String MD5(String pwd){
		StringBuffer sb= new StringBuffer();
		try{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			if(!pwd.equals("") && pwd!=null){
				byte[] bytes = digest.digest(pwd.getBytes());
				
				for(int i = 0;i<bytes.length;i++){
					String s =Integer.toHexString(0xff&bytes[i]);
					if(s.length()==1){
						sb.append("0"+s);
						}else{
							sb.append(s);
						}
				}			
			
			}
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
			throw new RuntimeException("不能生成");
		}
		return sb.toString();
	}
}
