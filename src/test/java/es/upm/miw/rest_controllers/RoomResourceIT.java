package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.RoomDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class RoomResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testReadAll(){
        List<RoomDto> roomDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<RoomDto[]>()).clazz(RoomDto[].class)
                .path(RoomResource.ROOM)
                .get().build());
        assertFalse( roomDtoList.isEmpty());
    }

    @Test
    void testSearchByHotelEmpty() {
        List<RoomDto> roomDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<RoomDto[]>()).clazz(RoomDto[].class)
                .path(RoomResource.ROOM).path(RoomResource.SEARCH)
                .param("hotelName", "Hotel Name")
                .get().build());
        assertTrue(roomDtoList.isEmpty());


    }

    @Test
    void testSearchByHotel() {
        List<RoomDto> roomDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<RoomDto[]>()).clazz(RoomDto[].class)
                .path(RoomResource.ROOM).path(RoomResource.SEARCH)
                .param("hotelName", "NH Madrid Centro")
                .get().build());
        assertFalse(roomDtoList.isEmpty());
    }
}
