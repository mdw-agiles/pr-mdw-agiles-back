package es.upm.miw.repositories;

import es.upm.miw.documents.Reservation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    List<Reservation> findAllByCode(String code);

    List<Reservation> findByRoomIdAndDateTimeBetween(String roomId, Date startDate, Date endDate);

    // NOT WORK throw java.lang.IllegalArgumentException: invalid hexadecimal representation of an ObjectId: [_param_0]
    //@Query(value="{ 'room' : { '$ref' : 'room' , '$id' : { '$oid' : ?0}}, 'dateTime' : { '$gte' : { '$date' : ?1 }, '$lte' : { '$date' : ?2 } } }")
    //List<Reservation> findByRoomIdAndDateTimeBetweenEqual(String roomId, Date startDate, Date endDate);

    //NOT WORK throw org.bson.json.JsonParseException: Invalid JSON input. Position: 110. Character: '?'
    //@Query("{ 'room' : { '$ref' : 'room' , '$id' : ?0 }, 'dateTime' : { '$gte' : { '$date' : ?1 }, '$lte' : { '$date' : ?2 } } }")
    //List<Reservation> findByRoomIdAndDateTimeBetweenEqual(ObjectId roomId, Date startDate, Date endDate);
}
