package es.upm.miw.repositories;

import es.upm.miw.documents.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {

    List<Hotel> findByHotelChain(String id);

}
