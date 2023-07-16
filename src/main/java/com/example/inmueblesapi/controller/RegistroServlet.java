package com.example.inmueblesapi.controller;

import java.io.*;

import com.example.inmueblesapi.dao.RegistroDao;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/api")
public class RegistroServlet extends HttpServlet {
    private RegistroDao registroDao = new RegistroDao();

    //public void init() {message = "Hello World!";    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String registros = this.registroDao.select("Yohel");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(registros);
            out.flush();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



    }

    public void destroy() {
    }
}