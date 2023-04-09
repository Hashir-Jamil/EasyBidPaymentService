package com.EasyBid.PaymentService.service;

import com.EasyBid.PaymentService.Model.Invoice;
import com.EasyBid.PaymentService.web.dto.InvoiceDTO;

public interface InvoiceService {

    Invoice save(InvoiceDTO invoiceDTO);

}
