package com.connect_group.thymeleaf_demo.controller.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IteratingThroughAListController {


	@RequestMapping({"/examples/iteratingThroughAList.html"})
    public ModelAndView iteratingThroughAList() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		List<String> myList = new ArrayList<String>();
		myList.add("Teal");
		myList.add("Magenta");
		myList.add("Turquoise");
		myList.add("Mauve");
		myList.add("Pink");
		myList.add("Lilac");
		model.put("myList", myList);
		
        return new ModelAndView("examples/iteratingThroughAList/iteratingThroughAList", model);
    }
}
