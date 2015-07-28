package com.connect_group.thymeleaf_demo.controller.examples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RemovingElementsController {

	@RequestMapping({"/examples/removingElements.html"})
    public String removingElements() {
       return "examples/removingElements/removingElements";
    }
}
