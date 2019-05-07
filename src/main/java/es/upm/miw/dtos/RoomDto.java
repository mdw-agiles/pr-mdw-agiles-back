package es.upm.miw.dtos;

import es.upm.miw.documents.Hotel;
import es.upm.miw.documents.Room;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomDto {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Hotel hotel;

    public RoomDto() {
        // Empty from framework
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.price = room.getPrice();
        this.hotel = room.getHotel();
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

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

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

    public static List<RoomDto> getListRoomDto(List<Room> roomList){
        List<RoomDto> roomDtoList = new ArrayList<>();
        roomList.forEach(room -> roomDtoList.add(new RoomDto(room)));
        return roomDtoList;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", hotel=" + hotel.getName() +
                '}';
    }
}
