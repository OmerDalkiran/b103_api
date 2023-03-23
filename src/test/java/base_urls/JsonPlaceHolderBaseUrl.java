package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {


  protected  RequestSpecification spec ; // buraya ulasabilirim ama setup calismazsa null olur. Onun icin set up i her sefer ilk once calistirmak icin @Before kullandik.

  @Before
  public void setUp(){


    spec = new RequestSpecBuilder ().setContentType (ContentType.JSON).
  setAccept (ContentType.JSON).setBaseUri ("https://jsonplaceholder.typicode.com").build ();
// buradakileri set ettik onlerine setConte.... yazdik.


  }

}
