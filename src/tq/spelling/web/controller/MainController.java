package tq.spelling.web.controller;

import tq.spelling.web.controller.view.ModelView;
import tq.spelling.web.controller.view.View;
import tq.spelling.web.controller.webcontroller.WebController;
import tq.spelling.web.controller.webcontroller.WebControllerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.servlet.annotation.WebServlet(name = "MainController", urlPatterns = "/index.jsp")
public class MainController extends javax.servlet.http.HttpServlet {

    private static final String SESSION_NAVIGATION = "navigation";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setAttribute("title", "TQ");

        String actionTxt = request.getContextPath().substring(1);

        Map<String, String[]> parameters = request.getParameterMap();
        ControllerContext controllerContext = (ControllerContext) request.getSession().getAttribute(SESSION_NAVIGATION);
        if (controllerContext == null) {
            controllerContext = createControllerContext();
            request.getSession().setAttribute(SESSION_NAVIGATION, controllerContext);
        }

        List<WebController> controllers = controllerContext.getControllers();
        List<ModelView> modelViews = new ArrayList<>();
        for (WebController webController : controllers) {
            ModelView modelView = new ModelView();
            webController.process(parameters, controllerContext.getSessionParameters(), modelView);
            modelViews.add(modelView);
        }
        putParameterFromModelViewToRequest(modelViews, request);

        request.getRequestDispatcher("/main.jsp").forward(request, response);

    }

    private ControllerContext createControllerContext() {
        ControllerContext controllerContext = new ControllerContext();
        WebControllerFactory.getControllers().forEach(controllerContext::addWebController);
        return controllerContext;
    }

    private void putParameterFromModelViewToRequest(List<ModelView> modelViews, HttpServletRequest request) {
        for (ModelView modelView : modelViews) {
            HashMap<String, Object> params = modelView.getModel();
            for (String key : params.keySet()) {
                request.setAttribute(key, params.get(key));
            }
            View view = modelView.getView();
            if (view != null) {
                request.setAttribute(view.getIncludeName(), view.getName());
            }
        }

    }


}
