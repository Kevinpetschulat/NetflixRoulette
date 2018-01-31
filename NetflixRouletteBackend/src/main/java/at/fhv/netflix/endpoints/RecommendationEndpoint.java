package at.fhv.netflix.endpoints;

// Start of user code (user defined imports)

// End of user code

@org.springframework.web.bind.annotation.RestController
public class RecommendationEndpoint {
	// Start of user code (user defined attributes)
	
	// End of user code
	
	
	@org.springframework.web.bind.annotation.PostMapping("recommendation")
	public at.fhv.netflix.models.Recommendation getRecommendation(@org.springframework.web.bind.annotation.RequestParam("token") String token, @org.springframework.web.bind.annotation.RequestParam("genreId") int genreId) throws Exception {
		// Start of user code getRecommendation
			
		return at.fhv.netflix.handlers.RecommendationHandler.getInstance().getRecommendation(token, genreId); 

		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
}
