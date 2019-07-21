package tq.spelling.web.controller.webcontroller;

import java.util.ArrayList;
import java.util.List;

public class WebControllerFactory {
    public static List<WebController> getControllers() {
        List<WebController> controllers = new ArrayList<>();
        controllers.add(new MenuWebController());
        controllers.add(StaticWebController.fromJspPageName("header"));
        controllers.add(StaticWebController.fromJspPageName("footer"));
        return controllers;
    }
}
