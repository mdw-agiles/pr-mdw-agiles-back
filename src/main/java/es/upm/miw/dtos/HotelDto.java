package es.upm.miw.dtos;

import es.upm.miw.documents.Hotel;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class HotelDto {

    @NotNull
    public String id;

    @NotNull
    public String name;

    @NotNull
    public String hotelChainId;

    @NotNull
    public String hotelChainName;

    public HotelDto() {
        // Empty from framework
    }

    public HotelDto(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.hotelChainId = hotel.getHotelChain().getId();
        this.hotelChainName = hotel.getHotelChain().getName();
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

    public String getHotelChainId() {
        return hotelChainId;
    }

    public void setHotelChainId(String hotelChainId) {
        this.hotelChainId = hotelChainId;
    }

    public String getHotelChainName() {
        return hotelChainName;
    }

    public void setHotelChainName(String hotelChainName) {
        this.hotelChainName = hotelChainName;
    }

    public static List<HotelDto> getListHotelDto(List<Hotel> hotelList) {
        List<HotelDto> hotelDtoList = new ArrayList<>();
        hotelList.forEach(hotel -> hotelDtoList.add(new HotelDto(hotel)));
        return hotelDtoList;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hotelChainId='" + hotelChainId + '\'' +
                ", hotelChainName='" + hotelChainName + '\'' +
                '}';
    }
}
