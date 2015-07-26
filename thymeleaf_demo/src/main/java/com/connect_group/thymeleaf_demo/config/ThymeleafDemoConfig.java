package com.connect_group.thymeleaf_demo.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.ITemplateModeHandler;

import com.connect_group.thymeleaf_demo.thymeleaf.dialect.ThymeleafDemoDialect;
import com.connect_group.thymeleaf_demo.thymeleaf.thymesheet.ThymeleafDemoTemplateModeHandler;
import com.connect_group.thymesheet.spring4.SpringThymesheetTemplateEngine;

@Configuration
public class ThymeleafDemoConfig {

	@Autowired
	private ServletContext servletContext;
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false); // This would be set to true in a live production environment.
		templateResolver.initialize();
		return templateResolver;
	}
	
	@Bean
	public SpringThymesheetTemplateEngine templateEngine() {
		SpringThymesheetTemplateEngine templateEngine = new SpringThymesheetTemplateEngine();
		
		Set<ITemplateModeHandler> templateModeHandlers = new HashSet<>();
		ThymeleafDemoTemplateModeHandler templateModeHandler = new ThymeleafDemoTemplateModeHandler();
		templateModeHandler.setServletContext(servletContext);
		templateModeHandlers.add(templateModeHandler);
		templateEngine.setTemplateModeHandlers(templateModeHandlers);
		
		templateEngine.setTemplateResolver(templateResolver());
		
		Set<IDialect> additionalDialects = new HashSet<>();
		additionalDialects.add(new ThymeleafDemoDialect());
		templateEngine.setAdditionalDialects(additionalDialects);
		
		return templateEngine;
	}
}
