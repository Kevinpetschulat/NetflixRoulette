package at.fhv.netflix.models;

// Start of user code (user defined imports)

// End of user code

public class History {
	/**
	 * Description of the property items.
	 */
	public java.util.Set<at.fhv.netflix.models.HistoryItem> items = new java.util.HashSet<at.fhv.netflix.models.HistoryItem>();
	
	// Start of user code (user defined attributes)
	
	// End of user code
	
		public java.util.Set<at.fhv.netflix.models.HistoryItem> getItems(){
		   return this.items;
		}
		
		public void setItems(java.util.Set<at.fhv.netflix.models.HistoryItem> items){
		   this.items = items;
		}
		
	
}
