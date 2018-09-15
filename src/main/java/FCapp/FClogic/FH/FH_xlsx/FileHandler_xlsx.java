package FCapp.FClogic.FH.FH_xlsx;

import FCapp.FClogic.FB_anytype.FileBuilder;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler_xlsx{

    private FileBuilder FB = new FileBuilder();
    private ArrayList<String[]> list = new ArrayList<String[]>(); //лист куда перезаписывается инфа из файла

    public FileHandler_xlsx(){}
    public void Work(String FileName, String NewFileName) throws IOException {

        FileInputStream in = new FileInputStream(FileName);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);
        List<String[]> rowList = new ArrayList<>();

        int rowEnd = sheet.getLastRowNum();

        //считывание инфы из файла

        for (int i = 1; i < rowEnd; i++) {

            XSSFRow row = sheet.getRow(i);
            int colEnd = row.getLastCellNum();
            int k = 0;
            String[] thisRow = new String[2];

            for (int j = 0; j < colEnd; j++) {
                if (j == 1 || j == 4) {
                    thisRow[k] = workbook.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();
                    k++;
                }
            }

            rowList.add(thisRow);
        }

        for (int i = 0; i < rowList.size(); i++) {

            String[] newRow = new String[3];

            String temp1 = rowList.get(i)[0];
            String temp2 = rowList.get(i)[1];

            newRow[0] = temp1.substring(temp1.indexOf("_") + 1);
            newRow[1] = temp2.substring(temp2.indexOf("/") + 1, temp2.indexOf(":"));
            newRow[2] = temp2.substring(temp2.indexOf(":") + 1);

            list.add(newRow);
        }

        FB.Work(NewFileName, list);
    }
}
