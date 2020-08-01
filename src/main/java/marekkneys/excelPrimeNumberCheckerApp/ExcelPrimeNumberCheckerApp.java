package marekkneys.excelPrimeNumberCheckerApp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ExcelPrimeNumberCheckerApp {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Please send exactly one command line argument - (Path to the xlsx file)");
            System.exit(0);
        }

        String xlsxFile = args[0];

        XlsxReader reader;
        List<Integer> positiveIntegers = null;
        try {
            reader = new XlsxReader(xlsxFile);
            positiveIntegers = reader.readPositive32bitIntegersFromColumn(0, 1);
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file with path " + xlsxFile);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println();
        PrimeNumberPrinter.printAllPrimeNumbersInList(positiveIntegers);
    }

    private static void exit() {
    }
}
