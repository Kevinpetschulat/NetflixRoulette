package at.fhv.netflix.models;

// Start of user code (user defined imports)

// End of user code

public class HistoryItem {
	/**
	 * Description of the property genreId.
	 */
	public int genreId = 0;
	
	/**
	 * Description of the property requested.
	 */
	public long requested = 0;
	
	/**
	 * Description of the property result.
	 */
	public at.fhv.netflix.models.Recommendation result = null;
	
	// Start of user code (user defined attributes)
	
	// End of user code
	
		public int getGenreId(){
		   return this.genreId;
		}
		
		public void setGenreId(int genreId){
		   this.genreId = genreId;
		}
		
		public long getRequested(){
		   return this.requested;
		}
		
		public void setRequested(long requested){
		   this.requested = requested;
		}
		
		public at.fhv.netflix.models.Recommendation getResult(){
		   return this.result;
		}
		
		public void setResult(at.fhv.netflix.models.Recommendation result){
		   this.result = result;
		}
		
	
}
