package es.upm.miw.repositories;

import es.upm.miw.documents.FamilyComposite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyCompositeRepository extends MongoRepository<FamilyComposite, String> {

}
