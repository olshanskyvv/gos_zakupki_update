package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.models.Position;
import ru.miit.goszakupki.repositories.PositionRepository;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public Position getPosition(Long id) {
        return positionRepository.findById(id).orElseThrow();
    }

    public List<Position> getPositions() {
        return positionRepository.findAll();
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(Position position) {
        return positionRepository.save(position);
    }

    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }
}
