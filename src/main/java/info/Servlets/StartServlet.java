package info.Servlets;

import info.HtmlCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartServlet extends javax.servlet.http.HttpServlet  {

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(HtmlCreator.createHead("Привет, я сервлет который уже загружен в память, и отображаюсь на главной странице"));
        response.getWriter().write(HtmlCreator.createBottom(false,false,true,false));
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
