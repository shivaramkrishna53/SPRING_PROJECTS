package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.context.ApplicationContext;

import com.nt.repo.employeerepo;

@SpringBootApplication
public class SpringDataJpaProj4FinderMethodsApplication {
	
	
	
	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj4FinderMethodsApplication.class, args);
		employeerepo repo=ctx.getBean(employeerepo.class);
		System.out.println(repo.getClass());
		//repo.findByEname("shiva").forEach(System.out::println);
		//repo.findByEnameIs("shiva").forEach(System.out::println);
		//repo.findByEno(101).forEach(System.out::println);
		//repo.findByEnoEquals(101).forEach(System.out::println);
		//repo.findByEadd("hyd").forEach(System.out::println);
		//repo.findByesal(70000).forEach(System.out::println);
//		repo.findByEsalLessThanEqual(70000).forEach(System.out::println);
//		repo.findByEsalGreaterThanEqual(70000).forEach(System.out::println);
		//repo.findByEnameLike("s%").forEach(System.out::println);
		//repo.findByEnameStartingWith("r").forEach(System.out::println);
		//repo.findByEnameContaining("a").forEach(System.out::println);
		//repo.findByEaddIn(List.of(new String("hyd"),new String("delhi"))).forEach(System.out::println); // or repo.findByEaddIn(List.of("hyd","delhi"));
		//repo.findByEaddNotIn(List.of("hyd")).forEach(System.out::println);
		//repo.findByEaddIsNull().forEach(System.out::println);
		//repo.findByEaddIsNotNull().forEach(System.out::println);
		//repo.findByEaddNotNull().forEach(System.out::println);
		//repo.findByEaddIgnoreCase("bAnGlore").forEach(System.out::println);
		//repo.findByEaddOrderByEnoAsc("hyd").forEach(System.out::println);
		//repo.findByEsalOrderByEnameDesc(70000.0f).forEach(System.out::println);
		//repo.findByEnameAndEaddOrderByEno("shiva", "hyd").forEach(System.out::println);
		//repo.findByEaddOrEname("hyd","shiva").forEach(System.out::println);
		//repo.findByEsalBetween(1, 500).forEach(System.out::println);
		//repo.findByEnameLikeAndEaddLike("s%","h%").forEach(System.out::println);
		//repo.findByEnoGreaterThanEqualAndEnameStartingWithOrEsalBetween(103,"s", 30000, 50000).forEach(System.out::println);
		repo.findByEaddInAndEnameIn(List.of("hyd","delhi","banglore"),List.of("shiva","sai","rana")).forEach(System.out::println);
	}

}
