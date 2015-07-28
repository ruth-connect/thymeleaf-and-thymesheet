package com.connect_group.thymeleaf_demo.controller.examples;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddingUpdatingRemovingAttributesController {

	@RequestMapping({"/examples/addingUpdatingRemovingAttributes.html"})
    public ModelAndView addingUpdatingRemovingAttributes() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("myStyle", "font-size: 25pt; color: #FF00FF;"); // adds some styles
		model.put("mySrc", "/test-images/donald-duck.gif"); // updates an image source
		model.put("myClass", ""); // removes a CSS class by setting it to empty string
		
        return new ModelAndView("examples/addingUpdatingRemovingAttributes/addingUpdatingRemovingAttributes", model);
    }
}
