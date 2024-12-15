package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.DTOs.DutyDTO;
import ru.miit.goszakupki.models.Duty;
import ru.miit.goszakupki.models.Position;
import ru.miit.goszakupki.repositories.DutyRepository;
import ru.miit.goszakupki.repositories.PositionRepository;

import java.util.List;

@Service
public class DutyService {
    @Autowired
    private DutyRepository dutyRepository;
    @Autowired
    private PositionRepository positionRepository;

    public Duty getDutyById(Long id) {
        return dutyRepository.findById(id).orElseThrow();
    }

    public List<Duty> getAllDuty() {
        return dutyRepository.findAll();
    }

    public Duty saveDuty(DutyDTO duty) {
        Position position = positionRepository.findById(duty.getPosition_id()).orElseThrow();
        return dutyRepository.save(new Duty(position, duty.getHeader(), duty.getDescription()));
    }

    public Duty updateDuty(DutyDTO duty) {
        Position position = positionRepository.findById(duty.getPosition_id()).orElseThrow();
        return dutyRepository.save(new Duty(position, duty.getHeader(), duty.getDescription()));
    }

    public void deleteDuty(Long id) {
        dutyRepository.deleteById(id);
    }
}
