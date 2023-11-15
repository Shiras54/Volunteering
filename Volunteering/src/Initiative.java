import java.util.*;

public class Initiative {
	private String id,name,date,time,description,status;
	private int credit;
	private List<User> volunteers = new ArrayList<User>();
	private User initiator;
	
	public Initiative() {}
	public Initiative(String name, String date, String time, String description, String status, int credit,
			User volunteer, User initiator) {
		setName(name);
		setDate(date);
		setTime(time);
		setDescription(description);
		setStatus("pending");
		
	}



	public String getStatus() {return status;}
	public int getCredit() {return credit;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	public String getTime() {return time;}
	public void setTime(String time) {this.time = time;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public List<User> getVolunteers() {return volunteers;}
	public void setVolunteers(List<User> volunteers) {this.volunteers = volunteers;}
	public User getInitiator() {return initiator;}
	public void setInitiator(User initiator) {this.initiator = initiator;}
	public void setStatus(String status) {this.status = status;}
	public void setCredit(int credit) {this.credit = credit;}
	
}
