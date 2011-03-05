package ru.rapapum.recipes.views;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 12:13
 */
public final class JspView implements View {
    private Map<String, Object> viewParams;
    private Map<String, String> urlParams;
    private final String jspPath;

    public JspView(String jspPath) {
        this.jspPath = jspPath;
    }

    public JspView(String jspPath, Map<String, Object> params) {
        this(jspPath);
        this.viewParams = params;
    }

    public JspView(String jspPath, Map<String, String> urlParams, Map<String, Object> params) {
        this(jspPath, params);
        this.urlParams = urlParams;
    }

    @Override
    public void show(ServletContext ctx, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        if (urlParams != null) {
            ctx.setAttribute("urlParams", urlParams);
        }

        if (viewParams != null) {
            ctx.setAttribute("viewParams", viewParams);
        }
        
        ctx.getRequestDispatcher(jspPath).forward(request, response);
    }
}
