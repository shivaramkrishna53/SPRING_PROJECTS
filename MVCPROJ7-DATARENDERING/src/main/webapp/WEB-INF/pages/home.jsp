<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
name::${name}
<br>
age::${age}
<br>
address::${address}
<br>
ListNames::${names}
<br>
SetPhones::${phones}
<br>
MapDetails::${details }
<br>
String[]::
<%=Arrays.toString((String[])request.getAttribute("colors")) %>

<% for(String color:(String[])request.getAttribute("colors"))
	out.print(color+"-------");	
%>
<br>
<c:forEach var="color" items="${colors}" >
${color}

</c:forEach>
<br>
${empdto}

<br>
${empdto.ename}
<br>
${lstempdto}
<br>
<br>

<c:forEach var="dto" items="${lstempdto}">
${dto }
<br>
</c:forEach>
