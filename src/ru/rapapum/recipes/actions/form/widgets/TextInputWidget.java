package ru.rapapum.recipes.actions.form.widgets;

import ru.rapapum.recipes.actions.form.fields.FormField;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 21:24
 */
public class TextInputWidget extends FormWidget {

    @Override
    public String render(FormField field) {
        String res = "<input type='text' name='" + field.getName() + "' />";
        return res;
    }
}
