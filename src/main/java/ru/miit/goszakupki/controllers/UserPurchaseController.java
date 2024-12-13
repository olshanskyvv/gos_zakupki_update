package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.services.UserPurchaseService;

@RestController
@RequestMapping("/user_purchase")
@Tag(name = "Пользователи Закупки", description = "Включает все функции пользователей закупок")
@RequiredArgsConstructor
public class UserPurchaseController {
    private UserPurchaseService userPurchaseService;
}
