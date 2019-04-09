package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ProviderRepositoryIT {

    @Autowired
    private ProviderRepository providerRepository;

    @Test
    void testReadAll() {
        assertTrue(this.providerRepository.findAll().size() > 1);
    }

}
