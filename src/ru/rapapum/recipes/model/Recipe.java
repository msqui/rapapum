package ru.rapapum.recipes.model;

import com.google.appengine.api.datastore.Category;
import com.google.appengine.api.datastore.Rating;
import com.googlecode.objectify.annotation.Unindexed;
import ru.rapapum.recipes.model.exceptions.ValidationException;
import ru.rapapum.recipes.model.util.Check;

import javax.persistence.Embedded;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 26/02/11
 * Time: 12:37
 */
public final class Recipe {

    @Id
    Long id;

    List<Category> categories;

    Integer cook_time;

    Integer complexity;

    String title;

    @Unindexed
    String description;

    @Embedded
    List<Ingredient> ingredients;

    @Unindexed
    List<String> instructions;

    Rating rating = new Rating(0);

    Date created_at = new Date();

    @Unindexed
    Boolean has_comments = false;

    private Recipe() {}

    public Recipe(List<Category> categories, Integer cook_time, Integer complexity, String title, String description,
                  List<Ingredient> ingredients, List<String> instructions) throws ValidationException {
        this.categories = categories;
        this.cook_time = cook_time;
        this.complexity = complexity;
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;

        validateState();
    }

    private void validateState() throws ValidationException {
        ValidationException ex = new ValidationException();

        if (! Check.required(cook_time)) {
            ex.add("Cook time field is mandatory");
        }
        if (! Check.required(complexity)) {
            ex.add("Complexity field is mandatory");
        }
        if (! Check.not_empty(title)) {
            ex.add("Title field is mandatory");
        }
        if (! Check.not_empty(ingredients)) {
            ex.add("Ingredients field is mandatory");
        }
        if (! Check.not_empty(instructions)) {
            ex.add("Instructions field is mandatory");
        }

        if (ex.size() > 0) {
            throw ex;
        }
    }

}

