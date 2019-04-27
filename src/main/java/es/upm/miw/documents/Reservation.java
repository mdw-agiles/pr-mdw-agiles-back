package es.upm.miw.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Document
public class Reservation {

    @Id
    private String id;

    @NotNull
    private String code;

    @NotNull
    private BigDecimal cost;

    @DBRef
    private Hotel hotel;

    @DBRef
    private Room room;

    @NotNull
    private BigDecimal duration;

    private LocalDateTime dateTime;

    public Reservation() {
        // Empty for framework
    }

    public Reservation(@NotNull String code, BigDecimal cost, Hotel hotel, Room room, BigDecimal duration, String dateTime) {
        this.code = code;
        this.cost = cost;
        this.hotel = hotel;
        this.room = room;
        this.duration = duration;
        this.dateTime = LocalDateTime.parse(dateTime);
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public BigDecimal getCost() { return cost; }

    public void setCost(BigDecimal cost) { this.cost = cost; }

    public Hotel getHotel() { return hotel; }

    public void setHotel(Hotel hotel) { this.hotel = hotel; }

    public Room getRoom() { return room; }

    public void setRoom(Room room) { this.room = room; }

    public BigDecimal getDuration() { return duration; }

    public void setDuration(BigDecimal duration) { this.duration = duration; }

    public LocalDateTime getDateTime() { return dateTime; }

    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation reservation = (Reservation) o;
        return Objects.equals(code, reservation.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, hotel.getId());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", cost='" + cost + '\'' +
                ", hotel=" + hotel.getName() +
                ", duration='" + duration + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}