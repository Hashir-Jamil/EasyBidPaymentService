package com.EasyBid.PaymentService.service;

import com.EasyBid.PaymentService.Model.PaymentOption;
import com.EasyBid.PaymentService.repository.PaymentOptionRepository;
import com.EasyBid.PaymentService.web.dto.PaymentOptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentOptionRepository paymentOptionRepository;

    @Autowired
    public PaymentServiceImpl(PaymentOptionRepository paymentOptionRepository) {
        super();
        this.paymentOptionRepository = paymentOptionRepository;
    }

    @Override
    public PaymentOption save(PaymentOptionDTO paymentOptionDTO) {

        PaymentOption paymentOption = new PaymentOption(
                paymentOptionDTO.getCardNum(),
                paymentOptionDTO.getCardNum(),
                paymentOptionDTO.getCvc(),
                paymentOptionDTO.getExpiration(),
                paymentOptionDTO.getPhoneNumber(),
                paymentOptionDTO.getBillingAddress());
        return paymentOption;
    }
}
