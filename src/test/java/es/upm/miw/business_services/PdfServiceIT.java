package es.upm.miw.business_services;

import es.upm.miw.TestConfig;
import es.upm.miw.repositories.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class PdfServiceIT {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void testPdfGenerateTicket() {
        assertNotNull(this.pdfService.generateTicket(this.ticketRepository.findById("201901121").get()));
    }

}
