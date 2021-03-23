<h1 style="color:green;text-align:center">Employee Registration Form</h1>
<%@taglib uri="http://www.springframework.org/tags" prefix="sprng"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<frm:form modelAttribute="emp">
<center>
<table style="background-color:cyan"> 
<tr>
<td>Employee Name:</td>
<td><frm:input path="ename"/></td>
</tr>
<tr>
<td>Employee Address:</td>
<td><frm:input path="eadd"/></td>
</tr>
<tr>
<td>Employee Salary:</td>
<td><frm:input path="esal"/></td>
</tr>
<tr>
<td colspan="2"><center><input type="submit" value="register"></center></td>
</tr>
</table>
</center>
</frm:form>