package org.wcs.invoice_api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.wcs.invoice_api.entity.Invoice;
import org.wcs.invoice_api.entity.User;
import org.wcs.invoice_api.repository.UserRepository;
import org.wcs.invoice_api.service.InvoiceService;
import org.wcs.invoice_api.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final UserRepository userRepository;

    public InvoiceController(InvoiceService invoiceService, UserRepository userRepository) {
        this.invoiceService = invoiceService;
        this.userRepository = userRepository;
    }

    // GET /invoices : retourne les factures de l'utilisateur connecté --> fonctionnel
//    @GetMapping
//    @PreAuthorize("isAuthenticated()")
//    public List<Invoice> getUserInvoices() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String email = authentication.getName();
//        System.out.println(email);
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Utilisateur " +
//                "non trouvé avec l'email : " + email));;
//        return invoiceService.getInvoicesForUser(user);
//    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<Invoice> getUserInvoices(@AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = this.userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                "Utilisateur non trouvé"));
        List<Invoice> invoices = invoiceService.getInvoicesForUser(user);
        return invoices;
    }

    // POST /invoices : permet à l'utilisateur de créer une nouvelle facture
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        Invoice invoiceSaved = new Invoice();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = this.userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(
                "Utilisateur non trouvé"));
        invoiceSaved.setUser(user);
        invoiceSaved.setAmount(invoice.getAmount());
        invoiceSaved.setDate(invoice.getDate());
        invoiceSaved.setDescription(invoice.getDescription());
        System.out.println(invoice.getDescription());
        System.out.println(invoiceSaved);
                invoiceService.save(invoiceSaved);
        return invoiceSaved;
    }
}
