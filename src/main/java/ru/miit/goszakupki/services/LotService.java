package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.repositories.LotRepository;

@Service
@RequiredArgsConstructor
public class LotService {
    private final LotRepository lotRepository;
}
