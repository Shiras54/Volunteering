public class Driver {
	public static void main(String[] args) {
		Initiative.pendingInitiatives.add(new Initiative("000","a","01/01/0001 00:00:00","pending","000",5,2,new User()));
		Initiative.activeInitiatives.add(new Initiative("000","b","01/01/0001 00:00:00","active","000",5,2,new User()));
		Initiative.expiredInitiatives.add(new Initiative("000","c","01/01/0001 00:00:00","expired","000",5,2,new User()));
		User u = new User();
		u.initiate();
		new adminP2();
	}
}
