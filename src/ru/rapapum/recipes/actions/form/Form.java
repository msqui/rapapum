package ru.rapapum.recipes.actions.form;

import ru.rapapum.recipes.actions.form.fields.FormField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 19:00
 */
public abstract class Form {
    protected final Map<String, FormField> fields = new HashMap<String, FormField>();
    protected List<String> errors;

    protected boolean bound = false;
    protected boolean valid = true;

    public final Map<String, FormField> getFields() {
        return fields;
    }

    public final void addField(String name, FormField field) {
        fields.put(name, field);
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

    /**
     * Validates form data and populates errors list
     * @param formFields map of received fields
     */
    public final void bind(Map<String, String[]> formFields) {
        for (Map.Entry<String, FormField> entry : fields.entrySet()) {
            String fieldName = entry.getKey();
            FormField field = entry.getValue();
            field.bind(formFields.get(fieldName));
            if (! field.getValid()) {
                valid = false;
            }

            bound = true;
        }
    }


    public final boolean getValid() {
        return valid;
    }
}
