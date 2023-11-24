
public class Admin {
	static final String name = "admin";
	static final String id = "0000000000";
	static final String password = "admin2023";
	
	public Admin() {}
	
	public void approveInitiative(Initiative i) {
		i.setStatus("active");
	}
	public void rejectInitiative(Initiative i) {
		Initiative.pendingInitiatives.remove(Initiative.pendingInitiatives.indexOf(i));
		
	}
	
}
