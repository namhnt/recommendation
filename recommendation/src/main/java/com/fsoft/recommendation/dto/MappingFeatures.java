package com.fsoft.recommendation.dto;

import java.util.HashMap;

public class MappingFeatures {

	HashMap<Integer, Property> mapping;

	public HashMap<Integer, Property> getMapping() {
		return mapping;
	}

	public void setMapping(HashMap<Integer, Property> mapping) {
		this.mapping = mapping;
	}
	
	public MappingFeatures() {
		// TODO Auto-generated constructor stub
		mapping = new HashMap<Integer, Property>();
	}
	
	//make sure that distinct value file should be avaiable
	//template for file should be
	// PropertiesName;Value1,Value2,Value3 ......
	//
	//
	public void loadPropertiesFromFile(String fileName) {
		
	}
	
}
