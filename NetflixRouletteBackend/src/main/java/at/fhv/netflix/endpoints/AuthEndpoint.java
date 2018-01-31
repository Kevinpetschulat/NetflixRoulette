package at.fhv.netflix.endpoints;

// Start of user code (user defined imports)

// End of user code

@org.springframework.web.bind.annotation.RestController
public class AuthEndpoint {
	// Start of user code (user defined attributes)
	
	// End of user code
	
	
	@org.springframework.web.bind.annotation.PostMapping("login")
	public at.fhv.netflix.models.User getToken() throws Exception {
		// Start of user code getToken
		
		return at.fhv.netflix.handlers.AuthHandler.getInstance().getToken();
	
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
}
