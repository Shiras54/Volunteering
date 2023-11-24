public class Driver {
<<<<<<< HEAD
	public static void main(String[] args) {
		Initiative.pendingInitiatives.add(new Initiative("000","0","01/01/0001 00:00:00","pending","000",5,2,new User()));
		Initiative.activeInitiatives.add(new Initiative("000","0","01/01/0001 00:00:00","active","000",5,2,new User()));
		Initiative.expiredInitiatives.add(new Initiative("000","0","01/01/0001 00:00:00","expired","000",5,2,new User()));
		User u = new User();
		u.initiate();	
		new Page1();
=======
	public static void main(String[] args) {	
		 new Page1();
>>>>>>> branch 'master' of https://github.com/Shiras54/Volunteering.git
	}
}
