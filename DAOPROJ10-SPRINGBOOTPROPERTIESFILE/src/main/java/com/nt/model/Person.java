package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("per")
@ConfigurationProperties(prefix = "per.info")
public class Person {

private String name;
private int age;
private String addrs;
private String[]cars;
private List<String>bikes;
private Set<Integer>marks;
private Map<String,Integer>phone;
private job job;

	
}
