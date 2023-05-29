package com.bhavna.java.soapapi;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;

import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class Soap_Reference {
	
	public static void main(String[] args) {
		//Step 1: Declare the Base URI and request body variables
		
		String BaseURI = "https://www.dataaccess.com";
		String requestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>100</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>\r\n"
				+ "";
		
		//Step 2 : Set the expected results
		
				XmlPath xmlreq = new XmlPath(requestBody);
				String requestParam = xmlreq.getString("ubiNum");
				
				//Step 3 : Configure the request and extract the response body
				RestAssured.baseURI=BaseURI;
				String responseBody = given().header("Content-Type", "text/xml; charset=utf-8")
						.body(requestBody).when().post("/webservicesserver/NumberConversion.wso")
						.then().extract().response().getBody().asString();
				
				//Step 4 : Extract the response body parameters 
				XmlPath xmlresp = new XmlPath(responseBody);
				String result = xmlresp.getString("NumberToWordsResult");
				
				//Step 5 : Validate the response body parameters
				Assert.assertEquals(result, "one hundred ");
				System.out.println(result);
				System.out.println(requestParam);
				System.out.println(responseBody);
				
	

	}

}

