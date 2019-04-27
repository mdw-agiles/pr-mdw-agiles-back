package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.ReservationDto;
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
    void testSearchByHotel() {
        assertFalse(false);
    }
}
