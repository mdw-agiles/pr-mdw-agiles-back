package es.upm.miw.rest_controllers;

import es.upm.miw.business_controllers.ReservationController;
import es.upm.miw.business_controllers.RoomController;
import es.upm.miw.dtos.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(RoomResource.ROOM)
public class RoomResource {

    public static final String ROOM = "/rooms";
    public static final String SEARCH = "/search";

    private static final String BOOKED_DATES = "/booked-dates";
    private static final String ROOM_ID = "/{roomId}";
    private static final String DATE_ID = "/{date}";
    public static final String ROOM_BOOKED_DATES = ROOM_ID + BOOKED_DATES + DATE_ID;


    @Autowired
    private RoomController roomController;
    @Autowired
    private ReservationController reservationController;

    @GetMapping
    public List<RoomDto> readAll() {
        return this.roomController.readAll();
    }

    @GetMapping(value = SEARCH)
    public List<RoomDto> searchByHotel(@RequestParam() String hotelName) {
        return this.roomController.searchByHotel(hotelName);
    }

    @GetMapping(value = ROOM_BOOKED_DATES)
    public Date[] calculateStockPrediction(@PathVariable String roomId,
                                           @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return new Date[] {};
    }
}
