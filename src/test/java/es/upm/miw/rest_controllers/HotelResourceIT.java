package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.HotelChainDto;
import es.upm.miw.dtos.HotelDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ApiTestConfig
public class HotelResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testReadAll(){
        List<HotelDto> hotelDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<HotelDto[]>()).clazz(HotelDto[].class)
                .path(HotelResource.HOTELS)
                .get().build());
        assertTrue( hotelDtoList.isEmpty());
    }
}
