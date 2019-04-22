package es.upm.miw.data_services;

import es.upm.miw.documents.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGraph {
    private List<User> userList;
    private List<HotelChain> hotelChainList;

    public DatabaseGraph() {
        this.userList = new ArrayList<>();
        this.hotelChainList = new ArrayList<>();
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
}
