package testClassPackage;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;

import commonMethodPackage.API_Common_Method;
import commonMethodPackage.Utility_Common_Functions;
import io.restassured.path.json.JsonPath;
import requestRepositoryPackage.post_req_repository;

public class POST_TC_3 {
	
public static void execute() throws IOException{
		
		for(int i = 0; i<5; i++) {
			
			int res_Status_Code = API_Common_Method.response_StatusCode(post_req_repository.base_URI(), 
					post_req_repository.post_resource(),post_req_repository.post_Request3());
			
			if(res_Status_Code == 201) {
			
			String response_Body = API_Common_Method.response_Body (post_req_repository.base_URI(),
					post_req_repository.post_resource(), post_req_repository.post_Request3());
			System.out.println(response_Body);
			
			POST_TC_3.validator(response_Body, res_Status_Code);
			Utility_Common_Functions.evidenceFileCreater("POST_TC_3", post_req_repository.post_Request3(),response_Body);
			System.out.println(res_Status_Code);
			break;
			
			}
			
			else {
				System.out.println("Correct status code is not found, hence retrying the API ");
			}
		}
		
		
	}
		public static void validator(String responsebody,int statusCode) throws IOException {
			JsonPath jsprequest = new JsonPath(post_req_repository.post_Request3());   //Creating s JSON Object 
			String req_name = jsprequest.getString("name");
			String req_job = jsprequest.getString("job");
	
			// Parse the response body
			JsonPath jsp = new JsonPath(responsebody);
			String res_name = jsp.getString("name");
			String res_job = jsp.getString("job");
			String res_id = jsp.getString("id");
			String res_createdAt=jsp.getString("createdAt"); 
			String currentdate=LocalDate.now().toString();
	
	
			// Validate the response body parameters
			Assert.assertEquals(res_name, req_name);
			Assert.assertEquals(res_job, req_job);
			Assert.assertNotNull(res_id);
			Assert.assertEquals(res_createdAt.substring(0,10), currentdate);
			
			System.out.println("statusCode is " +statusCode);
			System.out.println("responseBody is " +responsebody);
    

   

}

}