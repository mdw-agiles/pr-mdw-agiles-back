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
        Date beforeStartOfDayDate = DateUtils.beforeStartOfDayDate(date);
        Date afterEndOfDayDate = DateUtils.afterEndOfDayDate(date);
        List<Reservation> reservations = this.reservationRepository.findByRoomIdAndDateTimeBetween(roomId, beforeStartOfDayDate, afterEndOfDayDate);
        return buildBookedDatesByHours(reservations);
    }

    private List<Date> buildBookedDatesByHours(List<Reservation> reservations) {
        List<Date> bookedDates = new ArrayList<>();
        reservations.stream().forEach(reservation -> {
            bookedDates.addAll(DateUtils.datesByHour(reservation.getDateTime(), reservation.getDuration().longValue()));
        });
        return bookedDates;
    }

    static class DateUtils {

        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneId.systemDefault());

        private DateUtils() {
            //Avoid instances
        }

        public static Date convertToDate(LocalDateTime localDateTime) {
            return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        }

        public static LocalDateTime convertToLocalDateTime(Date date) {
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }

        public static Date startOfDayDate(Date date) {
            String dateTime = FORMATTER.format(date.toInstant()) + "T00:00:00";
            return parse(dateTime);
        }

        public static Date endOfDayDate(Date date) {
            String dateTime = FORMATTER.format(date.toInstant()) + "T23:59:59";
            return parse(dateTime);
        }

        public static Date parse(String dateTime) {
            return Date.from(LocalDateTime.parse(dateTime).atZone(ZoneId.systemDefault()).toInstant());
        }

        public static List<Date> datesByHour(Date date, long hours) {
            List<Date> dates = new ArrayList<>();
            LocalDateTime localDateTime = DateUtils.convertToLocalDateTime(date);
            for (int i = 0; i < hours; i++) {
                LocalDateTime localDateTimePlusHours = localDateTime.plusHours(i);
                dates.add(DateUtils.convertToDate(localDateTimePlusHours));
            }
            return dates;
        }

        public static Date beforeStartOfDayDate(Date date) {
            return DateUtils.convertToDate(
                    DateUtils.convertToLocalDateTime(
                            DateUtils.startOfDayDate(date)).minusSeconds(1));
        }

        public static Date afterEndOfDayDate(Date date) {
            return DateUtils.convertToDate(
                    DateUtils.convertToLocalDateTime(
                            DateUtils.endOfDayDate(date)).plusSeconds(1));
        }
    }
}
