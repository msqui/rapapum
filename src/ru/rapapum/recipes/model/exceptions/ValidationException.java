package ru.rapapum.recipes.model.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 02/03/11
 * Time: 11:25
 */
public class ValidationException extends Exception {
    private final List<String> messages = new ArrayList<String>();

    public void add(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }

    public int size() {
        return messages.size();
    }
}
