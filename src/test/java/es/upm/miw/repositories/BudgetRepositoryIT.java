package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import es.upm.miw.documents.Budget;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class BudgetRepositoryIT {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void testReadAll() {
        Budget budget = new Budget(this.ticketRepository.findById("201901121").get().getShoppingList());
        this.budgetRepository.save(budget);
        assertTrue(this.budgetRepository.findAll().size() > 0);
        this.budgetRepository.delete(budget);
    }

    @Test
    void testRead() {
        Budget budget = this.budgetRepository.findAll().stream()
                .filter(bud -> bud.getShoppingList()[0].getDescription().equals("test-budget")).findFirst().get();
        assertNotNull(budget.getCreationDate());
        assertEquals(3, budget.getShoppingList().length);
        assertEquals(0, new BigDecimal("79.7").compareTo(budget.getBudgetTotal()));
    }
}
