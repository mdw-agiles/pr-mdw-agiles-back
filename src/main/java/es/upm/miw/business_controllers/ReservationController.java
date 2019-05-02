package es.upm.miw.business_controllers;

import es.upm.miw.documents.Reservation;
import es.upm.miw.dtos.ReservationDto;
import es.upm.miw.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static es.upm.miw.business_controllers.DateUtils.*;

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

    public List<Date> searchBookedDateTimesByRoomAndDate(String roomId, Date date) {
        Date beforeStartOfDayDate = beforeStartOfDayDate(date);
        Date afterEndOfDayDate = afterEndOfDayDate(date);
        List<Reservation> reservations = this.reservationRepository.findByRoomIdAndDateTimeBetween(roomId, beforeStartOfDayDate, afterEndOfDayDate);
        return buildBookedDatesByHours(reservations);
    }

    private List<Date> buildBookedDatesByHours(List<Reservation> reservations) {
        List<Date> bookedDates = new ArrayList<>();
        reservations.stream().forEach(reservation -> {
            bookedDates.addAll(datesByHour(reservation.getDateTime(), reservation.getDuration().longValue()));
        });
        return bookedDates;
    }


}
