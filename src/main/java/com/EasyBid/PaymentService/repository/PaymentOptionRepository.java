package com.EasyBid.PaymentService.repository;

import com.EasyBid.PaymentService.Model.PaymentOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaymentOptionRepository extends JpaRepository<PaymentOption, Long> {

    PaymentOption findByCardNum(String cardNum);

}
