package ru.rapapum.recipes.actions.form.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 19:21
 */
public class AsList extends TagSupport {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("Welcome tp JSP tag Programming, " + name);
        } catch (IOException ioe) {
            throw new JspException("Error: IOException while writing to client");
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return SKIP_PAGE;
    }
}
