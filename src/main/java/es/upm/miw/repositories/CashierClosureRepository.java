package es.upm.miw.repositories;

import es.upm.miw.documents.CashierClosure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CashierClosureRepository extends MongoRepository<CashierClosure, String> {

    CashierClosure findFirstByOrderByOpeningDateDesc();

}
