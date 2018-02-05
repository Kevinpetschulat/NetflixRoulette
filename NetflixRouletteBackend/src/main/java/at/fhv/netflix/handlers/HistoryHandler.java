package at.fhv.netflix.handlers;

// Start of user code (user defined imports)

// End of user code

public class HistoryHandler {
	// Start of user code (user defined attributes)
	
	// End of user code
	

	private static HistoryHandler INSTANCE;
	
	private HistoryHandler(){
	    // singleton
	}
	
	public static HistoryHandler getInstance(){
	    if(INSTANCE == null){
	        INSTANCE = new HistoryHandler();
	    }
	
	    return INSTANCE;
	}
	
	public void addHistory(String token, int genreId, at.fhv.netflix.models.Recommendation result) throws Exception {
		// Start of user code addHistory
		at.fhv.netflix.models.User user = AuthHandler.getInstance().getUser(token);
		at.fhv.netflix.models.HistoryItem item = new at.fhv.netflix.models.HistoryItem();
        item.setRequested(java.time.Instant.now().toEpochMilli());
        item.setGenreId(genreId);
        item.setResult(result);
        user.getHistory().getItems().add(item);
		// End of user code
	}
	
	public at.fhv.netflix.models.History getHistory(String token) throws Exception {
		// Start of user code getHistory
		if(token == null || "".equals(token)) {
			return null; 
		}
		
		at.fhv.netflix.models.User user = AuthHandler.getInstance().getUser(token);
		return user.getHistory();
		// End of user code
	}
	
	public void clearHistory(String token) throws Exception {
		// Start of user code clearHistory
		if (token == null || "".equals(token)) {
			return; 
		}
		
		at.fhv.netflix.models.User user = AuthHandler.getInstance().getUser(token);
		user.setHistory(new at.fhv.netflix.models.History()); 
		// End of user code
	}
	
	// Start of user code (user defined operations)
	
	// End of user code
	
}
