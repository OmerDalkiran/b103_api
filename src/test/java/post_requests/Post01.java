package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {

  /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

  @Test
  public void post01(){

    //Set the url :
   // bunun yerine String url = "https://jsonplaceholder.typicode.com/";
    spec.pathParam ("first","todos");


    // set the expected data ==> Payload
    /* buna bakarak bir map olusturalim JAvaya benzetmemiz lazim. JSon olarak direkt gonderemem. JAva kullandigim icin body nin icine koyup oyle gondermem lazum.
     {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }


     */
    Map<String , Object> expectedData = new HashMap<> ();

    expectedData.put ("userId",55.0);
    expectedData.put ("title","Tidy your room");
    expectedData.put ("completed", false);
    System.out.println ("expectedDAta=" + expectedData);

    //Send the request and get the response

    given().spec(spec).when().body(expectedData).post("/{first}");

    Response response =  given().spec(spec).contentType (ContentType.JSON).when().body(expectedData).post("/{first}");
    response.prettyPrint ();

// do Assertion

    //response.as(); // De-serialization  ==> Json dan Java ya cevirmek demek
    response.as(HashMap.class);
    Map<String,Object> actualData = response.as (HashMap.class);
    System.out.println ("actualData =" + actualData);

    assertEquals(201,response.statusCode ());

    assertEquals (expectedData.get ("completed"), actualData.get ("completed"));
    assertEquals (expectedData.get ("title"), actualData.get ("title"));
    assertEquals (expectedData.get ("userId"), actualData.get ("userId"));
  }
}
