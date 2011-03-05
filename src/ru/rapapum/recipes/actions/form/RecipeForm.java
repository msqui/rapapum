package ru.rapapum.recipes.actions.form;

import ru.rapapum.recipes.actions.form.fields.IntegerField;
import ru.rapapum.recipes.actions.form.fields.StringField;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 19:00
 */
public final class RecipeForm extends Form {

    private StringField title = new StringField("Title");
    
    private IntegerField cook_time = new IntegerField("Cook time");

    private IntegerField ingredients_count = new IntegerField("Ingredients count");

    private StringField description = new StringField("Description");

    public RecipeForm() {
        addField("title", this.title);
        addField("cook_time", this.cook_time);
        addField("ingredients_count", this.ingredients_count);
        addField("description", this.description);
    }
}
