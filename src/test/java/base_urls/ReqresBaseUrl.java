package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.Map;

public class ReqresBaseUrl {

  protected RequestSpecification spec ;
  @Before
  public void setUp(){
    spec= new RequestSpecBuilder ().setContentType (ContentType.JSON).
   setAccept (ContentType.JSON).setBaseUri ("//https://reqres.in/").build ();
  }
//  public Map<String, String> expectedDataMethod () {
//    return  :
  }





//https://reqres.in/api/unknown/