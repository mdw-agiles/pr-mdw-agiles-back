package es.upm.miw.business_controllers;

import es.upm.miw.dtos.ReservationDto;
import es.upm.miw.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationDto> readAll() {
        return new ArrayList<>();
    }
}
