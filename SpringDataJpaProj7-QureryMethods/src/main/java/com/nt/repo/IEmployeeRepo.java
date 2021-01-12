package com.nt.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.EmployeeDetails;

public interface IEmployeeRepo extends JpaRepository<EmployeeDetails,Integer> {
	//------>fetching bulk select results with all column values
	@Query("from EmployeeDetails")
	public List<EmployeeDetails> fetchAllEmployess();
	
	@Query("from EmployeeDetails where eadd=:addrs")
	public List<EmployeeDetails> fetchAllEmpByEadd(String addrs);
	
	@Query("from EmployeeDetails where esal between ?1 and ?2") //or @Query("from EmployeeDetails where esal between :inisal and :finalsal");
	public List<EmployeeDetails> fetchAllBetweenSal(float inisal,float finalsal);

	//-------------->fetching bulk select results with specific multiple column values
	@Query("select eno,ename,eadd from EmployeeDetails where eadd in(?1,?2,?3)")
	public List<Object[]> fetchEmpDetailsByCities(String city1,String city2,String city3);
	
	@Query("select ename,esal from EmployeeDetails where ename like :initialchars%")
	public List<Object[]> fetchByInitialCharacters(String initialchars);
	
	//--------------------->retreving specific single col values in bulk select
	
	@Query("select ename from EmployeeDetails where eno between :ini and :fin")
	public List<String> findEmpNamesInEmpNosRange(int ini,int fin);
	
	@Query("select esal from EmployeeDetails where ename in(:name1,:name2,:name3)")
	public List<Float> findEmpSalariesByEmpName(String name1,String name2,String name3);
	
	//---------------->retreving all colmns for a single record
	@Query("from EmployeeDetails where eno=:no")
	public EmployeeDetails findEmpAllDetailsByEno(int no);
	
	//--->retreving single colmn value of a single record
	@Query("select esal from EmployeeDetails where ename=:name")
	public float findSalByEname(String name);
	
	//---->HQL/JPQL Aggregate functions
	@Query("select count(*) from EmployeeDetails")
	public int getEmpCount();
	
	@Query("select COUNT(*),MAX(esal),MIN(esal),AVG(esal) from EmployeeDetails")
	public Object  getEmpAggregateData();
	
	//--->HQL/JPQL NON SELECT OPERATIONS
	@Query("update EmployeeDetails set esal=esal+:incrementamnt where esal<=:sal")
	@Modifying
	@Transactional
	public int updateEmpByEsal(float sal,float incrementamnt);
	
	
	@Query("delete from EmployeeDetails where eadd is null")
	@Modifying
	@Transactional
	public int deleteEmpWithNullAddrs();
	
	//-->native sql @Query methods
	 @Query(value="SELECT SYSDATE  FROM DUAL",nativeQuery=true)
	    public  String  getSysDate();
	 
	 @Transactional
	 @Modifying
	 @Query(value="insert into Employee_Details(eno,eadd,ename,esal) values(:no,:addrs,:name,:sal)",nativeQuery=true)
	 public int insertIntoEmployeeDetails(int no,String addrs,String name,float sal);
	
}
