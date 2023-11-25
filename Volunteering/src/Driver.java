public class Driver {
	public static void main(String[] args) {
		Initiative.pendingInitiatives.add(new Initiative(Initiative.createID(),"Recycle","01/01/0001 00:00:00","pending","000",5,2,new User()));
		Initiative.pendingInitiatives.add(new Initiative(Initiative.createID(),"Rebuild","01/01/0001 00:00:00","pending","000",5,2,new User()));
		Initiative.activeInitiatives.add(new Initiative(Initiative.createID(),"Reuse","01/01/0001 00:00:00","active","000",5,2,new User()));
		Initiative.expiredInitiatives.add(new Initiative(Initiative.createID(),"Helpline","01/01/0001 00:00:00","expired","000",5,2,new User()));
		User u = new User();
		u.initiate();
		System.out.print(u);
		System.out.print("\n----\n");
		new adminP1();
		for(Initiative i: Initiative.activeInitiatives) {
			System.out.print(i);
		}
		System.out.print("\n----\n");
		for(Initiative i: Initiative.pendingInitiatives) {
			System.out.print(i);
		}
		System.out.print("\n----\n");
		for(Initiative i: Initiative.expiredInitiatives) {
			System.out.print(i);
		}
		System.out.print("\n------\n");
	}
}
