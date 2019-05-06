package es.upm.miw.business_controllers;

import es.upm.miw.documents.Hotel;
import es.upm.miw.documents.HotelChain;
import es.upm.miw.dtos.HotelDto;
import es.upm.miw.repositories.HotelChainRepository;
import es.upm.miw.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelChainRepository hotelChainRepository;

    public List<HotelDto> readAll() {
        List<Hotel> hotelList = this.hotelRepository.findAll();
        return HotelDto.getListHotelDto(hotelList);
    }

    public List<HotelDto> readAllByHotelChain(String hotelChain) {
        List<HotelChain> hotelChainList = hotelChainRepository.findAll();
        HotelChain hotelChainByName = hotelChainList.stream()
                .filter(hc -> hotelChain.equals(hc.getName()))
                .findAny()
                .orElse(null);
        if(hotelChainByName != null){
            return HotelDto.getListHotelDto(this.hotelRepository.findByHotelChain(hotelChainByName.getId()));
        } else {
            return Collections.emptyList();
        }
    }
}
