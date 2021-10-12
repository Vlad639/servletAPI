package com.example.servletapi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dogServlet", value = "/dog")
public class DogServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/dog.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
