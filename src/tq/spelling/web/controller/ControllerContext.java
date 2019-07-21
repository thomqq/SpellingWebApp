package tq.spelling.web.controller;

import tq.spelling.web.controller.webcontroller.WebController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControllerContext {
    private List<WebController> controllers = new ArrayList<>();
    public HashMap<String, Object> getSessionParameters() {
        return null;
    }

    public List<WebController> getControllers() {
        return controllers;
    }
    public void addWebController( WebController controller) {
        controllers.add(controller);
    }
}
