package tq.spelling.web.controller.webcontroller;

import tq.spelling.web.controller.view.ModelView;

import java.util.HashMap;
import java.util.Map;

public interface WebController {
    void process(Map<String, String[]> parameters, HashMap<String, Object> sessionParameters, ModelView modelView);
}
