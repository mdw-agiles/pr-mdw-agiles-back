package es.upm.miw.business_controllers;

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
        return new ArrayList<>();
    }
}
