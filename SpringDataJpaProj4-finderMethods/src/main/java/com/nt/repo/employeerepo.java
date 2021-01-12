package com.nt.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.employee;

public interface employeerepo extends JpaRepository<employee,Integer> {
	//select eno,ename,eadd,esal form employee where ename=?
	public List<employee> findByEname(String name);
	public List<employee> findByEnameIs(String name);
//	public List<employee> findByEnameEquals(String name);
	//select eno,ename,eadd,esal from employee where eno=?
	public List<employee> findByEno(int no);
	public List<employee> findByEnoEquals(int no);
	public List<employee> findByEadd(String addrs);
	public List<employee> findByesal(float sal);
	
	//select * from employee where esal<=?
	public List<employee> findByEsalLessThanEqual(float sal);
	
	//select * from employee where esal>=?
	public List<employee> findByEsalGreaterThanEqual(float sal);
	
	
	//select * from employee where ename like 's%';
	public List<employee> findByEnameLike(String initalchars);
	
	//select * from employee where ename like 'sh%';
	public List<employee> findByEnameStartingWith(String startchars);
	
	//select * from employee where ename like '%a%';
	public List<employee> findByEnameContaining(String chars);
	
	//select * form employee where eadd in ('hyd','banglore');
	
	public Iterable<employee> findByEaddIn(Collection<String> cities);
	
	//select * from employee where eadd notin('delhi');
	public Iterable<employee> findByEaddNotIn(Collection<String> citites);
	//select * from employee where eadd is null;
	public Iterable<employee> findByEaddIsNull();
	//select * from employee where eadd isnot null;
	public Iterable<employee> findByEaddIsNotNull();
	
	public Iterable<employee> findByEaddNotNull();
	//select * from employee where upper(eadd)=upper(city);
	public Iterable<employee> findByEaddIgnoreCase(String city);
	
	//select * from employee where ename=? orderby eno asc;
	public Iterable<employee> findByEaddOrderByEnoAsc(String city);
	
	//select * from employee where esal=70000 orderby ename desc;
	public Iterable<employee> findByEsalOrderByEnameDesc(Float sal);
	
	//select * from employee where ename='shiva' and eadd='hyd' orderbyeno asc;
	public Iterable<employee> findByEnameAndEaddOrderByEno(String name,String addrs);
	
	//select * from employee where eadd="hyd" or ename="shiva";
	public Iterable<employee> findByEaddOrEname(String addrs,String name);
	
	//select * from employee where esal between 10000 and 50000;
      public Iterable<employee> findByEsalBetween(float inisal,float finsal);
      
      //select * from employee where ename like 's%' and eadd like 'hy%';
      public Iterable<employee> findByEnameLikeAndEaddLike(String ininame,String iniadd);
      
      //select * from employee where (eno>=103 and ename like 's%') or (esal between 10000 and 50000);
      public Iterable<employee> findByEnoGreaterThanEqualAndEnameStartingWithOrEsalBetween(int eno,String name,float inisal,float finsal);

   //select * from employee where eadd in('hyd','banglore','delhi') and ename in('shiva','rana','sai');
      public Iterable<employee> findByEaddInAndEnameIn(List<String> cities,List<String> names);
}
