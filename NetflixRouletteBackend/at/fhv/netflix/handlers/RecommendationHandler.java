package at.fhv.netflix.handlers;

// Start of user code (user defined imports)

// End of user code

public class RecommendationHandler {
	// Start of user code (user defined attributes)
	
	// End of user code
	

	private static RecommendationHandler INSTANCE;
	
	private RecommendationHandler(){
	    // singleton
	}
	
	public static RecommendationHandler getInstance(){
	    if(INSTANCE == null){
	        INSTANCE = new RecommendationHandler();
	    }
	
	    return INSTANCE;
	}
	
	public at.fhv.netflix.models.Recommendation getRecommendation(String token, int genreId) throws Exception {
		// Start of user code getRecommendation
		return null;
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
	
}
