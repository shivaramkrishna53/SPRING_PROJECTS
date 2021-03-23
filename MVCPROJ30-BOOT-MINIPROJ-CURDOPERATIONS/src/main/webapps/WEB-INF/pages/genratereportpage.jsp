<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color:greeen;text-align:center">Employee Report</h1>
<c:choose>
<c:when test="${!empty empslist}">
<table style="background-color:cyan">
<tr>
<th>Employee Number</th>
<th>Employee Name</th>
<th>Employee Address</th>
<th>Employee Salary</th>
<th>Employee Edit</th>
<th>Employee Delete</th>
</tr>
<c:forEach  var="emp" items="${empslist}">
<tr>
<td>${emp.eno}</td>
<td>${emp.ename }</td>
<td>${emp.eadd }</td>
<td>${emp.esal }</td>
<td>
<a href="edit?no=${emp.eno}"> <img src="images/editimg.jpg" width="50px" height="50px"></a>
</td>
<td>
<a href="delete?no=${emp.eno}" onclick="return confirm('do you want to delete?')"><img  src="images/deleteimg.jpg" width="50px" height="50px"></a>
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">No Employee Records Found</h1>
</c:otherwise>
</c:choose>
<h3 style="color:green;text-align:center">${resultMsg}</h3></blink>