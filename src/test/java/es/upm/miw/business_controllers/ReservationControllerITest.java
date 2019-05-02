package es.upm.miw.business_controllers;

import es.upm.miw.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@TestConfig
public class ReservationControllerITest {

    @Autowired
    ReservationController reservationController;

    @Test
    void givenRoomIdAndDate_thenReturnBookedDateTimes() {
        String roomId = "5cbc2adec2e17403fb397c6b";
        Date date = DateUtils.parse("2019-04-21T00:00");
        List<Date> dates = reservationController.searchBookedDateTimesByRoomAndDate(roomId, date);
        assertNotNull(dates);
        assertThat(dates, is(not(empty())));
        assertThat(dates.size(), is(3));
    }
}
