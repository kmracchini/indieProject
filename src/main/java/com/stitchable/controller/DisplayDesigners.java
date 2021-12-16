package com.stitchable.controller;

import com.stitchable.entity.Designer;
import com.stitchable.persistence.GenericDao;
import lombok.extern.log4j.Log4j2;
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
        urlPatterns = {"/viewDesigners"}
)

@Log4j2
/**
 * Gets information for all designers
 */
public class DisplayDesigners extends HttpServlet {

    /**
     * Gets information for all designers and forwards to designers JSP
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao dao = new GenericDao(Designer.class);

        request.setAttribute("designers", dao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/designers.jsp");
        dispatcher.forward(request,response);
    }
}
