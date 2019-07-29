<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>



<div class="col-md-3">
    <div class="profile-sidebar position-fixed">
        <h5 class="text-primary">
            <fmt:message key="label.inspector"/>
        </h5>
        <!-- SIDEBAR MENU -->
        <div class="profile-usermenu sidebar-sticky">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/inspector/check-report" class="nav-link active">
                        <i class="fa fa-home"></i>
                        <fmt:message key="check.reports"/>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/inspector/set-taxable" class="nav-link active">
                        <i class="fa fa-home"></i>
                        <fmt:message key="set.taxable"/>
                    </a>
                </li>
            </ul>
        </div>
        <!-- END MENU -->
    </div>
</div>