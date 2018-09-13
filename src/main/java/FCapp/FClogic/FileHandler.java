package FCapp.FClogic;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    private String name;
    private ArrayList<String> dataList = new ArrayList<String>();

    public FileHandler(String name){
        this.name = name;
    }

    public void Work (String FILENAME){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(FILENAME));

            JSONArray dataArray = (JSONArray) obj;

            if (dataArray != null) {
                for (int i = 0; i < dataArray.size(); i++) {
                    dataList.add(dataArray.get(i).toString());
                }
            }

            /*for(int i=0; i<dataList.size(); i++){
                System.out.println(dataList.get(i));
            }*/
        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }

}

