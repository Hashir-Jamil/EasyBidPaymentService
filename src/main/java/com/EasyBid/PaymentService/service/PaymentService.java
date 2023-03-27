package com.EasyBid.PaymentService.service;

import com.EasyBid.PaymentService.Model.PaymentOption;
import com.EasyBid.PaymentService.web.dto.PaymentOptionDTO;

public interface PaymentService {

    PaymentOption save(PaymentOptionDTO paymentOptionDTO);

}
