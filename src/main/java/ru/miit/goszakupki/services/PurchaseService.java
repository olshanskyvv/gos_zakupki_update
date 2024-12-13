package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.DTOs.PurchaseDTO;
import ru.miit.goszakupki.models.Purchase;
import ru.miit.goszakupki.repositories.PurchaseRepository;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    private PurchaseDTO toDTO(Purchase purchase) {
        return new PurchaseDTO(
                purchase.getNumber(),
                purchase.getSphere(),
                purchase.getObject(),
                purchase.getDateOfPlacement(),
                purchase.getDateOfUpdate(),
                purchase.getStatus(),
                purchase.getType(),
                purchase.getMethod(),
                purchase.getDeliveryTime(),
                purchase.getPlaceOfDelivery(),
                purchase.getAdditionalRequirements()
        );
    }

    public PurchaseDTO getPurchaseByNumber(Long number) {
        Purchase purchase = purchaseRepository.findById(number).orElseThrow();
        return toDTO(purchase);
    }
}