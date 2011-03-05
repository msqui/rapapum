package ru.rapapum.recipes.model.util;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 15:00
 */
public final class Check {

    public static boolean required(Object field) {
        return (field != null);
    }

    public static boolean not_empty(String field) {
        return (field != null && !field.isEmpty());
    }

    public static boolean not_empty(Collection<? extends Object> field) {
        return (field != null && !field.isEmpty());
    }
}
