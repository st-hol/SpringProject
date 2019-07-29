<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="${pageContext.request.contextPath}/welcome">
            <fmt:message key="tax.report"/>
        </a>

        <div>
            <ul class="navbar-nav text-uppercase ml-auto">
                <li class="nav-item en-icon" style="margin-left: 0 !important;">
                    <a class="nav-link" href="?sessionLocale=en">
                        <img class="lang-icon" src="${pageContext.request.contextPath}/resources/image/eng.png"
                             alt="<fmt:message key="lang.en"/>">

                    </a>
                </li>

                <li class="nav-item ua-icon">
                    <a class="nav-link" href="?sessionLocale=ua">
                        <img class="lang-icon" src="${pageContext.request.contextPath}/resources/image/ukr.png"
                             alt="<fmt:message key="lang.ua"/>">

                    </a>
                </li>


                <li class="nav-item logout-btn">
                    <a class="btn btn-primary my-2 my-sm-0" href="${pageContext.request.contextPath}/logout" type="submit">
                        <i class="fa fa-sign-out"></i>
                        <fmt:message key="log.out"/>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>