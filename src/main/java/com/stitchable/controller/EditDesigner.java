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
        urlPatterns = {"/editDesigner"}
)
@Log4j2
public class EditDesigner extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao designerDao = new GenericDao(Designer.class);
        int id = Integer.valueOf(request.getParameter("id"));
        Designer designer = (Designer) designerDao.getById(id);
        request.setAttribute("designer", designer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editDesigner.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao designerDao = new GenericDao(Designer.class);

        String name = request.getParameter("name");
        String website = request.getParameter("website");
        String logo = request.getParameter("logo");
        int shopId = Integer.valueOf(request.getParameter("etsyId"));
        if (request.getParameter("id") == "") {
            Designer designer = new Designer(name, website, logo, shopId);
            designerDao.insert(designer);
            log.info("Added designer " + designer.getName());
        } else {
            int id = Integer.valueOf(request.getParameter("id"));
            Designer designer = new Designer(id, name, website, logo, shopId);
            designerDao.saveOrUpdate(designer);
            log.info("Updated designer " + designer.getName());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

}
