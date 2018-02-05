package at.fhv.netflix.handlers;

// Start of user code (user defined imports)

// End of user code

public class AuthHandler {
	// Start of user code (user defined attributes)
	protected java.util.Map<String, at.fhv.netflix.models.User> users = new java.util.HashMap<>();
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
	
	public at.fhv.netflix.models.User getUser(String Token) throws Exception {
		// Start of user code getUser
		
		// Get the user by token or return null if the user does not exist
		if (!users.containsKey(Token)) {
			return null; 
		}
		
        	return users.get(Token);
 		// End of user code
	}
	
	public at.fhv.netflix.models.User getToken() throws Exception {
		// Start of user code getToken
		at.fhv.netflix.models.User user = new at.fhv.netflix.models.User(); 
		
		String token = generateNewToken(); 
		user.setToken(token); 
        	user.setHistory(new at.fhv.netflix.models.History());
        users.put(token, user);
	
		return user; 
		// End of user code
	}
	
	// Start of user code (user defined operations)	
	private String generateNewToken() {
		java.util.Random rand = new java.util.Random(); 
		int min = 1000; 
		int max = 1000000; 
		int randomNum = rand.nextInt((max - min) + 1) + min;	// nextInt is normally exclusive of the top value, so add 1 to make it inclusive
		String token = "user"+randomNum; 
	
		while(users.containsKey(token)) {
			randomNum = rand.nextInt((max - min) + 1) + min;	
			token = "user"+randomNum; 
		}
		
		return token; 
	}
	// End of user code
	
}
