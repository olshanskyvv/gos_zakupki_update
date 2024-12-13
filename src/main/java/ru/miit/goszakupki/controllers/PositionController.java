package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.services.PositionService;

@RestController
@RequestMapping("/position")
@Tag(name = "Должности", description = "Включает все функции должностей")
@RequiredArgsConstructor
public class PositionController {
    private PositionService positionService;
}
