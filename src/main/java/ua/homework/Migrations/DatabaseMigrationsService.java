package ua.homework.Migrations;

import org.flywaydb.core.Flyway;

import org.hibernate.cfg.Environment;



import java.io.IOException;
import java.util.Properties;


public class DatabaseMigrationsService {


    public void initDbService() throws IOException {
        Properties hibernateProperties = new Properties();
        hibernateProperties.load(DatabaseMigrationsService.class.getClassLoader().getResourceAsStream("hibernate.properties"));

        String hibernateUrl = hibernateProperties.getProperty(Environment.URL);

        Flyway flyway = Flyway
                .configure()
                .dataSource(hibernateUrl, null, null)
                .load();
        flyway.migrate();
    }
}


