package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.services.LotService;

@RestController
@RequestMapping("/lot")
@Tag(name = "Лоты", description = "Включает все функции лотов")
@RequiredArgsConstructor
public class LotController {
    private final LotService lotService;
}
