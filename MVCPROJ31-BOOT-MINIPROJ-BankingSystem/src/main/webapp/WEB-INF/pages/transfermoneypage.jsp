<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<center>
<h1>Funds Transfer Page::</h1>
<frm:form modelAttribute="tm" action="transfernow" method="post">
<table style="color:cyan">
<tr>
<td>From Account Number:</td>
<td><frm:input path="fromaccount"/></td>
</tr>
<tr>
<td>To Account Number:</td>
<td><frm:input path="toaccount"/></td>
</tr>
<tr>
<td>Amount to be Transfered:</td>
<td><frm:input path="amount"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="transfernow"/></td>
</tr>
</table>
</frm:form>
</center>