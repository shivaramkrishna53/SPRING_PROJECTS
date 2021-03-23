<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<center>
<h1 style="color:green">Enter Your Login Credentials:</h1>
<frm:form modelAttribute="ulog" action="validateulogin" method="post">
<table style="background-color: cyan">
<tr>
<td>Account Number:</td>
<td><frm:input path="accountnumber"/>
</tr>
<tr>
<td>UserName:</td>
<td><frm:input path="username"/>
</tr>
<tr>
<td>Password:</td>
<td><frm:input path="password"/>
</tr>
<tr colspan=2>
<td style="text-align: center"><input type="submit" value="login"/></td>
</tr>
</table>
</frm:form>
<h1 style="color:red">${result}</h1>
</center>
