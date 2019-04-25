package es.upm.miw.rest_controllers;

import es.upm.miw.business_controllers.HotelController;
import es.upm.miw.dtos.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HotelResource.HOTELS)
public class HotelResource {

    public static final String HOTELS = "/hotels";
    public static final String SEARCH = "/search";

    @Autowired
    private HotelController hotelController;

    @GetMapping
    public List<HotelDto> readAll() { return this.hotelController.readAll(); }

    @GetMapping(value = SEARCH)
    public List<HotelDto> searchByHotelChainId(@RequestParam(required = false) String id) {
        return this.hotelController.readAllByHotelChainId(id);
    }
}
