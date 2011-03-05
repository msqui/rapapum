package ru.rapapum.recipes.actions.form.fields;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 20:47
 */
public final class StringField extends FormField {
    private String htmlValue;
    private String value;

    public StringField(String name) {
        super(name);
    }

    public StringField(String name, String value) {
        this(name);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void bind(String[] strings) {
        if (null == strings || strings.length == 0) {
            value = "";
        } else {
            value = htmlValue = strings[0];
        }
        
        bound = true;
    }

    @Override
    public String toString() {
        return htmlValue;
    }
}
