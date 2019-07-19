package tq.spelling.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ControllerManager {
    private final String actionTxt;
    private final Map<String, String[]> parameters;
    private final ControllerContext controllerContext;
    private List<WebController> controllers = new ArrayList<>();

    public ControllerManager(String actionTxt, Map<String, String[]> parameters, ControllerContext controllerContext) {
        this.actionTxt = actionTxt;
        this.parameters = parameters;
        this.controllerContext = controllerContext;
    }

    public List<WebController> getControllers() {
        return controllers;
    }
}
