package practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//API -> Application Program Interface
//201 status code -> created successfully
//300 -> redirect
//400 -> client issue.
//500 -> server(application) is in a bad state.
//-> wait timeout.
//-> appliaction is too busy doing other things.
//-> appliaction entered infinite loop somewhere.
//-> application is not able to add the data to cache, bc Ram is full.
// application is not running - server is down.
//appliaction is not running. - cannot connect error
//Layer between UI and DB.
//2 APIS ->
//1) API -> library
//2) API -> mechanism that enables two apps to communicate

//curl -i -H "Accept: application/json" -H
//"Content-Type:application/json" -H "Authorization:
//Bearer ACCESS-TOKEN" -XPOST "https://gorest.co.in/
//public-api/users" -d '{"name": "Tenali Ramakrishna",
//"gender": "Male","email": "tenali.ramakrishna@15ce.com","status": "Active"}'
public class RestAssuredDemo {
    public static void main(String[] args) {
       String url = "http: //3.20.225.112:8082/food/cache/add";
        String body = "";

        //RestAssured library is one of many
        // Java http clients -->
        //RestAssured uses BDD syntax:
        //given -> headers
        //when -> endpoint, http method type(GET, POST), body
        //then -> validate the response code, and body.
      String listFoodUrl = "http: //3.20.225.112:8082/food/cache/add";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .request("POST");
        System.out.println(response.getStatusCode());
    }
}
