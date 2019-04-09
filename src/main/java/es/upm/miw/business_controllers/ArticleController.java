package es.upm.miw.business_controllers;

import es.upm.miw.data_services.DatabaseSeederService;
import es.upm.miw.documents.Article;
import es.upm.miw.documents.Provider;
import es.upm.miw.dtos.ArticleDto;
import es.upm.miw.exceptions.ConflictException;
import es.upm.miw.exceptions.NotFoundException;
import es.upm.miw.repositories.ArticleRepository;
import es.upm.miw.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private DatabaseSeederService databaseSeederService;


    public ArticleDto readArticle(String code) {
        return new ArticleDto(this.articleRepository.findById(code)
                .orElseThrow(() -> new NotFoundException("Article code (" + code + ")")));
    }

    public ArticleDto createArticle(ArticleDto articleDto) {
        String code = articleDto.getCode();
        if (code == null) {
            code = this.databaseSeederService.nextCodeEan();
        }
        if (this.articleRepository.findById(code).isPresent()) {
            throw new ConflictException("Article code (" + code + ")");
        }
        int stock = (articleDto.getStock() == null) ? 10 : articleDto.getStock();
        Provider provider = null;
        if (articleDto.getProvider() != null) {
            provider = this.providerRepository.findById(articleDto.getProvider())
                    .orElseThrow(() -> new NotFoundException("Provider (" + articleDto.getProvider() + ")"));
        }
        Article article = Article.builder(code).description(articleDto.getDescription()).retailPrice(articleDto.getRetailPrice())
                .reference(articleDto.getReference()).stock(stock).provider(provider).build();
        this.articleRepository.save(article);
        return new ArticleDto(article);
    }

}
