package es.upm.miw.dtos;

import es.upm.miw.documents.Hotel;

import javax.validation.constraints.NotNull;

public class HotelDto {

    @NotNull
    public String name;

    @NotNull
    public String hotelChainId;

    public HotelDto() {
        // Empty from framework
    }

    public HotelDto(Hotel hotel) {
        this.name = hotel.getName();
        this.hotelChainId = hotel.getHotelChain().getId();
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

    @Override
    public String toString() {
        return "HotelDto{" +
                "name='" + name + '\'' +
                ", hotelChainId='" + hotelChainId + '\'' +
                '}';
    }
}
