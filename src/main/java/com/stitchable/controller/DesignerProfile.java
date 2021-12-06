package com.stitchable.controller;

import com.stitchable.api.ResultsItem;
import com.stitchable.api.Shop;
import com.stitchable.entity.Designer;
import com.stitchable.entity.Pattern;
import com.stitchable.persistence.EtsyShopDao;
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
import java.util.List;


@WebServlet(
        urlPatterns = {"/designerProfile"}
)
@Log4j2
public class DesignerProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao dao = new GenericDao(Designer.class);
        int id = Integer.valueOf(request.getParameter("id"));

        EtsyShopDao etsyDao = new EtsyShopDao();
        Designer designer = (Designer)dao.getById(id);
        int shopCode = designer.getEtsyId();
        Shop shop = etsyDao.getEtsyResponse(shopCode);
        List<ResultsItem> items = shop.getResults();
        for (ResultsItem item : items) {
            request.setAttribute("shopName", item.getShopName());
            request.setAttribute("shopURL", item.getUrl());
            request.setAttribute("listings", item.getListingActiveCount());
            request.setAttribute("icon", item.getIconUrlFullxfull());
        }

        request.setAttribute("designer", dao.getById(id));



        RequestDispatcher dispatcher = request.getRequestDispatcher("/designerProfile.jsp");
        dispatcher.forward(request,response);
    }

}
