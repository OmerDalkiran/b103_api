package get_requests;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {
  /*
  1)  Postman ==> manual API testi icin kullanilir.
  2) APi otomasyanu icin Rest Assured Library kullanacagiz
  3) Otomasyon kodlarinin yazilimi icin :
          a) gereksinimleri anlama
          b) Testcase i yazma :
                 - Cucumber Frameworku kullanacagimiz icin " Gherkin language"  i kullaniyoruz.
                 x) Given  :  on kusullar ==> End point ve body
                 xi) When :  islemler ==> get, put , patch, delete ...
                 xii) Then : Donutler ==> Assertions
                 xiii) And : Coklu islemlerin art arda yazilacagi yerlerde kullanilir.


          c) Test kodunu yazarken su adimlari izleriz :

          i)    Set the URL  ( yani end pointimizi gir)
          ii)   Set the expected data  (post yaparken gonderecegimiz data yani ==donustede bunu bekleyecegim. Bunu JAva objesine cevirmeye calisacagiz. En zor yer burasi API'in
          iii)  Send the request and get the response
          iv)  Do Assertion  ==> beklenen data ile gonderilen datanin kiyaslanmasi

   */

  public static void main(String[] args) {
    // Get request nasil yapilir?   get metodu REST Assured Library den gelmesi lazim. bunun librasini yuklemek gerekir yani

    String url = "https://restful-booker.herokuapp.com/booking/55";

 //Response response =  given ().when ().get("https://restful-booker.herokuapp.com/booking/55");
  Response response = given ().when ().get (url);
   response.prettyPrint (); // bu metod  response datayi yazdirir.
//Status Code    nasil yazdirilir ?   ==> Status Code :  200
    System.out.println ("Status Code :  "+ response.statusCode ());

    // content type nasil yazdirilir?
    System.out.println ("Content Type  = " + response.contentType ());
    //Status line nasil yazdirilir?
    System.out.println ("Status Line =" +  response.statusLine ());

    //Header nasil yazdirilir?
    System.out.println ("Header da connection kisminin bize dongusu = " + response.header ("Connection"));   // ==>  keep-alive

    System.out.println ("Header da  server kisminin bize dongusu = " + response.header ("Server")); // = =>  Cowboy

    // All headers nasil yazdirilir ?
    System.out.println ("All headers icin = " +  response.headers ());

    System.out.println ("Time : " + response.time ());  // yada asagidaki gibi alinabilir
    System.out.println (" Time :" +  response.getTime ());



  }
}
