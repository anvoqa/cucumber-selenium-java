package objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Accounts {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
