//package test_data;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class JsonPlaceHolderTestData {
//
//  public Map<String, Object> expectedDataMethod (Integer userId, String title, Boolean completed) {     // Bize bir Map donecegi icin buraya bir MAp actik
//
//    Map<String, Object> expectedData = new HashMap<> ();
//    expectedData.put ("userId", userId);
//    expectedData.put ("title", title);
//    expectedData.put ("completed", completed);
//
//  }
//
//}
//
//
//
///* Bir metod olusturacagim, o bize bir Map donecek su sekilde Map<String, Object> expectedData = new HashMap<> ();
//    expectedData.put ("userId", 21.0);
//    expectedData.put ("title","wash the dishes");
//    expectedData.put ("completed", false);
// */
package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

  public Map<String, Object> expectedDataMethod (Integer userId, String title, Boolean completed) {

    Map<String, Object> expectedData = new HashMap<> ();

    if (userId != null) {
      expectedData.put ("userId", userId);
    }
    if (userId != null) {
      expectedData.put ("title", title);
    }
    if (userId != null) {
      expectedData.put ("completed", completed);
    }
      //    expectedData.put("userId",userId);
      //    expectedData.put("title",title);
      //    expectedData.put("completed",completed);

      return expectedData;
    }

    public static  String expectedDataInString (Integer userId,  String title, Boolean completed) {

      return "{ \"userId\": "+userId+", \"title\": \""+title+"\", \"completed\": "+completed+" }";
    }
}
/*
{
									                                                                  "userId": 10,  			    "title": "quis eius est sint explicabo",     "completed": true
									  }
 */