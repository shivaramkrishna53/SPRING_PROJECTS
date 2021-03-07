<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
<c:when test="${!empty lstempdata }">
<table>
<tr>
<th>S.no</th>
<th>EmpNo</th>
<th>Ename</th>
<th>EmpAddress</th>
<th>EmpSalary</th> 
</tr>
<c:forEach var="emp" items="${lstempdata}">
<tr>
<td>${emp.sno}</td>
<td>${emp.eno}</td>
<td>${emp.ename}</td>
<td>${emp.eadd}</td>
<td>${emp.esal}</td>
</tr>

</c:forEach>

</table>


</c:when>

<c:otherwise>
<h1 style="color:red;text-align:center">NO RECORDS FOUND</h1>
</c:otherwise>

</c:choose>