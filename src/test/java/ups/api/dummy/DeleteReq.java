package ups.api.dummy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteReq {

	static String domain = "https://jsonplaceholder.typicode.com";

	@Test
	public static void DeletRequest() {
		RestAssured.baseURI = domain;
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.DELETE, "/posts/1");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
}
}