package cn.zx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Page")
public class Page {
	@RequestMapping("/index.html")
	public String Login(){
		return "admin/index";
	}
}
