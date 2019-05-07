package es.upm.miw.repositories;

import es.upm.miw.documents.HotelChain;
import es.upm.miw.dtos.HotelChainDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HotelChainRepository extends MongoRepository<HotelChain, String> {

    @Query(value = "{}", fields = "{ '_id' : 1, 'name' : 1}")
    List<HotelChainDto> findAllHotelChains();
}
