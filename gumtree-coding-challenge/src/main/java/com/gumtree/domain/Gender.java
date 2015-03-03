package com.gumtree.domain;

public enum Gender{
	
	MALE("Male"),
	FEMALE("Female");
	
	String value;
	Gender (String value){
		this.value=value;
	}
	
	String getValue(){
		return value;
	}
}
