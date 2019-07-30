<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>
        <fmt:message key="see.all.reports"/>
    </title>
    <meta name="viewport" content="width=device-width"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/report-list.css"/>
</head>
<body>

<div class="table-cont">
    <table class="responstable" border="1" cellpadding="3" cellspacing="3">
        <tr>

            <th>person id</th>
            <th><fmt:message key="placeholder.company.name"/></th>
            <th><fmt:message key="placeholder.taxpayer.code"/></th>
            <th><fmt:message key="completion.time"/></th>
            <th><fmt:message key="total.amount"/></th>
            <th><fmt:message key="is.accepted"/></th>
            <th><fmt:message key="should.change"/></th>
            <th><fmt:message key="insp.comment"/></th>
            <th>check?</th>
        </tr>

        <c:forEach var="report" items="${reports}">
            <tr>
                <td><c:out value="${report.person.id}"/></td>
                <td><c:out value="${report.companyName}"/></td>
                <td><c:out value="${report.taxpayerCode}"/></td>
                <td><c:out value="${report.completionTime}"/></td>
                <td><c:out value="${report.totalAmountOfProperty}"/></td>
                <td><c:out value="${report.accepted}"/></td>
                <td><c:out value="${report.shouldBeChanged}"/></td>
                <td><c:out value="${report.inspectorComment}"/></td>
                <td><a href="${pageContext.request.contextPath}/inspector/check-report/${report.id}">check</a></td>
            </tr>
        </c:forEach>
    </table>


    <br>
    <div class="home">
        <a class="" href="${pageContext.request.contextPath}/personal-cabinet">
            <fmt:message key="back.to.cabinet"/>
        </a>
    </div>
</div>


</body>
</html>










