<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<center>
<h1 style="color:pink">USER SIGNUP PAGE</h1>
<frm:form modelAttribute="usd" action="saveregistration" method="post">
<table style="text-align:center; background-color: cyan">
<tr>
<td>First Name:</td>
<td><frm:input path="firstname"/></td>
</tr>
<tr>
<td>Last Name:</td>
<td><frm:input path="lastname"/></td>
</tr>
<tr>
<td>Phone Number:</td>
<td><frm:input path="phonenumber"/></td>
</tr>
<tr>
<td>Address:</td>
<td><frm:input path="address"/></td>
</tr>
<tr>
<td>Email id:</td>
<td><frm:input path="emailid"/></td>
</tr>
<tr>
<center><td colspan="2"><input type="submit" value="Register Customer"></td></center>
</tr>
</table>
</frm:form>
</center>