////package get_requests;
////
////import base_urls.HerOkuAppBaseUrl;
////import io.restassured.response.Response;
////import org.junit.Test;
////
////import java.awt.geom.RectangularShape;
////import java.util.HashMap;
////import java.util.Map;
////
////import static io.restassured.RestAssured.given;
////import static org.junit.Assert.assertEquals;
////
////public class Get09 extends HerOkuAppBaseUrl {
////
////  /*
////      Given
////          https://restful-booker.herokuapp.com/booking/1504
////      When
////          I send GET Request to the url
////      Then
////          Response body should be like that;
////           {
////            "firstname": "John",
////            "lastname": "Smith",
////            "totalprice": 111,
////            "depositpaid": true,
////            "bookingdates": {
////                "checkin": "2018-01-01",
////                "checkout": "2019-01-01"
////            },
////            "additionalneeds": "Breakfast"
////            }
////   */
////
////@Test
////  public void get09(){
////
////  //SEt the url :
////  spec.pathParams ("first", "booing", "second", 1504);
////
////  //Set the expected  Data : once inner olan booking date in map ini olusturmak lazim.
////  Map<String, String> bokingdatesMap = new HashMap<> ();
////
////  bokingdatesMap.put ("checkin", "2018-01-01");
////  bokingdatesMap.put ("checkout", "2019-01-01");
////
////  Map<String , Object> expectedData = new HashMap<> ();  // bu buyuk MAp , asil map bu.
////
////  expectedData.put ("firstname","John");
////  expectedData.put ("lastname","Smith");
////  expectedData.put ("totalprice","111");  // 111 artik bir obje oldu . matematik islemi yapilmaz mesela
////  expectedData.put ("depositpaid","true");
////  expectedData.put ("bookingdates","bokingdatesMap");         // Buraya dikkat !!! bookingdatesMap buraya nasil eklendi !!!
////  expectedData.put ("additionalneeds","Breakfast");
////
////  // Send the request and get the response
////  Response response = given().spec(spec).get("/{first}/{second}");
////  response.prettyPrint ();
////  // https://restful-booker.herokuapp.com/booking/?firstname=John
////  // ==> postman de ismi John olanlari boyle aratiyoruz sonra booking no sunu oradan aliyoruz
////
////  //Do assertion
////  Map<String, Object> actualData = response.as(HashMap.class);
////  System.out.println ("actualData = " + actualData);
////
////assertEquals (200, response.statusCode ());
////assertEquals (expectedData.get("firstname"), actualData.get ("firstname"));
////  assertEquals (expectedData.get("lastname"), actualData.get ("lastname"));
////  assertEquals (expectedData.get("totalprice"), actualData.get ("totalprice"));
////  assertEquals (expectedData.get("depositpaid"), actualData.get ("depositpaid"));
////
////  assertEquals (bokingdatesMap.get ("checkin"), ((Map)actualData.get ("bookingdates")).get ("checkin"));
////  assertEquals (bokingdatesMap.get ("checkout"), ((Map)actualData.get ("bookingdates")).get ("checkout"));
////
////  assertEquals (expectedData.get("additionalneeds"), actualData.get ("Breakfast"));
////
////}
////}
//package get_requests;
//
//import base_urls.HerOkuAppBaseUrl;
//import io.restassured.response.Response;
//import org.junit.Test;
//import test_data.HerOkuAppTestData;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//import static org.junit.Assert.assertEquals;
//
//public class Get09 extends HerOkuAppBaseUrl {
//  /*
//   Given
//       https://restful-booker.herokuapp.com/booking/2170
//   When
//       I send GET Request to the url
//   Then
//       Response body should be like that;
//        {
//         "firstname": "John",
//         "lastname": "Smith",
//         "totalprice": 111,
//         "depositpaid": true,
//         "bookingdates": {
//             "checkin": "2018-01-01",
//             "checkout": "2019-01-01"
//         },
//         "additionalneeds": "Breakfast"
//         }
//*/
//  @Test
//  public void get09(){
//    //Set the URL
//    spec.pathParams("first","booking","second",794);
//
//    //Set the expected data
//    Map<String, String> bookingdatesMap = new HashMap<>();
//    bookingdatesMap.put("checkin","2018-01-01");
//    bookingdatesMap.put("checkout","2019-01-01");
//
//    Map<String, Object> expectedData = new HashMap<>();
//    expectedData.put("firstname","John");
//    expectedData.put("lastname","Smith");
//    expectedData.put("totalprice",111);
//    expectedData.put("depositpaid",true);
//    expectedData.put("bookingdates",bookingdatesMap);
//    expectedData.put("additionalneeds","Breakfast");
//
//    System.out.println("expectedData = " + expectedData);
//
//    //Send the request and get the response
//    Response response = given().spec(spec).get("/{first}/{second}");
//    response.prettyPrint();
//
//    //Do Assertion
//    Map<String, Object> actualData = response.as(HashMap.class);
//    System.out.println("actualData = " + actualData);
//
//    assertEquals(200, response.statusCode());
//    assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
//    assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
//    assertEquals(expectedData.get("totalprice"),(actualData.get("totalprice")));
//    assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
//    assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
//    assertEquals(bookingdatesMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
//    assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
//
//  }
//  @Test // Dinamik Yontem
//  public void get09b(){
//    //Set the URL
//    spec.pathParams("first","booking","second",794);
//
//    //Set the expected data
//
//    HerOkuAppTestData obj1 = new HerOkuAppTestData ();
//    Map<String,String > bookingdatesMap = obj1.bookingdatesMapMethod ("2018-01-01", "2019-01-01");
//
//    Map<String, Object> expectedData = obj1.expectedDataMethod ("John", "Smith", 111,true,bookingdatesMap,"Breakfast");
//    System.out.println ("expectedData=" +expectedData);
//
//    //Alttakinin  yerine usttekini yaptik
////    Map<String, String> bookingdatesMap = new HashMap<>();
////    bookingdatesMap.put("checkin","2018-01-01");
////    bookingdatesMap.put("checkout","2019-01-01");
//
//    Map<String, Object> expectedData = new HashMap<>();
//    expectedData.put("firstname","John");
//    expectedData.put("lastname","Smith");
//    expectedData.put("totalprice",111);
//    expectedData.put("depositpaid",true);
//    expectedData.put("bookingdates",bookingdatesMap);
//    expectedData.put("additionalneeds","Breakfast");
//
//    System.out.println("expectedData = " + expectedData);
//
//    //Send the request and get the response
//    Response response = given().spec(spec).get("/{first}/{second}");
//    response.prettyPrint();
//
//    //Do Assertion
//    Map<String, Object> actualData = response.as(HashMap.class);
//    System.out.println("actualData = " + actualData);
//
//    assertEquals(200, response.statusCode());
//    assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
//    assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
//    assertEquals(expectedData.get("totalprice"),(actualData.get("totalprice")));
//    assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
//    assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
//    assertEquals(bookingdatesMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
//    assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));
//
//  }
//}
//
//}
//
//
package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
  /*
   Given
       https://restful-booker.herokuapp.com/booking/2170
   When
       I send GET Request to the url
   Then
       Response body should be like that;
        {
         "firstname": "John",
         "lastname": "Smith",
         "totalprice": 111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2018-01-01",
             "checkout": "2019-01-01"
         },
         "additionalneeds": "Breakfast"
         }
*/
  @Test
  public void get09(){
    //Set the URL
    spec.pathParams("first","booking","second",794);

    //Set the expected data
    Map<String, String> bookingdatesMap = new HashMap<>();
    bookingdatesMap.put("checkin","2018-01-01");
    bookingdatesMap.put("checkout","2019-01-01");

    Map<String, Object> expectedData = new HashMap<>();
    expectedData.put("firstname","John");
    expectedData.put("lastname","Smith");
    expectedData.put("totalprice",111);
    expectedData.put("depositpaid",true);
    expectedData.put("bookingdates",bookingdatesMap);
    expectedData.put("additionalneeds","Breakfast");

    System.out.println("expectedData = " + expectedData);

    //Send the request and get the response
    Response response = given().spec(spec).get("/{first}/{second}");
    response.prettyPrint();

    //Do Assertion
    Map<String, Object> actualData = response.as(HashMap.class);
    System.out.println("actualData = " + actualData);

    assertEquals(200, response.statusCode());
    assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
    assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
    assertEquals(expectedData.get("totalprice"),(actualData.get("totalprice")));
    assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
    assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
    assertEquals(bookingdatesMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
    assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));

  }


  @Test//Dinamik Yöntem
  public void get09b(){
    //Set the URL
    spec.pathParams("first","booking","second",794);

    //Set the expected data
    HerOkuAppTestData obj1 = new HerOkuAppTestData();
    Map<String, String> bookingdatesMap = obj1.bookingdatesMapMethod("2018-01-01","2019-01-01");

    Map<String, Object> expectedData = obj1.expectedDataMethod("John","Smith",111,true,bookingdatesMap,"Breakfast");
    System.out.println("expectedData = " + expectedData);

    //Send the request and get the response
    Response response = given().spec(spec).get("/{first}/{second}");
    response.prettyPrint();

    //Do Assertion
    Map<String, Object> actualData = response.as(HashMap.class);
    System.out.println("actualData = " + actualData);

    assertEquals(200, response.statusCode());
    assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
    assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
    assertEquals(expectedData.get("totalprice"),(actualData.get("totalprice")));
    assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
    assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
    assertEquals(bookingdatesMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
    assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));

  }
}
