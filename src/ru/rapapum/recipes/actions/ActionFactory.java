package ru.rapapum.recipes.actions;

import ru.rapapum.recipes.actions.exceptions.Error404;
import ru.rapapum.rest.RestMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ActionFactory {

    public static Action dispatch(RestMethods method, HttpServletRequest request)
            throws ServletException {

        // Dispatch using regexp
        Action action = ActionMap.match(request);
        if (null == action) {
            throw new Error404();
        }
        return action;

    }

    static final class ActionMap {
        private static final Map<String, ActionMapItem> actionMapItems = new HashMap<String, ActionMapItem>();

        private ActionMap() {
            // Index
            actionMapItems.put("recipes",
                    new ActionMapItem("/recipes/?",
                            new RecipesAction()));

            // Show
            actionMapItems.put("recipe",
                    new ActionMapItem("/recipes/(\\d+)/?",
                            Arrays.asList("id"),
                            new RecipeAction()));

            // Create
            actionMapItems.put("new_recipe",
                    new ActionMapItem("/recipes/new/?",
                            new FormNewRecipeAction()));

            // Edit
            actionMapItems.put("edit_recipe",
                    new ActionMapItem("/recipes/(\\d+)/edit/?",
                            Arrays.asList("id"),
                            new FormEditRecipeAction()));

            // Delete
            actionMapItems.put("delete_recipe",
                    new ActionMapItem("/recipes/(\\d+)/delete/?",
                            Arrays.asList("id"),
                            new ConfirmDeleteRecipeAction()));
        }

        public static Action match(HttpServletRequest request) {
            for (ActionMapItem item : actionMapItems.values()) {
                if (item.match(request)) {
                    return item.getAction();
                }
            }
            return null;
        }

    }

    static final class ActionMapItem {
        private final Pattern pattern;
        private final Action action;

        private List<String> groupNames;

        protected ActionMapItem(String regexp, Action action) {
            this.pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            this.action = action;
        }

        protected ActionMapItem(String regexp, List<String> groupNames, Action action) {
            this(regexp, action);
            this.groupNames = groupNames;
        }

        public Action getAction() {
            return action;
        }

        public boolean match(HttpServletRequest request) {
            Matcher matcher = pattern.matcher(request.getRequestURI());
            if (matcher.matches()) {

                if (matcher.groupCount() > 0) {
                    if (matcher.groupCount() == groupNames.size()) {
                        for (int i = 0; i < matcher.groupCount(); ++i) {
                            action.addUrlParam(groupNames.get(i), matcher.group(i + 1));
                        }
                    } else {
                        throw new IllegalStateException("groupNames size != groupCount()");
                    }
                }

                return true;
            }
            return false;
        }
    }
}
