package com.stitchable.controller;

import com.stitchable.entity.Pattern;
import com.stitchable.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/editPattern"}
)
public class EditPattern extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Pattern.class);

        if (request.getParameter("id").equals("")) {
            Pattern pattern = new Pattern();
            dao.insert(pattern);
        } else {
            Pattern pattern = new Pattern();
            dao.saveOrUpdate(pattern);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/allPatterns");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Pattern.class);
        int id = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("pattern", dao.getById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editPattern.jsp");
        dispatcher.forward(request, response);
    }
}
