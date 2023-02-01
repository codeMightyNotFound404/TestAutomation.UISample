package test.automation.commons;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import test.automation.Elite.APISuperClass;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class APIActions extends APISuperClass {

    private APIActions apiActions=null;

    public APIActions getIntance()
    {
        if(apiActions==null)
            apiActions=new APIActions();
        return apiActions;
    }

    public Response postAction(){return response;}

    public Response getAction(String endPoint){
        return  RestAssured.given().headers(setHeaders("")).params(setQueryParam("")).when().get();
       }

    public  Response patchAction()
    {
        return response;
    }

    public Response deleteAction()
    {
        return response;
    }

    public Response putAction()
    {
        return response;
    }

    public HashMap<String,String> setHeaders(String node){
        HashMap<String,String> headers=new LinkedHashMap<>();
        return headers;
    }

    public HashMap<String,String> setQueryParam(String node){
        HashMap<String,String> headers=new LinkedHashMap<>();
        return headers;
    }

    public JSONObject setPayload(String node){
        JSONObject object =new JSONObject();
        return object;
    }

}
