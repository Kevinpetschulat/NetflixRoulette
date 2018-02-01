package at.fhv.netflix.endpoints;

import org.junit.Assert;
import org.junit.Test;

import at.fhv.netflix.models.Recommendation;
import at.fhv.netflix.models.User;

//integration test for recommendation endpoint
public class RecommendationPointIT {
	
	private static final int GENRE_ID = 17; 
	
	@Test
	public void getRecommendationWithInvalidLogin() throws Exception {
		RecommendationEndpoint recommendationEndpoint = new RecommendationEndpoint(); 
	
		Recommendation recommendation = recommendationEndpoint.getRecommendation("", 1); 
		Assert.assertNull(recommendation); 
	}
	
	@Test
	public void getValidRecommendation() throws Exception {		
		
		Exception e = null; 
		String token = null; 
		try {
			token = login(); 
		} catch (Exception e1) {
			e = e1; 
		}
		
		Assert.assertNull(e); 
		Assert.assertNotNull(token);
		
		RecommendationEndpoint recommendationEndpoint = new RecommendationEndpoint(); 
		Recommendation recommendation = recommendationEndpoint.getRecommendation(token, GENRE_ID); 
		Assert.assertNotNull(recommendation); 
		Assert.assertNotNull(recommendation.description); 
		Assert.assertNotNull(recommendation.imageUrl); 
		Assert.assertNotNull(recommendation.movieName); 
		Assert.assertFalse(recommendation.description.isEmpty()); 
		Assert.assertFalse(recommendation.imageUrl.isEmpty()); 
		Assert.assertFalse(recommendation.movieName.isEmpty()); 
	}
	
	// Returns token of login 
	private String login() throws Exception {
		AuthEndpoint authEndpoint = new AuthEndpoint(); 
		User user = authEndpoint.getToken(); 
		return user.getToken(); 
	}
	
}
