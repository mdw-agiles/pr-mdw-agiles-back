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

    @NotNull
    private BigDecimal duration;

    @NotNull
    private Date dateTime;

    public Reservation() {
        // Empty for framework
    }

    public Reservation(@NotNull String code, BigDecimal cost, Hotel hotel, BigDecimal duration, Date dateTime) {
        this.code = code;
        this.cost = cost;
        this.hotel = hotel;
        this.duration = duration;
        this.dateTime = dateTime;
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