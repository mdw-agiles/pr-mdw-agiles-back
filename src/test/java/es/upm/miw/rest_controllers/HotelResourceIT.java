package es.upm.miw.rest_controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ApiTestConfig
public class HotelResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testReadAll(){
        assertTrue( false);
    }
}
