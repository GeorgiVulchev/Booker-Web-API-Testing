package resources;

public enum APIResources {

	authAPI("/auth");
	
	private String resource;
	
	APIResources(String resource){
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
}
