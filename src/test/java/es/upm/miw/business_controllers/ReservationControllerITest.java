package es.upm.miw.business_controllers;

import es.upm.miw.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@TestConfig
public class ReservationControllerITest {

    @Autowired
    ReservationController reservationController;

    @Test
    void givenDate_thenReturnStartOfDayDate() {
        Date date = ReservationController.DateUtils.startOfDayDate(new Date());
        assertThat(date.getHours(), is(0));
        assertThat(date.getMinutes(), is(0));
        assertThat(date.getSeconds(), is(0));
    }

    @Test
    void givenDate_thenReturnEndOfDayDate() {
        Date date = ReservationController.DateUtils.endOfDayDate(new Date());
        assertThat(date.getHours(), is(23));
        assertThat(date.getMinutes(), is(59));
        assertThat(date.getSeconds(), is(59));
    }

    @Test
    void givenDate_thenReturnBeforeStartOfDayDate() {
        LocalDateTime localDateTimeBeforeStartOfDay = LocalDate.now().atStartOfDay().minusSeconds(1);
        Date dateBeforeStartOfDay = ReservationController.DateUtils.convertToDate(localDateTimeBeforeStartOfDay);
        Date date = ReservationController.DateUtils.beforeStartOfDayDate(new Date());
        assertEquals(date, dateBeforeStartOfDay);
    }

    @Test
    void givenDate_thenReturnAfterEndOfDayDate() {
        LocalDateTime localDateTimeAfterEndOfDay = LocalDate.now().plusDays(1).atStartOfDay();
        Date dateAfterEndOfDay = ReservationController.DateUtils.convertToDate(localDateTimeAfterEndOfDay);
        Date date = ReservationController.DateUtils.afterEndOfDayDate(new Date());
        assertEquals(date, dateAfterEndOfDay);
    }

    @Test
    void givenDateAndHours_thenReturnDatesByHour() {
        Date date = ReservationController.DateUtils.parse("2019-04-21T00:00");
        Date datePlusOneHour = ReservationController.DateUtils.parse("2019-04-21T01:00");
        List<Date> dates = ReservationController.DateUtils.datesByHour(date, 2);
        assertThat(dates.size(), is(2));
        assertThat(dates.get(0), is(date));
        assertThat(dates.get(1), is(datePlusOneHour));
    }

    @Test
    void givenRoomIdAndDate_thenReturnBookedDateTimes() {
        String roomId = "5cbc2adec2e17403fb397c6b";
        Date date = ReservationController.DateUtils.parse("2019-04-21T00:00");
        List<Date> dates = reservationController.searchBookedDateTimesByRoomAndDate(roomId, date);
        assertNotNull(dates);
        assertThat(dates, is(not(empty())));
        assertThat(dates.size(), is(3));
    }
}
