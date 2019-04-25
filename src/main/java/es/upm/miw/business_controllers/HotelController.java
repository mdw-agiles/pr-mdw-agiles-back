package es.upm.miw.business_controllers;

import es.upm.miw.documents.Hotel;
import es.upm.miw.dtos.HotelDto;
import es.upm.miw.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDto> readAll() {
        List<Hotel> hotelList = this.hotelRepository.findAll();
        return convertResultDomainModelToDto(hotelList);
    }

    public List<HotelDto> readAllByHotelChainId(String id) {
        return this.hotelRepository.findByHotelChain(id);
    }

    private List<HotelDto> convertResultDomainModelToDto(List<Hotel> all) {
        List<HotelDto> hotelDtos = new ArrayList<>();
        for (Hotel hotel : all) {
            hotelDtos.add(new HotelDto(hotel));
        }
        return hotelDtos;
    }
}
