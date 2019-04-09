package es.upm.miw.repositories;

import es.upm.miw.documents.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {

}
