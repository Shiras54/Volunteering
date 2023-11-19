import java.util.*;
import java.text.*;

public class User {
	private String id, name, email, phone, address, password;
	private List<Initiative> volunteeringJobs = new ArrayList<Initiative>();
	private Initiative initiative1,initiative2;
	private int points;
	private Date dob;
	private static int idCounter;
	
	public User() {
		
	}
	
	public User(String name, String dob, String email, String phone, String address, String password) {
		createID();
		setName(name);
		setDob(dob);
		setEmail(email);
		setPhone(phone);
		setAddress(address);
		setPassword(password);
	}
	public void initiate() {
		if(initiative1==null || initiative2 == null) {
			if(initiative1==null) {
				initiative1 = new Initiative();
			} else if (initiative2 == null) {
				initiative2 = new Initiative();
			}
		} else if(initiative1.getStatus() == "expired" || initiative2.getStatus() == "expired") {
			if(initiative1.getStatus() == "expired") {
				initiative1 = new Initiative();
			} else if (initiative2.getStatus() == "expired") {
				initiative2 = new Initiative();
			}
		} else {
			System.out.print("Initiatives are not complete, do");
		}
		
	}
	public void volunteer(Initiative i) {
		volunteeringJobs.add(i);
		points+=i.getCredit();
	}
	public void withdraw(Initiative i) {
		boolean found = false;
		for(int j = 0;j<=volunteeringJobs.size();j++) {
			if(volunteeringJobs.get(j).equals(i)) {
				found = true;
			}
		}
		if(found) {
		volunteeringJobs.remove(volunteeringJobs.indexOf(i));
		points-=i.getCredit();
		} else {
			System.out.print("Isn't in list");
		}
	}
	public void terminate(Initiative i) {
		if(i.equals(initiative1)) {
			initiative1 = null;
		} else if (i.equals(initiative1)) {
			initiative2 = null;
		} else {
			System.out.print("not your initiative");
		}
	}
	
	public void createID() {
		idCounter++;
		this.id = String.format("%10.0f", idCounter);
	}
	
	public String getId() {return id;}
	public void setId(String id) {
		this.id = id;
		}
	public String getName() {return name;}
	public void setName(String name) {
		if(name.contains("")) {	
			this.name = name;
		}
	}	
	public Date getDob() {return dob;}
	public void setDob(String dob) {
		try {
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			this.dob = format.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getEmail() {return email;}
	public void setEmail(String email) {
		if(email.contains("@")&&email.contains(".")) {
			this.email = email;
		}
	}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getAddress() {return address;}
	public void setAddress(String address) {
		this.address = address;
		}
	public String getPassword() {return password;}
	public void setPassword(String password) {
		this.password = password;
		}
	public Initiative getInitiative1() {return initiative1;}
	public void setInitiative1(Initiative initiative) {
		this.initiative1 = initiative;
		}
	public List<Initiative> getVolunteeringJobs() {return volunteeringJobs;}
	public void setVolunteeringJobs(List<Initiative> volunteeringJobs) {this.volunteeringJobs = volunteeringJobs;}
	public int getPoints() {return points;}
	public void setPoints(int points) {this.points=points;}
}
	
