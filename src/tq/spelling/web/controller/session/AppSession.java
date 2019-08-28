package tq.spelling.web.controller.session;

import pl.tq.spelling.service.user.User;

import java.util.HashMap;

public class AppSession {
    private HashMap<String, Object> parameters = new HashMap<>();

    public AppSession() {
    }

    public Object get(String key) {
        return parameters.get(key);
    }

    public boolean contain(String key) {
        return parameters.containsKey(key);
    }

    public void put(String key, User value) {
        parameters.put(key, value);
    }
}
