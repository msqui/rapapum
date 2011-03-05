<%@ attribute name="title" fragment="true" %>
<%@ attribute name="head" fragment="true" %>
<%@ attribute name="content" fragment="true" %>

<html>
    <head>
        <title>Rapapum <jsp:invoke fragment="title"/></title>
        <jsp:invoke fragment="head"/>
    </head>
    <body>
        <div id="content">
            <jsp:invoke fragment="content"/>
        </div>
    </body>
</html>