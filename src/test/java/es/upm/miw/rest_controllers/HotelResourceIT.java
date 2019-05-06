package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.HotelDto;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class HotelResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testReadAll() {
        List<HotelDto> hotelDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<HotelDto[]>()).clazz(HotelDto[].class)
                .path(HotelResource.HOTELS)
                .get().build());
        LogManager.getLogger().debug(">>>>> HotelDto size: " + hotelDtoList.size());
        assertFalse(hotelDtoList.isEmpty());
    }

    @Test
    void testSearchByHotelChain() {
        List<HotelDto> hotelDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<HotelDto[]>()).clazz(HotelDto[].class)
                .path(HotelResource.HOTELS).path(HotelResource.SEARCH)
                .param("hotelChain", "NH Hoteles")
                .get().build());
        LogManager.getLogger().debug(">>>>> HotelDto size: " + hotelDtoList.size());
        assertFalse(hotelDtoList.isEmpty());
    }

    @Test
    void testSearchByHotelChainWithWrongRequestParam() {
        String hotelChain = "Barceló";
        LogManager.getLogger().debug(">>>>> hotelChain : " + hotelChain);
        List<HotelDto> hotelDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<HotelDto[]>()).clazz(HotelDto[].class)
                .path(HotelResource.HOTELS).path(HotelResource.SEARCH)
                .param("hotelChain", hotelChain)
                .get().build());
        LogManager.getLogger().debug(">>>>> HotelDto size: " + hotelDtoList.size());
        assertTrue(hotelDtoList.isEmpty());
    }

}
