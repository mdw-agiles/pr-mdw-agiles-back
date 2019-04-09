package es.upm.miw.business_controllers;

import es.upm.miw.TestConfig;
import es.upm.miw.dtos.ArticleDto;
import es.upm.miw.exceptions.ConflictException;
import es.upm.miw.exceptions.NotFoundException;
import es.upm.miw.repositories.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class ArticleControllerIT {

    @Autowired
    private ArticleController articleController;

    @Autowired
    private ArticleRepository articleRepository;

    private ArticleDto articleDto;

    @BeforeEach
    void seed() {
        this.articleDto = new ArticleDto("non exist", "descrip", "ref", BigDecimal.TEN, null);
    }

    @Test
    void testConflictRequestException() {
        this.articleDto.setCode("8400000000017");
        assertThrows(ConflictException.class, () -> this.articleController.createArticle(this.articleDto));
    }

    @Test
    void testProviderNotFoundException() {
        this.articleDto.setProvider("non exist");
        assertThrows(NotFoundException.class, () -> this.articleController.createArticle(articleDto));
    }

    @Test
    void testInitStock() {
        assertNotNull(this.articleController.createArticle(articleDto).getStock());
        this.articleRepository.deleteById(this.articleDto.getCode());
    }

}
