
public class Admin {
	static final String name = "admin";
	static final String id = "0000000000";
	static final String password = "admin2023";
	
	public Admin() {}
	
	public static void approveInitiative(Initiative i) {
		i.setStatus("active");
	}
	public static void rejectInitiative(Initiative i) {
		Initiative.pendingInitiatives.remove(Initiative.pendingInitiatives.indexOf(i));
	}
	public static void removeUser(User u) {
		User.users.remove(User.users.indexOf(u));
	}
	
}
