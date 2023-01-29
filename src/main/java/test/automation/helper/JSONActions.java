/**
 * @Author : Viren Tiwari
 */
package test.automation.helper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;


public class JSONActions {

    private JSONActions json=null;
    JSONParser parser=new JSONParser();
    Object obj=null;

    JSONObject jsonObject;

    public JSONActions getInstance()
    {
        if(json==null)
            json=new JSONActions();
        return json;
    }

    public JSONObject readJson(String jsonPath) {
        try (FileReader reader=new FileReader(jsonPath))
        {
            obj=parser.parse(reader);
             return (JSONObject) obj;
        }
        catch(Exception e)
        {
            //to be Imp
        }
        return null;
    }

    public Object readJson(String jsonPath,String node)
    {
        try (FileReader reader=new FileReader(jsonPath))
        {
            obj=parser.parse(reader);
            jsonObject=(JSONObject) obj;
            return jsonObject.get(node);
        }
        catch(Exception e)
        {
            //to be Imp

        }
        return null;
    }

    public boolean writeJson(String filePath,JSONObject jsonObject,Boolean override)
    {
        try(FileWriter file =new FileWriter(filePath,override))
        {
            file.write(jsonObject.toJSONString());
            file.flush();
            return true;
        }
        catch (Exception e)
        {
           // to be Imp
        }
        return false;
    }


}
