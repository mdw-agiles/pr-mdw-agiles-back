package es.upm.miw.repositories;

import es.upm.miw.documents.FamilyArticle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyArticleRepository extends MongoRepository<FamilyArticle, String> {

}
