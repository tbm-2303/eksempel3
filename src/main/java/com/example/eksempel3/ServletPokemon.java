package com.example.eksempel3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletPokemon", value = "/ServletPokemon")
public class ServletPokemon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Pokemon = request.getParameter("pokemon");
        String Pokemon_img = request.getParameter("pokemon_img");
        request.setAttribute("PokemonSubmission",Pokemon);
        request.setAttribute("pokemon_img", Pokemon_img);
        ServletContext servletContext = request.getServletContext();
        List<String> PokemonListAppScope = (List<String>) servletContext.getAttribute("PokemonListAppScope");

        if (PokemonListAppScope == null) {
            PokemonListAppScope = new ArrayList<>();
        }
        PokemonListAppScope.add(Pokemon);
        servletContext.setAttribute("PokemonListAppScope", PokemonListAppScope);
        request.getRequestDispatcher("user.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
