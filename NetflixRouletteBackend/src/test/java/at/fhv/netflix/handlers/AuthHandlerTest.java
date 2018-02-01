package at.fhv.netflix.handlers;

import org.junit.Assert;
import org.junit.Test;
import at.fhv.netflix.models.User; 

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

	
	
	// TODO Test get user function
	
	
	
	
	// Test the logout function 
//	@Test
//	public void testLogout() throws Exception {
//		String exampleEmail = "hugo@example.com"; 
//		
//		AuthHandler handler = AuthHandler.getInstance();
//		handler.users.put(exampleEmail, new User());
//		handler.logout(exampleEmail);
//		Assert.assertFalse(handler.users.containsKey(exampleEmail));
//	}
//
//	/**
//	 * Test logout with empty token
//	 */
//	@Test(expected = Exception.class)
//	public void testLogoutEmptyMail() throws Exception {
//		AuthHandler handler = AuthHandler.getInstance();
//		handler.users.put("user@test.com", new User());
//		handler.logout("");
//	}
//
//	/**
//	 * Test logout with null token
//	 */
//	@Test(expected = Exception.class)
//	public void testLogoutNullMail() throws Exception {
//		AuthHandler handler = AuthHandler.getInstance();
//		handler.users.put("user@test.com", new User());
//		handler.logout(null);
//	}
//
//	/**
//	 * Test successful user loading
//	 */
//	@Test
//	public void testGetUser() throws Exception {
//		AuthHandler handler = AuthHandler.getInstance();
//		handler.users.put("user@test.com", new User());
//		Assert.assertNotNull(handler.getUser("user@test.com"));
//	}
//
//	/**
//	 * Test user loading with empty token
//	 */
//	@Test(expected = Exception.class)
//	public void testGetUserEmptyMail() throws Exception {
//		AuthHandler handler = AuthHandler.getInstance();
//		handler.users.put("user@test.com", new User());
//		handler.getUser("");
//	}
//
//	/**
//	 * Test user loading with null token
//	 */
//	@Test(expected = Exception.class)
//	public void testGetUserNullMail() throws Exception {
//		AuthHandler handler = AuthHandler.getInstance();
//		handler.users.put("user@test.com", new User());
//		handler.getUser(null);
//	}
//
//	/**
//	 * Test successful user login
//	 */
//	@Test
//	public void testLogin() throws Exception {
//		AuthHandler handler = AuthHandler.getInstance();
//		String token = handler.login("user@test.com");
//		Assert.assertNotNull(token);
//		Assert.assertNotEquals("", token);
//
//		User user = handler.users.get(token);
//		Assert.assertEquals("user@test.com", user.getEmail());
//		Assert.assertNotNull(user.getHistory());
//	}
//
//	/**
//	 * Test user login with empty mail
//	 */
//	@Test(expected = Exception.class)
//	public void testLoginEmptyMail() throws Exception {
//		AuthHandler handler = AuthHandler.getInstance();
//		handler.login("");
//	}
//	
//	/**
//	 * Test user login with null mail
//	 */
//	@Test(expected = Exception.class)
//	public void testLoginNullMail() throws Exception {
//		AuthHandler handler = AuthHandler.getInstance();
//		handler.login(null);
//	}
}