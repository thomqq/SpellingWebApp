package tq.spelling.web.controller.webcontroller;

import pl.tq.spelling.service.user.User;
import tq.spelling.web.controller.view.ModelView;
import tq.spelling.web.controller.view.View;

import java.util.HashMap;
import java.util.Map;

public class ContentWebController implements WebController {


    @Override
    public void process(Map<String, String[]> parameters, HashMap<String, Object> sessionParameters, ModelView modelView) {
        User user = (User) sessionParameters.get("user");

        if( user == null ) {
            if (containParameterLoginDatas(parameters)) {
                user = createUser();
                modelView.setView( new View("content", "/content.jsp"));
            } else {
                modelView.setView( new View("content", "/login.jsp"));
            }
        }

    }

    private boolean containParameterLoginDatas(Map<String, String[]> parameters) {
        return false;
    }

    private pl.tq.spelling.service.user.User createUser() {
        return null;
    }
}
