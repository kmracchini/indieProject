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
        urlPatterns = {"/patterns"}
)
public class PatternByDesigner extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    //TODO: gotta rekajigger this bad boy

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        GenericDao dao = new GenericDao(Pattern.class);
//
//        String id = request.getParameter("id");
//
//        request.setAttribute("patterns", dao.getByPropertyEquals("designer", id));
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/patterns.jsp");
//        dispatcher.forward(request,response);
//    }

}
