package tq.spelling.web.controller.webcontroller;

import pl.tq.spelling.service.user.User;
import tq.spelling.web.adapters.PollyAdapter;
import tq.spelling.web.controller.session.AppSession;
import tq.spelling.web.controller.view.ModelView;
import tq.spelling.web.controller.view.View;
import tq.spelling.web.resources.ResourcesMapper;

import java.util.Map;

public class ContentWebController implements WebController {

    public static final String MP3_PATH_KEY = "mp3";
    public static final String RESOURCES_MAPPER = "resourcesMapper";
    private String login;
    private String password;

    @Override
    public void process(String action, Map<String, String[]> parameters, AppSession appSession, ModelView modelView) {
        User user = (User) appSession.get("user");

        if( user == null ) {
            if (containParameterLoginData(parameters)) {
                user = createUser();
                modelView.setView( new View("content", "/content.jsp"));
                appSession.put("user", user);
            } else {
                modelView.setView( new View("content", "/login.jsp"));
            }
        } else {
            if( action.equals("simple")) {
                String sentence[] = parameters.get("sentence");
                if( sentence != null && sentence.length > 0 ) {
                    String pathToMp3 = PollyAdapter.getMp3ForSentence(sentence[0]);
                    registerResource(appSession, pathToMp3);
                    modelView.addModel("mp3Path", pathToMp3);
                }
            }
            modelView.setView( new View("content", "/content.jsp"));
        }

    }

    private void registerResource(AppSession appSession, String pathToMp3) {
        ResourcesMapper mapper =  (ResourcesMapper) appSession.get(RESOURCES_MAPPER);
        if( mapper != null ) {
            mapper.registerPath(MP3_PATH_KEY, pathToMp3);
        }
    }

    private boolean containParameterLoginData(Map<String, String[]> parameters) {
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

    private User createUser() {
        return new User(1);
    }
}
