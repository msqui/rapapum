package ru.rapapum.recipes.dispatcher;

import ru.rapapum.recipes.actions.Action;
import ru.rapapum.recipes.actions.ActionFactory;
import ru.rapapum.recipes.actions.errors.Action404;
import ru.rapapum.recipes.actions.errors.Action505;
import ru.rapapum.recipes.actions.exceptions.Error404;
import ru.rapapum.recipes.actions.exceptions.Error505;
import ru.rapapum.recipes.views.View;
import ru.rapapum.rest.RestMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 26/02/11
 * Time: 12:08
 */
public final class RecipesDispatcherServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(RestMethods.POST, request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(RestMethods.GET, request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(RestMethods.PUT, request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(RestMethods.DELETE, request, response);
    }

    private void processRequest(RestMethods method, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Action action = ActionFactory.dispatch(method, request);
            View view = action.execute(method, request, response);
            view.show(getServletContext(), request, response);
        } catch (Error404 e) {
            View view = Action404.getInstance().execute(method, request, response);
            view.show(getServletContext(), request, response);
        } catch (Error505 e) {
            View view = Action505.getInstance().execute(method, request, response);
            view.show(getServletContext(), request, response);
        }
    }
}
