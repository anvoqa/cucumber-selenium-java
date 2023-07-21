package commons;

import java.io.File;

public class GlobalConstants {
	
	public static final int MAX_TIMEOUT = 30;
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILES = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILES = PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
	
	public static final String HOME_PAGE_URL = "https://thinking-tester-contact-list.herokuapp.com/";
	public static final String CONTACT_LIST_URL = HOME_PAGE_URL + "contactList";
	public static final String ADD_NEW_CONTACT_URL = HOME_PAGE_URL + "addContact";
	public static final String EDIT_CONTACT_URl = HOME_PAGE_URL + "editContact";
	
	public static final String BASE_URI = "https://thinking-tester-contact-list.herokuapp.com/";
	public static final String CONTACT_END_POINT = "contacts/";
	public static final String ADD_USER_END_POINT = "users/";
	public static final String LOGGED_IN_USER_END_POINT = "users/me";
	public static final String LOG_OUT_END_POINT = "users/logout";
	public static final String LOG_IN_END_POINT = "users/login";

}
