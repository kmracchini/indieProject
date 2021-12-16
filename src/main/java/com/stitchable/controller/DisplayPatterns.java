package com.stitchable.controller;

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
        urlPatterns = {"/allPatterns"}
)
@Log4j2
/**
 * Gets information for all patterns
 */
public class DisplayPatterns extends HttpServlet {

    /**
     * Gets information for all patterns and forwards to patterns JSP
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao dao = new GenericDao(Pattern.class);

        request.setAttribute("patterns", dao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/patterns.jsp");
        dispatcher.forward(request,response);
    }
}
