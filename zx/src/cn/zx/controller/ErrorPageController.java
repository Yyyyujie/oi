package cn.zx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ErrorPageController {
	
	 Logger log = LogManager.getLogger(ErrorPageController.class);
	 
	@RequestMapping("404")
    public String page404() {
        log.info("HTTP-400错误");
        System.out.println("404");
        return "HTTP-404";
    }

    @RequestMapping("500")
    public String page500() {
        log.error(500);
        System.out.println("500");
        return "HTTP-500";
    }

}
