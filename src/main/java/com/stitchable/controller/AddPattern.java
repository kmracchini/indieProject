package com.stitchable.controller;

import com.stitchable.entity.Designer;
import com.stitchable.entity.Pattern;
import com.stitchable.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(
        urlPatterns = {"/addPattern"}
)
/**
 * Used to add a pattern to the database
 */
public class AddPattern extends HttpServlet {

    /**
     * Adds list of designers to attribute and forwards to edit pattern JSP
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao designerDao = new GenericDao(Designer.class);
        request.setAttribute("designers", designerDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editPattern.jsp");
        dispatcher.forward(request, response);
    }
}
