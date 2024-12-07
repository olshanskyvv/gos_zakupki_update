package ru.miit.goszakupki.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class ExcelWorker {

    public static <T> void writeObjectsToExcel(String fileName, T[] objects) throws IOException, IllegalAccessException {
        if (objects == null || objects.length == 0) {
            throw new IllegalArgumentException("Array of objects cannot be null or empty");
        }

        // Создаем новую книгу Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        // Получаем заголовки из полей первого объекта
        T firstObject = objects[0];
        Field[] fields = firstObject.getClass().getDeclaredFields();

        // Создаем строку заголовков
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < fields.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(fields[i].getName());
        }

        // Записываем значения объектов
        for (int rowIndex = 0; rowIndex < objects.length; rowIndex++) {
            Row dataRow = sheet.createRow(rowIndex + 1);
            T object = objects[rowIndex];

            for (int colIndex = 0; colIndex < fields.length; colIndex++) {
                fields[colIndex].setAccessible(true);
                Object value = fields[colIndex].get(object);

                Cell cell = dataRow.createCell(colIndex);
                if (value != null) {
                    cell.setCellValue(value.toString());
                }
            }
        }

        // Записываем файл на диск
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }
}
