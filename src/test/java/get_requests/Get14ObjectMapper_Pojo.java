package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Pojo  extends JsonPlaceHolderBaseUrl {

   /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,                                                                                    // Test classinda bu goruntuyu istemiyoruz
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

  // once hazir bi kalip hazirliyoruz, pojo classi biz hazirliyoruz.

  @Test
  public void get14 () {
    //Set the url
    spec.pathParams ("first", "todos", "second", 198);

    //Set the expected data
JsonPlaceHolderPojo expectedData= new JsonPlaceHolderPojo (10,"quis eius est sint explicabo",true);

    System.out.println ("expectedData = " + expectedData);

    //Send the request and get the response
   Response response =  given().spec(spec).when ().get ("/{first}/{second}");
response.prettyPrint ();

//Do assertions
 JsonPlaceHolderPojo actualData =   ObjectMapperUtils.convertJsonToJava (response.asString (),JsonPlaceHolderPojo.class);
    System.out.println ("actualData = " + actualData);

    assertEquals(200,response.statusCode ());
    assertEquals (expectedData.getUserId (), actualData.getUserId ());
    assertEquals (expectedData.getTitle (), actualData.getTitle ());
    assertEquals (expectedData.getCompleted (), actualData.getCompleted ());

  }
}