public class Driver {
	public static void main(String[] args) {
    	User.readUsers();
    	Initiative.readInitiatives();
    	Initiative.linkUsers();
    	User.linkInitiatives();  
		new Page1();
	}
}
