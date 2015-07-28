package com.connect_group.thymeleaf_demo.controller.examples;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReplacingTextContentController {

	@RequestMapping({"/examples/replacingTextContent.html"})
    public ModelAndView replacingTextContent() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("myText", "This is some text from the webapp. <b>This text is bold.</b> <i>This text is italic.</i>");
		
        return new ModelAndView("examples/replacingTextContent/replacingTextContent", model);
    }
}
