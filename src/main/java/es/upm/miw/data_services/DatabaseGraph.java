package es.upm.miw.data_services;

import es.upm.miw.documents.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGraph {
    private List<User> userList;
    private List<HotelChain> hotelChainList;

    private List<Hotel> hotelList;

    private List<Room> roomList;

    public DatabaseGraph() {
        this.userList = new ArrayList<>();
        this.hotelChainList = new ArrayList<>();
        this.hotelList = new ArrayList<>();
        this.roomList = new ArrayList<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<HotelChain> getHotelChainList() {
        return hotelChainList;
    }

    public void setHotelChainList(List<HotelChain> hotelChainList) {
        this.hotelChainList = hotelChainList;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
