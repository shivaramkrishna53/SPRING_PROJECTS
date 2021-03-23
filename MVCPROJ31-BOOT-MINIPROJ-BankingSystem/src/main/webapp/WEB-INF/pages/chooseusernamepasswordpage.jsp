<h1 style="color:pink;text-align: center">Please Select the Username and Password for your account:</h1>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 style="color:green;text-align:center">Your's Generated Account Number is:${result}</h3></blink><center>
<frm:form modelAttribute="usercre" action="saveusercredentials" method="post">
<table style="background-color: pink">
<tr>
<td>Account Number:</td>
<td><frm:input path="accountnumber" readonly="true"/></td>
</tr>
<tr>
<td>User Name:</td>
<td><frm:input path="username"/></td>
</tr>
<tr>
<td>Password:</td>
<td><frm:input path="password"/></td>
</tr>
<tr>
<td>Re-enter Password</td>
<td><frm:input path="repassword"/></td>
</tr>
<tr>
<td colspan="2" style="text-align:center"><input type="submit" value="submit"/></td></center>
</tr>
</table>
<h1 style="color:red">${mismatch}</h1>
</center>
</frm:form>