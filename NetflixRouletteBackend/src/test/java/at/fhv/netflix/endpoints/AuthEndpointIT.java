package at.fhv.netflix.endpoints;

import org.junit.Assert;
import org.junit.Test;

import at.fhv.netflix.handlers.AuthHandler;
import at.fhv.netflix.models.User;


// integration test for auth endpoint
public class AuthEndpointIT {

	// This will create a new token in the backend where the user can get his user model 
	@Test
	public void testLogin() throws Exception {
		AuthHandler handler = AuthHandler.getInstance(); 
		
		// Login and create token
		User freshUser = handler.getToken(); 
		Assert.assertNotNull(freshUser);
		String token = freshUser.getToken(); 
		
		// Use this token and try to get the user by the token
		User savedUser = handler.getUser(token); 
		Assert.assertNotNull(savedUser);
	}
}
