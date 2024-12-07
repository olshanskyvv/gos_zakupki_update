package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.DTOs.SignInRequest;
import ru.miit.goszakupki.DTOs.SignUpRequest;
import ru.miit.goszakupki.models.User;
import ru.miit.goszakupki.repositories.OrganizationRepository;
import ru.miit.goszakupki.repositories.PositionRepository;
import ru.miit.goszakupki.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final OrganizationRepository organizationRepository;

    public Boolean authorize(SignInRequest signInRequest) {
        User user = userRepository.findByEmail(signInRequest.getEmail());
        return user != null;
    }

    public void add (SignUpRequest signUpRequest) {
        userRepository.save(new User(
                signUpRequest.getSurname(),
                signUpRequest.getName(),
                signUpRequest.getPatronymic(),
                signUpRequest.getNumber(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.getRole(),
                signUpRequest.getIsLegalEntity(),
                organizationRepository.findById(signUpRequest.getOrganization_id()).orElseThrow(),
                positionRepository.findById(signUpRequest.getPosition_id()).orElseThrow()
        ));
    }
}
