package es.upm.miw.rest_controllers;

import es.upm.miw.business_controllers.RoomController;
import es.upm.miw.dtos.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RoomResource.ROOM)
public class RoomResource {

    public static final String ROOM = "/room";
    public static final String SEARCH = "/search";

    @Autowired
    private RoomController roomController;

    @GetMapping
    public List<RoomDto> readAll() { return this.roomController.readAll(); }

    @GetMapping(value = SEARCH)
    public List<RoomDto> searchByHotel(@RequestParam() String hotelName) {
        return this.roomController.searchByHotel(hotelName);
    }
}
