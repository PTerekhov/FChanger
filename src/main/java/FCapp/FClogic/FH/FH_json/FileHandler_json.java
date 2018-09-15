package FCapp.FClogic.FH.FH_json;


import FCapp.FClogic.FB_anytype.FileBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler_json{

    private FileBuilder FB = new FileBuilder();
    private JSONArray dataArray = new JSONArray();
    private JSONArray dataArrayChanged = new JSONArray();
    private ArrayList<String> list = new ArrayList<String>();

    public FileHandler_json(){}
    public void Work (String FileName, String NewFileName){


        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(FileName));

            dataArray = (JSONArray) obj;

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


                if (dataArrayChanged != null) {
                    int len = dataArrayChanged.size();
                    for (int i=0;i<len;i++){
                        list.add(dataArrayChanged.get(i).toString());
                    }
                }

                FB.Work(NewFileName, list);
            }



        }
        catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ParseException e){e.printStackTrace();}
        catch(Exception e){e.printStackTrace();}
    }

}
