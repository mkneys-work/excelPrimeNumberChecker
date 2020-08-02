package marekkneys.excelPrimeNumberCheckerApp;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XlsxReader implements Closeable {

    private static final String REGEX_POSITIVE_INTEGER = "\\d+";

    private XSSFWorkbook xsfxWorkbook;

    public XlsxReader(String filePath) throws IOException {
        File myFile = new File(filePath);
        FileInputStream fis = new FileInputStream(myFile);
        this.xsfxWorkbook = new XSSFWorkbook (fis);
    }

    public List<Integer> readPositive32bitIntegersFromColumn(int sheetNumber, int collNumber){
        List<Integer> columnNumbers = new ArrayList<>();
        XSSFSheet sheet = xsfxWorkbook.getSheetAt(sheetNumber);

        int rowIndex = 0;
        Row row = sheet.getRow(rowIndex);
        while(row != null){
            Cell cell = row.getCell(collNumber);
            String cellStringValue = cell.getStringCellValue();

            if(cellStringValue.matches(REGEX_POSITIVE_INTEGER)){
                try {
                    Integer positiveIntValue = Integer.parseInt(cell.getStringCellValue());
                    columnNumbers.add(positiveIntValue);
                } catch (NumberFormatException e) {
                    System.out.println("Method does not support reading more than 32 bit number");
                }
            }

            rowIndex++;
            row = sheet.getRow(rowIndex);
        }

        return columnNumbers;
    }

    @Override
    public void close() throws IOException {
        xsfxWorkbook.close();
    }
}
