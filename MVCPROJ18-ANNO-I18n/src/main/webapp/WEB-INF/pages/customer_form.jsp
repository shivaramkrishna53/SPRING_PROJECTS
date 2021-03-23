<%@ page  contentType="text/html; charset=UTF-8" isELIgnored="false"   %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color:red;text-align:center"><spring:message code="title"/></h1>
<form:form modelAttribute="cust">
<table border="2" bgcolor="cyan" align="center">
<tr>
<td><spring:message code="name"/></td>
<td><form:input path="name"/>
</tr>
<tr>
<td><spring:message code="address"/></td>
<td><form:input path="address"/>
</tr>
<tr>
<td><spring:message code="billamnt"/></td>
<td><form:input path="billamnt"/></td>
</tr>
<tr>
<td colspan="2" ><input type="submit" value="<spring:message code="submit"/>" ></td>
</tr>
</table>

</form:form>


<br>
<br>
<a href="?lang=hi_IN">हिन्दी</</<<<</</a><br>
<a href="?lang=fr_FR">française</a><br>
<a href="?lang=zh_CN">中國人</a><br>
<a href="?lang=ar_SA">عربي</a><br>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<b> current Locale is :: ${pageContext.response.locale} </b>

<fmt:setLocale value="${pageContext.response.locale}"/>
<fmt:formatNumber var="fsal" value="${salary }" type="currency"/>
<h1>salary is:${fsal }</h1>
<br>
<fmt:setLocale value="${pageContext.request.locale }"/>
<fmt:formatDate var="fdate" value="${sysdate }"/>
<h1>date is:${fdate }</h1>

<fmt:formatNumber type="percent" var="p" value="${salary }"></fmt:formatNumber>
<h1>percentage is: ${p}</h1>