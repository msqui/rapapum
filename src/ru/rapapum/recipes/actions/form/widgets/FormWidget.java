package ru.rapapum.recipes.actions.form.widgets;

import ru.rapapum.recipes.actions.form.fields.FormField;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 21:24
 */
public abstract class FormWidget {
    public abstract String render(FormField field);
}
