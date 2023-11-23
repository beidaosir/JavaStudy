package com.hnu.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstController implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入了FirstController");
        request.setAttribute("msg","我是FirstController");
        request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request,response);
    }
}
