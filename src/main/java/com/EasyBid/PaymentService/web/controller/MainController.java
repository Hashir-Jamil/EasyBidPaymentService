package com.EasyBid.PaymentService.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

/*    @GetMapping("/payment")
    public String creditEntryEndPoint() {
        return "creditCard";
    }*/

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
