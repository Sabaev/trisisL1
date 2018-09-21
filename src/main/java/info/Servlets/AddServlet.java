package info.Servlets;


import info.DataBase.DB;
import info.HtmlCreator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddServlet extends javax.servlet.http.HttpServlet {

    private void process(HttpServletRequest request, HttpServletResponse response, String data) throws IOException{
        String encoding = "utf-8";
        response.setCharacterEncoding(encoding);
        response.setStatus(200);
        response.getWriter().write(HtmlCreator.createHead("Добавление"));
        if(data != null && !data.equals("")){
            DB.db.add(data);
            response.getWriter().write("data have been added");
        } else {
            response.getWriter().write("вводите");
        }
        response.getWriter().write(HtmlCreator.createBottom(true,false, true,true));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        process(request,response, request.getParameter("data"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        process(request,response, request.getParameter("data"));
    }
}

