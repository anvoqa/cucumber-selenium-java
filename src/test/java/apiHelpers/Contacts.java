package apiHelpers;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.json.*;


import commons.GlobalConstants;
import io.restassured.response.Response;

public class Contacts {
	public static void deleteAllContacts(String email, String password) {
		String token = Users.getLoggedInToken(email, password);
		List<String> contactIDs = getContactIDs(email, password);
		for (String id: contactIDs) {
			given()
			.header("Authorization", "Bearer " + token
					, "Content-Type", "application/json"
					, "Accept", "application/json")
			.when()
			.delete(GlobalConstants.BASE_URI + GlobalConstants.CONTACT_END_POINT + id)
			.then()
			.extract()
			.response()
			.body()
			.toString()
			.equals("Contact deleted");
		}
	}
	
	public static List<String> getContactIDs(String email, String password) {
		String token = Users.getLoggedInToken(email, password);
		Response response = given()
		.header("Authorization", "Bearer " + token
				, "Content-Type", "application/json"
				, "Accept", "application/json")
		.when()
		.get(GlobalConstants.BASE_URI + GlobalConstants.CONTACT_END_POINT)
		.then()
		.extract()
		.response();
		
		JSONArray contactList = new JSONArray(response.body().asString());
		List<String> contactIDs = new ArrayList<String>();
		for (int i = 0; i < contactList.length(); i++) {
			JSONObject object = contactList.getJSONObject(i);
			contactIDs.add(object.get("_id").toString());
		}
		
		return contactIDs;
	}
	
}
