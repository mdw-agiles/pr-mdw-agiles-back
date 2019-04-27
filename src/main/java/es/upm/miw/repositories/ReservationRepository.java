package es.upm.miw.repositories;

import es.upm.miw.documents.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    List<Reservation> findAllByCode(String code);
}
