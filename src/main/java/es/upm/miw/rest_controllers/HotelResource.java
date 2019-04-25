package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.HotelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(HotelResource.HOTELS)
public class HotelResource {

    public static final String HOTELS = "/hotels";

    @Autowired
    private HotelController hotelController;

    @GetMapping
    public List<HotelDto> readAll() { return this.hotelController.readAll(); }


}
