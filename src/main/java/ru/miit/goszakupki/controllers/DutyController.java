package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.services.DutyService;

@RestController
@RequestMapping("/duty")
@Tag(name = "Обязанности", description = "Включает все функции обязанностей")
@RequiredArgsConstructor
public class DutyController {
    private final DutyService dutyService;
}
