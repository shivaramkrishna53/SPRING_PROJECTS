<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f" %>

<f:form modelAttribute="cust" action="customer">
<h1 style="color:green;text-align:center">Customer Registration Page</h1>
<table border="2" color:cyan align:center>
<tr>
<td>Customer Name::</td>
<td><f:input path="cname"/><f:errors path="cname"/></td>
</tr>
<tr>
<td>Customer Address::</td>
<td><f:input path="cadd"/><f:errors path="cadd" /></td>
</tr>
<tr>
<td>Bill Amount::</td>
<td><f:input path="billamnt"/><f:errors path="billamnt"/></td>
</tr>
<tr>
<td colspan="2" ><input type="submit" value="register"/></td>
</tr>
</table>
</f:form>