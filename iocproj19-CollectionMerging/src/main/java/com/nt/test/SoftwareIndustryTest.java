package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.SoftwareIndustrySkillsRequiredAccordingToExperience;

public class SoftwareIndustryTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		SoftwareIndustrySkillsRequiredAccordingToExperience exp1=ctx.getBean("fresher", SoftwareIndustrySkillsRequiredAccordingToExperience.class);
		System.out.println(exp1);
		SoftwareIndustrySkillsRequiredAccordingToExperience exp2=ctx.getBean("TwoYear", SoftwareIndustrySkillsRequiredAccordingToExperience.class);
        System.out.println(exp2);
		
	}
}
