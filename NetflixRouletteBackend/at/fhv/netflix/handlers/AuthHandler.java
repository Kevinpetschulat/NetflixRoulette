package at.fhv.netflix.handlers;

// Start of user code (user defined imports)

// End of user code

public class AuthHandler {
	// Start of user code (user defined attributes)
	
	// End of user code
	

	private static AuthHandler INSTANCE;
	
	private AuthHandler(){
	    // singleton
	}
	
	public static AuthHandler getInstance(){
	    if(INSTANCE == null){
	        INSTANCE = new AuthHandler();
	    }
	
	    return INSTANCE;
	}
	
	public at.fhv.netflix.models.User getToken() throws Exception {
		// Start of user code getToken
		return null;
		// End of user code
	}
	
	public at.fhv.netflix.models.User getUser(String Token) throws Exception {
		// Start of user code getUser
		return null;
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
	
}
