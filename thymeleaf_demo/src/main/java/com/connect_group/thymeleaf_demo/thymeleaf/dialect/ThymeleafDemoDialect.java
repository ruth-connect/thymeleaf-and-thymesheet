package com.connect_group.thymeleaf_demo.thymeleaf.dialect;

import org.thymeleaf.dialect.AbstractDialect;

public class ThymeleafDemoDialect extends AbstractDialect {

	@Override
	public String getPrefix() {
		return "demo";
	}
	
	@Override
	public boolean isLenient() {
		return false;
	}
}
