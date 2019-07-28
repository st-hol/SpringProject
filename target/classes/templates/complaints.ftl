<#import "fragments/header.ftl" as c>
<#import "/spring.ftl" as spring/>

<@c.page>
    <h1>list compl</h1>
    <table>
        <tr>
            <td>person</td>
            <td>content</td>
            <td>time</td>
        </tr>
        <#list complaints as complaint>
            <tr>
                <td>${complaint.user.id}</td>
                <td>${complaint.content}</td>
                <td>${complaint.completionTime}</td>
            </tr>
        </#list>
    </table>



    <a href="/logout">outlog</a>

<#--    <form action="/complaints/edit/" method="post">-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}">-->
<#--        <input type="hidden" name="id" value="${complaint.id}">-->
<#--        <td><button type="submit" name="confirm" value="true">Confirm</button></td>-->
<#--        <td><button type="submit" name="confirm" value="false">Reject</button></td>-->
<#--    </form>-->
</@c.page>