package es.upm.miw.business_services;

import es.upm.miw.TestConfig;
import es.upm.miw.exceptions.PdfException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
public class PdfBuilderIT {

    @Test
    void testPdfBuilder() {
        assertThrows(PdfException.class, () -> new PdfBuilder("&-InvalidName"));
    }
}
