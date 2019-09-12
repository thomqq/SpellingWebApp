package tq.spelling.web.controller;

import tq.spelling.web.controller.webcontroller.ContentWebController;
import tq.spelling.web.resources.ResourcesMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

        ServletOutputStream stream = null;
        BufferedInputStream buf = null;
        try{

            stream = response.getOutputStream();
            File mp3 = new File(path);

            response.setContentType("audio/mpeg");

            response.addHeader("Content-Disposition","attachment; filename="+"cosik.mp3" );

            response.setContentLength( (int) mp3.length() );

            FileInputStream input = new FileInputStream(mp3);
            buf = new BufferedInputStream(input);
            int readBytes = 0;

            while((readBytes = buf.read()) != -1)
                stream.write(readBytes);

        } catch (IOException ioe){

            throw new ServletException(ioe.getMessage());

        } finally {
            if(stream != null)
                stream.close();
            if(buf != null)
                buf.close();
        }
    }
}
