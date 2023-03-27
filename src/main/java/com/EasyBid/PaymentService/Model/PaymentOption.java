package com.EasyBid.PaymentService.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@Table(name = "payment_option", uniqueConstraints = @UniqueConstraint(columnNames = "cardNum"))
public class PaymentOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNum;
    private String cardName;
    private String cvc;
    private String expiration;
    private String phoneNumber;
    private String billingAddress;

    public PaymentOption(String cardNum, String cardName, String cvc, String expiration, String phoneNumber, String billingAddress) {
        this.cardNum = cardNum;
        this.cardName = cardName;
        this.cvc = cvc;
        this.expiration = expiration;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
    }

}
