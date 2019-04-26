package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import es.upm.miw.documents.Hotel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class HotelRepositoryIT {

    @Autowired
    private HotelRepository hotelRepository;

    private Hotel hotel;

    @BeforeEach
    void seedDB() {
        this.hotel = new Hotel();
        this.hotel.setName("Hotel Riu Plaza España");
        this.hotelRepository.save(hotel);
    }

    @Test
    void testReadAll() {
        assertFalse(this.hotelRepository.findAll().isEmpty());
    }

    @Test
    void testUpdateHotel(){
        String hotelName = "Hotel Riu Plaza España";
        assertEquals(hotelName, this.hotel.getName());
        this.hotel.setName("Hotel Riu Cancun");
        this.hotelRepository.save(hotel);
        assertNotEquals(hotelName, this.hotel.getName());
    }

    @AfterEach
    void testRemoveHotel(){
        this.hotelRepository.delete(hotel);
    }

}
