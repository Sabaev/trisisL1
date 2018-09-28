package info;

public class HtmlCreator {
    static public String createHead(String title) {
        return "<html>\n" +
                "<meta charset='utf-8'>\n" +
                "<body\n" +
                "<h2>" + title + "</h2>\n" +
                "<h2>";

    }
    static public String createBottom(boolean form, boolean add,boolean players, boolean delete){
        String bottom = "";
        if(form){
            bottom += "<form method='post' accept-charset='UTF-8'><input name='data'><input type='submit'></form>";
        }
        if(add){
            bottom += "<p><a href=\"http://localhost:8080/SampleJSP/newplayer\">New Player</a></p>";
        }
        if(players){
            bottom += "<p><a href=\"http://localhost:8080/SampleJSP/players\">Players</a></p>";
        }
        if(delete){
            bottom += "<p><a href=\"http://localhost:8080/SampleJSP/del\">Delete</a></p>";
        }
        return bottom + "</h2>\n</body>\n</html>";
    }


    static public String openTable(){
        return "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"5\">";
    }
    static public String createPlayer(String name, Integer number, Integer id, boolean deleteRef){
        return  "<tr>" +
                "<td>" +
                "Игрок" +
                "</td>" +
                "<td>" +
                name +
                "</td>" +
                "<td>" +
                "Номер игрока" +
                "</td>" +
                "<td>" +
                number +
                 "</td>" +
                "<td>" +
                "</td>" +
                "<td>" +
                "<a href = \"players?command=delete&id="+id+"\">удалить</a>" +
                "</td>" +
                "</tr>";

    }
    static public String closeTable(){
        return "</table>";
    }



    static public String addPlayerForm(){
        return  "<form method='post' accept-charset=\"UTF-8\">" +
                "<input name='command' type='hidden' value='add'>Имя игрока <br>" +
                "<input name='playerName'><br>" +
                "Номер игрока<br><input name='playerNumber'><br>" +
                "<input type='submit' value='Добавить'></form></body>\n";
    }
}
