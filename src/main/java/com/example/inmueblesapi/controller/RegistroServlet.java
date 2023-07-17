package com.example.inmueblesapi.controller;

import java.io.*;

import com.example.inmueblesapi.dao.RegistroDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/api")
public class RegistroServlet extends HttpServlet {
    private RegistroDao registroDao = new RegistroDao();

    //public void init() {message = "Hello World!";    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String consulta = request.getParameter("searchText");
            String registros = this.registroDao.select(consulta);

            response.setContentType("application/json");
            response.getWriter().write(registros);

        } catch (ClassNotFoundException  e) {
            throw new RuntimeException(e);
        }



    }

    public void destroy() {
    }
}