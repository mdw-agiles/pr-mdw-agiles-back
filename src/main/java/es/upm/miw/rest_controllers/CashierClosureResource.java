package es.upm.miw.rest_controllers;

import es.upm.miw.business_controllers.CashierClosureController;
import es.upm.miw.dtos.CashierClosureInputDto;
import es.upm.miw.dtos.CashierLastOutputDto;
import es.upm.miw.dtos.CashierStateOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('OPERATOR')")
@RestController
@RequestMapping(CashierClosureResource.CASHIER_CLOSURES)
public class CashierClosureResource {

    public static final String CASHIER_CLOSURES = "/cashier-closures";

    public static final String LAST = "/last";

    public static final String STATE = "/state";

    @Autowired
    private CashierClosureController cashierClosureController;

    @PostMapping
    public void openCashierClosure() {
        cashierClosureController.createCashierClosure();
    }

    @GetMapping(value = LAST)
    public CashierLastOutputDto getCashierClosureLast() {
        return cashierClosureController.readCashierClosureLast();
    }

    @GetMapping(value = LAST + STATE)
    public CashierStateOutputDto readStateFromLast() {
        return this.cashierClosureController.readTotalsFromLast();
    }

    @PatchMapping(value = LAST)
    public void closeCashierClosure(@Valid @RequestBody CashierClosureInputDto cashierClosureInputDto) {
        cashierClosureController.close(cashierClosureInputDto);
    }

}
