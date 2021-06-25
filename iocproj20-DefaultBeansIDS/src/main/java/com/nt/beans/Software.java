package com.nt.beans;

import java.util.Set;

public class Software {
	
	Set<String> technologies;
	Set<String> tools;
	
	public void setTechnologies(Set<String> technologies) {
		this.technologies = technologies;
	}
	public void setTools(Set<String> tools) {
		this.tools = tools;
	}
	@Override
	public String toString() {
		return "Software [technologies=" + technologies + ", tools=" + tools
				+ "]";
	}

	
}
