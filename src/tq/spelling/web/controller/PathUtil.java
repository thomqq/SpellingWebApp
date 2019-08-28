package tq.spelling.web.controller;

public class PathUtil {
    public static String prepareActionName(String servletPath) {
        String action = "";
        if (servletPath == null) {
            return action;
        }
        if (servletPath.startsWith("/")) {
            action = servletPath.substring(1, servletPath.length() );
        }
        int pos = servletPath.indexOf(".act");
        if( pos > -1) {
            action =  action.substring(0, pos - 1);
        }
        return action;
    }
}
