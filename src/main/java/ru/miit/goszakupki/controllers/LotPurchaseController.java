package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.miit.goszakupki.services.LotPurchaseService;

@RestController
@RequestMapping("/lot_purchase")
@Tag(name = "Лоты закупок", description = "Включает все функции лотов закупок")
public class LotPurchaseController {
    @Autowired
    private LotPurchaseService lotPurchaseService;
}
