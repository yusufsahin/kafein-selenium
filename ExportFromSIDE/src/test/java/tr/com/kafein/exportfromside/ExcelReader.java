package tr.com.kafein.exportfromside;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelReader(String filePath,String sheetName) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);
        }
    }

    public List<String[]> getData() {
        List<String[]> data = new ArrayList<>();
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header row
            Row row = sheet.getRow(i);
            int colCount = row.getPhysicalNumberOfCells();
            String[] rowData = new String[colCount];

            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                rowData[j] = getCellValue(cell);
            }
            data.add(rowData);
        }
        System.out.println(data.toString());
        return data;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
