package at.fhv.netflix.models;

// Start of user code (user defined imports)

// End of user code

public class User {
	/**
	 * Description of the property token.
	 */
	public String token = null;
	
	/**
	 * Description of the property history.
	 */
	public at.fhv.netflix.models.History history = null;
	
	// Start of user code (user defined attributes)
	
	// End of user code
	
		public String getToken(){
		   return this.token;
		}
		
		public void setToken(String token){
		   this.token = token;
		}
		
		public at.fhv.netflix.models.History getHistory(){
		   return this.history;
		}
		
		public void setHistory(at.fhv.netflix.models.History history){
		   this.history = history;
		}
		
	
}
