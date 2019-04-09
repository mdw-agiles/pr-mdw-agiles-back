package es.upm.miw.repositories;

import es.upm.miw.documents.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {

}
