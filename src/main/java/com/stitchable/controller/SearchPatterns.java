package com.stitchable.controller;

import com.stitchable.entity.Designer;
import com.stitchable.entity.Pattern;
import com.stitchable.persistence.GenericDao;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/search"}
)
@Log4j2
public class SearchPatterns extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Pattern.class);

        String searchTerm = request.getParameter("searchTerm");

        if (request.getParameter("type").equals("size")) {
            request.setAttribute("patterns", dao.getByPropertyLike("size", searchTerm));
        } else if (request.getParameter("type").equals("keywords")) {
            request.setAttribute("patterns", dao.getByPropertyLike("keywords", searchTerm));
        } else if (request.getParameter("type").equals("colorsMax")) {
            int number = Integer.valueOf(searchTerm);
            request.setAttribute("patterns", dao.getByLessThan("numberOfColors", number));
        } else if (request.getParameter("type").equals("colorsMin")){
            int number = Integer.valueOf(searchTerm);
            request.setAttribute("patterns", dao.getByGreaterThan("numberOfColors", number));
        } else {
            request.setAttribute("patterns", dao.getAll());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request, response);
    }
}
