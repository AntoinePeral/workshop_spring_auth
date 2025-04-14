package org.wcs.invoice_api.controller;

import org.springframework.web.bind.annotation.*;
import org.wcs.invoice_api.service.InvoiceService;


@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // GET /invoices : retourne les factures de l'utilisateur connecté
    //@GetMapping
    //public List<Invoice> getUserInvoices() {

    //}

    // POST /invoices : permet à l'utilisateur de créer une nouvelle facture
    //@PostMapping
    //public Invoice createInvoice(@RequestBody Invoice invoice) {
        //
    //}
}
