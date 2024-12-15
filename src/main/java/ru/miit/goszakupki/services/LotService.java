package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.miit.goszakupki.DTOs.LotDTO;
import ru.miit.goszakupki.models.Lot;
import ru.miit.goszakupki.repositories.LotRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
public class LotService {
    @Autowired
    private LotRepository lotRepository;
    private Timestamp maxDate = Timestamp.valueOf("9999-12-31 00:00:00");

    private LotDTO toDTO(Lot lot) {
        return new LotDTO(
                lot.getCode(),
                lot.getTitle(),
                lot.getUnitOfMeasurement(),
                lot.getOKPD2(),
                lot.getOKVED2()
        );
    }

    public List<LotDTO> getLots() {
        List<Lot> lots = lotRepository.findAll();
        List<LotDTO> lotDTOs = new ArrayList<>();
        for (Lot lot : lots) {
            Date validTo = lot.getValidTo();
            if (validTo.equals(maxDate)) {
                lotDTOs.add(toDTO(lot));
            }
        }
        return lotDTOs;
    }

    public LotDTO getLotByCode(Long code) {
        Lot lot = lotRepository.findActualByCode(code);
        return lot != null ? toDTO(lot) : null;
    }

    public List<LotDTO> getLotsByCodesAndTimestamp(List<Long> codes, Timestamp timestamp) {
        List<Lot> lots = lotRepository.findByCodesAndDate(codes, timestamp);
        return !lots.isEmpty() ? lots.stream().map(this::toDTO).toList() : List.of();
    }
    @Transactional
    public LotDTO createOrUpdate(LotDTO lotDTO) {
        Long code = lotDTO.getCode();
        Lot newLot = new Lot(
                code,
                Date.from(Instant.now()),
                maxDate,
                lotDTO.getTitle(),
                lotDTO.getUnitOfMeasurement(),
                lotDTO.getOkpd2(),
                lotDTO.getOkved2()
        );
        if (code != null) {
            Lot oldLot = lotRepository.findActualByCode(code);
            if (oldLot != null) {
                oldLot.setValidTo(newLot.getValidFrom());
                lotRepository.save(oldLot);
            }
        }
        lotRepository.saveAndFlush(newLot);
        return toDTO(newLot);
    }

    public List<Lot> getAllLots() {
        return lotRepository.findAll();
    }
}
