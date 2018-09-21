package info.Servlets;

import info.DataBase.DB;
import info.HtmlCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends javax.servlet.http.HttpServlet {


    private void process(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(HtmlCreator.createHead("Удаление"));
        if(data != null && !data.equals(" ")) {
            response.getWriter().write("<h1> удалён " + deleteAthlete(data) + "</h1>\n");
        }
        response.getWriter().write("количество атлетов: " + DB.db.size() + '\n');
        int i = 1;
        for (String name : DB.db) {
            response.getWriter().write("<h3>" + i + " " + name + "</h3>\n");
            i++;
        }
        response.getWriter().write(HtmlCreator.createBottom(true,true,true,false));


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response, request.getParameter("data"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response, request.getParameter("data"));
    }

    String deleteAthlete(String data) {
        try {
            return DB.db.remove(Integer.parseInt(data) - 1);
        } catch (NumberFormatException e) {
            return "неверный формат ввода";
        } catch (IndexOutOfBoundsException e) {
            return "спортсмена с таким номером нет";
        }
    }
}
