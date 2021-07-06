package utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
    static String projectpath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    //creating constructor
    public ReadExcelFile(String sheetPath, String sheetName) {
        try {
            projectpath = System.getProperty("user.dir");
            workbook = new XSSFWorkbook(sheetPath);
            sheet= workbook.getSheet(sheetName);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static int getRowCount() {
        int rowCount=0;
        try {
            //get row count
            rowCount = sheet.getPhysicalNumberOfRows();
            // System.out.println("Number of row count:"+rowCount);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return rowCount;
    }

    public static int getColCount() {
        int colCount =0;
        try {
            //get row count
            colCount = sheet.getRow(1).getPhysicalNumberOfCells();
            //System.out.println("Number of column count:"+colCount);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return colCount;
    }

    public static String getCellData(int rowNum, int colNum) {
        String cellData = null;
        try {
            //Get the row value
            cellData = sheet.getRow(rowNum).getCell(colNum).toString();
            //System.out.println(cellData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellData;
    }

}
