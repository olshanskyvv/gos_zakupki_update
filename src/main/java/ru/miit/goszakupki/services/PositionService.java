package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.repositories.PositionRepository;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
}
