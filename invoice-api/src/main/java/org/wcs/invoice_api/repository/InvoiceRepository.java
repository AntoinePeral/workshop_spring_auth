package org.wcs.invoice_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wcs.invoice_api.entity.Invoice;
import org.wcs.invoice_api.entity.User;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByUser(User user);
}
