package es.upm.miw.business_controllers;

import es.upm.miw.TestConfig;
import es.upm.miw.data_services.DatabaseSeederService;
import es.upm.miw.dtos.CashierLastOutputDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class CashierClosureControllerIT {

    @Autowired
    private CashierClosureController cashierClosureController;

    @Autowired
    private DatabaseSeederService databaseSeederService;

    @Test
    void testReadCashierClosureLast() {
        CashierLastOutputDto cashierLastOutputDto = cashierClosureController.readCashierClosureLast();
        assertNotNull(cashierLastOutputDto);
        assertTrue(cashierLastOutputDto.isClosed());
    }

}
