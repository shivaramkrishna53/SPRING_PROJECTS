package com.nt.beans;

import java.util.Date;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
@Setter
@Getter
@ToString

public class Emp {
	private int eno;
	private String ename;
	private Dept dep;
	private String eadd;
	private Date dob;

}
