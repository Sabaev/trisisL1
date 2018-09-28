package info.Servlets;

import info.DataBase.DB;
import info.DataBase.model.Player;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Random;

public class ContextListener implements ServletContextListener {

    static Random random = new Random(System.currentTimeMillis());
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DB.db.add(new Player("Gena",1));
        DB.db.add(new Player("Sasha",2));
        DB.db.add(new Player("Oleg",3));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
