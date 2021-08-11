package ups.api.dummy;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutReq {
	static String domain = "https://jsonplaceholder.typicode.com";

	@Test
	public static void putReq() {
		RestAssured.baseURI = domain;
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject data = new JSONObject();
		data.put("Batch-no", "112");
		data.put("First_Name", "Mohammed");
		data.put("Last_Name", "Alam");
		data.put("Company_Name", "Smarttech");
		data.put("Email", "Alammohammed79@gmail.com");

		httpRequest.header("Content-Type", " application/json; charset=utf-8");
		httpRequest.body(data.toJSONString());

		Response response = httpRequest.request(Method.PUT, "/posts/1");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		// Verify the content type
		String contantType = response.header("Content-Type");
		System.out.println("Content-Type : " + contantType);

		Assert.assertEquals(contantType, "application/json; charset=utf-8");

		// Verify the status code
		int statusCode = response.getStatusCode();
		System.out.println("My status code is a : " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// Verify the status line
		String statusLine = response.statusLine();
		System.out.println("Status Line  : " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		// Verify the body
		String emailVerify = response.jsonPath().get("Email");
		Assert.assertEquals(emailVerify, "Alammohammed79@gmail.com");
		System.out.println("Email address  is a : " + emailVerify);
	}
}
