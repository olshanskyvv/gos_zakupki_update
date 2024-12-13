package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.services.PurchaseService;

@RestController
@RequestMapping("/purchase")
@Tag(name = "Закупки", description = "Включает все функции закупок")
@RequiredArgsConstructor
public class PurchaseController {
    private PurchaseService purchaseService;
}
