package at.fhv.netflix.endpoints;

// Start of user code (user defined imports)

// End of user code

@org.springframework.web.bind.annotation.RestController
public class HistoryEndpoint {
	// Start of user code (user defined attributes)
	
	// End of user code
	
	
	@org.springframework.web.bind.annotation.GetMapping("history")
	public at.fhv.netflix.models.History getHistory(@org.springframework.web.bind.annotation.RequestParam("token") String token) throws Exception {
		// Start of user code getHistory
		return at.fhv.netflix.handlers.HistoryHandler.getInstance().getHistory(token);
		// End of user code
	}

	
	// Start of user code (user defined operations)
	
	// End of user code
}
