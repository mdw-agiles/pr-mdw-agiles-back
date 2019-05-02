package es.upm.miw.business_controllers;

import es.upm.miw.documents.Reservation;
import es.upm.miw.dtos.ReservationDto;
import es.upm.miw.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Date> searchBookedDateTimesByRoomAndDate(String roomId, Date date) {
        Date startDate = DateUtils.startOfDayDate(date);
        Date endDate = DateUtils.endOfDayDate(date);
        List<Reservation> reservations = this.reservationRepository.findByRoomIdAndDateTimeBetween(roomId, startDate, endDate);

        List<Date> bookedDates = new ArrayList<>();
        //reservations.stream().map(reservation -> calculateBookedDateTimes(reservation)).collect(Collectors.toList());
        return bookedDates;
    }

    static class DateUtils {

        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());

        private DateUtils() {
            //Avoid instances
        }

        public static Date startOfDayDate(Date date) {
            String dateTime = FORMATTER.format(date.toInstant()) + "T00:00:00";
            return parse(dateTime);
        }

        public static Date endOfDayDate(Date date) {
            String dateTime = FORMATTER.format(date.toInstant()) + "T23:59:59";
            return parse(dateTime);
        }

        private static Date parse(String dateTime) {
            return Date.from(LocalDateTime.parse(dateTime).atZone(ZoneId.systemDefault()).toInstant());
        }

        public static List<Date> datesByHour(Date date, int hours) {
            List<Date> dates = new ArrayList<>();
            LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            for (int i = 0; i < hours; i++) {
                LocalDateTime localDateTimePlusHours = localDateTime.plusHours(i);
                dates.add(Date.from(localDateTimePlusHours.atZone(ZoneId.systemDefault()).toInstant()));
            }

            return dates;
        }
    }
}
