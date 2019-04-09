package es.upm.miw.repositories;

import es.upm.miw.documents.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoucherRepository extends MongoRepository<Voucher, String> {

}
