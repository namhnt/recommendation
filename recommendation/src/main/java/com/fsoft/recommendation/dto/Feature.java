package com.fsoft.recommendation.dto;

import java.util.List;

public class Feature extends Property {

	List<String> domainValues;

	public List<String> getDomainValues() {
		return domainValues;
	}

	public void setDomainValues(List<String> domainValues) {
		this.domainValues = domainValues;
	}
	
	public void addToDomainValues(String value) {
		domainValues.add(value);
	}

	@Override
	public String toString() {
		return "Feature [domainValues=" + domainValues + "]";
	}	
}
