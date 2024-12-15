package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.DTOs.AuthorityDTO;
import ru.miit.goszakupki.models.Authority;
import ru.miit.goszakupki.models.Position;
import ru.miit.goszakupki.repositories.AuthorityRepository;
import ru.miit.goszakupki.repositories.PositionRepository;

import java.util.List;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private PositionRepository positionRepository;

    public Authority getAuthority(Long id) {
        return authorityRepository.findById(id).orElseThrow();
    }

    public List<Authority> getAuthorities() {
        return authorityRepository.findAll();
    }

    public Authority saveAuthority(AuthorityDTO authority) {
        Position position = positionRepository.findById(authority.getPosition_id()).orElseThrow();
        return authorityRepository.save(new Authority(position, authority.getHeader(), authority.getDescription()));
    }

    public Authority updateAuthority(AuthorityDTO authority) {
        Position position = positionRepository.findById(authority.getPosition_id()).orElseThrow();
        return authorityRepository.save(new Authority(position, authority.getHeader(), authority.getDescription()));
    }

    public void deleteAuthority(Long id) {
        authorityRepository.deleteById(id);
    }
}
