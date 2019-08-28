package tq.spelling.web.controller.webcontroller;

import tq.spelling.web.controller.session.AppSession;
import tq.spelling.web.controller.view.ModelView;

import java.util.HashMap;
import java.util.Map;

public interface WebController {
    void process(String action, Map<String, String[]> parameters, AppSession appSession, ModelView modelView);
}
