<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"  %>
<h1 style="color:green;text-align:center">Student Registration Form</h1>
<f:form modelAttribute="stud" action="student" method="post">
<table>
<tr>
<td>StudentNumber:</td>
<td>
<f:input path="sno"/>
</td>
</tr>
<tr>
<td>StudentName::</td>
<td><f:input path="sname"/> </td>
</tr>
<tr>
<td>StudentAddress::</td>
<td><f:input path="sadd"/>
</tr>
<tr>
<td>StudentAverage::</td>
<td><f:input path="savg"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="submit" value="register"/></td>
</tr>
</table>
</f:form>