package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import es.upm.miw.documents.Invoice;
import es.upm.miw.documents.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
class InvoiceRepositoryIT {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void testCreate() {
        Ticket ticket = this.ticketRepository.findById("201901121").get();
        Invoice invoice = new Invoice(5, new BigDecimal("20"), new BigDecimal("4.2"), ticket.getUser(), ticket);
        this.invoiceRepository.save(invoice);
        Invoice bdInvoice = this.invoiceRepository.findById(invoice.getId()).get();
        assertEquals(5, bdInvoice.simpleId());
        assertEquals(LocalDate.now().getYear() + "5", invoice.getId());
        assertNotNull(bdInvoice.getCreationDated());
        this.invoiceRepository.deleteById(invoice.getId());
    }

}
