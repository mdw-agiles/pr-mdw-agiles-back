package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.HotelDto;
import es.upm.miw.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDto> readAll() {
        return new ArrayList<>();
    }
}
