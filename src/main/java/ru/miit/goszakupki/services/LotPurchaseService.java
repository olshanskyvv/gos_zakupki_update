package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.models.LotPurchase;
import ru.miit.goszakupki.repositories.LotPurchaseRepository;

import java.util.List;

@Service
public class LotPurchaseService {
    @Autowired
    private LotPurchaseRepository lotPurchaseRepository;

    public LotPurchase getLotPurchaseById(Long id) {
        return lotPurchaseRepository.findById(id).orElseThrow();
    }

    public List<LotPurchase> getAllLotPurchases() {
        return lotPurchaseRepository.findAll();
    }

    public LotPurchase createLotPurchase(LotPurchase lotPurchase) {
        return lotPurchaseRepository.save(lotPurchase);
    }

    public LotPurchase updateLotPurchase(LotPurchase lotPurchase) {
        return lotPurchaseRepository.save(lotPurchase);
    }

    public void deleteLotPurchase(Long id) {
        lotPurchaseRepository.deleteById(id);
    }
}
