package es.upm.miw.business_controllers;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DateUtilsTest {

    @Test
    void givenDate_thenReturnStartOfDayDate() {
        Date date = DateUtils.startOfDayDate(new Date());
        assertThat(date.getHours(), is(0));
        assertThat(date.getMinutes(), is(0));
        assertThat(date.getSeconds(), is(0));
    }

    @Test
    void givenDate_thenReturnEndOfDayDate() {
        Date date = DateUtils.endOfDayDate(new Date());
        assertThat(date.getHours(), is(23));
        assertThat(date.getMinutes(), is(59));
        assertThat(date.getSeconds(), is(59));
    }

    @Test
    void givenDate_thenReturnBeforeStartOfDayDate() {
        LocalDateTime localDateTimeBeforeStartOfDay = LocalDate.now().atStartOfDay().minusSeconds(1);
        Date dateBeforeStartOfDay = DateUtils.convertToDate(localDateTimeBeforeStartOfDay);
        Date date = DateUtils.beforeStartOfDayDate(new Date());
        assertEquals(date, dateBeforeStartOfDay);
    }

    @Test
    void givenDate_thenReturnAfterEndOfDayDate() {
        LocalDateTime localDateTimeAfterEndOfDay = LocalDate.now().plusDays(1).atStartOfDay();
        Date dateAfterEndOfDay = DateUtils.convertToDate(localDateTimeAfterEndOfDay);
        Date date = DateUtils.afterEndOfDayDate(new Date());
        assertEquals(date, dateAfterEndOfDay);
    }

    @Test
    void givenDateAndHours_thenReturnDatesByHour() {
        Date date = DateUtils.parse("2019-04-21T00:00");
        Date datePlusOneHour = DateUtils.parse("2019-04-21T01:00");
        List<Date> dates = DateUtils.datesByHour(date, 2);
        assertThat(dates.size(), is(2));
        assertThat(dates.get(0), is(date));
        assertThat(dates.get(1), is(datePlusOneHour));
    }

}
