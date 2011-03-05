<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:common>
    <jsp:attribute name="title">Test</jsp:attribute>
    <jsp:attribute name="content">
        <p>
            Test text:
            <span>${viewParams['text']}</span>
        </p>

        <p>
            Params:
            <span>${param}</span>
        </p>
    </jsp:attribute>
</t:common>