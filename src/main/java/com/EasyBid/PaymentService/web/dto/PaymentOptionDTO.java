package com.EasyBid.PaymentService.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentOptionDTO {

    private String cardNum;
    private String cardName;
    private String cvc;
    private String expiration;
    private String phoneNumber;
    private String billingAddress;

}
