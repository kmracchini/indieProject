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
        urlPatterns = {"/admin"}
)
@Log4j2
/**
 * Used to populate data on site admin page
 */
public class Admin extends HttpServlet {

    /**
     * Adds all patterns and all designers to attributes and forwards to admin.jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao patternDao = new GenericDao(Pattern.class);
        GenericDao designerDao = new GenericDao(Designer.class);

        request.setAttribute("patterns", patternDao.getAll());
        request.setAttribute("designers", designerDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }
}
