package com.connect_group.thymeleaf_demo.controller.examples;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SwitchingBetweenCasesController {

	@RequestMapping({"/examples/switchingBetweenCases.html"})
    public ModelAndView switchingBetweenCases() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		double randomness = Math.random();
		if (randomness < 0.2) {
			model.put("teletubby", "Tinky Winky");
		} else if (randomness < 0.4) {
			model.put("teletubby", "Dipsy");
		} else if (randomness < 0.6) {
			model.put("teletubby", "Laa-Laa");
		} else if (randomness < 0.8) {
			model.put("teletubby", "Po");
		}
		
        return new ModelAndView("examples/switchingBetweenCases/switchingBetweenCases", model);
    }
}
