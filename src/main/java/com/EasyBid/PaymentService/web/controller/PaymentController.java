package com.EasyBid.PaymentService.web.controller;

import com.EasyBid.PaymentService.service.PaymentService;
import com.EasyBid.PaymentService.web.dto.PaymentOptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checkout")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        super();
        this.paymentService = paymentService;
    }

    @ModelAttribute("user")
    public PaymentOptionDTO paymentOptionDTO() {
        return new PaymentOptionDTO();
    }

    @GetMapping
    public String showPaymentForm() {
        return "checkout";
    }

    @PostMapping
    public String paymentReceipt(@ModelAttribute("paymentOption")PaymentOptionDTO paymentOptionDTO) {
        paymentService.save(paymentOptionDTO);
        return "redirect:/checkout?success";
    }

}
