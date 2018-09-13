package FCapp.FClogic;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    private String name;

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
                    JSONObject jsonObjectRow = (JSONObject) dataArray.get(i);

                    Long replicas = (Long) jsonObjectRow.get("replicas");
                    String version = (String) jsonObjectRow.get("version");
                    String env = (String) jsonObjectRow.get("env");
                    String service = (String) jsonObjectRow.get("service");
                    String jobname = (String) jsonObjectRow.get("jobname");


                    System.out.println(
                            replicas.toString() + '\n'
                            + version + '\n'
                            + env + '\n'
                            + service + '\n'
                            + jobname + '\n');
                }
            }

        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }

}
