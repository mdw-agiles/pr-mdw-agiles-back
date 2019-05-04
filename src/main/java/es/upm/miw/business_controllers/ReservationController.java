package es.upm.miw.business_controllers;

import es.upm.miw.documents.Reservation;
import es.upm.miw.documents.Room;
import es.upm.miw.dtos.ReservationDto;
import es.upm.miw.exceptions.NotFoundException;
import es.upm.miw.exceptions.BadRequestException;
import es.upm.miw.repositories.ReservationRepository;
import es.upm.miw.repositories.RoomRepository;
import es.upm.miw.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static es.upm.miw.business_controllers.DateUtils.*;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ReservationDto> readAll() {
        List<Reservation> reservationList = this.reservationRepository.findAll();
        return ReservationDto.getListReservationDto(reservationList);
    }

    public List<ReservationDto> searchByCode(String code) {
        List<Reservation> reservations = this.reservationRepository.findAllByCode(code);
        return ReservationDto.getListReservationDto(reservations);
    }

    public List<Date> searchBookedDateTimesByRoomAndDate(String roomId, Date date) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new NotFoundException("Room id (" + roomId + ")"));
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

    public String makeReservation(ReservationDto reservationDto){
        Reservation reservation= confirmRoomReservation(reservationDto);
        this.reservationRepository.save(reservation);

        return reservation.getCode();
    }

    private Reservation confirmRoomReservation(ReservationDto reservationDto){
        if(!isRoomAvailable(reservationDto.getRoom().getId(), reservationDto.getDateTime(), dateAfterDuration (reservationDto.getDateTime(), reservationDto.getDuration()))){
            throw new BadRequestException("Room is no longer available");
        }

        return new Reservation(reservationDto.getCost(),reservationDto.getHotel(),reservationDto.getRoom(), reservationDto.getDuration(), reservationDto.getDateTime());
    }

    public boolean isRoomAvailable(String roomId, Date startDate, Date endDate){
        List<Reservation> bookedDates= this.reservationRepository.findByRoomId(roomId);

        for(Reservation reservation:bookedDates){
            if((startDate.after(reservation.getDateTime()) && startDate.before(reservation.getEndDateTime()))
                    || (startDate.before(reservation.getDateTime()) && endDate.after(reservation.getDateTime()))){
                return false;
            }
        }

        return true;
    }


}
