package es.upm.miw.rest_controllers;

import es.upm.miw.dtos.CashierClosureInputDto;
import es.upm.miw.dtos.CashierLastOutputDto;
import es.upm.miw.dtos.CashierStateOutputDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class CashierClosureResourceIT {

    @Autowired
    private RestService restService;

    @Test
    void testGetCashierClosureLast() {
        CashierLastOutputDto cashierClosureLastDto = this.restService.loginAdmin()
                .restBuilder(new RestBuilder<CashierLastOutputDto>()).clazz(CashierLastOutputDto.class)
                .path(CashierClosureResource.CASHIER_CLOSURES).path(CashierClosureResource.LAST)
                .get().build();
        assertTrue(cashierClosureLastDto.isClosed());
    }

    @Test
    void testGetCashierClosureLastTotals() {
        this.restService.loginAdmin().restBuilder().path(CashierClosureResource.CASHIER_CLOSURES)
                .post().build();
        CashierStateOutputDto cashierStateOutputDto = this.restService.loginAdmin()
                .restBuilder(new RestBuilder<CashierStateOutputDto>()).clazz(CashierStateOutputDto.class)
                .path(CashierClosureResource.CASHIER_CLOSURES).path(CashierClosureResource.LAST)
                .path(CashierClosureResource.STATE)
                .get().build();
        assertNotNull(cashierStateOutputDto);
        CashierClosureInputDto cashierClosureInputDto = new CashierClosureInputDto(BigDecimal.ZERO, BigDecimal.ZERO, "");
        this.restService.loginAdmin().restBuilder()
                .path(CashierClosureResource.CASHIER_CLOSURES).path(CashierClosureResource.LAST)
                .body(cashierClosureInputDto)
                .patch().build();
    }

    @Test
    void testGetCashierClosureLastTotalsCashierClosed() {
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () ->
                this.restService.loginAdmin().restBuilder()
                        .path(CashierClosureResource.CASHIER_CLOSURES).path(CashierClosureResource.LAST)
                        .path(CashierClosureResource.STATE)
                        .get().build());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


}
