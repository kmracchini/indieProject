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
        urlPatterns = {"/editPattern"}
)
@Log4j2
public class EditPattern extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Pattern.class);
        GenericDao designerDao = new GenericDao(Designer.class);

        String patternName = request.getParameter("name");
        int patternWidth = Integer.valueOf(request.getParameter("width"));
        int patternHeight = Integer.valueOf(request.getParameter("height"));
        String patternSize = request.getParameter("size");
        int numberOfColors = Integer.valueOf(request.getParameter("number"));
        String keywords = request.getParameter("keywords");
        String features = request.getParameter("features");
        String stitchedExample = request.getParameter("example");
        String imageURL = request.getParameter("image");
        String patternURL = request.getParameter("url");
        int designerID = Integer.valueOf(request.getParameter("designer"));
        log.info("The designer id is " + designerID);
        Designer designer = (Designer)designerDao.getById(designerID);
        log.info("The designer is " + designer.getName());

        if (request.getParameter("id") == "") {
            Pattern newPattern = new Pattern(patternName, patternWidth, patternHeight, numberOfColors, keywords, features, stitchedExample, imageURL, patternURL, designer, patternSize);
            dao.insert(newPattern);
            log.info("Added pattern " + newPattern);
        } else {
            int id = Integer.valueOf(request.getParameter("id"));
            Pattern pattern = new Pattern(id, patternName, patternWidth, patternHeight, numberOfColors, keywords, features, stitchedExample, imageURL, patternURL, designer, patternSize);
            dao.saveOrUpdate(pattern);
            log.info("Updated pattern " + patternName);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(Pattern.class);
        int id = Integer.valueOf(request.getParameter("id"));
        Pattern pattern = (Pattern)dao.getById(id);
        request.setAttribute("pattern", pattern);
        request.setAttribute("patternDesigner", pattern.getDesigner().getId());

        GenericDao designerDao = new GenericDao(Designer.class);
        request.setAttribute("designers", designerDao.getAll());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editPattern.jsp");
        dispatcher.forward(request, response);
    }
}
