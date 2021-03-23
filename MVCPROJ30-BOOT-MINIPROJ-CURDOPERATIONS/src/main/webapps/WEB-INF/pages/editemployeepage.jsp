<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<frm:form modelAttribute="emp" method="post" action="updateemployee">
<center>
<table style="background-color: cyan">
<tr>
<td>Employee Number:</td>
<td><frm:input path="eno" readonly="true"/></td>
</tr>
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
<td colspan="2"><center><input type="submit" value="update the record"></center></td>
</tr>
</table>
</center>
</frm:form>
