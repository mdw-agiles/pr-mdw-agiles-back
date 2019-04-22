package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import es.upm.miw.documents.HotelChain;
import es.upm.miw.dtos.HotelChainDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@TestConfig
public class HotelChainRepositoryIT {

    @Autowired
    private HotelChainRepository hotelChainRepository;

    private HotelChain hotelChain;

    @BeforeEach
    void seedDB() {
        this.hotelChain = new HotelChain("MIW Test Hotels");
        this.hotelChainRepository.save(hotelChain);
    }

    @Test
    void testFindAllHotelChains() {
        List<HotelChainDto> hotelChains = hotelChainRepository.findAllHotelChains();
        assertNotNull(hotelChains);
    }

    @AfterEach
    void delete() {
        this.hotelChainRepository.delete(hotelChain);
    }

}
