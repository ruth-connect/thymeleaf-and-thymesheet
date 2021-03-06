package com.connect_group.thymeleaf_demo.tdd;

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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.connect_group.thymeleaf.testing.ThymeleafTestEngine;
import com.connect_group.thymeleaf_demo.beans.cars.CarMake;
import com.connect_group.thymeleaf_demo.beans.cars.CarModel;
import com.connect_group.thymeleaf_demo.config.SpringBootTestThymesheetContext;
import com.connect_group.thymesheet.css.selectors.NodeSelectorException;
import com.connect_group.thymesheet.query.HtmlElements;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootTestThymesheetContext.class)
public class CarsTests {
	
	private static final String HTML_PATH = "tdd/cars/cars.html";

	@Autowired
	private ThymeleafTestEngine selectorEngine;

	@Before
	public void setup() {
	}

	@Test
	@Ignore
	public void shouldNotOutputUlTagForCarMakes_WhenListOfCarMakesIsEmpty() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", new ArrayList<CarMake>());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes"), not(exists()));
	}
	
	@Test
	@Ignore
	public void shouldOutputUlTagForCarMakes_WhenListOfCarMakesContainsOneCarMake() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes"), occursOnce());
	}
	
	@Test
	@Ignore
	public void shouldOutputOneLiTagForCarMakes_WhenListOfCarMakesContainsOneCarMake() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes > li"), occursOnce());
	}
	
	@Test
	@Ignore
	public void shouldOutputTwoLiTagsForCarMakes_WhenListOfCarMakesContainsTwoCarMakes() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getTwoCarMakesWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes > li"), hasSize(2));		
	}
	
	@Test
	@Ignore
	public void shouldOutputCarMakeName_WhenCarMakeNameIsSet() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-makes > li > h2"), isSingleElementThat(hasOnlyText("Jaguar")));
	}
	
	@Test
	@Ignore
	public void shouldOutputNoUlTagForCarModels_WhenListOfCarModelsIsEmpty() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithNoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-models"), not(exists()));
	}
	
	@Test
	@Ignore
	public void shouldOutputUlTagForCarModels_WhenListOfCarModelsContainsOneCarModel() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithOneModel());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-models"), occursOnce());
	}
	
	@Test
	@Ignore
	public void shouldOutputOneCarModel_WhenListOfCarModelsContainsOneCarModel() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithOneModel());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-models > li"), occursOnce());
	}
	
	@Test
	@Ignore
	public void shouldOutputTwoCarModels_WhenListOfCarModelsContainsTwoCarModels() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithTwoModels());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-models > li"), hasSize(2));
	}
	
	@Test
	@Ignore
	public void shouldOutputCarModelName_WhenCarModelNameIsSet() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("carMakes", getOneCarMakeWithOneModel());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching("ul.car-models > li"), isSingleElementThat(hasOnlyText("XE")));
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
	
	private List<CarMake> getOneCarMakeWithOneModel() {
		CarMake jaguar = new CarMake("Jaguar");
		List<CarModel> jaguarModels = new ArrayList<>();
		jaguarModels.add(new CarModel("XE"));
		jaguar.setModels(jaguarModels);
		return Collections.singletonList(jaguar);
	}
	
	private List<CarMake> getOneCarMakeWithTwoModels() {
		CarMake jaguar = new CarMake("Jaguar");
		List<CarModel> jaguarModels = new ArrayList<>();
		jaguarModels.add(new CarModel("XE"));
		jaguarModels.add(new CarModel("XF"));
		jaguar.setModels(jaguarModels);
		return Collections.singletonList(jaguar);
	}
}
