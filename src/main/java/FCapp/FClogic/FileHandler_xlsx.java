package FCapp.FClogic;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler_xlsx {

    private List<String[]> rowList = new ArrayList<>(); //лист куда перезаписывается инфа из файла


    public FileHandler_xlsx(){}

    public void Work(String FileName, String NewFileName) throws IOException {

        FileInputStream in = new FileInputStream(FileName);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowEnd = sheet.getLastRowNum ();

        //считывание инфы из файла

        for(int i = 1; i < rowEnd; i++){

            XSSFRow row = sheet.getRow(i);
            int colEnd = row.getLastCellNum();
            int k = 0;
            String[] thisRow = new String[2];

            for(int j = 0; j < colEnd; j++){
                if(j == 1 || j == 4){
                    thisRow[k] = workbook.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();
                    k++;
                }
            }

            rowList.add(thisRow);

        }


        for (int i =0; i< rowList.size(); i++){
            for(int j=0; j<rowList.get(i).length ; j++){
                System.out.print(rowList.get(i)[j] + "\t");
            }
            System.out.println();
        }

    }
}

/*


for(int i=1; i<111; i++){
            try {   double Values[] = new double[6];
                for (int j = 0; j < 6; j++) {
                    Values[j] = WB.getSheetAt(0).getRow(i).getCell(j+1).getNumericCellValue();
                }
                rowList.add(Values);
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }
        }


 */