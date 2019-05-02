package es.upm.miw.repositories;

import es.upm.miw.documents.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    List<Reservation> findAllByCode(String code);
    List<Reservation> findByRoom(String roomId);
    List<Reservation> findByDateTimeBetween(Date startDate, Date endDate);
    List<Reservation> findByRoomIdAndDateTimeBetween(String roomId, Date startDate, Date endDate);
    @Query(value="{ 'room.$id' : ?0 }")
    List<Reservation> findByRoomId(String roomId);
}
