package test.automation.rare;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class APISuperClass {

    private RequestSpecification request;
    protected Response response;
    private static String tokenNumber;

    public APISuperClass() {
        RestAssured.baseURI="";
    }

    public APISuperClass(RequestSpecification request)
    {
        this.request=request;
        RestAssured.baseURI="";
    }

    public static String generatetoken()
    {
         //To be Imp
        return tokenNumber;
    }

    public Response postAction(String endPoint){return response;}

    public Response getAction(String endPoint){return response;}

   public  Response patchAction(String endPoint)
   {
       return response;
   }

   public Response deleteAction(String endPoint)
   {
       return response;
   }

   public Response putAction(String endPoint)
   {
       return response;
   }

}
