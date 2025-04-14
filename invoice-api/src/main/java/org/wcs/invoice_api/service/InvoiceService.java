package org.wcs.invoice_api.service;

import org.springframework.stereotype.Service;
import org.wcs.invoice_api.entity.Invoice;
import org.wcs.invoice_api.entity.User;
import org.wcs.invoice_api.repository.InvoiceRepository;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getInvoicesForUser(User user) {
        return invoiceRepository.findByUser(user);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}

