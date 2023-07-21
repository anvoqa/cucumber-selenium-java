package objects;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/*
 * This class applies Builder Pattern to construct complex POJO step by step, 
 * with Lombok library to take care of getter using annotation
 * */

@Getter
@Setter
@Builder
public class ContactDetails {
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private String phoneNumber;
	private String address1;
	private String address2;
	private String city;
	private String stateProvince;
	private String postalCode;
	private String country;

}
