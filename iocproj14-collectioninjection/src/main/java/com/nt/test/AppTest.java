package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.CollegeInfoListInjection;
import com.nt.beans.EmployeeInfo;
import com.nt.beans.PhoneNumbers;
import com.nt.beans.UniversityInfo;

/**
 * Hello world!
 *
 */
public class AppTest 
{
    public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/config/applicationContext.xml");
        EmployeeInfo e=ctx.getBean("emp", EmployeeInfo.class);
        e.printvalues();
        CollegeInfoListInjection ci=ctx.getBean("col", CollegeInfoListInjection.class);
        ci.printvalues();
        PhoneNumbers pn=ctx.getBean("ph", PhoneNumbers.class);
        pn.printvalues();
        UniversityInfo ui=ctx.getBean("uni", UniversityInfo.class);
        ui.printvalues();
    }
}
