package apiHelpers;
import commons.GlobalConstants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Users {
	
	public static String getLoggedInToken(String email, String password) {
		Map<String, String> credential = new HashMap<String, String>();
		credential.put("email", email);
		credential.put("password", password);
		
		Response response = given()
				.header("Content-Type", "application/json"
						, "Accept", "application/json")
				.when()
				.body(credential)
				.post(GlobalConstants.BASE_URI + GlobalConstants.LOG_IN_END_POINT)
				.then()
				.extract()
				.response();
			return JsonPath.from(response.body().asString()).get("token");
	}
	
	public static void deleteUser(String email, String password) {
		String token = getLoggedInToken(email, password);
		given()
		.header("Authorization", "Bearer " + token
				, "Content-Type", "application/json"
				, "Accept", "application/json")
		.when()
		.delete(GlobalConstants.BASE_URI + GlobalConstants.LOGGED_IN_USER_END_POINT)
		.then()
		.extract()
		.response()
		.body()
		.toString()
		.equals("Contact deleted");
	}
	
}
