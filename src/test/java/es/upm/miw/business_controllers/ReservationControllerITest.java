package es.upm.miw.business_controllers;

import es.upm.miw.TestConfig;
import es.upm.miw.documents.Hotel;
import es.upm.miw.documents.Reservation;
import es.upm.miw.documents.Room;
import es.upm.miw.dtos.ReservationDto;
import es.upm.miw.repositories.HotelRepository;
import es.upm.miw.repositories.ReservationRepository;
import es.upm.miw.repositories.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@TestConfig
public class ReservationControllerITest {

    @Autowired
    ReservationController reservationController;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

    @Test
    void givenRoomIdAndDate_thenReturnBookedDateTimes() {
        String roomId = "5cbc2adec2e17403fb397c6b";
        Date date = DateUtils.parse("2019-04-21T00:00");
        List<Date> dates = reservationController.searchBookedDateTimesByRoomAndDate(roomId, date);
        assertNotNull(dates);
        assertThat(dates, is(not(empty())));
        assertThat(dates.size(), is(3));
    }

    @Test
    void givenRoomIdAndStartDateAndEndDate_thenReturnIfRoomIsAvailable() {
        String roomId = "5cbc2adec2e17403fb397c6b";

        Date startDate1 = DateUtils.parse("2020-04-21T11:00");
        Date endDate1 = DateUtils.parse("2020-04-21T19:00");

        Date startDate2 = DateUtils.parse("2020-04-21T12:00");
        Date endDate2 = DateUtils.parse("2020-04-22T10:00");

        Date startDate3 = DateUtils.parse("2020-04-21T09:00");
        Date endDate3 = DateUtils.parse("2020-04-21T22:00");

        Date startDate4 = DateUtils.parse("2020-04-21T08:00");
        Date endDate4 = DateUtils.parse("2020-04-21T12:00");

        Date startDate0 = DateUtils.parse("2019-04-21T00:00");
        Date endDate0 = DateUtils.parse("2019-04-21T10:00");

        assertFalse(reservationController.isRoomAvailable(roomId, startDate1, endDate1));
        assertFalse(reservationController.isRoomAvailable(roomId, startDate2, endDate2));
        assertFalse(reservationController.isRoomAvailable(roomId, startDate3, endDate3));
        assertFalse(reservationController.isRoomAvailable(roomId, startDate4, endDate4));

        assertTrue(reservationController.isRoomAvailable(roomId, startDate0, endDate0));
    }

    @Test
    void givenReservation_thenReturnCode(){

        List<Hotel> hotels = hotelRepository.findByHotelChain("5cbc2d6ec2e17403fb397c7d");
        List<Room> room = roomRepository.findByHotel(hotels.get(0));

        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setCost(new BigDecimal(2));
        reservationDto.setHotel(hotels.get(0));
        reservationDto.setRoom(room.get(0));
        reservationDto.setDuration(new BigDecimal(2));
        reservationDto.setDateTime(DateUtils.parse("2019-04-21T00:00:00"));

        assertNotNull(reservationController.makeReservation(reservationDto));
    }
}
