package es.upm.miw.business_controllers;

import es.upm.miw.data_services.DatabaseSeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.InputStream;

@Controller
public class AdminController {

    @Autowired
    private DatabaseSeederService databaseSeederService;

    public void deleteDb() {
        this.databaseSeederService.deleteAllAndInitialize();
    }

    public void seedDatabase(InputStream inputStream) {
        this.databaseSeederService.seedDatabase(inputStream);
    }

    public void seedDatabase() {
        this.databaseSeederService.seedDatabase();
    }

}
