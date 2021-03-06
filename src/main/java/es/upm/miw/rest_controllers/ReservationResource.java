package es.upm.miw.rest_controllers;

import es.upm.miw.business_controllers.ReservationController;
import es.upm.miw.dtos.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(ReservationResource.RESERVATION)
public class ReservationResource {

    public static final String RESERVATION = "/reservation";
    public static final String SEARCH = "/search";

    @Autowired
    private ReservationController reservationController;

    @GetMapping
    public List<ReservationDto> readAll() { return this.reservationController.readAll(); }

    @GetMapping(value = SEARCH)
    public List<ReservationDto> searchByCode(@RequestParam() String code) {
        return this.reservationController.searchByCode(code);
    }

    @PostMapping(value = RESERVATION)
    public String makeReservation(@RequestBody ReservationDto reservationDto) {
        return this.reservationController.makeReservation(reservationDto);
    }
}
