package tq.spelling.web.controller.webcontroller;

import tq.spelling.web.controller.view.ModelView;
import tq.spelling.web.controller.view.View;

import java.util.HashMap;
import java.util.Map;

public class StaticWebController implements WebController {

    private final String jspPageName;

    public static StaticWebController fromJspPageName(String jspPageName ) {
        return new StaticWebController(jspPageName);
    }

    private StaticWebController(String jspPageName) {
        this.jspPageName = jspPageName;
    }

    @Override
    public void process(Map<String, String[]> parameters, HashMap<String, Object> sessionParameters, ModelView modelView) {
        modelView.setView(new View(jspPageName, "/" + jspPageName +".jsp"));
    }
}
