package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get03 {
  /*
  Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
   */

  @Test
  public void get03(){

    //1. Adım: Set the URL
    String url = "https://jsonplaceholder.typicode.com/todos/23";

    //2. Adım: Set the expected data==>(Post, Put, Patch)

    //3. Adım: Send the request get the response
    Response response = given ().when ().get (url);
    response.prettyPrint ();

    //Do Assertion

    response.then ().statusCode (200).  //HTTP Status code should be 404
    contentType("application/json").
            body ("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")) .
            body ("completed",equalTo (false)).
            body ("userId",equalTo (2));

    //2.Yol :
    response.then ().statusCode (200).  //HTTP Status code should be 404
    contentType(ContentType.JSON).
           body ("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
            "completed",equalTo (false),
            "userId",equalTo (2));

// Tek body () methodu icerisinde coklu assertion yaparak soft assertion olusturabiliriz. Yani, fail durumunda body() icerisinde java calismayi durdurmaz.
    //Coklu body() metodu ile assertion yapildiginda fail durumunda Java bir sonraki body() metodundaki assertion 'i yapmaz.




//    //Response body contains "Not Found"
//    //assertTrue() methodu, method parantezi içindeki değerin false olması durumda test "fail" olur.
//    assertTrue (response.asString ().contains ("application/json"));
//
//    //Response body does not contain "TechProEd"
//    assertFalse (response.asString ().contains ("TechProEd"));
//    //assertFalse() methodu, method parantezi içindeki değerin true olması durumda test "fail" olur.
//    System.out.println (response.asString ().contains ("TechProEd"));
//
//    System.out.println(response.headers().getValue("title"));
//    // Server is "Cowboy"
//    assertEquals ("et itaque necessitatibus maxime molestiae qui quas velit", response.header ("title"));

  }
}
