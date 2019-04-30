package es.upm.miw.repositories;

import es.upm.miw.documents.Hotel;
import es.upm.miw.documents.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomRepository extends MongoRepository<Room, String> {
    List<Room> findByHotel(Hotel hotel);
}
