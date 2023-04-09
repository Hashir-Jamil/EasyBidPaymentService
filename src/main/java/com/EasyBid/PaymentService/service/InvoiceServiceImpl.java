package com.EasyBid.PaymentService.service;

import com.EasyBid.PaymentService.Model.Invoice;
import com.EasyBid.PaymentService.repository.InvoiceRepository;
import com.EasyBid.PaymentService.web.dto.InvoiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        super();
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice save(InvoiceDTO invoiceDTO) {

        Invoice invoice = new Invoice(
                invoiceDTO.getCardNum(),
                invoiceDTO.getCardNum(),
                invoiceDTO.getCvc(),
                invoiceDTO.getExpiration(),
                invoiceDTO.getPhoneNumber(),
                invoiceDTO.getBillingAddress(),
                invoiceDTO.getItemId(),
                invoiceDTO.getUserId(),
                invoiceDTO.getShipmentId());

        return invoice;
    }
}
