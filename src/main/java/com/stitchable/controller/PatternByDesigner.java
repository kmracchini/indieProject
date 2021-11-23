package com.stitchable.controller;

import com.stitchable.entity.Designer;
import com.stitchable.entity.Pattern;
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
        urlPatterns = {"/designerPatterns"}
)
@Log4j2
public class PatternByDesigner extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao dao = new GenericDao(Designer.class);
        int id = Integer.valueOf(request.getParameter("id"));

        request.setAttribute("designer", dao.getById(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/designerPatterns.jsp");
        dispatcher.forward(request,response);
    }

}
