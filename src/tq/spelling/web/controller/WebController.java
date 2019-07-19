package tq.spelling.web.controller;

import java.util.HashMap;
import java.util.Map;

public interface WebController {
    ModelView process(Map<String, String[]> parameters, HashMap<String, Object> sessionParameters, ModelView modelView);
}
