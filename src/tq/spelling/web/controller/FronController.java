package tq.spelling.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "FrontController", urlPatterns = "/FrontController")
public class FronController extends javax.servlet.http.HttpServlet {

    public static final String SESSION_NAVIGATION = "navigation";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("title", "TQ");

        String actionTxt = request.getContextPath().substring(1);

        Map<String, String[]> parameters = request.getParameterMap();
        ControllerContext controllerContext = (ControllerContext) request.getSession().getAttribute(SESSION_NAVIGATION);
        if (controllerContext == null) {
            controllerContext = new ControllerContext();
            request.getSession().setAttribute(SESSION_NAVIGATION, controllerContext);
        }

        ControllerManager controllerManager = new ControllerManager(actionTxt, parameters, controllerContext);
        List<WebController> controllers = controllerManager.getControllers();
        List<ModelView> modelViews = new ArrayList<>();
        for (WebController webController : controllers) {
            ModelView modelView = new ModelView();
            webController.process(parameters, controllerContext.getSessionParameters(), modelView);
            modelViews.add(modelView);
        }
        putParameterFromModelViewToRequest(modelViews, request);
    }

    private void putParameterFromModelViewToRequest(List<ModelView> modelViews, HttpServletRequest request) {
        for (ModelView modelView : modelViews) {
            HashMap<String, Object> params = modelView.getModel();
            for (String key : params.keySet()) {
                request.setAttribute(key, params.get(key));
            }
        }
    }


}
