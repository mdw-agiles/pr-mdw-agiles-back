package es.upm.miw.business_controllers;

import es.upm.miw.dtos.HotelChainDto;
import es.upm.miw.repositories.HotelChainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class HotelChainController {

    @Autowired
    private HotelChainRepository hotelChainRepository;


    public List<HotelChainDto> readAll() {
        return this.hotelChainRepository.findAllHotelChains();
    }
}
