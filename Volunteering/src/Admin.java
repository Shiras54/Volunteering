
public class Admin {
	static final String name = "admin";
	static final String id = "0000000000";
	static final String password = "admin2023";
	
	public Admin() {}
	
	public static void approveInitiative(Initiative i) {
		i.setStatus("active");
		Initiative.pendingInitiatives.remove(Initiative.pendingInitiatives.indexOf(i));
		Initiative.activeInitiatives.add(i);
		Initiative.sortInitiatives(Initiative.pendingInitiatives);
		Initiative.sortInitiatives(Initiative.activeInitiatives);
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	public static void rejectInitiative(Initiative i) {
		if (Initiative.pendingInitiatives.indexOf(i)>=0) {
		Initiative.pendingInitiatives.remove(Initiative.pendingInitiatives.indexOf(i));
		}
		i=null;
		Initiative.sortInitiatives(Initiative.pendingInitiatives);
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	public static void removeUser(User u) {
		removeInitiative(u.getInitiative1());
		removeInitiative(u.getInitiative2());
		User.users.remove(User.users.indexOf(u));
		u=null;
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	public static void removeInitiative(Initiative i) {
		if (Initiative.activeInitiatives.indexOf(i)>=0) {
		Initiative.activeInitiatives.remove(Initiative.activeInitiatives.indexOf(i));
		}
		i=null;
		Initiative.sortInitiatives(Initiative.activeInitiatives);
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	
}
