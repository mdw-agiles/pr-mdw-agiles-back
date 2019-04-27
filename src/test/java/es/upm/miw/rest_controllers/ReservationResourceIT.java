package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.ReservationDto;
import es.upm.miw.dtos.RoomDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class ReservationResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testReadAll(){
        List<ReservationDto> reservationDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<ReservationDto[]>()).clazz(ReservationDto[].class)
                .path(ReservationResource.RESERVATION)
                .get().build());
        assertFalse( reservationDtoList.isEmpty());
    }

    @Test
    void testSearchByCodeEmpty() {
        List<ReservationDto> reservationDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<ReservationDto[]>()).clazz(ReservationDto[].class)
                .path(ReservationResource.RESERVATION).path(ReservationResource.SEARCH)
                .param("code", "123abc")
                .get().build());
        assertTrue(reservationDtoList.isEmpty());


    }

    @Test
    void testSearchByCode() {
        List<ReservationDto> reservationDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<ReservationDto[]>()).clazz(ReservationDto[].class)
                .path(ReservationResource.RESERVATION).path(ReservationResource.SEARCH)
                .param("code", "1a2b3c4d5e6f7g8h")
                .get().build());
        assertFalse(reservationDtoList.isEmpty());
    }
}
