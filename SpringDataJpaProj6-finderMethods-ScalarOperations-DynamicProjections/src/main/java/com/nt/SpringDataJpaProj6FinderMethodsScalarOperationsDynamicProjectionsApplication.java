package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.IEmployeeRepo;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;
import com.nt.view.ResultView3;

@SpringBootApplication
public class SpringDataJpaProj6FinderMethodsScalarOperationsDynamicProjectionsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj6FinderMethodsScalarOperationsDynamicProjectionsApplication.class, args);
	    IEmployeeRepo repo=ctx.getBean(IEmployeeRepo.class);
	    List<ResultView1> lst=repo.findByEadd("delhi",ResultView1.class);
	    lst.forEach(view1->System.out.println(view1.getEno()+" "+view1.getEname()));
	    System.out.println("----------------------------------------");
	    
	    List<ResultView2> lst2=repo.findByEadd("banglore",ResultView2.class);
	    lst2.forEach(view2->System.out.println(view2.getEno()+" "+view2.getEsal()));
	    
	    System.out.println("----------------------------------------");
	    List<ResultView3> lst3=repo.findByEadd("banglore",ResultView3.class);
	    lst3.forEach(view3->System.out.println(view3.getEname()+" "+view3.getEadd()+" "+view3.getEsal()));
	    
	}

}
