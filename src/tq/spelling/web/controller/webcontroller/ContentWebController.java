package tq.spelling.web.controller.webcontroller;

import pl.tq.spelling.service.user.User;
import tq.spelling.web.controller.view.ModelView;
import tq.spelling.web.controller.view.View;

import java.util.HashMap;
import java.util.Map;

public class ContentWebController implements WebController {

    private String login;
    private String password;

    @Override
    public void process(Map<String, String[]> parameters, HashMap<String, Object> sessionParameters, ModelView modelView) {
        User user = (User) sessionParameters.get("user");

        if( user == null ) {
            if (containParameterLoginDatas(parameters)) {
                user = createUser();
                modelView.setView( new View("content", "/content.jsp"));
                sessionParameters.put("user", user);
            } else {
                modelView.setView( new View("content", "/login.jsp"));
            }
        } else {
            modelView.setView( new View("content", "/content.jsp"));
        }

    }

    private boolean containParameterLoginDatas(Map<String, String[]> parameters) {
        login = getParameter("login",parameters);
        password = getParameter("password",parameters);
        return login != null && password != null ;
    }

    private String getParameter(String name, Map<String, String[]> parameters) {
        if( parameters.containsKey(name) && parameters.get(name).length > 0) {
            return parameters.get(name)[0];
        }
        return null;
    }

    private pl.tq.spelling.service.user.User createUser() {
        return new User(1);
    }
}
