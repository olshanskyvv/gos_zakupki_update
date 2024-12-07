package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.repositories.LotPurchaseRepository;

@Service
@RequiredArgsConstructor
public class LotPurchaseService {
    private final LotPurchaseRepository lotPurchaseRepository;
}
