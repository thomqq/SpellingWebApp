package tq.spelling.web.controller;

import tq.spelling.web.controller.webcontroller.ContentWebController;
import tq.spelling.web.resources.ResourcesMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

import static tq.spelling.web.controller.MainController.SESSION_NAVIGATION;

@javax.servlet.annotation.WebServlet(name = "StaticServlet",urlPatterns = "*.mp2")
public class StaticServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ControllerContext controllerContext = (ControllerContext) request.getSession().getAttribute(SESSION_NAVIGATION);
        ResourcesMapper resourcesMapper = (ResourcesMapper)  controllerContext.getAppSession().get(ContentWebController.RESOURCES_MAPPER);
        String path =  resourcesMapper.getPath(ContentWebController.MP3_PATH_KEY);

        File file = new File(path);

        response.setContentType("audio/mpeg");
        response.addHeader("Content-Disposition", "attachment; filename=" + file.getName());

        response.setContentLength((int) file.length());
        byte[] bytes =  Files.readAllBytes(file.toPath());
        ServletOutputStream outputStream = response.getOutputStream();
        Stream.of(bytes).forEach((x) -> safeWrite(outputStream, x));

    }

    private void safeWrite(ServletOutputStream outputStream, byte[] x) {
        try {
            outputStream.write(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
