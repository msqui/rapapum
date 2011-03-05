package ru.rapapum.recipes.views;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 15:07
 */
public final class ErrorView implements View {
    private final int errorCode;

    public ErrorView(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public void show(ServletContext ctx, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.sendError(errorCode);
    }
}
