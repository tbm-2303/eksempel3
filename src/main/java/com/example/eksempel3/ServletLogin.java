package com.example.eksempel3;

import Mappers.Database;
import Mappers.UserMapper;
import Services.UserFacade;
import objects.User;
import org.omg.CORBA.UserException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //UserMapper userMapper = new UserMapper(database);
        try {
            HttpSession session = request.getSession();
            UserFacade userFacade = new UserFacade(database);
            //get from input data
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User(email, password);
            //test if this user exists in the database. To do this we need to create a userMapper class.
            userFacade.Login(email, password);

            session.setAttribute("user", user);
            request.getRequestDispatcher("user.jsp").forward(request, response);

        } catch (SQLException | Services.UserException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("errorpage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //test if this user exists in the database. To do this we need to create a userMapper class.
        HttpSession session = request.getSession();
        User user = new User(email, password);
        session.setAttribute("user", user);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }
}
