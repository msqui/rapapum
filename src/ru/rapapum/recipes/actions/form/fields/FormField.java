package ru.rapapum.recipes.actions.form.fields;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 20:46
 */

/**
 * Class to store and cast form values, store and expose field errors
 * @see ru.rapapum.recipes.actions.form.Form
 */
public abstract class FormField {
    private final String name;
    protected List<String> errors;

    protected boolean bound = false;
    protected boolean valid = true;

    public abstract void bind(String[] strings);

    public FormField(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public final List<String> getErrors() {
        return errors;
    }

    public final void addError(String error) {
        if (null == errors) {
            errors = new ArrayList<String>();
        }
        errors.add(error);
    }

    public final boolean getBound() {
        return bound;
    }

    public final boolean getValid() {
        return valid;
    }
}
