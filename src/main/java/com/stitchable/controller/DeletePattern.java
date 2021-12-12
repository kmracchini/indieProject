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
public class DeletePattern extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Pattern.class);
        int id = Integer.valueOf(request.getParameter("id"));
        Pattern pattern = (Pattern)dao.getById(id);
        request.setAttribute("pattern", pattern);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/deletePattern.jsp");
        dispatcher.forward(request, response);
    }

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
