package es.upm.miw.repositories;

import es.upm.miw.documents.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {

    Ticket findFirstByOrderByCreationDateDescIdDesc();

}
