package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.repositories.PurchaseRepository;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
}
