package es.upm.miw.business_controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtils {

    private static final ZoneId ZONE_ID = ZoneId.of("Europe/Madrid");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZONE_ID);

    private DateUtils() {
        //Avoid instances
    }

    public static Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZONE_ID).toInstant());
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalDateTime();
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
        return Date.from(LocalDateTime.parse(dateTime).atZone(ZONE_ID).toInstant());
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