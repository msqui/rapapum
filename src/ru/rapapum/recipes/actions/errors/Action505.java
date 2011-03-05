package ru.rapapum.recipes.actions.errors;

import ru.rapapum.recipes.views.ErrorView;
import ru.rapapum.recipes.views.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 13:50
 */
public final class Action505 extends ErrorAction {
    private static final Action505 ourInstance = new Action505();

    public static Action505 getInstance() {
        return ourInstance;
    }

    private Action505() {}

    @Override
    protected View processRequest(HttpServletRequest request, HttpServletResponse response)
            {
        return new ErrorView(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
