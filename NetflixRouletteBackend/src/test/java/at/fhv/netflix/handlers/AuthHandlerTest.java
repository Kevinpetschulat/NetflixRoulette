package at.fhv.netflix.handlers;

import org.junit.Assert;
import org.junit.Test;
import at.fhv.netflix.models.User; 

// Unit test for auth handler 
public class AuthHandlerTest {

	// Test the get instance function
	@Test
	public void testSingleton() {
		Assert.assertNotNull(AuthHandler.getInstance());
	}
	
	// Test get token function
	@Test
	public void testGetToken() throws Exception {
		AuthHandler handler = AuthHandler.getInstance();
		User newUserWithToken = handler.getToken(); 
		
		Assert.assertNotNull(newUserWithToken);
		Assert.assertNotNull(newUserWithToken.getToken());
		Assert.assertFalse(newUserWithToken.getToken().isEmpty()); 
	}	

	// Test get user function: function returns valid user
	// Demo user will be manually created in this test 
	@Test
	public void testGetUserByValidToken1() throws Exception {
		AuthHandler handler = AuthHandler.getInstance();
		
		// Create demo user 
		String demoToken = "user-234"; 
		User testUser = new User(); 
		testUser.setToken(demoToken);
		handler.users.put(demoToken, testUser); 
		
		User resultUser = handler.getUser(demoToken); 
		Assert.assertNotNull(resultUser);
	}

	// Test get user function: function returns valid user
	// Demo user will be automatically created in this test
	@Test
	public void testGetUserByValidToken2() throws Exception {
		AuthHandler handler = AuthHandler.getInstance();
		
		// Create demo user 
		User demoUser = handler.getToken(); 
		String demoToken = demoUser.getToken(); 
		
		User resultUser = handler.getUser(demoToken); 
		Assert.assertNotNull(resultUser);
	}
	
	// Test get user function: token is null
	@Test
	public void testGetUserByNullToken() throws Exception {
		AuthHandler handler = AuthHandler.getInstance();
		
		User user = handler.getUser(null); 
		Assert.assertNull(user);
	}
	
	// Test get user function: token is an invalid string
	@Test
	public void testGetUserByInvalidToken() throws Exception {
		AuthHandler handler = AuthHandler.getInstance();
		
		User user = handler.getUser("some invalid token"); 
		Assert.assertNull(user);
	}
}