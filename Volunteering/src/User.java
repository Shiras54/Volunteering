
public class User {
	private String id, name, dob, email, phone, address, password;
	private Initiative[] volunteeringJobs;
	private Initiative initiative;
	
	public User() {
		
	}
	
	public User(String name, String dob, String email, String phone, String address, String password) {
		setId();
		setName(name);
		setDob(dob);
		setEmail(email);
		setPhone(phone);
		setAddress(address);
		setPassword(password);
	}
	public void initiate() {
		
	}
	public void volunteer() {
		
	}
	
	public String getId() {return id;}
	public void setId() {this.id = "";}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getDob() {return dob;}
	public void setDob(String dob) {this.dob = dob;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public Initiative getInitiative() {return initiative;}
	public void setInitiative(Initiative initiative) {this.initiative = initiative;}
	public Initiative[] getVolunteeringJobs() {return volunteeringJobs;}
	public void setVolunteeringJobs(Initiative[] volunteeringJobs) {this.volunteeringJobs = volunteeringJobs;}
	
}
