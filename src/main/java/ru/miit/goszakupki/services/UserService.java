package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
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

    private UserRepository userRepository;
    private PositionRepository positionRepository;
    private OrganizationRepository organizationRepository;

    public Boolean authorize(SignInRequest signInRequest) {
        User user = userRepository.findByEmail(signInRequest.email);
        return user != null;
    }

    public void add (SignUpRequest signUpRequest) {
        userRepository.save(new User(
                signUpRequest.surname,
                signUpRequest.name,
                signUpRequest.patronymic,
                signUpRequest.number,
                signUpRequest.email,
                signUpRequest.password,
                signUpRequest.role,
                signUpRequest.isLegalEntity,
                organizationRepository.findById(signUpRequest.organization_id).orElseThrow(),
                positionRepository.findById(signUpRequest.position_id).orElseThrow()
        ));
    }
}
