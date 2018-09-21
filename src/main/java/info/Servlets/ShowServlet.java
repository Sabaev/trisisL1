package info.Servlets;

import info.DataBase.DB;
import info.HtmlCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowServlet extends javax.servlet.http.HttpServlet {

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(HtmlCreator.createHead("Посмотреть всех спортсменов"));
        response.getWriter().write("количество атлетов: " + DB.db.size() + '\n');
        for (String name : DB.db) {
            response.getWriter().write("<h3>" + name + "</h3>\n");
        }
        response.getWriter().write(HtmlCreator.createBottom(false,true,false,true));
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
