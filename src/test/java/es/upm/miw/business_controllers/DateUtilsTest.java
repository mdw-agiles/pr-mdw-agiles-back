package es.upm.miw.business_controllers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static es.upm.miw.business_controllers.DateUtils.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DateUtilsTest {

    @Test
    void givenDate_thenReturnStartOfDayDate() {
        LocalDateTime localDateTimeStartOfDay = LocalDate.now().atStartOfDay();
        Date dateStartOfDay = convertToDate(localDateTimeStartOfDay);
        Date date = DateUtils.startOfDayDate(new Date());
        assertEquals(date, dateStartOfDay);
    }

    @Test
    void givenDate_thenReturnEndOfDayDate() {
        LocalDateTime localDateTimeEndOfDay = LocalDate.now().plusDays(1).atStartOfDay().minusSeconds(1);
        Date dateEndOfDay = convertToDate(localDateTimeEndOfDay);
        Date date = DateUtils.endOfDayDate(new Date());
        assertEquals(date, dateEndOfDay);
    }

    @Test
    void givenDate_thenReturnBeforeStartOfDayDate() {
        LocalDateTime localDateTimeBeforeStartOfDay = LocalDate.now().atStartOfDay().minusSeconds(1);
        Date dateBeforeStartOfDay = convertToDate(localDateTimeBeforeStartOfDay);
        Date date = DateUtils.beforeStartOfDayDate(new Date());
        assertEquals(date, dateBeforeStartOfDay);
    }

    @Test
    void givenDate_thenReturnAfterEndOfDayDate() {
        LocalDateTime localDateTimeAfterEndOfDay = LocalDate.now().plusDays(1).atStartOfDay();
        Date dateAfterEndOfDay = convertToDate(localDateTimeAfterEndOfDay);
        Date date = afterEndOfDayDate(new Date());
        assertEquals(date, dateAfterEndOfDay);
    }

    @Test
    void givenDateAndHours_thenReturnDatesByHour() {
        Date date = parse("2019-04-21T00:00");
        Date datePlusOneHour = parse("2019-04-21T01:00");
        List<Date> dates = datesByHour(date, 2);
        assertThat(dates.size(), is(2));
        assertThat(dates.get(0), is(date));
        assertThat(dates.get(1), is(datePlusOneHour));
    }
    @Test
    void givenDateAndDuration_thenReturnEndDate(){

        Date date = parse("2019-04-21T00:00");

        Date datePlusOneHour = parse("2019-04-21T01:00");
        Date datePlusOneHourTest = dateAfterDuration (date, new BigDecimal("1"));

        assertEquals(datePlusOneHour, datePlusOneHourTest);

        Date datePlus10h53m = parse ("2019-04-21T10:53");
        Date datePlus10h53mTest = dateAfterDuration (date, new BigDecimal("10.894945454545455"));

        assertEquals(datePlus10h53m, datePlus10h53mTest);
    }

}
