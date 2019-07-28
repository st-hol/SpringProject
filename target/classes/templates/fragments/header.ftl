<#import "/spring.ftl" as spring/>
<#macro page>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>qwe</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/static/css/main.css">
        <link rel="stylesheet" type="text/css" href="/static/css/bootstrap-grid.css">
    </head>

    <header>
        <div class="container">
            <div class="row">
                <a class="col-lg-3 mypage" href="/userpage">MyPage</a>
                <div class="langc col-lg-2 offset-5">
                    <a href="?lang=ua"><@spring.message "lang.ukr"/></a>
                    <a href="?lang=eng"><@spring.message "lang.eng"/></a>
                </div>
                <a href="/logout">logout</a>
            </div>
        </div>
    </header>


    <body>
    <#if !(__user??)>
        <a class="p-2" href="#" data-toggle="modal" data-target="#signinModal">Sign in</a>
    <#else>
        <span class="badge badge-secondary">${__user.getName()}</span>
    </#if>
    <#nested>
    </body>
    </html>
</#macro>