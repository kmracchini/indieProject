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
        urlPatterns = {"/deletePattern"}
)
@Log4j2
/**
 * Deletes a pattern from the database
 */
public class DeletePattern extends HttpServlet {

    /**
     * Gets id of pattern from url and sets pattern in attribute and forwards to delete pattern jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Pattern.class);
        int id = Integer.valueOf(request.getParameter("id"));
        Pattern pattern = (Pattern)dao.getById(id);
        request.setAttribute("pattern", pattern);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/deletePattern.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Gets id of pattern from form and deletes pattern from database
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patternID = Integer.valueOf(request.getParameter("id"));
        GenericDao dao = new GenericDao(Pattern.class);
        Pattern pattern = (Pattern)dao.getById(patternID);
        dao.delete(pattern);
        log.info("Pattern " + pattern.getName() + " deleted");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
