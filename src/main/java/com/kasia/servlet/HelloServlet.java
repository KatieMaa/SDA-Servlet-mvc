package com.kasia.servlet;

import com.kasia.controller.Controller;
import com.kasia.controller.UserController;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RENT on 2017-03-01.
 */
public class HelloServlet extends HttpServlet {

    private Map<String, Controller> controllerMap;


    @Override
    public void init() throws ServletException {
        System.out.println("Hello from HelloServlet init method");

        this.controllerMap = new HashMap<String, Controller>();
        controllerMap.put("users", new UserController());
        controllerMap.put("default", (request, response) ->
                response.getWriter()
                        .write("<h1>Hello from HelloServlet init method</h1>"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String requestURI = req.getRequestURI();
        String relativePath = requestURI.substring(StringUtils.ordinalIndexOf(requestURI, "/", 2) + 1);

        PrintWriter writer = resp.getWriter();
        writer.write("<h1>Hello World</h1>");
    }
}
