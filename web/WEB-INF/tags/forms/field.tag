<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="target" required="true" type="ru.rapapum.recipes.actions.form.fields.FormField" %>
<%@ attribute name="id" required="false" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="name" required="false" %>

<c:if test="${empty name}">
    <c:set var="name" value="${target.name}" />
</c:if>
<c:if test="${empty id}">
    <c:set var="id" value="${name}-id" />
</c:if>

<c:if test="${not empty target.errors}">
    <ul class="field_error_list">
        <c:forEach var="errorString" items="${target.errors}">
            <li><span>${errorString}</span></li>
        </c:forEach>
    </ul>
</c:if>

<c:if test="${not empty label}">
    <label for="${id}">${label}</label>
</c:if>