package com.EasyBid.PaymentService.web.controller;

import com.EasyBid.PaymentService.service.InvoiceService;
import com.EasyBid.PaymentService.web.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PaymentController {

    private InvoiceService invoiceService;

    @Autowired
    public PaymentController(InvoiceService invoiceService) {
        super();
        this.invoiceService = invoiceService;
    }

    @ModelAttribute("user")
    public InvoiceDTO paymentOptionDTO() {
        return new InvoiceDTO();
    }

    @GetMapping("/")
    public String showPaymentForm() {
        return "checkout";
    }

    @PostMapping
    public String paymentReceipt(@ModelAttribute("invoice") InvoiceDTO invoiceDTO) {
        invoiceService.save(invoiceDTO);
        return "redirect:/receipt";
    }

    @GetMapping("/receipt")
    public String showReceipt() {
        return "receipt";
    }

}
