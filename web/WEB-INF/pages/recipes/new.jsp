<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--<%@ taglib prefix="form" uri="/WEB-INF/taglibs/forms.tld" %>--%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/forms" %>

<t:common>
    <jsp:attribute name="title">New</jsp:attribute>

    <jsp:attribute name="content">
        <p>New recipe</p>

        <%--<jsp:include page="_form.jsp"/>--%>
        <%--${viewParams["form"].to_list()}--%>
        <%--<form:asList name="Parrot" />--%>

        <%--<form:asList form='${viewParams["form"]}' />--%>

        <jsp:include page="_form.jsp" />

    </jsp:attribute>

</t:common>