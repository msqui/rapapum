<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/forms" %>

<c:set var="form" value="${viewParams['form']}" />

<ul>
    <%--<form action="/recipes" method="post">--%>
    <form action="" method="post">

        <c:if test="${not form.valid}">
            <ul>
                <li>Form is not valid</li>

                <c:forEach var="errorString" items="${form.errors}">
                    <li>${errorString}</li>
                </c:forEach>
            </ul>
        </c:if>

        <li>
            <field:textinput target="${form.fields['title']}" name="title" id="title-id" label="Title" />
        </li>

        <li>
            <field:textinput target="${form.fields['cook_time']}" name="cook_time" id="cook-time-id" label="Cook time" />
        </li>

        <li>
            <field:textinput target="${form.fields['ingredients_count']}" name="ingredients_count" id="ingredients-count-id" label="Ingredients count" />
        </li>

        <li>
            <field:textarea target="${form.fields['description']}" name="description" id="description-id" label="Description" />
        </li>

        <%--
        <li>
            <field:textinput target="${viewParams['form'].fields['f']}" name="cook-time" id="cook-time-id" />
        </li>
        --%>

        <%--
        <li>
            ${viewParams['form'].fields['title']}
        </li>
        --%>

        <%--
        <li>
            <label for="field_category">Category</label>
            <input type="text" name="category" id="field_category" value="Ogogo" />
        </li>

        <li>
            <label for="field_cook_time">Cook time</label>
            <input type="text" name="cook_time" id="field_cook_time" />
        </li>

        <li>
            <label for="field_complexity">Complexity</label>
            <input type="text" name="complexity" id="field_complexity" />
        </li>


        <li>
            <label for="field_title">Title</label>
            <input type="text" name="title" id="field_title" />
        </li>

        <li>
            <label for="field_description">Description</label>
            <textarea rows="10" cols="50" name="description" id="field_description"></textarea>
        </li>

        <li>
            <label for="field_ingredients">Ingredients</label>
            <textarea rows="10" cols="50" name="ingredients" id="field_ingredients"></textarea>
        </li>

        <li>
            <label for="field_instructions">Instructions</label>
            <textarea rows="10" cols="50" name="instructions" id="field_instructions"></textarea>
        </li>

        <li>
            <label for="field_rating">Rating</label>
            <input type="text" name="rating" id="field_rating" />
        </li>
        --%>

        <li>
            <input type="submit" value="Save" />
            <input type="reset" value="Clear" />
        </li>
    </form>
</ul>