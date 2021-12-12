package com.stitchable.controller;

import com.stitchable.entity.User;
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
        urlPatterns = {"/updateUser"}
)
@Log4j2
public class UpdateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GenericDao dao = new GenericDao(User.class);

        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        User user = (User)dao.getById(id);
        user.setName(name);
        dao.saveOrUpdate(user);
        log.info("Updated user with new name " + name);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);

    }
}
