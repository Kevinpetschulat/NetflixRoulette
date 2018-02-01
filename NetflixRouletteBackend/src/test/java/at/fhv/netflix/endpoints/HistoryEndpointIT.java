package at.fhv.netflix.endpoints;

import org.junit.Test;
import org.junit.Assert;

import at.fhv.netflix.models.History;
import at.fhv.netflix.models.User;

//integration test for history endpoint
public class HistoryEndpointIT {

	@Test(expected = Exception.class)
	public void testGetHistoryNullToken() throws Exception {
		HistoryEndpoint endpoint = new HistoryEndpoint();
		endpoint.getHistory(null);
	}
	
	@Test(expected = Exception.class)
	public void testGetHistoryEmptyToken() throws Exception {
		HistoryEndpoint endpoint = new HistoryEndpoint();
		endpoint.getHistory("");
	}
	
	@Test
	public void testGeValidHistory() throws Exception {
		
		AuthEndpoint authEndpoint = new AuthEndpoint(); 
		User user = authEndpoint.getToken(); 
		
		HistoryEndpoint endpoint = new HistoryEndpoint();
		History history = endpoint.getHistory(user.getToken());
		
		Assert.assertNotNull(history); 
	}
}
