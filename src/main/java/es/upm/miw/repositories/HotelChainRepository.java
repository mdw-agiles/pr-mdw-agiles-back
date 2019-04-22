package es.upm.miw.repositories;

import es.upm.miw.documents.HotelChain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HotelChainRepository extends MongoRepository<HotelChain, String> {
    Optional<HotelChain> findByName(String name);

    @Query(value = "{}", fields = "{ '_id' : 0, 'name' : 1}")
    List<HotelChain> findAllHotelChains();
}
