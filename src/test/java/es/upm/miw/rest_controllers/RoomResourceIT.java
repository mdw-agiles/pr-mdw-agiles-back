package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.RoomDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ApiTestConfig
public class RoomResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testReadAll() {
        List<RoomDto> roomDtoList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<RoomDto[]>()).clazz(RoomDto[].class)
                .path(RoomResource.ROOM)
                .get().build());
        assertFalse(roomDtoList.isEmpty());
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

    @Test
    void givenRoomAndDate_thenReturnBookedDateTimes() {
        List<Date> bookedDates = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<Date[]>()).clazz(Date[].class)
                .path(RoomResource.ROOM).path(RoomResource.ROOM_BOOKED_DATES)
                .expand("5cbc2adec2e17403fb397c6b")
                .expand("2019-04-21")
                .get().build());
        assertThat(bookedDates, is(not(empty())));
        assertThat(bookedDates.size(), is(3));
    }
}
