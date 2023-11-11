package ua.homework.Migrations;

import org.flywaydb.core.Flyway;
import ua.homework.prefs.Prefs;


public class DatabaseMigrationsService {
    String connectionUrl = new Prefs().getString(Prefs.DB_JDBS_CONNECTION_URL);

    public void initDbService() {

        Flyway flyway = Flyway.
                configure().
                dataSource(connectionUrl, null, null).
                load();

        flyway.migrate();
    }
}


