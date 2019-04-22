package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import es.upm.miw.documents.HotelChain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@TestConfig
public class HotelChainRepositoryIT {

    @Autowired
    private HotelChainRepository hotelChainRepository;

    private HotelChain hotelChain;

    @BeforeEach
    void seedDB() {
        this.hotelChain = new HotelChain("NH Hoteles");
        this.hotelChainRepository.save(hotelChain);
    }

    @Test
    void testFindByName() {
        HotelChain hotelChainDb = hotelChainRepository.findByName("NH Hoteles").get();
        assertEquals("NH Hoteles", hotelChainDb.getName());
    }

    @Test
    void testFindAllHotelChains() {
        List<HotelChain> hotelChains = hotelChainRepository.findAllHotelChains();
        assertNotNull(hotelChains);
    }

    @AfterEach
    void delete() {
        this.hotelChainRepository.delete(hotelChain);
    }

}
