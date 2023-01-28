package test.automation.rare;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APISuperClass {

    public RequestSpecification request;
    public Response response;
    public static String tokenNumber;
    public APISuperClass() {}

    public APISuperClass(RequestSpecification request)
    {
        this.request=request;
    }

    public static String generatetoken()
    {
         return tokenNumber;
    }

    public Response postAction(){return response;}

    public Response getAction(){return response;}

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


}
