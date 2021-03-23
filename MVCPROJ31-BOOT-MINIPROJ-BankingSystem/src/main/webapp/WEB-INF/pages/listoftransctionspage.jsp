<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<center>
List of Transction Details:

<c:choose>
<c:when test="${!empty depositslst}">

List of Deposits:
<table>
<tr>
<th>From AccountNo:</th>
<th>To AccountNo:</th>
<th>Credited Amount:</th>
<th>Date of Credit:</th>
</tr>
<c:forEach var="depo" items="${depositslst}">
<tr>
<td>${depo.frmaccno}</td>
<td>${depo.toaccno}</td>
<td>${depo.creditedamount}</td>
<td>${depo.dateofcredit}</td>
</tr>
</c:forEach>
</table>
</c:when>
</c:choose>

<c:choose>
<c:when test="${!empty withdrawslst}">
List of Withdraws:
<table>
<tr>
<th>From AccountNo:</th>
<th>To AccountNo:</th>
<th>Credited Amount:</th>
<th>Date of Credit:</th>
</tr>
<c:forEach var="with" items="${withdrawslst}">
<tr>
<td>${with.frmaccno}</td>
<td>${with.toaccno}</td>
<td>${with.debitedamount}</td>
<td>${with.dateofdebit}</td>
</tr>
</c:forEach>
</table>
</c:when>

</c:choose>
</center>