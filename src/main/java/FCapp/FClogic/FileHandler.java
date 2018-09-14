package FCapp.FClogic;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandler {
    private String name;

    public FileHandler(String name){
        this.name = name;
    }

    public void Work (String FileName, String NewFileName){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(FileName));
            JSONObject NewObject = new JSONObject();

            JSONArray dataArray = (JSONArray) obj;
            JSONArray dataArrayChanged = new JSONArray();

            if (dataArray != null) {
                for (int i = 0; i < dataArray.size(); i++) {
                    JSONObject jsonObjectRow = (JSONObject) dataArray.get(i);

                    Long replicas = (Long) jsonObjectRow.get("replicas");
                    String version = (String) jsonObjectRow.get("version");
                    String env = (String) jsonObjectRow.get("env");
                    String service = (String) jsonObjectRow.get("service");
                    String jobname = (String) jsonObjectRow.get("jobname");

                    JSONObject obj1 = new JSONObject();
                    JSONObject obj2 = new JSONObject();

                    obj1.put("fullname",jobname+"/"+env);
                        obj2.put("Action","$ACTION$");
                        obj2.put("Service",service);
                        obj2.put("Services version", version);
                    obj1.put("params", obj2);

                    dataArrayChanged.add(obj1);

                }

                try (FileWriter writer = new FileWriter(NewFileName)){
                    writer.write(String.valueOf(dataArrayChanged));
                    writer.flush();
                } catch (IOException e) { e.printStackTrace();}
            }

        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }

}
