package info.Servlets;

import info.DataBase.DB;
import info.DataBase.model.Player;
import info.HtmlCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class PlayersServlet extends javax.servlet.http.HttpServlet {

    private void process(HttpServletRequest request, HttpServletResponse response, String command) throws IOException {
        if(command != null) {
            switch (command) {
                case "delete":
                    int id = Integer.valueOf(request.getParameter("id"));
                    doDelete(id);
                    break;
                case "add":
                    String name = request.getParameter("playerName");
                    int number = Integer.valueOf(request.getParameter("playerNumber"));
                    doAdd(name,number);
                    break;
            }
        }


        response.setStatus(200);
        response.setContentType("text/html;charset = UTF-8");
        response.getWriter().write(HtmlCreator.createHead("тут просмотр игроков"));
        response.getWriter().write(HtmlCreator.openTable());
        for(Player player : DB.db){
            response.getWriter().write(HtmlCreator.createPlayer(player.getName(),player.getNumber(),player.getId(),true));
        }
        response.getWriter().write(HtmlCreator.closeTable());
        response.getWriter().write(HtmlCreator.addPlayerForm());
        response.getWriter().write(HtmlCreator.createHead("Конец"));


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response,request.getParameter("command"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response,request.getParameter("command"));
    }

    private void doDelete(int id){
        for(Player player : DB.db){
            if(player.getId() == id){
                DB.db.remove(player);
                break;
            }
        }
    }

    private void doAdd(String name,int number){
        Player player = new Player(name,number);
        DB.db.add(player);
    }


}
