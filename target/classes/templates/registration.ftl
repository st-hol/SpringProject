<#import "/spring.ftl" as spring/>

<#import "fragments/unsheader.ftl" as uh/>


<@uh.page>
    <@spring.bind "user"/>
    <#if user?? && noErrors??>
        Your submitted data<br>
        First name: ${user.firstName}<br>
        Last name: ${user.lastName}<br>
        Email: ${user.email}<br>
    <#else>
        <form action="/registration" method="post">
            First name:<br>
            <@spring.formInput "user.firstName"/>
            <@spring.showErrors "<br>"/>
            <br><br>
            Last name:<br>
            <@spring.formInput "user.lastName"/>
            <@spring.showErrors "<br>"/>
            <br><br>
            Email:<br>
            <@spring.formInput "user.email"/>
            <@spring.showErrors "<br>"/>
            <br><br>
            Password:<br>
            <@spring.formInput "user.password"/>
            <@spring.showErrors "<br>"/>
            <br><br>
            confirmPassword:<br>
            <@spring.formInput "user.passwordConfirm"/>
            <@spring.showErrors "<br>"/>

            <input type="submit" value="Submit">
        </form>
    </#if>
<#--    </#if>-->
<#--    <div class="container">-->
<#--        <#if message?has_content>-->
<#--            <div class="mess"><@spring.message "message"/></div>-->
<#--        </#if>-->
<#--        <form modelAttribute="user" method="POST" action="/registration">-->
<#--            <h2 class="form-signin-heading">Create your account</h2>-->

<#--            <div class="col-lg-12 input-group-text">-->
<#--                <label>-->
<#--                    Name:-->
<#--                    <input type="text" name="firstName" required/>-->
<#--                </label>-->
<#--            </div>-->

<#--            <div class="col-lg-12 input-group-text">-->
<#--                <label>-->
<#--                    Surname:-->
<#--                    <input type="text" name="lastName" required/>-->
<#--                </label>-->
<#--            </div>-->

<#--            <div class="col-lg-12 input-group-text">-->
<#--                <label>-->
<#--                    Email:-->
<#--                    <input type="email" name="email" required/>-->
<#--                </label>-->
<#--            </div>-->

<#--            <div class="col-lg-12 input-group-text">-->
<#--                <label>-->
<#--                    Password:-->
<#--                    <input type="number" name="password" required/>-->
<#--                </label>-->
<#--            </div>-->

<#--            <div class="col-lg-12 input-group-text">-->
<#--                <label>-->
<#--                    confirmPassword:-->
<#--                    <input type="number" name="passwordConfirm" required/>-->
<#--                </label>-->
<#--            </div>-->


<#--            <div class="col-lg-12 input-group-text">-->
<#--                <label>-->
<#--                    Role(0-inspector, 1-client)-->
<#--                    <input type="number" name="role" required/>-->
<#--                </label>-->
<#--            </div>-->

<#--            <#if error?has_content>-->
<#--                <div class="mess"><@spring.message "error"/></div>-->
<#--            </#if>-->


<#--            <button class="btn btn-lg btn-primary btn-block" type="submit"><@spring.message "submit"/></button>-->
<#--        </form>-->

<#--    </div>-->


</@uh.page>


<#--    <h1><@spring.message "registration"/></h1>-->
<#--    <form action="/registration" method="post">-->
<#--        <div class="container">-->
<#--            <div class="row">-->
<#--                <div class="col-lg-12 inputf">-->
<#--                    <#if nulogin?has_content>-->
<#--                        <div class="mess" ><@spring.message "${nulogin!}"/></div>-->
<#--                    </#if>-->

<#--                    <#if loginerr?has_content>-->
<#--                        <div class="mess" ><@spring.message "${loginerr!}"/></div>-->
<#--                    </#if>-->
<#--                    <label><h3><@spring.message "login"/></h3><input type="text" name="username" required/></label>-->
<#--                </div>-->
<#--                <div class="col-lg-12 inputf">-->
<#--                    <#if passerr?has_content>-->
<#--                        <div class="mess" ><@spring.message "${passerr!}"/></div>-->
<#--                    </#if>-->
<#--                    <label><h3><@spring.message "password"/></h3><input type="password" name="password" required/></label>-->
<#--                </div>-->
<#--                <div class="col-lg-12 inputf">-->
<#--                    <label><h3>Age</h3><input type="number" name="age" required/></label>-->
<#--                </div>-->
<#--                <div class="col-lg-12 inputf">-->
<#--                    <label><h3>Height</h3><input type="number" name="height" required/></label>-->
<#--                </div>-->
<#--                <div class="col-lg-12 inputf">-->
<#--                    <label><h3>Weight</h3><input type="number" name="weight" required/></label>-->
<#--                </div>-->
<#--                <div class="col-lg-12 inputf">-->
<#--                    <h3>Sex</h3>-->
<#--                    <label><input type="radio" name="sex" value="Man" checked/>Man</label>-->
<#--                    <label><input type="radio" name="sex" value="Woman"/>Woman</label>-->
<#--                </div>-->
<#--                <div class="col-lg-12 inputf">-->
<#--                    <h3>Lifestyle</h3>-->
<#--                    <label><input type="radio" name="lifeStyle" value="Sitting" checked/>Sitting</label>-->
<#--                    <label><input type="radio" name="lifeStyle" value="LowActivity" />Low Activity</label>-->
<#--                    <label><input type="radio" name="lifeStyle" value="NormalActivity" />Normal Activity</label>-->
<#--                    <label><input type="radio" name="lifeStyle" value="HighActivity" />High Activity</label>-->
<#--                    <label><input type="radio" name="lifeStyle" value="Sportsman"/>Sportsman</label>-->
<#--                </div>-->


<#--                <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--                <input type="submit" class="col-lg-6 offset-3" value="<@spring.message "submit"/>"/></div>-->
<#--        </div>-->
<#--    </form>-->

