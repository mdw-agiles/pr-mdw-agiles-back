package es.upm.miw.repositories;

import es.upm.miw.documents.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
}
