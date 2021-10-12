package com.example.servletapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "parametersServlet", value = "/parameters")
public class ParametersServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger("ParametersServletLogger");

    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String parameter = request.getParameter("parameter");
        logger.info(parameter);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Переданный параметр:");
        out.println(parameter);
        out.close();

    }

    public void destroy() {
    }
}
