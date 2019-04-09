package es.upm.miw.rest_controllers;

import es.upm.miw.business_controllers.AdminController;
import es.upm.miw.exceptions.FileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping(AdminResource.ADMINS)
public class AdminResource {

    public static final String ADMINS = "/admins";

    public static final String DB = "/db";

    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @Autowired
    private AdminController adminController;

    @DeleteMapping(value = DB)
    public void deleteDb() {
        this.adminController.deleteDb();
    }

    @PostMapping(value = DB)
    public void seedDb(@RequestParam(value = "file", required = false) MultipartFile file) {
        if (file != null) {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            if (file.isEmpty()) {
                throw new FileException("Failed to load empty file (" + filename + ")");
            }
            try {
                this.adminController.seedDatabase(file.getInputStream());
            } catch (IOException e) {
                throw new FileException("Failed to load file (" + filename + ")");
            }
        } else {
            this.adminController.seedDatabase();
        }

    }

}
