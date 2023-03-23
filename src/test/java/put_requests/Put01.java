package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {
/*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/201
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									    "id": 198
									   }
     */

  @Test
  public void put01() {

    //Set the url :
    spec.pathParams ("first","todos","second",198);

    //Set the expected data
    Map<String, Object> expectedData = new HashMap<> ();  // Bos bir map olusturuyorum, ve gonderecegim datayi buna gomuyorum.
    expectedData.put ("userId", 21.0);
    expectedData.put ("title","wash the dishes");
    expectedData.put ("completed", false);

    /* Tekrarli yerleri daha guze yapiyoruz. Bir metot olusturup test_data package ina koyacagiz
     expectedData.put ("userId", 21.0);
    expectedData.put ("title","wash the dishes");
    expectedData.put ("completed", false);
     */
    System.out.println ("expectedDAta = " + expectedData);

// Send the request and get the response
    //Nasil gonderiyoruz? contentType ini belirtiyoruz.
 Response response =  given().spec(spec).contentType (ContentType.JSON).body(expectedData).put("/{first}/{second}");
  response.prettyPrint ();

/*
expectedDAta = {completed=false, title=wash the dishes, userId=21}
{
    "completed": false,
    "title": "wash the dishes",
    "userId": 21,
    "id": 198
}
 */

    //Do Assertion  :   simdi ikisinide Map e cevirip kiyaslama yapacagiz
                       Map<String,Object> actualData      = response.as(HashMap.class);
    System.out.println ("actualData ="+ actualData);

    assertEquals (200, response.statusCode ());
    assertEquals(expectedData.get("completed"), actualData.get("completed"));
    assertEquals(expectedData.get("title"), actualData.get("title"));
    assertEquals(expectedData.get("userId"), actualData.get("userId"));




  }


  @Test  // Dinamik yontem
  public void put01b() {

    //Set the url :
    spec.pathParams ("first","todos","second",198);

    //Set the expected data
    JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();

    Map<String, Object> expectedData = obj.expectedDataMethod (21, "Wash the dishes" , false );

    System.out.println ("expectedData = " + expectedData);




    // Send the request and get the response
    //Nasil gonderiyoruz? contentType ini belirtiyoruz.
    Response response =  given().spec(spec).contentType (ContentType.JSON).body(expectedData).put("/{first}/{second}");
    response.prettyPrint ();

    //Do Assertion  :   simdi ikisinide Map e cevirip kiyaslama yapacagiz
    Map<String,Object> actualData      = response.as(HashMap.class);
    System.out.println ("actualData ="+ actualData);

    assertEquals (200, response.statusCode ());
    assertEquals(expectedData.get("completed"), actualData.get("completed"));
    assertEquals(expectedData.get("title"), actualData.get("title"));
    assertEquals(expectedData.get("userId"), actualData.get("userId"));




  }
}
