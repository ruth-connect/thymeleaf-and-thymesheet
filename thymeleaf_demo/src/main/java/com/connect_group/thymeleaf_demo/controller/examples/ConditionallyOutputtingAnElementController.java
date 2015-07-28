package com.connect_group.thymeleaf_demo.controller.examples;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConditionallyOutputtingAnElementController {

	@RequestMapping({"/examples/conditionallyOutputtingAnElement.html"})
    public ModelAndView conditionallyOutputtingAnElement() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("myRandomness", new Boolean(Math.random() >= 0.5));
		
        return new ModelAndView("examples/conditionallyOutputtingAnElement/conditionallyOutputtingAnElement", model);
    }
}
