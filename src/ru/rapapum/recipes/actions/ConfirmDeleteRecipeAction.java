package ru.rapapum.recipes.actions;

import ru.rapapum.recipes.views.JspView;
import ru.rapapum.recipes.views.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 11:23
 */
public final class ConfirmDeleteRecipeAction extends Action {
//    private static ConfirmDeleteRecipeAction instance = new ConfirmDeleteRecipeAction();
//    private ConfirmDeleteRecipeAction() {}
//
//    public static ConfirmDeleteRecipeAction getInstance() {
//        return instance;
//    }

    @Override
    protected View doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new JspView("/WEB-INF/pages/recipes/delete.jsp");
    }
}
