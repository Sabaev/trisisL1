package info.Servlets;


import info.DataBase.DB;
import info.HtmlCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


public class RandomServlet extends javax.servlet.http.HttpServlet {



    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(HtmlCreator.createHead("Лидер"));
        if(DB.db.size() != 0) {
            response.getWriter().write("<h/2> У нас есть лидер "+DB.db.get(ContextListener.random.nextInt(DB.db.size())) + "</h2>");
        }else {
            response.getWriter().write("<h/2> Ждём спортсменов </h2>");
        }
        response.getWriter().write(HtmlCreator.createBottom(false,true,true,true));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }
}
