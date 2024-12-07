package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.repositories.UserPurchaseRepository;

@Service
@RequiredArgsConstructor
public class UserPurchaseService {
    private final UserPurchaseRepository userPurchaseRepository;
}
