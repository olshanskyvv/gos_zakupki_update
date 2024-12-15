package ru.miit.goszakupki.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.models.UserPurchase;
import ru.miit.goszakupki.repositories.UserPurchaseRepository;

import java.util.List;

@Service
public class UserPurchaseService {
    @Autowired
    private UserPurchaseRepository userPurchaseRepository;

    public UserPurchase getUserPurchaseRepository(Long id) {
        return userPurchaseRepository.findById(id).orElseThrow();
    }

    public List<UserPurchase> getAllUserPurchases() {
        return userPurchaseRepository.findAll();
    }

    public UserPurchase createUserPurchase(UserPurchase userPurchase) {
        return userPurchaseRepository.save(userPurchase);
    }

    public UserPurchase updateUserPurchase(UserPurchase userPurchase) {
        return userPurchaseRepository.save(userPurchase);
    }

    public void deleteUserPurchase(Long id) {
        userPurchaseRepository.deleteById(id);
    }
}
