package ru.rapapum.recipes.model.dao;

import com.google.appengine.api.datastore.Category;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.helper.DAOBase;
import ru.rapapum.recipes.model.Ingredient;
import ru.rapapum.recipes.model.Recipe;
import ru.rapapum.recipes.model.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 00:40
 */
public final class RecipeDao extends DAOBase {
    static {
        ObjectifyService.register(Recipe.class);
    }
    
//    public Recipe getOrCreate(long id) {
//        Recipe found = ofy().find(Recipe.class, id);
//        if (null == found) {
//            return new Recipe();
//        } else {
//            return found;
//        }
//    }

    public Recipe createRecipe(Map<String, String[]> parameterMap) throws ValidationException {

        List<Category> categories = new ArrayList<Category>();
        String[] categories_array = parameterMap.get("categories");
        if (categories_array != null && categories_array.length > 0) {
            for (String categoryTitle : Arrays.asList(parameterMap.get("categories"))) {
                categories.add(new Category(categoryTitle));
            }
        }


        ValidationException ex = new ValidationException();

        Integer cook_time = null;
        try {
            cook_time = Integer.valueOf(parameterMap.get("cook_time")[0]);
        } catch (NumberFormatException e) {
            ex.add("cook_time must be Integer");
        }

        Integer complexity = null;
        try {
            complexity = Integer.valueOf(parameterMap.get("complexity")[0]);
        } catch (NumberFormatException e) {
            ex.add("complexity must be Integer");
        }

        String title = parameterMap.get("title")[0];

        String description = parameterMap.get("description")[0];

        // TODO deal with "ingredients" field
        List<Ingredient> ingredients = null;

        List<String> instructions = Arrays.asList(parameterMap.get("instructions"));

        if (ex.size() > 0) {
            throw ex;
        }

        Recipe recipe;
        try {
            recipe = new Recipe(categories, cook_time, complexity, title, description, ingredients, instructions);
        } catch (ValidationException e) {
            throw ex;
        }

        return recipe;
    }
}
