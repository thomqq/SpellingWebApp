package tq.spelling.web.controller.webcontroller;

import tq.spelling.web.controller.view.ModelView;
import tq.spelling.web.controller.view.View;

import java.util.HashMap;
import java.util.Map;

public class MenuWebController implements WebController {
    @Override
    public void process(Map<String, String[]> parameters, HashMap<String, Object> sessionParameters, ModelView modelView) {
        modelView.setView(new View("menu", "/menu.jsp"));
    }
}
