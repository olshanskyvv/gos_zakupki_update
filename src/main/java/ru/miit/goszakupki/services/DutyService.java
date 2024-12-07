package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.repositories.DutyRepository;

@Service
@RequiredArgsConstructor
public class DutyService {
    private final DutyRepository dutyRepository;
}
