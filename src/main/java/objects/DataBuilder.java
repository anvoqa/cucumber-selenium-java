package objects;


import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class DataBuilder {
	private static final Faker FAKER = Faker.instance ();
	
	 @SuppressWarnings("deprecation")
	public static ContactDetails getContactDetails() {
	        return ContactDetails.builder()
	        		.firstName(FAKER.name().firstName())
	        		.lastName(FAKER.name().lastName())
	        		.dob(new SimpleDateFormat("yyyy-MM-dd").format(FAKER.date().birthday().getDate()))
	        		.email(FAKER.internet().emailAddress())
	        		.phoneNumber(FAKER.phoneNumber().cellPhone().replaceAll("[^0-9]", ""))
	        		.address1(FAKER.address().streetAddress())
	        		.address2(FAKER.address().buildingNumber())
	        		.city(FAKER.address().city())
	        		.stateProvince(FAKER.address().state())
	        		.postalCode(FAKER.address().zipCode())
	        		.country(FAKER.address().country()).build();
	    }
	 
	 public static Accounts getAccountDetails() {
		 return Accounts.builder()
				 .firstName(FAKER.name().firstName())
				 .lastName(FAKER.name().lastName())
				 .email(FAKER.internet().emailAddress())
				 .password("1234567")
				 .build();
	 }
}
