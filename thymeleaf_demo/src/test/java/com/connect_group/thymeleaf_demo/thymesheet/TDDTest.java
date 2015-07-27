package com.connect_group.thymeleaf_demo.thymesheet;

import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.exists;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.hasOnlyText;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.isSingleElementThat;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.occursOnce;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.connect_group.thymeleaf.testing.ThymeleafTestEngine;
import com.connect_group.thymeleaf_demo.beans.CarMake;
import com.connect_group.thymeleaf_demo.config.TestContext;
import com.connect_group.thymesheet.css.selectors.NodeSelectorException;
import com.connect_group.thymesheet.query.HtmlElements;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestContext.class)
public class TDDTest {
	
	private static final String HTML_PATH = "src/main/resources/templates/thymesheet/tddTest.html";

	@Autowired
	private ThymeleafTestEngine selectorEngine;

	@Before
	public void setup() {
	}

	@Test
	public void shouldNotOutputUlTagForCarMakes_WhenListOfCarMakesIsEmpty() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", new ArrayList<CarMake>());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes"), not(exists()));
	}
	
	@Test
	public void shouldOutputUlTagForCarMakes_WhenListOfCarMakesContainsOneCarMake() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes"), occursOnce());
	}
	
	@Test
	public void shouldOutputOneLiTagForCarMakes_WhenListOfCarMakesContainsOneCarMake() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes > li"), occursOnce());
	}
	
	@Test
	public void shouldOutputTwoLiTagsForCarMakes_WhenListOfCarMakesContainsTwoCarMakes() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getTwoCarMakesWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes > li"), hasSize(2));		
	}
	
	@Test
	public void shouldOutputCarMakeName_WhenCarMakeNameIsSet() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes > li > h2"), isSingleElementThat(hasOnlyText("Jaguar")));
	}
	
	private List<CarMake> getOneCarMakeWithNoModels() {
		return Collections.singletonList(new CarMake("Jaguar"));
	}
	
	private List<CarMake> getTwoCarMakesWithNoModels() {
		List<CarMake> carMakes = new ArrayList<>();
		carMakes.add(new CarMake("jaguar"));
		carMakes.add(new CarMake("Land Rover"));
		return carMakes;
	}
}
