<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="userName" value="${pageContext.request.userPrincipal.name}"/>

<!DOCTYPE html>
<html>
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
        <c:if test="${userName != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <h2>
                Welcome ${pageContext.request.userPrincipal.name} | You are already logged in
                You can go to <a href="${contextPath}/personal-cabinet">personal cabinet</a>
                or <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            </h2>
        </c:if>
        <c:if test="${userName == null}">
                  <form method="POST" action="${contextPath}/login" class="form-signin">
                    <h2 class="form-heading">Log in</h2>

                    <div class="form-group ${error != null ? 'has-error' : ''}">
                        <span>${message}</span>
                        <input name="username" type="text" class="form-control" placeholder="Username"
                               autofocus="true"/>
                        <input name="password" type="password" class="form-control" placeholder="Password"/>
                        <span>${error}</span>
                        <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

                        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                        <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
                         <h4 class="text-center"><a href="${contextPath}/welcome">to main page</a></h4>
                    </div>
                  </form>
        </c:if>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
