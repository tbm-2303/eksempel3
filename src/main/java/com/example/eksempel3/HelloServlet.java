package com.example.eksempel3;

import Mappers.Database;
import Mappers.UserMapper;
import Services.UserFacade;
import objects.User;
import org.omg.CORBA.UserException;

import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final static String USER = "root";
    private final static String PASSWORD = "Timmy2008";
    private final static String URL = "jdbc:mysql://localhost:3306/pokemondb?serverTimezone=CET";
    public static Database database;

    @Override
    public void init() throws ServletException {
        // Initialize database connection
        if (database == null) {
            try {
                database = new Database(USER, PASSWORD, URL);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger("web").log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        // Initialize whatever global datastructures needed here:

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("Email");
        String password1 = request.getParameter("Password1");
        String password2 = request.getParameter("Password2");
        User test = new User(email, password2);

        System.out.println(email+password1+password2);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        HttpSession session = request.getSession();
        User user = new User(email, password);
        session.setAttribute("user", user);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }

    public void destroy() {
    }
}