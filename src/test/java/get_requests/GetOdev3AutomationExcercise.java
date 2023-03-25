package get_requests;

import org.junit.Test;

public class GetOdev3 {

  /*
  Given
		https://automationexercise.com/api/productsList
	When
		User sends Get request
	Then
		Assert that number of "Women" usertype is 12
		(Kadın usertype sayısının 12 olduğunu doğrulayın)
   {
            "id": 1,
            "name": "Blue Top",
            "price": "Rs. 500",
            "brand": "Polo",
            "category": {
                        "usertype": {
                                  "usertype": "Women"
                },
                "category": "Tops"
            }
        }
   */

  @Test
          public void getOdev3(){
    //Set the URL
    spec.pathParams("first", "api", "second", "productList");


  }

}
