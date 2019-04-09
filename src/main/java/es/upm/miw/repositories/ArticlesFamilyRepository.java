package es.upm.miw.repositories;

import es.upm.miw.documents.ArticlesFamily;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticlesFamilyRepository extends MongoRepository<ArticlesFamily, String> {

}
