<#import "/spring.ftl" as spring/>
<#import "fragments/unsheader.ftl" as uh/>

<@uh.page>

    <div class="container">
        <form method="POST" action="/login" class="form-signin">
            <h2 class="form-heading">Log in</h2>

            <div class="form-group">

                <#if message?has_content>
                    <div class="mess"><@spring.message "error"/></div>
                </#if>

                <input name="username" type="text" class="form-control" placeholder="Username"
                       autofocus="true"/>
                <input name="password" type="password" class="form-control" placeholder="Password"/>

                <#if error?has_content>
                    <div class="mess"><@spring.message "error"/></div>
                </#if>

<#--                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            </div>
        </form>
        <h4 class="text-center"><a href="/registration">Create an account</a></h4>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>

</@uh.page>



<#--<#import "parts/login.ftl" as l>-->
<#--<#import "parts/unsheader.ftl" as c>-->
<#--<#import "/spring.ftl" as spring/>-->
<#--<@c.page>-->
<#--    <h1><@spring.message "login"/></h1>-->
<#--&lt;#&ndash;    <#if error>&ndash;&gt;-->
<#--&lt;#&ndash;        <div class="mess"><@spring.message "error"/></div>&ndash;&gt;-->
<#--&lt;#&ndash;    </#if>&ndash;&gt;-->
<#--&lt;#&ndash;    <#if logout>&ndash;&gt;-->
<#--&lt;#&ndash;        <div class="mess"><@spring.message "logged.out"/></div>&ndash;&gt;-->
<#--&lt;#&ndash;    </#if>&ndash;&gt;-->
<#--    <form action="/login" method="post">-->
<#--        <div class="container">-->
<#--            <div class="row">-->
<#--                <div class="col-lg-12 inputf">-->
<#--&lt;#&ndash;                    <#if nulogin?has_content>&ndash;&gt;-->
<#--&lt;#&ndash;                        <div class="mess" ><@spring.message "${nulogin!}"/></div>&ndash;&gt;-->
<#--&lt;#&ndash;                    </#if>&ndash;&gt;-->

<#--&lt;#&ndash;                    <#if loginerr?has_content>&ndash;&gt;-->
<#--&lt;#&ndash;                        <div class="mess" ><@spring.message "${loginerr!}"/></div>&ndash;&gt;-->
<#--&lt;#&ndash;                    </#if>&ndash;&gt;-->
<#--                    <label><h3><@spring.message "login"/></h3><input type="text" name="username"/></label>-->
<#--                </div>-->
<#--                <div class="col-lg-12 inputf">-->
<#--&lt;#&ndash;                    <#if passerr?has_content>&ndash;&gt;-->
<#--&lt;#&ndash;                        <div class="mess" ><@spring.message "${passerr!}"/></div>&ndash;&gt;-->
<#--&lt;#&ndash;                    </#if>&ndash;&gt;-->
<#--                    <label><h3><@spring.message "password"/></h3><input type="password" name="password"/></label>-->
<#--                </div>-->

<#--                <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--                <input type="submit" class="col-lg-6 offset-3" value="<@spring.message "submit"/>"/></div>-->
<#--        </div>-->
<#--    </form>-->
<#--    <h2><@spring.message "dont.have.acc"/><a href="/registration"> <@spring.message "registration"/></a> </h2>-->
<#--</@c.page>-->
