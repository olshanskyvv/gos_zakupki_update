package ru.miit.goszakupki.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.DTOs.SignInRequest;
import ru.miit.goszakupki.DTOs.SignUpRequest;
import ru.miit.goszakupki.DTOs.UserDTO;
import ru.miit.goszakupki.models.User;
import ru.miit.goszakupki.repositories.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private DutyRepository dutyRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    public Boolean authorize(SignInRequest signInRequest) {
        User user = userRepository.findByEmail(signInRequest.getEmail());
        if (user != null) {
            return user.getPassword().equals(signInRequest.getPassword());
        } else {
            return false;
        }
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

    public UserDTO getUserDTO(String email) {
        User user = userRepository.findByEmail(email);
        return new UserDTO(user.getId(),
                user.getSurname(),
                user.getName(),
                user.getPatronymic(),
                user.getNumber(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getLegalEntity(),
                user.getOrganization(),
                user.getPosition(),
                dutyRepository.findAllByPosition(user.getPosition()),
                authorityRepository.findAllByPosition(user.getPosition()));
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
