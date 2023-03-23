package get_requests;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08 extends JsonPlaceHolderBaseUrl {
  /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */
  @Test
  public void get08(){

    //Set the URL
    spec.pathParams ("first", "todos",  "second", 2);

    //Set the expected data
    JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData ();
    Map< String, Object> expectedData = obj.expectedDataMethod(1,"quis ut nam facilis et officia qui", false);
    System.out.println ("expecteData = "+ expectedData);

    expectedData.put("id",2);
    expectedData.put("Via","1.1 vegur");
    expectedData.put("Server","cloudflare");

    // Set the request and get the response
   Response response = given().spec(spec).get("/{first}/{second}");
    response.prettyPrint();

    // map olarak alip deserialition yapmam lazim. Yapalim o zaman :

    Map <String, Object> actualData = response.as(HashMap.class);
    System.out.println ("actualData = " + actualData); // iki tane data yi karsilastirmami isteyecek sirketim benden , onun icin yaptim. test datalarini daha onceden
     // kullanipta karsilastirmaya hazirlik yapmak dah guzel

    assertEquals(200, response.getStatusCode ());

    //  assertEquals (expectedData, actualData); // bu sekilde yapmak olmaz, hangisinin uysmadigini gormem lazim
    assertEquals (expectedData.get("completed"), actualData.get ("completed"));
    assertEquals (expectedData.get("title"), actualData.get ("title"));
    assertEquals (expectedData.get("userId"), actualData.get ("userId"));
    assertEquals (expectedData.get("id"), actualData.get ("id"));
    // Map e iki tane completed koyamayiz. MAp'in kurali bu. Map ler interface dir. ve MAP ler Map tir. ne array dir ne de collection dir.

 //   And header "Via" is "1.1 vegur"
    assertEquals (expectedData.get ("Via"), response.header ("Via"));

    //  And header "Server" is "cloudflare"
    assertEquals (expectedData.get ("Server"), response.header ("Server"));

  }
}
