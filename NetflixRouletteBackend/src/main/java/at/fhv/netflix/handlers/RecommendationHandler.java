package at.fhv.netflix.handlers;

// Start of user code (user defined imports)
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import at.fhv.netflix.models.Recommendation; 
// End of user code

public class RecommendationHandler {
	// Start of user code (user defined attributes)
	private static final String STRING_CODING = "UTF-8"; 
	private static final String URL_RECOMMENDATION_PART_1 = "https://api.reelgood.com/v1/roulette/netflix?nocache=true&kind="; 
	private static final String URL_RECOMMENDATION_PART_2 = "&minimumScore=4&sources=netflix%2Cshowtime%2Cstarz&free=true"; 
	private static final String URL_MOVIE_DETAILS = "https://api.reelgood.com/v1/movie/"; 
	private static final String JSON_TITLE_ATTRIBUTE = "title"; 
	private static final String JSON_OVERVIEW_ATTRIBUTE = "overview"; 
	private static final String URL_PICTURE_PART_1 = "https://img.reelgood.com/content/movie/"; 
	private static final String URL_PICTURE_PART_2 = "/poster-780.webp"; 
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
			return null; 
		}

		Gson gson = new GsonBuilder().create();
		
		// Fetch new movie id
		String urlRecommendation = URL_RECOMMENDATION_PART_1 + genreId + URL_RECOMMENDATION_PART_2; 
		
				
		HttpResponse responseDetails; 
		String movieID; 
		do {		// Sometimes the api returns a invalid movie id, because of this: loop 
			HttpResponse responseRecommendation = null;
			responseRecommendation = Request.Get(urlRecommendation).execute().returnResponse();
			
			String resultRecommendation = null;
			resultRecommendation = IOUtils.toString (responseRecommendation.getEntity().getContent(), STRING_CODING);
			
			JsonObject jsonObjectRecommendation = gson.fromJson(resultRecommendation, JsonObject.class);
			movieID = gson.fromJson(jsonObjectRecommendation.get("id"), String.class);
			
			
			if (movieID == null || "".equals(movieID) ) {
				// Could not fetch new movie
				return null; 
			}

			// Fetch movie details 
			String urlDetails = URL_MOVIE_DETAILS + movieID; 
			responseDetails = Request.Get(urlDetails).execute().returnResponse();
				
		} while (responseDetails.getEntity() == null); 
		
		
		String resultDetails = null; ;
		resultDetails = IOUtils.toString(responseDetails.getEntity().getContent(), STRING_CODING);
		
		JsonObject jsonObjectDetails = gson.fromJson(resultDetails, JsonObject.class);
		String movieDetailsTitle = gson.fromJson(jsonObjectDetails.get(JSON_TITLE_ATTRIBUTE), String.class);
		String movieDetailsOverview = gson.fromJson(jsonObjectDetails.get(JSON_OVERVIEW_ATTRIBUTE), String.class);
		String pictureURL = URL_PICTURE_PART_1+ movieID + URL_PICTURE_PART_2; 
		
	
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
