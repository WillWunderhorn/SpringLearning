package ru.horn.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/serv")
public class Servlets extends HttpServlet {

    public void doGet() throws SecurityException {
        System.out.println("init servlet");
        log("Init servlet");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("Service");
    }
}


