package tq.spelling.web.controller.webcontroller;

import tq.spelling.web.controller.session.AppSession;
import tq.spelling.web.controller.view.ModelView;
import tq.spelling.web.controller.view.View;

import java.util.Map;

public class MenuWebController implements WebController {
    @Override
    public void process(String action, Map<String, String[]> parameters, AppSession appSession, ModelView modelView) {
        modelView.setView(new View("menu", "/menu.jsp"));
    }
}
