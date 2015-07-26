package com.connect_group.thymeleaf_demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger log = Logger.getLogger(HomeController.class);
	
	@RequestMapping({"/", "/index.html"})
    String index() {
		if(log.isInfoEnabled()) {
			log.info("HomeController index() invoked");
		}
        return "index";
    }
}
