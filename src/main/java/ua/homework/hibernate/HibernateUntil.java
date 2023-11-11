package ua.homework.hibernate;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.homework.Client.Client;
import ua.homework.Migrations.DatabaseMigrationsService;
import ua.homework.planet.Planet;


public class HibernateUntil {
    private static final HibernateUntil INSTANCE;

    @Getter
    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUntil();
    }

    private HibernateUntil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUntil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }

}

