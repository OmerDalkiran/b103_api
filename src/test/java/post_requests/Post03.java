//package post_requests;
//
//import base_urls.JsonPlaceHolderBaseUrl;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import groovy.lang.DelegatesTo;
//import io.restassured.response.Response;
//import org.junit.Test;
//import pojos.JsonPlaceHolderPojo;
//
//import static io.restassured.RestAssured.given;
//
//@JsonIgnoreProperties (ignoreUnknown = true)
//public class Post03 extends JsonPlaceHolderBaseUrl {
//
//  /*
//         Given
//            https://jsonplaceholder.typicode.com/todos
//            {
//            "userId": 55,
//            "title": "Tidy your room",
//            "completed": false
//            }
//        When
//            I send POST Request to the Url
//        Then
//            Status code is 201
//        And
//            response body is like {
//                                    "userId": 55,
//                                    "title": "Tidy your room",
//                                    "completed": false,
//                                    "id": 201
//                                    }
//     */
//
//  @Test
//  public void post03(){
//    //Set the URL
//    spec.pathParam ("first", "todos");
//
//    //Set the expected data  ==> burada bir pojo class olusturacagiz
//  JsonPlaceHolderPojo expectedData =  new JsonPlaceHolderPojo (55,"Tidy your room", false);
//    // bir obje olusturdum . iceriseinde userId, title ve boolean iceren bir obje oldu.
//    System.out.println ("expectedData = "+ expectedData);   // bunu generate/String sayesinde yazdirabiliyoruz.
//
//    // Send the request and get the response
//    Response response = given(). spec(spec).body (expectedData).post ("{first}");
//    response.prettyPrint ();
//
//    //Do assertion
//    JsonPlaceHolderPojo actualData = response. as(JsonPlaceHolderPojo.class);
//    System.out.println ("actualData= " + actualData);
////Burada bir hata aliyoruz :
//    // Unrecognized field "id" (class pojos.JsonPlaceHolderPojo), not marked as ignorable (3 known properties: "title", "completed", "userId"])
//    // JsonIgnoreProperties i classin basina koyuyoruz  !!!
//  }
//}
package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
     /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
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
  public void post03() {
    //Set the URL
    spec.pathParam("first", "todos");

    //Set the expected data
    JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55, "Tidy your room", false);
    System.out.println("expectedData = " + expectedData);

    //Send the request and get the response
    Response response = given().spec(spec).body(expectedData).post("{first}");
    response.prettyPrint();

    //Do Assertion
    JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
    System.out.println("actualData = " + actualData);

    assertEquals(201, response.statusCode());
    assertEquals(expectedData.getUserId(), actualData.getUserId());
    assertEquals(expectedData.getTitle(), actualData.getTitle());
    assertEquals(expectedData.getCompleted(), actualData.getCompleted());

  }
}