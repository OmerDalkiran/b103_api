package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {
  /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

  @Test
  public void get04()    {
//set the url :
    String url = " https://jsonplaceholder.typicode.com/todos"; // request specification kullanacagiz  base url icin bir class olusturacagiz.
                                                                                                                            // bizim calisacagimiz API lar public olmayacak. 50 tane farkli test icin authorization yapmiyacagiz.
                                                                                                                   //
// burada spec e ulasmak icin extend yapmak lazim
    spec.pathParams ("first", "todos");

    // Set the expected data



    //Send the request and get the response  ( RequestSpecification yaptik ve bu hale geldi code. !!)
    Response response = given().spec (spec).when().get("/{first}");
     response.prettyPrint ();

// Do Assertions
response.then ().statusCode (200).contentType (ContentType.JSON).
        body ("id",hasSize(200),
        "title", hasItem("quis eius est sint explicabo"),
        "userId",hasItems (2,7,9) );
  }
}
