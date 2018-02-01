package at.fhv.netflix.endpoints;

import org.junit.Test;

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
}
