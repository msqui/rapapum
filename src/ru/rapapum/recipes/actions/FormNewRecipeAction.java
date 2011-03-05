package ru.rapapum.recipes.actions;

import ru.rapapum.recipes.actions.form.Form;
import ru.rapapum.recipes.actions.form.RecipeForm;
import ru.rapapum.recipes.model.dao.RecipeDao;
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
public final class FormNewRecipeAction extends Action {
//    private static FormNewRecipeAction instance = new FormNewRecipeAction();
//    private FormNewRecipeAction() {}
//
//    public static FormNewRecipeAction getInstance() {
//        return instance;
//    }

    @Override
    protected View doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Form recipeForm = new RecipeForm();

        return showForm(recipeForm);
    }

    @Override
    protected View doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Form recipeForm = new RecipeForm();

        @SuppressWarnings("unchecked")
        Map<String, String[]> requestParameters = (Map<String, String[]>)request.getParameterMap();
        recipeForm.bind(requestParameters);

        if (recipeForm.getValid()) {
            RecipeDao recipeDao = new RecipeDao();
            // TODO create recipe from form fields data
            //Recipe recipe = recipeDao.createRecipe(recipeForm);

            // TODO if created redirect to show action
            response.sendRedirect("http://www.google.com");
        }
        
        return showForm(recipeForm);
    }

    private View showForm(Form form) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("form", form);

        return new JspView("/WEB-INF/pages/recipes/new.jsp", params);
    }
}
