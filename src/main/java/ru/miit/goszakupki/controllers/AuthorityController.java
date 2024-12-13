package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.services.AuthorityService;

@RestController
@RequestMapping("/authority")
@Tag(name = "Полномочия", description = "Включает все функции полномочий")
@RequiredArgsConstructor
public class AuthorityController {
    private AuthorityService authorityService;
}
