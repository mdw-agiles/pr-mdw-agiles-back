package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class TicketRepositoryIT {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void testReadAll() {
        assertTrue(this.ticketRepository.findAll().size() > 0);
    }

}
