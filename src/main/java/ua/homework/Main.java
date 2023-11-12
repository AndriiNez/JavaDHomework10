package ua.homework;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.homework.Client.Client;
import ua.homework.Client.ClientCrudService;
import ua.homework.Migrations.DatabaseMigrationsService;
import ua.homework.hibernate.HibernateUntil;
import ua.homework.planet.Planet;
import ua.homework.planet.PlanetCrudService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        new DatabaseMigrationsService().initDbService();


        ClientCrudService clientCrudService = new ClientCrudService();

        Client newCli = new Client();
        newCli.setName("Lucian");
        clientCrudService.createClient(newCli);

        Client byId = clientCrudService.getById(11);
        System.out.println("Get by id Client after create = " + byId);

        clientCrudService.setName(11, "Donald");
        Client byId1 = clientCrudService.getById(11);
        System.out.println("Get by id Client after set new name = " + byId1);

        clientCrudService.deleteById(11);
        List<Client> clients = clientCrudService.listAllClients();
        System.out.println("List all Clients after delete Client = " + clients);

        PlanetCrudService planetCrudService = new PlanetCrudService();

        Planet newPlanet = new Planet();
        newPlanet.setId("MOR");
        newPlanet.setName("Mordor");
        planetCrudService.createPlanet(newPlanet);

        Planet mor = planetCrudService.getById("MOR");
        System.out.println("Get by id Planet after create  = " + mor);

        planetCrudService.setName("MOR", "Morovin");
        Planet mor1 = planetCrudService.getById("MOR");
        System.out.println("Get by id Planet after set new name  = " + mor1);


        planetCrudService.deleteById("MOR");
        List<Planet> planets = planetCrudService.listAllPlanets();
        System.out.println("List all Planets after delete Planet = " + planets);
    }
}