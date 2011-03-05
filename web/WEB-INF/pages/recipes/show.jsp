<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:common>
    <jsp:attribute name="title">Show</jsp:attribute>

    <jsp:attribute name="content">
        <p>
            We will show you recipe
        </p>
        <p>
            <span>${viewParams['first_param']}</span>
            <span>${viewParams['second_param']}</span>
        </p>

        <p>
            Url param "id":
            <span>${urlParams['id']}</span>
        </p>
    </jsp:attribute>
</t:common>
