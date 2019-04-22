package es.upm.miw.rest_controllers;

import es.upm.miw.business_controllers.HotelChainController;
import es.upm.miw.dtos.HotelChainDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(HotelChainResource.CHAINS)
public class HotelChainResource {

    public static final String CHAINS = "/chains";

    @Autowired
    private HotelChainController hotelChainController;

    @GetMapping
    public List<HotelChainDto> readAll() { return this.hotelChainController.readAll(); }
}
