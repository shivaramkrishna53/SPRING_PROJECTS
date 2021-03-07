<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<f:form  modelAttribute="stud">  <!-- by default form gives post mode request..if no action url is given it takes previously requested url path(i.e student) -->
<table bgcolor="cyan" align="center" border="3">
<tr>
<td>Student Sno::</td>
<td><f:input path="sno"/></td>
</tr>
<tr>
<td>Student Sname::</td>
<td><f:input path="sname"/></td>
</tr>
<tr>
<td>Student Saddrs::</td>
<td><f:input path="sadd"/></td>
</tr>
<tr>
<td>Student Avg::</td>
<td><f:input path="savg"/></td>
</tr>
<tr >
<td colspan="2"><input type="submit" name="submit" value="register"/></td>
</tr>
</table>
</f:form>

