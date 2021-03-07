package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Department_table")
@Getter
@Setter
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptno;
	@Column(length = 20)
	private String deptname;
	@Column(length = 20)
	private String deptloc;
	@OneToMany(targetEntity = Employee123.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_no",referencedColumnName = "deptno")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Employee123> emps;
	
	public Department() {
		System.out.println("Department:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptno + ", deptName=" + deptname + ", deptLocation=" + deptloc + "]";
	}

}
