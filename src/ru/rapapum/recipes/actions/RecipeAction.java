package ru.rapapum.recipes.actions;

import ru.rapapum.recipes.actions.exceptions.Error505;
import ru.rapapum.recipes.views.JspView;
import ru.rapapum.recipes.views.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 11:22
 */
public final class RecipeAction extends Action {
//    private static RecipeAction instance = new RecipeAction();
//    private RecipeAction() {}
//
//    public static RecipeAction getInstance() {
//        return instance;
//    }

    @Override
    protected View doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("first_param", "Parrot says:");
        params.put("second_param", "Parrot is fool");
        return new JspView("/WEB-INF/pages/recipes/show.jsp", getUrlParams(), params);
    }

    @Override
    protected View doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("_method");
        if ("put" == method) {
            return doPut(request, response);
        } else if ("delete" == method) {
            return doDelete(request, response);
        } else {
            throw new Error505();
        }
    }

    @Override
    protected View doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return super.doPut(request, response);
    }

    @Override
    protected View doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return super.doDelete(request, response);
    }
}
