package at.fhv.netflix.models;

// Start of user code (user defined imports)

// End of user code

public class Recommendation {
	/**
	 * Description of the property movieName.
	 */
	public String movieName = null;
	
	/**
	 * Description of the property imageUrl.
	 */
	public String imageUrl = null;
	
	/**
	 * Description of the property description.
	 */
	public String description = null;
	
	// Start of user code (user defined attributes)
	
	// End of user code
	
		public String getMovieName(){
		   return this.movieName;
		}
		
		public void setMovieName(String movieName){
		   this.movieName = movieName;
		}
		
		public String getImageUrl(){
		   return this.imageUrl;
		}
		
		public void setImageUrl(String imageUrl){
		   this.imageUrl = imageUrl;
		}
		
		public String getDescription(){
		   return this.description;
		}
		
		public void setDescription(String description){
		   this.description = description;
		}
		
	
}
