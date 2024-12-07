package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.repositories.AuthorityRepository;

@Service
@RequiredArgsConstructor
public class AuthorityService {
    private final AuthorityRepository authorityRepository;
}
