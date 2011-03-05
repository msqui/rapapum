package ru.rapapum.recipes.actions.errors;

import ru.rapapum.recipes.views.ErrorView;
import ru.rapapum.recipes.views.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 13:24
 */
public final class Action404 extends ErrorAction {
    private static final Action404 ourInstance = new Action404();

    public static Action404 getInstance() {
        return ourInstance;
    }

    private Action404() {}

    @Override
    protected View processRequest(HttpServletRequest request, HttpServletResponse response)
            {
        return new ErrorView(HttpServletResponse.SC_NOT_FOUND);
    }
}
