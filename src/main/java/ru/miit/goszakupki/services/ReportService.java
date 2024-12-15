package ru.miit.goszakupki.services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import ru.miit.goszakupki.models.LotPurchase;
import ru.miit.goszakupki.models.Organization;
import ru.miit.goszakupki.models.Purchase;
import ru.miit.goszakupki.models.UserPurchase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    public File generateGeneralReport(Purchase purchase,
                                      List<LotPurchase> lotPurchases,
                                      List<UserPurchase> userPurchases,
                                      Organization organization) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        // Create styles
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // Create sheet for purchase information
        Sheet purchaseSheet = workbook.createSheet("Закупка");
        Row purchaseHeader = purchaseSheet.createRow(0);

        String[] purchaseHeaders = {"Идентификатор", "Номер", "Сфера", "Объект закупки", "Размещено", "Обновлено", "Статус", "Тип", "Способ", "Срок поставки", "Место поставки", "Дополнительные требования"};

        for (int i = 0; i < purchaseHeaders.length; i++) {
            Cell cell = purchaseHeader.createCell(i);
            cell.setCellValue(purchaseHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        Row purchaseRow = purchaseSheet.createRow(1);
        purchaseRow.createCell(0).setCellValue(purchase.getId());
        purchaseRow.createCell(1).setCellValue(purchase.getNumber());
        purchaseRow.createCell(2).setCellValue(purchase.getSphere());
        purchaseRow.createCell(3).setCellValue(purchase.getObject());
        purchaseRow.createCell(4).setCellValue(purchase.getDateOfPlacement().toString());
        purchaseRow.createCell(5).setCellValue(purchase.getDateOfUpdate().toString());
        purchaseRow.createCell(6).setCellValue(purchase.getStatus().toString());
        purchaseRow.createCell(7).setCellValue(purchase.getType().toString());
        purchaseRow.createCell(8).setCellValue(purchase.getMethod().toString());
        purchaseRow.createCell(9).setCellValue(purchase.getDeliveryTime());
        purchaseRow.createCell(10).setCellValue(purchase.getPlaceOfDelivery());
        purchaseRow.createCell(11).setCellValue(purchase.getAdditionalRequirements());

        // Create sheet for lot purchases
        Sheet lotSheet = workbook.createSheet("Лот закупки");
        Row lotHeader = lotSheet.createRow(0);

        String[] lotHeaders = {"Идентификатор", "Код лота", "Количество", "Начальная стоимость", "Дата добавления"};
        for (int i = 0; i < lotHeaders.length; i++) {
            Cell cell = lotHeader.createCell(i);
            cell.setCellValue(lotHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        int lotRowIndex = 1;
        for (LotPurchase lotPurchase : lotPurchases) {
            Row row = lotSheet.createRow(lotRowIndex++);
            row.createCell(0).setCellValue(lotPurchase.getId());
            row.createCell(1).setCellValue(lotPurchase.getLotCode());
            row.createCell(2).setCellValue(lotPurchase.getQuantity());
            row.createCell(3).setCellValue(lotPurchase.getInitialCost());
            row.createCell(4).setCellValue(lotPurchase.getDateOfAddition().toString());
        }

        // Create sheet for user purchases
        Sheet userSheet = workbook.createSheet("Пользователи закупки");
        Row userHeader = userSheet.createRow(0);

        String[] userHeaders = {"Идентификатор", "Почта"};
        for (int i = 0; i < userHeaders.length; i++) {
            Cell cell = userHeader.createCell(i);
            cell.setCellValue(userHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        int userRowIndex = 1;
        for (UserPurchase userPurchase : userPurchases) {
            Row row = userSheet.createRow(userRowIndex++);
            row.createCell(0).setCellValue(userPurchase.getId());
            row.createCell(1).setCellValue(userPurchase.getUser().getEmail());
        }

        // Create sheet for organization information
        Sheet organizationSheet = workbook.createSheet("Организация");
        Row organizationHeader = organizationSheet.createRow(0);

        String[] organizationHeaders = {"Идентификатор", "Наименование", "ИНН", "КПП", "Юридический адрес", "Сфера", "Тип"};

        for (int i = 0; i < organizationHeaders.length; i++) {
            Cell cell = organizationHeader.createCell(i);
            cell.setCellValue(organizationHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        Row organizationRow = organizationSheet.createRow(1);
        organizationRow.createCell(0).setCellValue(organization.getId());
        organizationRow.createCell(1).setCellValue(organization.getTitle());
        organizationRow.createCell(2).setCellValue(organization.getINN());
        organizationRow.createCell(3).setCellValue(organization.getKPP());
        organizationRow.createCell(4).setCellValue(organization.getLegalAddress());
        organizationRow.createCell(5).setCellValue(organization.getSphere());
        organizationRow.createCell(6).setCellValue(organization.getType());

        // Write the output to a file
        File file = File.createTempFile("PurchaseReport", ".xlsx");
        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
        }

        workbook.close();
        return file;
    }

    public File generateNotificationReport(Purchase purchase, Organization organization) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        // Create styles
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // Create sheet for purchase information
        Sheet purchaseSheet = workbook.createSheet("Закупка");
        Row purchaseHeader = purchaseSheet.createRow(0);

        String[] purchaseHeaders = {"Идентификатор", "Номер", "Сфера", "Объект закупки", "Размещено", "Обновлено", "Статус", "Тип", "Способ", "Срок поставки", "Место поставки", "Дополнительные требования"};

        for (int i = 0; i < purchaseHeaders.length; i++) {
            Cell cell = purchaseHeader.createCell(i);
            cell.setCellValue(purchaseHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        Row purchaseRow = purchaseSheet.createRow(1);
        purchaseRow.createCell(0).setCellValue(purchase.getId());
        purchaseRow.createCell(1).setCellValue(purchase.getNumber());
        purchaseRow.createCell(2).setCellValue(purchase.getSphere());
        purchaseRow.createCell(3).setCellValue(purchase.getObject());
        purchaseRow.createCell(4).setCellValue(purchase.getDateOfPlacement().toString());
        purchaseRow.createCell(5).setCellValue(purchase.getDateOfUpdate().toString());
        purchaseRow.createCell(6).setCellValue(purchase.getStatus().toString());
        purchaseRow.createCell(7).setCellValue(purchase.getType().toString());
        purchaseRow.createCell(8).setCellValue(purchase.getMethod().toString());
        purchaseRow.createCell(9).setCellValue(purchase.getDeliveryTime());
        purchaseRow.createCell(10).setCellValue(purchase.getPlaceOfDelivery());
        purchaseRow.createCell(11).setCellValue(purchase.getAdditionalRequirements());

        // Create sheet for organization information
        Sheet organizationSheet = workbook.createSheet("Организация");
        Row organizationHeader = organizationSheet.createRow(0);

        String[] organizationHeaders = {"Идентификатор", "Наименование", "ИНН", "КПП", "Юридический адрес", "Сфера", "Тип"};

        for (int i = 0; i < organizationHeaders.length; i++) {
            Cell cell = organizationHeader.createCell(i);
            cell.setCellValue(organizationHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        Row organizationRow = organizationSheet.createRow(1);
        organizationRow.createCell(0).setCellValue(organization.getId());
        organizationRow.createCell(1).setCellValue(organization.getTitle());
        organizationRow.createCell(2).setCellValue(organization.getINN());
        organizationRow.createCell(3).setCellValue(organization.getKPP());
        organizationRow.createCell(4).setCellValue(organization.getLegalAddress());
        organizationRow.createCell(5).setCellValue(organization.getSphere());
        organizationRow.createCell(6).setCellValue(organization.getType());

        // Write the output to a file
        File file = File.createTempFile("PurchaseReport", ".xlsx");
        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
        }

        workbook.close();
        return file;
    }

    public File generatePriceJustificationReport(Purchase purchase, List<LotPurchase> lotPurchases) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        // Create styles
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // Create sheet for purchase information
        Sheet purchaseSheet = workbook.createSheet("Закупка");
        Row purchaseHeader = purchaseSheet.createRow(0);

        String[] purchaseHeaders = {"Идентификатор", "Номер", "Сфера", "Объект закупки", "Размещено", "Обновлено", "Статус", "Тип", "Способ", "Срок поставки", "Место поставки", "Дополнительные требования"};

        for (int i = 0; i < purchaseHeaders.length; i++) {
            Cell cell = purchaseHeader.createCell(i);
            cell.setCellValue(purchaseHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        Row purchaseRow = purchaseSheet.createRow(1);
        purchaseRow.createCell(0).setCellValue(purchase.getId());
        purchaseRow.createCell(1).setCellValue(purchase.getNumber());
        purchaseRow.createCell(2).setCellValue(purchase.getSphere());
        purchaseRow.createCell(3).setCellValue(purchase.getObject());
        purchaseRow.createCell(4).setCellValue(purchase.getDateOfPlacement().toString());
        purchaseRow.createCell(5).setCellValue(purchase.getDateOfUpdate().toString());
        purchaseRow.createCell(6).setCellValue(purchase.getStatus().toString());
        purchaseRow.createCell(7).setCellValue(purchase.getType().toString());
        purchaseRow.createCell(8).setCellValue(purchase.getMethod().toString());
        purchaseRow.createCell(9).setCellValue(purchase.getDeliveryTime());
        purchaseRow.createCell(10).setCellValue(purchase.getPlaceOfDelivery());
        purchaseRow.createCell(11).setCellValue(purchase.getAdditionalRequirements());

        // Create sheet for lot purchases
        Sheet lotSheet = workbook.createSheet("Лот закупки");
        Row lotHeader = lotSheet.createRow(0);

        String[] lotHeaders = {"Идентификатор", "Код лота", "Количество", "Начальная стоимость", "Дата добавления"};
        for (int i = 0; i < lotHeaders.length; i++) {
            Cell cell = lotHeader.createCell(i);
            cell.setCellValue(lotHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        int lotRowIndex = 1;
        for (LotPurchase lotPurchase : lotPurchases) {
            Row row = lotSheet.createRow(lotRowIndex++);
            row.createCell(0).setCellValue(lotPurchase.getId());
            row.createCell(1).setCellValue(lotPurchase.getLotCode());
            row.createCell(2).setCellValue(lotPurchase.getQuantity());
            row.createCell(3).setCellValue(lotPurchase.getInitialCost());
            row.createCell(4).setCellValue(lotPurchase.getDateOfAddition().toString());
        }

        // Write the output to a file
        File file = File.createTempFile("PurchaseReport", ".xlsx");
        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
        }

        workbook.close();
        return file;
    }
}
