package es.upm.miw.repositories;

import es.upm.miw.documents.Hotel;
import es.upm.miw.dtos.HotelDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {

    List<HotelDto> findByHotelChain(String id);

}
