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
    private ActionFactory() {}

    public static Action dispatch(RestMethods method, HttpServletRequest request)
            throws ServletException {

        // Dispatch using regexp
        Action action = ActionMap.match(request);
        if (null == action) {
            throw new Error404();
        }
        return action;

    }

    public static String actionUrl(String actionName) {
        ActionMapItem am = ActionMap.get(actionName);
        if (null == am) {
            return null;
        }
        return am.getPattern().pattern();
    }

    public static String actionUrl(String actionName, List<String> parameters) {
        ActionMapItem am = ActionMap.get(actionName);
        if (null == am) {
            return null;
        }

        Pattern pattern = am.getPattern();
        Matcher matcher = pattern.matcher("");
        if (matcher.groupCount() != parameters.size()) {
            return null;
        }

        String res = pattern.pattern();
        if (am.match(res)) {
            return res;
        } else {
            return null;
        }
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

        /**
         * Dispatches request to action using url regexp
         * @param request Request
         * @return first matched Action or null
         */
        public static Action match(HttpServletRequest request) {
            for (ActionMapItem item : actionMapItems.values()) {
                if (item.match(request)) {
                    return item.getAction();
                }
            }
            return null;
        }

        public static ActionMapItem get(String actionName) {
            return actionMapItems.get(actionName);
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

        public Pattern getPattern() {
            return pattern;
        }

        public Action getAction() {
            return action;
        }

        /**
         * Returns if request matches this action
         * @param string String to compare with
         * @return true if matches and false otherwise
         * @throws IllegalStateException if group count in regexp != group names count in groupNames
         */
        public boolean match(String string) throws IllegalStateException {
            Matcher matcher = pattern.matcher(string);
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

        /**
         * Overload of {@link #match(String)} to match against {@link HttpServletRequest} objects
         * @param request Request
         * @return If request url matches the regexp
         * @throws IllegalStateException if group count in regexp != group names count in groupNames
         */
        public boolean match(HttpServletRequest request) throws IllegalStateException {
            return match(request.getRequestURI());
        }
    }
}
