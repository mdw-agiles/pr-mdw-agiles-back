package es.upm.miw.repositories;

import es.upm.miw.documents.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BudgetRepository extends MongoRepository<Budget, String> {

}
