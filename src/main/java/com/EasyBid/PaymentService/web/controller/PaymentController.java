package com.EasyBid.PaymentService.web.controller;

import com.EasyBid.PaymentService.Model.AuctionItem;
import com.EasyBid.PaymentService.service.InvoiceService;
import com.EasyBid.PaymentService.web.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/")
public class PaymentController {

    private InvoiceService invoiceService;
    RestTemplate restTemplate;

    @Autowired
    public PaymentController(InvoiceService invoiceService) {
        super();
        this.invoiceService = invoiceService;
    }

    @ModelAttribute("invoice")
    public InvoiceDTO paymentOptionDTO() {
        return new InvoiceDTO();
    }

    @GetMapping("/")
    public String showPaymentForm() {
        return "checkout";
    }

    @GetMapping("/checkout/{userId}/{itemId}/{expedited_shipping}")
    public String showPaymentForm(@PathVariable("userId") Long userId,
                                  @PathVariable("itemId") Long itemId,
                                  @PathVariable("expedited_shipping") Boolean expedited_shipping,
                                  Model model) {
        restTemplate = new RestTemplate();

        model.addAttribute("userId", userId);
        model.addAttribute("itemId", itemId);

        //  fetch user information

        // fetch full name
        String url = "http://localhost:8080/firstLastTransfer/"+userId;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String full_name = response.getBody();
        model.addAttribute("fullName", full_name);

        //fetch address
        url = "http://localhost:8080/addressTransfer/"+userId;
        response = restTemplate.getForEntity(url, String.class);
        String address = response.getBody();
        model.addAttribute("address", address);

        // get total cost
        url = "http://localhost:8090/auction/items/"+itemId;
        AuctionItem auctionItem = restTemplate.getForObject(url, AuctionItem.class);
        double total_cost = 0.0;
        total_cost += auctionItem.getCurrent_price();
        if( expedited_shipping )
            total_cost += auctionItem.getShip_price_ex();
        model.addAttribute("totalCost", total_cost);

        //TESTING
//        model.addAttribute("fullName", "Random User");
//        model.addAttribute("address", "Where they live");
//        model.addAttribute("totalCost", 17.09 );


        return "checkout";
    }


    @PostMapping("/receipt/{userId}/{itemId}/{totalCost}")
    public String paymentReceipt(@ModelAttribute("invoice") InvoiceDTO invoiceDTO,
                               @PathVariable Long userId,
                               @PathVariable Long itemId,
                                 @PathVariable Double totalCost) {
        invoiceDTO.setUserId(userId);
        invoiceDTO.setItemId(itemId);
        invoiceDTO.setAmountPaid(totalCost);
        invoiceService.save(invoiceDTO);

        return "receipt";
    }

}
