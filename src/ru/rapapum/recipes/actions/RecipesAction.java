package ru.rapapum.recipes.actions;

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
 * Time: 11:21
 */
public final class RecipesAction extends Action {
//    private static RecipesAction instance = new RecipesAction();
//    private RecipesAction() {}
//
//    public static RecipesAction getInstance() {
//        return instance;
//    }

    @Override
    protected View doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new JspView("/WEB-INF/pages/recipes/index.jsp");
    }

    /**
     * Adds new recipe to recipes collection
     * @param request Request
     * @param response Response
     * @return redirect to created recipe
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected View doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Create DAO
        RecipeDao recipeDao = new RecipeDao();

//        Recipe recipe = null;
//        try {
//            recipe = recipeDao.createRecipe(request.getParameterMap());
//        } catch (ValidationException e) {
//            // TODO return form html with errors
//
////            return FormNewRecipeAction.getInstance().doGet(request, response);
//        }
//
////        Store entity
//        recipeDao.ofy().put(recipe);
//
////        Send redirect
//
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("text", "post done");
        return new JspView("/WEB-INF/pages/recipes/test.jsp", params);
    }
}
