package ru.miit.goszakupki.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.miit.goszakupki.models.LotPurchase;
import ru.miit.goszakupki.models.Purchase;
import ru.miit.goszakupki.models.User;
import ru.miit.goszakupki.models.UserPurchase;
import ru.miit.goszakupki.services.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/doc")
@Tag(name = "Документы", description = "Включает все функции документации")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private LotPurchaseService lotPurchaseService;
    @Autowired
    private UserPurchaseService userPurchaseService;
    @Autowired
    private UserService userService;

    @GetMapping("/purchase/{id}")
    public ResponseEntity<FileSystemResource> downloadPurchaseReport(@PathVariable Long id,
                                                                     @RequestParam Long user_id) throws IOException {
        Purchase purchase = purchaseService.getPurchase(id);
        User user = userService.getUser(user_id);
        List<LotPurchase> lotPurchaseList = lotPurchaseService.getLotPurchasesByPurchase(purchase);
        List<UserPurchase> userPurchaseList = userPurchaseService.getUserPurchasesByPurchase(purchase);
        FileSystemResource fileResource = new FileSystemResource(reportService.generateGeneralReport(purchase,
                lotPurchaseList,
                userPurchaseList,
                user.getOrganization()));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=purchase.xlsx");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok()
                .headers(headers)
                .body(fileResource);
    }
    @GetMapping("/notification/{id}")
    public ResponseEntity<FileSystemResource> downloadNotificationReport(@PathVariable Long id,
                                                                         @RequestParam Long user_id) throws IOException {
        Purchase purchase = purchaseService.getPurchase(id);
        User user = userService.getUser(user_id);
        FileSystemResource fileResource = new FileSystemResource(reportService.generateNotificationReport(purchase,
                user.getOrganization()));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=notification.xlsx");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok()
                .headers(headers)
                .body(fileResource);
    }
    @GetMapping("/price_justification/{id}")
    public ResponseEntity<FileSystemResource> downloadPriceJustificationReport(@PathVariable Long id) throws IOException {
        Purchase purchase = purchaseService.getPurchase(id);
        List<LotPurchase> lotPurchaseList = lotPurchaseService.getLotPurchasesByPurchase(purchase);
        FileSystemResource fileResource = new FileSystemResource(reportService.generatePriceJustificationReport(purchase, lotPurchaseList));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=price_justification.xlsx");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok()
                .headers(headers)
                .body(fileResource);
    }
}
