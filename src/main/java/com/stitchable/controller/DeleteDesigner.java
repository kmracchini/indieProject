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
/**
 * Used to delete a designer from the database
 */
public class DeleteDesigner extends HttpServlet {

    /**
     * Gets designer information from ID parameter and forwards to delete designer JSP
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Designer.class);
        int id = Integer.valueOf(request.getParameter("id"));
        Designer designer = (Designer)dao.getById(id);
        request.setAttribute("designer", designer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/deleteDesigner.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Gets ID of designer from form and deletes designer from database
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int designerID = Integer.valueOf(request.getParameter("id"));
        GenericDao dao = new GenericDao(Designer.class);
        dao.delete(dao.getById(designerID));
        log.info("Deleting designer");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
