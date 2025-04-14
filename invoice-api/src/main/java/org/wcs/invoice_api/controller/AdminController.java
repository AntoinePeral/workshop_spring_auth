package org.wcs.invoice_api.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcs.invoice_api.entity.Invoice;
import org.wcs.invoice_api.entity.User;
import org.wcs.invoice_api.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final InvoiceService invoiceService;

    public AdminController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // GET /invoices : retourne les factures de tous les utilisateurs
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }
}
