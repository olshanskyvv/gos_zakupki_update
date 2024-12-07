package ru.miit.goszakupki.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelWorker {
    public void work(String fileLocation) throws IOException {
        FileInputStream file = new FileInputStream(new File(fileLocation));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
//                    case STRING: ... break;
//                    case NUMERIC: ... break;
//                    case BOOLEAN: ... break;
//                    case FORMULA: ... break;
//                    default: data.get(new Integer(i)).add(" ");
                }
            }
            i++;
        }
    }
}
