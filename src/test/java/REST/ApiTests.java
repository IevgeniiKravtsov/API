package REST;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests {
    String endpoint = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void testBody() {
        given().
         when().
                get(endpoint).
         then().
                log().body();
    }

//	1 Create a test to verify an http status code:
// 	Send the http request by using the GET method.
// 	The URL is https://jsonplaceholder.typicode.com/users
// 	Validation: status code of the obtained response is 200 OK
    @Test
    public void testStatusCode() {
        given().
         when().
                get(endpoint).
         then().
                assertThat().
                statusCode(200);
    }

// 	2 Create a test to verify an http response header:
//	Send the http request by using the GET method.
//	The URL is https://jsonplaceholder.typicode.com/users
//	Validation: - the content-type header exists in the obtained response
//              - the value of the content-type header is application/json; charset=utf-8
    @Test
    public void testResponseHeader(){
        given().
         when().
                get(endpoint).
         then().
                assertThat().
                header("Content-Type", notNullValue()).
                header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

//	3 Create a test to verify an http response body:
//	Send the http request by using the GET method:
//	The URL is https://jsonplaceholder.typicode.com/users
//	Validation: the content of the response body is the array of 10 users
    @Test
    public void testResponseBody(){
        given().
         when().
                get(endpoint).
         then().
                assertThat().
                body("", hasSize(10));
    }

}
