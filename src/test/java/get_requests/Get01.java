package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;

public class Get01 {
/*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
          */

  @Test
  public void get01 (){

    //    i)    Set the URL  ( yani end pointimizi gir)   //    https://restful-booker.herokuapp.com/booking/55
    String url = "     https://restful-booker.herokuapp.com/booking/55";

    //    ii)   Set the expected data  (post yaparken gonderecegimiz data yani ==donustede bunu bekleyecegim. Bunu JAva objesine cevirmeye calisacagiz. En zor yer burasi API'in



    //    iii)  Send the request and get the response
    Response response = given().when().get(url);
    response.prettyPrint ();


    //    iv)  Do Assertion  ==> beklenen data ile gonderilen datanin kiyaslanmasi

    response.
                    then().
                                  statusCode (200).
                                            contentType ("application/json").statusLine ("HTTP/1.1 200 OK");











  }


}
