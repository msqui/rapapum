package ru.rapapum.recipes.actions.errors;

import ru.rapapum.recipes.actions.Action;
import ru.rapapum.recipes.views.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 13:45
 */
public abstract class ErrorAction extends Action {
    protected abstract View processRequest(HttpServletRequest request, HttpServletResponse response);

    @Override
    protected final View doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return processRequest(request, response);
    }

    @Override
    protected final View doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return processRequest(request, response);
    }

    @Override
    protected final View doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return processRequest(request, response);
    }

    @Override
    protected final View doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return processRequest(request, response);
    }
}
