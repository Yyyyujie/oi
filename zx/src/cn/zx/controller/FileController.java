package cn.zx.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/file")
public class FileController {
	
	@RequestMapping("/upload.do")
    @ResponseBody
	public Object insert(@RequestParam("file")MultipartFile attach,
			HttpServletRequest request,
			HttpServletResponse response){
		String path=System.getProperty("catalina.home")+"/webapps/statics/images/picture/";
		String oldFileName = attach.getOriginalFilename();//原文件名		
		String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀    	 
		String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_Personal.jpg";
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
        System.out.println(targetFile.getPath().substring(targetFile.getPath().length()-50));
        json.put("msg","success");
        json.put("filePath",targetFile.getPath().substring(targetFile.getPath().length()-50));
	     System.out.println("json="+json.toJSONString());
		 return json;
		
	}
	/**
	 * 富文本上传图片
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/UploadPrice.do")
	public void imgUpload(HttpServletRequest request,PrintWriter out,
			@RequestParam("upload")MultipartFile attach) throws IOException{
		
		String oldFileName = attach.getOriginalFilename();//原文件名		
		String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀    	 
		String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_News.jpg";
		//图片上传路径
		 String callback = request.getParameter("CKEditorFuncNum");

		 String uploadPath =System.getProperty("catalina.home")+"/webapps/statics/images/news/";
		File targetFile = new File(uploadPath, fileName);
		if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
        	attach.transferTo(targetFile);
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("uploadFileError", " * 上传失败！");
        }  
		 
		// 返回"图像"选项卡并显示图片  request.getContextPath()为web项目名
		 out.write("<script type='text/javascript\'>");
		 out.write("window.parent.CKEDITOR.tools.callFunction(" + callback
				 + ",'http://www.sxfs0351.com/statics/images/news/"+fileName+"','')");// 相对路径用于显示图片  
		 out.write("</script>");
		 out.flush();
		
	}
}
