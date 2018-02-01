package at.fhv.netflix.handlers;

import org.junit.Assert;
import org.junit.Test;

import at.fhv.netflix.models.Recommendation;

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
	
	private String addDummyHistoryItem(HistoryHandler handler) throws Exception {
		// Create dummy data for the test. 
		String demoToken = "user-123"; 
		int demoGenreID = 17; 
		Recommendation demoRecommendation = new Recommendation(); 
		demoRecommendation.setMovieName("This is a unit test");
		handler.addHistory(demoToken, demoGenreID, demoRecommendation);
		
		return demoToken; 
	}
}
