package es.upm.miw.repositories;

import es.upm.miw.TestConfig;
import es.upm.miw.business_services.Encrypting;
import es.upm.miw.documents.Voucher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;

@TestConfig
class VoucherRepositoryIT {

    @Autowired
    private VoucherRepository voucherRepository;

    private Voucher voucher;

    @BeforeEach
    void seedDb() {
        String id;
        do {
            id = new Encrypting().shortId64UrlSafe();
        } while (this.voucherRepository.existsById(id));
        this.voucher = new Voucher(id, BigDecimal.TEN);
        voucherRepository.save(this.voucher);
    }

    @Test
    void testFindById() {
        Voucher voucher = voucherRepository.findById(this.voucher.getId()).get();
        assertFalse(voucher.isUsed());
    }

    @AfterEach
    void delete() {
        this.voucherRepository.delete(this.voucher);
    }

}
