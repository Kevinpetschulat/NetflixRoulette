package at.fhv.netflix.handlers;

import org.junit.Assert;
import org.junit.Test;
import at.fhv.netflix.models.Recommendation;
import at.fhv.netflix.models.User;

public class RecommendationHandlerTest {

	@Test
	public void testSingleton() {
		Assert.assertNotNull(RecommendationHandler.getInstance());
	}
	
	@Test
	public void testGetRecommendation() {
		RecommendationHandler handler = RecommendationHandler.getInstance(); 
		
		int dummyGenreId = 17; 
		String dummyToken = getDummyTokenId(); 
		
		Assert.assertNotNull(dummyToken);
		
		Recommendation result = null;
		Exception e = null; 
		try {
			result = handler.getRecommendation(dummyToken, dummyGenreId);
		} catch (Exception e1) {
			e = e1; 
		} 
		
		Assert.assertNull(e); 
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getMovieName());
		Assert.assertFalse(result.getMovieName().isEmpty());
	}
	
	
	private String getDummyTokenId() {
		AuthHandler handler = AuthHandler.getInstance();
		User newUserWithToken;
		try {
			newUserWithToken = handler.getToken();
			return newUserWithToken.getToken(); 
		} catch (Exception e) {
			return null; 
		} 
	}
	
}
