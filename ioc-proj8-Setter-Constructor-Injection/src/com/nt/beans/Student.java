package com.nt.beans;

public class Student {
	private int sid;
	private String sname;
	private float savg;
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setSavg(float savg) {
		this.savg = savg;
	}

	public Student(int sid, String sname, float savg) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.savg = savg;
	}
	public void displayDetails()
	{
		System.out.println(sid+"  "+sname+"   "+savg);
	}
}
