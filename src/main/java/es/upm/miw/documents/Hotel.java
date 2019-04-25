package es.upm.miw.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document
public class Hotel {

    @Id
    private String id;

    @NotNull
    private String name;

    @DBRef
    private HotelChain hotelChain;

    public Hotel(@NotNull String name, HotelChain hotelChain) {
        this.name = name;
        this.hotelChain = hotelChain;
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

    public HotelChain getHotelChain() {
        return hotelChain;
    }

    public void setHotelChain(HotelChain hotelChain) {
        this.hotelChain = hotelChain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) &&
                Objects.equals(hotelChain.getId(), hotel.hotelChain.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hotelChain.getId());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hotelChain=" + hotelChain +
                '}';
    }
}


