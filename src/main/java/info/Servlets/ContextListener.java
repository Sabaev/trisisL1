package info.Servlets;

import info.DataBase.DB;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Random;

public class ContextListener implements ServletContextListener {

    static Random random = new Random(System.currentTimeMillis());
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DB.db.add("First player");
        DB.db.add("Second player");
        DB.db.add("Third player");


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
