package resources;

public enum APIResources {

	authAPI("/auth"),
	createBookingAPI("/booking"),
	updateBookingAPI("/booking/"),
	deleteBookingAPI("/booking/");
	private String resource;
	
	APIResources(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
}