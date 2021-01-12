package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.dto.JobSeekerDto;
import com.nt.service.IjobSer;
import com.nt.service.JobSeekerImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaProj11WorkingWithLobApplication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj11WorkingWithLobApplication.class, args);
	    IjobSer ser=ctx.getBean("jobser",JobSeekerImpl.class);
	    try {
	    //read the input params
	    
	    System.out.println("Enter the job seeeker name::");
	    String name=sc.next();
	    System.out.println("Enter the job seeker qulfy");
	    String qlyf=sc.next();
	    System.out.println("Enter the Location of the job seekers photo");
	    String photoloc=sc.next();
	    System.out.println("Enter the Location of the job seekers resume");
	    String resumeloc=sc.next();
	    //copying the content to the variables using streams and readers
	    
	    //for photo
	    //file represting the photo location
	    File f=new File(photoloc);
	    //input stream represting the file, i.e to read the data from the file
	    InputStream is=new FileInputStream(f);
	    //create a new byte[] 
	    byte[] newphoto=new byte[(int) f.length()];
	    //copy the content of the stream to byte[]
	    is.read(newphoto);
	    
	    //for resume
	    File file=new File(resumeloc);
	    FileReader rdr=new FileReader(file);
	    char[] newresume=new char[(int) file.length()];
	    rdr.read(newresume);
	    JobSeekerDto dto=new JobSeekerDto();
	    dto.setJsname(name);
	    dto.setJsqlyf(qlyf);
	    dto.setPhoto(newphoto);
	    dto.setResume(newresume);
	   System.out.println( ser.registerJobSekker(dto));
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}

}
