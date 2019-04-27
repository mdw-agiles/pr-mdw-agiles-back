package es.upm.miw.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Document
public class Room {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

    @DBRef
    private Hotel hotel;

    public Room() {
        // Empty for framework
    }

    public Room(@NotNull String name, BigDecimal price, Hotel hotel) {
        this.name = name;
        this.price = price;
        this.hotel = hotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room hotel = (Room) o;
        return Objects.equals(name, hotel.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hotel.getId());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", hotel=" + hotel.getName() +
                '}';
    }
}