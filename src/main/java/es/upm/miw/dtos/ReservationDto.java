package es.upm.miw.dtos;

import es.upm.miw.documents.Hotel;
import es.upm.miw.documents.Reservation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class ReservationDto {

    @Id
    private String id;

    @NotNull
    private String code;

    @NotNull
    private BigDecimal cost;

    @DBRef
    private Hotel hotel;

    @NotNull
    private BigDecimal duration;

    @NotNull
    private Date dateTime;

    public ReservationDto() {
        // Empty for framework
    }

    public ReservationDto(Reservation reservation) {
        this.code = reservation.getCode();
        this.cost = reservation.getCost();
        this.hotel = reservation.getHotel();
        this.duration = reservation.getDuration();
        this.dateTime = reservation.getDateTime();
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public BigDecimal getCost() { return cost; }

    public void setCost(BigDecimal cost) { this.cost = cost; }

    public Hotel getHotel() { return hotel; }

    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    public BigDecimal getDuration() { return duration; }

    public void setDuration(BigDecimal duration) { this.duration = duration; }

    public Date getDateTime() { return dateTime; }

    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationDto)) return false;
        ReservationDto reservation = (ReservationDto) o;
        return Objects.equals(code, reservation.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, hotel.getId());
    }

    public static List<ReservationDto> getListRoomDto(List<Reservation> roomList){
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        roomList.forEach(res -> reservationDtoList.add(new ReservationDto(res)));
        return reservationDtoList;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", cost='" + cost + '\'' +
                ", hotel=" + hotel.getName() +
                ", duration='" + duration + '\'' +
                ", dateTime='" + dateTime.toString() + '\'' +
                '}';
    }
}