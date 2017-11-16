package cn.zx.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.zx.tool.ObtainIp;

import com.alibaba.fastjson.JSONObject;
@RequestMapping("/tupian")
@Controller
public class PictureUploadController {
	private static final long serialVersionUID = 1L;
	/*private String serverPath = "D:/";*/
	
	
	@RequestMapping("/upload.do")
    @ResponseBody
	public String insert(@RequestParam("file")MultipartFile attach,
			HttpServletRequest request,
			HttpServletResponse response){
		ObtainIp ip=new ObtainIp();
		String path = ip.getIpAddr(request)+"/statics/images" ;
		String oldFileName = attach.getOriginalFilename();//原文件名		
		String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀    	 
		String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_Task.jpg";
		File targetFile = new File(path, fileName);
		
		JSONObject json = new JSONObject();
		if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
        	attach.transferTo(targetFile);
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("uploadFileError", " * 上传失败！");
            return json.toJSONString();
        }  
        json.put("msg","success");
		 json.put("filePath",targetFile.getPath());
		 return json.toJSONString();
		
	}
	}

