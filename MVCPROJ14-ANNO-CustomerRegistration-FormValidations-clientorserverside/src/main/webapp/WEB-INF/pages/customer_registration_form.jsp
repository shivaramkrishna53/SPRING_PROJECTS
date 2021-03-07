<%@page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script language="JavaScript" src='<c:url value="/myresources/js/val.js"/>'>

</script>
<noscript >
     <h1 style="color:red;text-align:center"> Enable Java script </h1>
  </noscript> 
  <style>
  span
  {
  color:red;
  }
</style>
<f:form modelAttribute="cust" action="customer" onsubmit="return validate(this)">
<h1 style="color:green;text-align:center">Customer Registration Page</h1>
<table border="2" color:cyan align="center">
<tr>
<td>Customer Name::</td>
<td><f:input path="cname"/><span id="cname_err"><f:errors path="cname"/></td>
</tr>
<tr>
<td>Customer Address::</td>
<td><f:input path="cadd"/><span id="cadd_err"><f:errors path="cadd"/></td>
</tr>
<tr>
<td>Bill Amount::</td>
<td><f:input path="billamnt"/><span id="billamnt_err"><f:errors path="billamnt"/></td>
</tr>
<tr>
<td colspan="2" ><input type="submit" value="register"/></td>
</tr>
</table>
<f:hidden path="vflag"/>
</f:form>