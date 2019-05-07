package es.upm.miw.business_controllers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static es.upm.miw.business_controllers.DateUtils.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DateUtilsTest {

    public static final Date DATE = parse("2019-04-04T22:00");

    @Test
    void givenDate_thenReturnStartOfDayDate() {
        Date dateStartOfDay = parse("2019-04-04T00:00:00");
        Date date = DateUtils.startOfDayDate(DATE);
        assertEquals(date, dateStartOfDay);
    }

    @Test
    void givenDate_thenReturnEndOfDayDate() {
        Date dateEndOfDay = parse("2019-04-04T23:59:59");
        Date date = DateUtils.endOfDayDate(DATE);
        assertEquals(date, dateEndOfDay);
    }

    @Test
    void givenDate_thenReturnBeforeStartOfDayDate() {
        Date dateBeforeStartOfDay = parse("2019-04-03T23:59:59");
        Date date = DateUtils.beforeStartOfDayDate(DATE);
        assertEquals(date, dateBeforeStartOfDay);
    }

    @Test
    void givenDate_thenReturnAfterEndOfDayDate() {
        Date dateAfterEndOfDay = parse("2019-04-05T00:00:00");
        Date date = afterEndOfDayDate(DATE);
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
    void givenDateAndDuration_thenReturnEndDate() {
        Date date = parse("2019-04-21T00:00");
        Date datePlusOneHour = parse("2019-04-21T01:00");
        Date datePlusOneHourTest = dateAfterDuration(date, new BigDecimal("1"));
        assertEquals(datePlusOneHour, datePlusOneHourTest);

        Date datePlus10h53m = parse("2019-04-21T10:53");
        Date datePlus10h53mTest = dateAfterDuration(date, new BigDecimal("10.894945454545455"));
        assertEquals(datePlus10h53m, datePlus10h53mTest);
    }

}
