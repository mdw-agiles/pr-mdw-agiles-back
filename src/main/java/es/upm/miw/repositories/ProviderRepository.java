package es.upm.miw.repositories;

import es.upm.miw.documents.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderRepository extends MongoRepository<Provider, String> {

}
