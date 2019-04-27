package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import es.upm.miw.documents.Hotel;
import es.upm.miw.documents.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class RoomRepositoryIT {

    @Autowired
    private RoomRepository roomRepository;

    private Room room;

    @BeforeEach
    void seedDB() {
        this.room = new Room();
        this.room.setName("Room test");
        this.room.setPrice(BigDecimal.TEN);
        this.roomRepository.save(room);
    }

    @Test
    void testReadAll() {
        assertFalse(this.roomRepository.findAll().isEmpty());
    }

    @Test
    void testCheckRoom(){
        String roomName = "Room test";
        assertEquals(roomName, this.room.getName());
        assertEquals(BigDecimal.TEN, this.room.getPrice());
        assertNull(this.room.getHotel());
        this.room.setName("Room test 2");
        this.room.setPrice(BigDecimal.ONE);
        this.roomRepository.save(room);
        assertNotEquals(roomName, this.room.getName());
    }

    @AfterEach
    void testRemoveRoom(){
        this.roomRepository.delete(room);
    }

}
