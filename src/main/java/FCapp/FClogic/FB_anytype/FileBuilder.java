package FCapp.FClogic.FB_anytype;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileBuilder {

    private List<String[]> rowList = new ArrayList<>();

    public FileBuilder(){}
    public void Work(String FileName, ArrayList list){


        if(FileName.contains(".json")) {
            try (FileWriter writer = new FileWriter(FileName)) {
                writer.write(String.valueOf(list));
                writer.flush();
                System.out.println("Your "+FileName+" is saved");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(FileName.contains(".xlsx")){
            try {
                rowList = list;
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("sheet1");

                for(int i=0; i<list.size(); i++){
                    XSSFRow rowhead = sheet.createRow((short)i);
                    for(int j=0; j<3; j++){
                        rowhead.createCell(j).setCellValue(rowList.get(i)[j]);
                    }
                }

                FileOutputStream fileOut = new FileOutputStream(FileName);
                workbook.write(fileOut);
                fileOut.close();
                System.out.println("Your "+FileName+" is saved");
            } catch ( Exception ex ) {
                System.out.println(ex);
            }

        }
    }
}
