package commonMethodPackage;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;


public class API_Common_Method {
	
	public static int response_StatusCode(String baseURI, String resource, String requestBody) {
		
		RestAssured.baseURI= baseURI;		
		// Configure Request Body
		int statusCode =given().header("Content-Type","application/json").body(requestBody)
				.when().post(resource).then().extract().statusCode();
		
		return statusCode;
		
	}
	
    public static String response_Body(String baseURI, String resource, String requestBody) {
		
		RestAssured.baseURI= baseURI;		
		
		String responseBody = given().header("Content-Type","application/json").body(requestBody)
				.when().post(resource).then().extract().response().asString();
		return responseBody;
		

}
}
