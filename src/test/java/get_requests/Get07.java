package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {
/*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL == > URL'e Get Request gonderin
      Then
          1)Status code is 200 == > Status kodu 200 olmali
          2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
            Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
          3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
            Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
          4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
            Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
            basliginin "delectus aut autem" icerdigini dogrulayin
     */

  @Test
  public void get07() {

//SET the url
    spec.pathParam("first", "todos");

    // Set the expected data

    // Send the request and get the response
    Response response = given().spec(spec).get("/{first}");
  //  response.prettyPrint ();

    // Do assertion :
    assertEquals(200, response.getStatusCode ());

   //Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
    //Groovy language olarak yapabilirim.  id si buyuktur 190 olan yerlerde bana bunu doner
  JsonPath jsonPath =  response.jsonPath ();
List<Object> list = jsonPath.getList ( " findAll{it.id>190}.id"   );
    System.out.println ("list = "+ list);  // yukarida "id" yerine bunu yazdik =
                                                                       // Groovy language     ==>   " findAll{it.id>190}"    ya da  " findAll{it.id==200}.title" ya da " findAll{it.id>190}.userId"

  //  Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
assertEquals (10,list.size ());

//     3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
List<Integer> list1=jsonPath.getList ("findAll{it.id<5}.id");
    List<Integer> list2=jsonPath.getList ("findAll{it.id==2}.id");
    List<Integer> list3=jsonPath.getList ("findAll{it.userId==1}.id");
    List<Integer> list4=jsonPath.getList ("findAll{it.id<5}.userId");
    System.out.println ("list1 = "+ list1+list2+list3+list4);

    assertEquals (4, list4.size ());

//  Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
    List<String> titleList =jsonPath.getList ("findAll{it.id<5}.title");
    System.out.println ("title List= "+ titleList);

   //    Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
    //            basliginin "delectus aut autem" icerdigini dogrulayin
    assertTrue (titleList.contains ("delectus aut autem"));


  }
}
