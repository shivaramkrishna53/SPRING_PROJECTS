package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class IocProj74BootDependencyInjectionApplication {

	public static void main(String[] args) {
		System.out.println("Main class of spring boot");
		ApplicationContext ctx;
		ctx=SpringApplication.run(IocProj74BootDependencyInjectionApplication.class, args);
		WishMessageGenerator gen=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(gen.wishmessage("shiva"));
		((ConfigurableApplicationContext) ctx).close();
	}

}
