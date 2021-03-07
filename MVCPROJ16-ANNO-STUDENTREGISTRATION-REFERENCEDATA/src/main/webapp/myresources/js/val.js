function validate(frm)
{
	document.getElementById("cname_err").innerHTML="";
	document.getElementById("cadd_err").innerHTML="";
	document.getElementById("billamnt_err").innerHTML="";
	
	let name=frm.cname.value;
	let addrs=frm.cadd.value;
	let bill=frm.billamnt.value;
	let flag=true;
	
	if(name.length==0)
	{
		document.getElementById("cname_err").innerHTML="Customer Name Cannot be Empty";
		flag=false;
	}
	else
	if(name.length<5)
	{
		document.getElementById("cname_err").innerHTML="Customer Name Cannot be less than 5 characters";
		flag=false;
	}
	
	if(addrs.length==0)
	{
		document.getElementById("cadd_err").innerHTML="Customer Address Cannot be empty";
		flag=false;
	}
	else
	if(addrs.length<8)
	{
		document.getElementById("cadd_err").innerHTML="Customer Address Cannot be less than 8 characters";
		flag=false;
	}
	
	
	if(isNaN(bill))
	{
		document.getelgetElementById("billamnt_err").innerHTML="Customer bill should only be numeric";
		flag=false;
		
	}
	else
	if(bill.length==0)
	{
		document.getElementById("billamnt_err").innerHTML="Customer bill cannot be empty";
		flag=false;
	}
	else
	if(bill<=0)
	{
		document.getElementById("billamnt_err").innerHTML="Customer bill amount cannot be less than or equal to zero";
		flag=false;
	}
	
	
	
	frm.vflag.value="yes";
	
return flag;
}