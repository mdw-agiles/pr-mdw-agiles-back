package es.upm.miw.business_controllers;

import es.upm.miw.documents.Room;
import es.upm.miw.dtos.RoomDto;
import es.upm.miw.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomDto> readAll() {
        List<Room> roomList = this.roomRepository.findAll();
        return RoomDto.getListRoomDto(roomList);
    }

    public List<RoomDto> searchByHotel(String hotelName) {
        List<Room> roomList = roomRepository.findAll();
        Room roomByHotelName = roomList.stream()
                .filter(room -> hotelName.equals(room.getHotel().getName()))
                .findAny()
                .orElse(null);
        return roomByHotelName != null
            ? RoomDto.getListRoomDto(this.roomRepository.findByHotel(roomByHotelName.getHotel()))
            : new ArrayList<>();
    }
}
