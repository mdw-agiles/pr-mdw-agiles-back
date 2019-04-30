package es.upm.miw.business_controllers;

import es.upm.miw.documents.Reservation;
import es.upm.miw.dtos.ReservationDto;
import es.upm.miw.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationDto> readAll() {
        List<Reservation> reservationList = this.reservationRepository.findAll();
        return ReservationDto.getListReservationDto(reservationList);
    }

    public List<ReservationDto> searchByCode(String code) {
        List<Reservation> reservations = this.reservationRepository.findAllByCode(code);
        return ReservationDto.getListReservationDto(reservations);
    }
}
