package com.stitchable.controller;

import com.stitchable.entity.Pattern;
import com.stitchable.entity.User;
import com.stitchable.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/addFavorite"}
)
public class AddFavorite extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao patternDao = new GenericDao(Pattern.class);
        GenericDao userDao = new GenericDao(User.class);
        HttpSession session = request.getSession();
        int id = Integer.valueOf(request.getParameter("id"));
        Pattern pattern = (Pattern)patternDao.getById(id);
        User user = (User) session.getAttribute("user");
        user.addFavorite(pattern);
        userDao.saveOrUpdate(user);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
    }
}
