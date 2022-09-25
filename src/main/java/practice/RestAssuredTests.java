package practice;

import com.google.gson.Gson;
import domains.AddNewFoodToCacheResponseBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.ResponseCache;

public class RestAssuredTests {
    @Before
    public void cleanUp(){
        String url = "http: //3.20.225.112:8082/food/resetcache";
        Response response =  RestAssured.given()
                .baseUri(url)
                .contentType(ContentType.JSON) //ACCEPT REQUEST BODY IN JSON FORMAT
                .accept(ContentType.JSON)
                .when()
                .request("POST");
        Assert.assertEquals(200,response.getStatusCode());

    }
    @Test
    public void GET(){
        //RestAssured library is a one of the many
    //Java http clients -->
    //RestAssured uses BDD syntax.
    //given -> headers
    //when -> endpoint, http method type(GET, POST), body
    //then -> validate the response code, and body
String listFoodUrl = "http: //3.20.225.112:8082/food/cache/list";
        RequestSpecification s;
        Response response = RestAssured
                .given()
                .baseUri(listFoodUrl)
                .contentType(ContentType.JSON)//accept request body in Json format
                .accept(ContentType.JSON)//accept response body in Json format
                .when()
                .request("GET");
        Assert.assertEquals(200,response.getStatusCode());//I identified many existing
        //only validating status and not validating response body content
        System.out.println(response.getBody().asPrettyString());
    }

    @Test
    public void POST(){
        String url = "http: //3.20.225.112:8082/food/cache/add";
                    //"http://localhost:8082/food/cache/add"
        String body = "";

       Response response =  RestAssured.given()
               .baseUri(url)
               .contentType(ContentType.JSON)
               .accept(ContentType.JSON)
               .when()
               .request("POST");
        Assert.assertEquals(200,response.getStatusCode());
        System.out.println(response.getBody().asPrettyString());
        Gson gson = new Gson();
        //from Json(String json,WhichClass to convert it to?)
        AddNewFoodToCacheResponseBody convertedToJavaObjectResponseBody
                = gson.fromJson(response.getBody().asString(), AddNewFoodToCacheResponseBody.class);
        Assert.assertEquals(15.0,convertedToJavaObjectResponseBody.getFoodCached().get(0).getPrice());
        Assert.assertEquals("Lagman",convertedToJavaObjectResponseBody.getFoodCached().get(0).getDescription());
Assert.assertEquals(1,convertedToJavaObjectResponseBody.getFoodCached().size());

    }
}
