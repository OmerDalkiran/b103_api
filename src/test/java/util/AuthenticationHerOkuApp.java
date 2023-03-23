//package util;
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//
//public class AuthenticationHerOkuApp {
//
//  // burada bir metod olusturacagiz , bu metod bize string olarak bir token donecek.
//  public static  String generateToken (){
//
//    String url = "https://restful-booker.herokuapp.com/auth";  // bu adrese username ve paswordu gondermek icin bir map olusturuyoruz
//   /*
//   {
//    "username" : "admin",
//    "password" : "password123"
//}
//    */
//
//    Map<String,String > tokenBody = new HashMap<> ();
//    tokenBody.put("username","admin");
//    tokenBody.put("password","password123");
//    given().body ("").when ().post();
//
//
//    Response response = given ().contentType (ContentType.JSON).body (tokenBody).when ().post (url);
//    response.prettyPrint ();
//
//
//    return response.jsonPath ().getString ("token");
//
//  }
//}
package util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationHerOkuApp {

  public static String generateToken() {

    String url = "https://restful-booker.herokuapp.com/auth";
    Map<String, String> tokenBody = new HashMap<>();
    tokenBody.put("username", "admin");
    tokenBody.put("password", "password123");

    Response response = given().contentType(ContentType.JSON).body(tokenBody).when().post(url);

    return response.jsonPath().getString("token");

  }

}