package at.fhv.netflix.handlers;

import org.junit.Assert;
import org.junit.Test;
import at.fhv.netflix.models.Recommendation;
import at.fhv.netflix.models.User;

// Unit test for history handler
public class HistoryHandlerTest {
	
	@Test
	public void testSingleton() {
		Assert.assertNotNull(HistoryHandler.getInstance());
	}
	
	@Test
	public void testAddHistory() {
		
		HistoryHandler handler = HistoryHandler.getInstance(); 
		
		Exception e = null; 
		String token = null; 
		try {
			token = addDummyHistoryItem(handler);
		} catch (Exception e1) {
			e = e1; 
		}
		
		Assert.assertNull(e);
		Assert.assertNotNull(token);
	}

	@Test
	public void testGetHistory() {
		HistoryHandler handler = HistoryHandler.getInstance(); 
		
		Exception e = null; 
		String token  = null; 
		try {
			token = addDummyHistoryItem(handler);
		} catch (Exception e1) {
			e = e1; 
		}
		
		Assert.assertNull(e);
		Assert.assertNotNull(token);
		
		
		try {
			handler.getHistory(token);
		} catch (Exception e1) {
			e = e1; 
		} 
		
		Assert.assertNull(e);
	}
	
	private String addDummyHistoryItem(HistoryHandler historyHandler) throws Exception {
		
		// Create user because it has to exist in the backend 
		AuthHandler authHandler = AuthHandler.getInstance(); 
		User newUser = authHandler.getToken(); 
		
		// Create dummy data for the test. 
		String demoToken = newUser.getToken(); 
		int demoGenreID = 17; 
		Recommendation demoRecommendation = new Recommendation(); 
		demoRecommendation.setMovieName("This is a unit test");
		historyHandler.addHistory(demoToken, demoGenreID, demoRecommendation);
		
		return demoToken; 
	}
}
