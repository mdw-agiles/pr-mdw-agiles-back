package es.upm.miw.rest_controllers;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ApiTestConfig
class AdminResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testDeleteDB() {
        this.restService.deleteDB();
        this.restService.reLoadTestDB();
    }

    @Test
    void testSeedDBUpload() throws IOException {
        this.restService.loginAdmin().restBuilder().loadFile("test.yml").path(AdminResource.ADMINS)
                .path(AdminResource.DB).post().log().build();
        this.restService.reLoadTestDB();
    }

    @Test
    void testSeedDBUploadError() {
        assertThrows(HttpClientErrorException.NotFound.class, () ->
                this.restService.loginAdmin().restBuilder().loadFile("testEmpty.yml").path(AdminResource.ADMINS)
                        .path(AdminResource.DB).post().log().build());
    }

    @Test
    void testSeedDBUploadErrorNotException() throws IOException {
                String json = this.restService.loginAdmin().restBuilder(new RestBuilder<String>()).clazz(String.class)
                        .loadFile("testEmpty.yml").path(AdminResource.ADMINS).path(AdminResource.DB)
                        .post().log().notError().build();
        LogManager.getLogger(this.getClass()).info("Error Message: " + json);
    }

    @Test
    void testSeedDB() {
        this.restService.deleteDB();
        this.restService.loginAdmin().restBuilder().path(AdminResource.ADMINS)
                .path(AdminResource.DB).post().build();
        this.restService.reLoadTestDB();
    }

}
