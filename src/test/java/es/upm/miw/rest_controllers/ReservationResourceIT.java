package es.upm.miw.rest_controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;

@ApiTestConfig
public class ReservationResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testReadAll(){
        assertFalse( false);
    }
}
