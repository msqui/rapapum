package ru.rapapum.recipes.actions.form.fields;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 20:50
 */
public final class IntegerField extends FormField {
    private String htmlValue;
    private Integer value;

    public IntegerField(String name) {
        super(name);
    }

    public IntegerField(String name, Integer value) {
        this(name);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void bind(String[] strings) {
        if (null == strings || strings.length == 0) {
            addError("Value is not integer");
            valid = false;
        } else {
            htmlValue = strings[0];
            try {
                value = Integer.valueOf(htmlValue);
            } catch (NumberFormatException e) {
                addError("Value is not integer");
                valid = false;
            }
        }

        bound = true;
    }

    @Override
    public String toString() {
        return htmlValue;
    }
}
