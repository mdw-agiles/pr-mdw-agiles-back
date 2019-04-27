package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import es.upm.miw.documents.Reservation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class ReservationRepositoryIT {

    @Autowired
    private ReservationRepository reservationRepository;

    private Reservation reservation;

    @BeforeEach
    void seedDB() {
        this.reservation = new Reservation();
        this.reservation.setCode("1a2b3c");
        this.reservation.setCost(BigDecimal.TEN);
        this.reservation.setDuration(BigDecimal.ONE);
        this.reservationRepository.save(reservation);
    }

    @Test
    void testReadAll() {
        assertFalse(this.reservationRepository.findAll().isEmpty());
    }

    @Test
    void testCheckReservation(){
        String code = "1a2b3c";
        assertEquals(code, this.reservation.getCode());
        assertEquals(BigDecimal.TEN, this.reservation.getCost());
        assertEquals(BigDecimal.ONE, this.reservation.getDuration());
        assertNull(this.reservation.getHotel());
        assertNull(this.reservation.getRoom());
        this.reservation.setCode("0z9y8x");
        this.reservation.setCost(BigDecimal.ZERO);
        this.reservation.setDuration(BigDecimal.ZERO);
        this.reservationRepository.save(reservation);
        assertNotEquals(code, this.reservation.getCode());
        assertNotEquals(BigDecimal.TEN, this.reservation.getCost());
        assertNotEquals(BigDecimal.ONE, this.reservation.getDuration());
    }

    @AfterEach
    void testRemoveReservation(){
        this.reservationRepository.delete(reservation);
    }
}
