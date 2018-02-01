package at.fhv.netflix.endpoints;

import org.junit.Assert;
import org.junit.Test;

import at.fhv.netflix.handlers.AuthHandler;
import at.fhv.netflix.models.User;


// integration test for auth endpoint
public class AuthEndpointIT {

	@Test
	public void testLogin() throws Exception {
		AuthEndpoint authEndpoint = new AuthEndpoint(); 
		User user = authEndpoint.getToken(); 
		
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getToken());
		Assert.assertFalse(user.getToken().isEmpty());
	}
}
