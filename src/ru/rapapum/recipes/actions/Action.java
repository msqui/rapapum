package ru.rapapum.recipes.actions;

import ru.rapapum.recipes.actions.exceptions.Error505;
import ru.rapapum.recipes.views.View;
import ru.rapapum.rest.RestMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: msqui
 * Date: 28/02/11
 * Time: 10:29
 */
public abstract class Action {

    private Map<String, String> urlParams;

    public void addUrlParam(String key, String value) {
        if (null == urlParams) {
            urlParams = new HashMap<String, String>();
        }
        urlParams.put(key, value);
    }

    public Map<String, String> getUrlParams() {
        return urlParams;
    }

    public final View execute(RestMethods method, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (method) {
            case GET:
                return doGet(request, response);
            case POST:
                return doPost(request, response);
            case PUT:
                return doPut(request, response);
            case DELETE:
                return doDelete(request, response);
            default:
                throw new Error505();
        }
    }

    protected View doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new Error505();
    }

    protected View doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new Error505();
    }

    protected View doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new Error505();
    }

    protected View doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        throw new Error505();
    }
}
