package ups.api.dummy;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.CommonUtility;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReq {
	static	String domain = "https://jsonplaceholder.typicode.com";
	
	@Test
	public static void postReq() {		
		RestAssured.baseURI = domain;
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject data = new JSONObject();
		data.put("Batch-no", CommonUtility.randomNumeric());
		data.put("First_Name", CommonUtility.randomestring());
		data.put("Last_Name", CommonUtility.randomestring());
		data.put("Company_Name", CommonUtility.randomestring());
		data.put("Email", "Alammohammed79@gmail.com");
		
		httpRequest.header("Content-Type", "application/json; charset=utf-8");
		httpRequest.body(data.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "/posts");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		
		// Verify the content type
		String contantType = response.header("Content-Type");
		System.out.println("Content-Type : "+contantType);
		
		Assert.assertEquals(contantType, "application/json; charset=utf-8");
		
		
		// Verify the status code
		 int statusCode =  response.getStatusCode();
		 System.out.println("My status code is a : "+statusCode);
		 Assert.assertEquals(statusCode, 201);
		 
		 
			// Verify the status line
			String statusLine = response.statusLine();
			System.out.println("Status Line  : "+ statusLine);		
			Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		
			String emailVerify = response.jsonPath().get("Email");
			Assert.assertEquals(emailVerify, "Alammohammed79@gmail.com");
			System.out.println("Email address  is a : " + emailVerify);
	}
}
