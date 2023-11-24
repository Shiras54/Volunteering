
public class Admin {
	private String name = "admin";
	private String id = "0";
	private String password = "admin2023";
	
	public Admin() {}
	
	public void approveInitiative(Initiative i) {
		i.setStatus("active");
	}
	public void rejectInitiative(Initiative i) {
		Initiative.pendingInitiatives.remove(Initiative.pendingInitiatives.indexOf(i));
		
	}
	
}
