package odevler;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Odev03 extends ReqresBaseUrl{

  /*1//
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız */ /*
  //2)
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
 3//  "https://petstore.swagger.io/" dökümanını kullanarak 'user' olusturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.
   */

    /*1//
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then
            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız */


  @Test
  public void odev03(){
    // Set the URL
    spec.pathParams ("first", "api", "second", "unknown");


    //Set the expected data
//ReqresBaseUrl obj = new ReqresBaseUrl ();
//    Map<String, String > expectedData = obj.expectedDataMethod();
//    System.out.println ("expectedData=" +expectedData);

    //Send the request and get the response
Response response = given().spec (spec).when ().get ("/{api}/{unknown}");
response.prettyPrint ();

  }

}
