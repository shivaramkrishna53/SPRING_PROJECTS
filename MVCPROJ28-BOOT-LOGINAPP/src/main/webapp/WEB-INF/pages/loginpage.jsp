<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color:red;text-align:center">Login Page</h1>
<frm:form modelAttribute="emp" method="post" action="login">
<center>
<table style="background-color: cyan">
<tr>
<td>UserName:</td>
<td><frm:input path="username"/></td>
</tr>
<tr>
<td>Password:</td>
<td><frm:input path="password"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="login"></td>
</tr>
</table>
</frm:form>