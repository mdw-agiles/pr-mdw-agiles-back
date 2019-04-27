package es.upm.miw.dtos;

import es.upm.miw.documents.Hotel;
import es.upm.miw.documents.Room;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class RoomDto {

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Hotel hotel;

    public RoomDto(@NotNull String name, BigDecimal price, Hotel hotel) {
        this.name = name;
        this.price = price;
        this.hotel = hotel;
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
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", hotel=" + hotel.getName() +
                '}';
    }
}
