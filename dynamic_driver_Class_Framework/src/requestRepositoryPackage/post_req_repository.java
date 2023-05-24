package requestRepositoryPackage;

import java.io.IOException;
import java.util.ArrayList;

import commonMethodPackage.Utility_Common_Functions;

public class post_req_repository {
	
	public static String base_URI() {
		
		String baseURI = "https://reqres.in";
		return baseURI;
	}
	
	public static String post_resource() {
		
		String resource = "/api/users";
		return resource;
		
	}
	
	public static String post_Request1() throws IOException {
		ArrayList<String> data = Utility_Common_Functions.readDataExcel("POST_SHEET", "POST_TC_1");
		//System.out.println(data);
		String req_name=data.get(1);
		String req_job=data.get(2);

		String requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestbody;
	}
	
	public static String post_Request2() throws IOException {
		ArrayList<String> data = Utility_Common_Functions.readDataExcel("POST_SHEET", "POST_TC_2");
		//System.out.println(data);
		String req_name=data.get(1);
		String req_job=data.get(2);

		String requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestbody;
	}
	
	public static String post_Request3() throws IOException {
		ArrayList<String> data = Utility_Common_Functions.readDataExcel("POST_SHEET", "POST_TC_3");
		//System.out.println(data);
		String req_name=data.get(1);
		String req_job=data.get(2);

		String requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		
		return requestbody;
	}
}
	

