package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.HotelChainDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ApiTestConfig
public class HotelChainResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testReadAll() {
        List<HotelChainDto> hotelChainDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<HotelChainDto[]>()).clazz(HotelChainDto[].class)
                .path(HotelChainResource.CHAINS)
                .get().build());
        assertTrue(hotelChainDtoList.size() > 1);
    }
}
