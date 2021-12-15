package com.stitchable.controller;

import com.stitchable.entity.Designer;
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
        urlPatterns = {"/deleteDesigner"}
)
@Log4j2
public class DeleteDesigner extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Designer.class);
        int id = Integer.valueOf(request.getParameter("id"));
        Designer designer = (Designer)dao.getById(id);
        request.setAttribute("designer", designer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/deleteDesigner.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patternID = Integer.valueOf(request.getParameter("id"));
        GenericDao dao = new GenericDao(Designer.class);
        Designer designer = (Designer) dao.getById(patternID);
        dao.delete(designer);
        log.info("Designer " + designer.getName() + " deleted");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
