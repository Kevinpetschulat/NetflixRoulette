package at.fhv.netflix.handlers;

// Start of user code (user defined imports)
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import at.fhv.netflix.endpoints.RecommendationEndpoint;
import at.fhv.netflix.models.Recommendation; 
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
		
		if (token == null || "".equals(token)) {
			throw new Exception("Not authenticated");
		}

		Gson gson = new GsonBuilder().create();
		
		// Fetch new movie id
		String urlRecommendation = "https://api.reelgood.com/v1/roulette/netflix?nocache=true&kind=" + genreId + "&minimumScore=4&sources=netflix%2Cshowtime%2Cstarz&free=true"; 
		
				
		HttpResponse responseDetails; 
		String movieID; 
		do {		// Sometimes the api returns a invalid movie id, because of this: loop 
			HttpResponse responseRecommendation = Request.Get(urlRecommendation).execute().returnResponse();
			String resultRecommendation = IOUtils.toString(responseRecommendation.getEntity().getContent(), "UTF-8");
			JsonObject jsonObjectRecommendation = gson.fromJson(resultRecommendation, JsonObject.class);
			movieID = gson.fromJson(jsonObjectRecommendation.get("id"), String.class);
			
			
			if (movieID == null || "".equals(movieID) ) {
				throw new Exception("Could not fetch new movie");
			}

			// Fetch movie details 
			String urlDetails = "https://api.reelgood.com/v1/movie/" + movieID; 
			responseDetails = Request.Get(urlDetails).execute().returnResponse();		
		} while(responseDetails.getEntity() == null); 
		
		
		
		String resultDetails = IOUtils.toString(responseDetails.getEntity().getContent(), "UTF-8");
		JsonObject jsonObjectDetails = gson.fromJson(resultDetails, JsonObject.class);
		String movieDetailsTitle = gson.fromJson(jsonObjectDetails.get("title"), String.class);
		String movieDetailsOverview = gson.fromJson(jsonObjectDetails.get("overview"), String.class);
		String pictureURL = "https://img.reelgood.com/content/movie/"+ movieID + "/poster-780.webp"; 
		
	
		// Create new model and return it
		Recommendation res = new Recommendation(); 
		res.setDescription(movieDetailsOverview); 
		res.setMovieName(movieDetailsTitle);
		res.setImageUrl(pictureURL);
		
		
		// Add history item 
		HistoryHandler.getInstance().addHistory(token, genreId, res);

		
		return res; 
		
		
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
	
}
