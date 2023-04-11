package com.EasyBid.PaymentService.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNum;
    private String cardName;
    private String cvc;
    private String expiration;
    private String phoneNumber;
    private String billingAddress;
    private Double amountPaid;
    private Long itemId;
    private Long userID;

    public Invoice(String cardNum, String cardName, String cvc, String expiration, String phoneNumber, String billingAddress, Long itemID, Long userID) {
        this.cardNum = cardNum;
        this.cardName = cardName;
        this.cvc = cvc;
        this.expiration = expiration;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.itemId = itemID;
        this.userID = userID;
    }
}
