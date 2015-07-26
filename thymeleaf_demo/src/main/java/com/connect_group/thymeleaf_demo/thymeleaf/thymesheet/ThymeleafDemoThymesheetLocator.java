package com.connect_group.thymeleaf_demo.thymeleaf.thymesheet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.thymeleaf.dom.Document;

import com.connect_group.thymesheet.ThymesheetLocator;
import com.connect_group.thymesheet.impl.HtmlThymesheetLocator;

public class ThymeleafDemoThymesheetLocator extends HtmlThymesheetLocator implements ThymesheetLocator {

	private static final Logger log = Logger.getLogger(ThymeleafDemoThymesheetLocator.class);

	private ServletContext servletContext;
	private static final String PATH_PREFIX = "/WEB-INF/templates/";
	private static final String DEFAULT_SUFFIX = ".tss";
	
	private final Set<String> thymesheetSuffixes = new HashSet<String>();
	
	@Override
	public List<String> getThymesheetPaths(Document document) {
		String path = document.getDocumentName();
		List<String> thymesheetPaths = getThymesheetPaths(path);
		thymesheetPaths.addAll(super.getThymesheetPaths(document));
		
		if (log.isInfoEnabled()) {
			log.info("getThymesheetPaths called");
			for (String thymesheetPath : thymesheetPaths) {
				log.info("Thymesheet Path: " + thymesheetPath);
			}
		}
		
		return thymesheetPaths;
	}
	
	@Override
	public void removeThymesheetLinks(Document document) {
	}
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public void addThymesheetSuffix(String suffix) {
		if (suffix != null) {
			if (suffix.startsWith("*")) {
				suffix = suffix.substring(1);
			}
			thymesheetSuffixes.add(suffix);
		}
	}
	
	protected boolean isPathWithThymesheetSuffix(String path) {
		boolean result = false;
		if (path != null && path.length() > 0) {
			if (thymesheetSuffixes != null && !thymesheetSuffixes.isEmpty()) {
				for (String suffix : thymesheetSuffixes) {
					if (path.endsWith(suffix)) {
						result = true;
						break;
					}
				}
			} else {
				result = path.endsWith(DEFAULT_SUFFIX);
			}
		}
		return result;
	}
	
	private List<String> getThymesheetPaths(String documentPath) {
		String folderPath = getFolderPath(documentPath);
		
		if (log.isInfoEnabled()) {
			log.info("getThymesheetPaths - folder path is: " + folderPath);
		}
		
		Set<String> folderContents = servletContext.getResourcePaths(PATH_PREFIX + folderPath);
		return filterThymesheetPaths(folderContents);
	}
	
	private List<String> filterThymesheetPaths(Set<String> folderContents) {
		List<String> thymesheetPaths = new ArrayList<String>();
		
		if (log.isInfoEnabled()) {
			log.info("filterThymesheetPaths called");
		}
		
		if (folderContents != null) {
			
			for (String filePath : folderContents) {
				
				if (log.isInfoEnabled()) {
					log.info("File path: " + filePath);
				}
				
				if (isPathWithThymesheetSuffix(filePath)) {
					thymesheetPaths.add(filePath);
				}
			}
		}
		return thymesheetPaths;
	}
	
	private String getFolderPath(String documentPath) {
		int last = documentPath.lastIndexOf(File.separatorChar);
		if (last >= 0 && last != documentPath.length() - 1) {
			return documentPath.substring(0, last);
		}
		return "";
	}
}
