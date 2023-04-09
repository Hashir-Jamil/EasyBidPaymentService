package com.EasyBid.PaymentService.repository;

import com.EasyBid.PaymentService.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice findByItemId(Long itemId);

}
