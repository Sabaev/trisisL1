package info;

public class HtmlCreator {
    static public String createHead(String title) {
        return "<html>\n" +
                "<meta charset='utf-8'>\n" +
                "<body\n" +
                "<h2>" + title + "</h2>\n" +
                "<h2>";

    }
    static public String createBottom(boolean form, boolean add,boolean show, boolean delete){
        String bottom = "</h2>\n";
        if(form){
            bottom += "<form method='post' accept-charset='UTF-8'><input name='data'><input type='submit'></form></body>";
        }
        if(add){
            bottom += "<p><a href=\"http://localhost:8080/SampleJSP/add\">Add</a></p>";
        }
        if(show){
            bottom += "<p><a href=\"http://localhost:8080/SampleJSP/show\">Show</a></p>";
        }
        if(delete){
            bottom += "<p><a href=\"http://localhost:8080/SampleJSP/del\">Delete</a></p>";
        }
        return bottom + "</h2>\n</body>\n</html>";
    }

    static public String getRandRefer(){
        return "<p><a href=\"http://localhost:8080/SampleJSP/rand\">Rand</a></p>";
    }
}
