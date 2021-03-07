package com.nt.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Department;
import com.nt.entity.Employee123;
import com.nt.repo.IDeptRepo;
import com.nt.repo.IEmpRepo;
@Service("companyser")
public class CompanyMangamentServiceImpl implements ICompanyMangmntService {

	
	@Autowired
	private IEmpRepo emprepo;
	@Autowired
	private IDeptRepo deptrepo;
	@Override
	public void saveDataUsingParent() {
		// TODO Auto-generated method stub
		//child entity objects
		Employee123 e1=new Employee123();
		e1.setEno(123);
		e1.setEname("babu");
		e1.setEdesg("engineer");
		e1.setEsal(1000.0f);
		
		Employee123 e2=new Employee123();
		e1.setEno(112523);
		e1.setEname("mahi");
		e1.setEdesg("mangaer");
		e1.setEsal(13000.0f);
		
		
		//parent entity object
		Department d=new Department();
		d.setDeptno(1);
		d.setDeptname("manufacture");
		d.setDeptloc("hyd");
		
		
		//mapping all the childs to parents
		d.setEmps(Set.of(e1,e2));
		//mapping the parent to childs
		e1.setDept(d);
		e2.setDept(d);
		
		//saving the data using the parent
		deptrepo.save(d);
		
	}

	@Override
	public void saveDataUsingChild() {
		// TODO Auto-generated method stub
		//entity objects for child
		Employee123 e1=new Employee123();
		e1.setEno(89123);
		e1.setEname("badsha");
		e1.setEdesg("ceo");
		e1.setEsal(1000.0f);
		
		Employee123 e2=new Employee123();
		e1.setEno(9112523);
		e1.setEname("varu");
		e1.setEdesg("developer");
		e1.setEsal(13000.0f);
		
		// creating entity object for parent
		Department d=new Department();
		d.setDeptno(899);
		d.setDeptname("software");
		d.setDeptloc("hyd");
		
		//mapping the entities
		d.setEmps(Set.of(e1,e2));
		e1.setDept(d);
		e2.setDept(d);
		
		//save using child repo
		emprepo.save(e1);
		emprepo.save(e2);
		
	}

}
