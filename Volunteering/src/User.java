import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;

public class User {
	private String id, name, email, phone, address, password;
	private List<Initiative> volunteeringJobs = new ArrayList<Initiative>();
	private Initiative initiative1,initiative2;
	private int points;
	private Date dob;
	private DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	static List<User> users = new ArrayList<User>();
	
	public User() {
		setId(createID());
		setName("abc");
		setDob("12/12/2012");
		setEmail("mm@mm.mm");
		setPhone("0000000");
		setAddress("asdasd");
		setPassword("123");
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	
	public User(String line) {
		this.readFromLine(line);
		
	}
	
	public User(String name, String dob, String email, String phone, String address, String password) {
		setId(createID());
		setName(name);
		setDob(dob);
		setEmail(email);
		setPhone(phone);
		setAddress(address);
		setPassword(password);
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	
	public String toString() {
			String data = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%d\t%s\t%s\t%s",id, name, email, phone, address, password, points, getDobAsString(),initiative1!=null?initiative1.getId():"null",initiative2!=null?initiative2.getId():"null");
			for(Initiative x:volunteeringJobs) {
				data+=x.getId() + "\t";
			}
			data+="\n";
			return data;
	}
	
	public void readFromLine(String line) {
		Scanner fin = new Scanner(line);
		setId(fin.next());
		setName(fin.next());
		setEmail(fin.next());
		setPhone(fin.next());
		setAddress(fin.next());
		setPassword(fin.next());
		setPoints(fin.nextInt());
		setDob(fin.next());
		String tempId = fin.next();
		if(!tempId.equals("null")) {
			Initiative i1 = Initiative.searchForInitiative(Initiative.activeInitiatives,tempId);
			if (i1==null) {
				i1 = Initiative.searchForInitiative(Initiative.pendingInitiatives,tempId);
			}
			if (i1==null) {
				i1 = Initiative.searchForInitiative(Initiative.expiredInitiatives,tempId);
			}
			setInitiative1(i1);
		} else {setInitiative1(null);}
		String tempId2 = fin.next();
		if(!tempId.equals("null")) {
			Initiative i2 = Initiative.searchForInitiative(Initiative.activeInitiatives,tempId2);
			if (i2==null) {
				i2 = Initiative.searchForInitiative(Initiative.pendingInitiatives,tempId2);
			}
			if (i2==null) {
				i2 = Initiative.searchForInitiative(Initiative.expiredInitiatives,tempId2);
			}
			setInitiative1(i2);
		} else {setInitiative2(null);}
		while(fin.hasNext()) {
			String tempId3 = fin.next();
			Initiative i = Initiative.searchForInitiative(Initiative.activeInitiatives,tempId3);
			if (i==null) {
				
				i = Initiative.searchForInitiative(Initiative.pendingInitiatives,tempId3);
			}
			if (i==null) {
				i = Initiative.searchForInitiative(Initiative.expiredInitiatives,tempId3);
			}
			volunteeringJobs.add(i);
		}
		fin.close();
	}
	
	public static void readUsers() {
		try {
			Scanner fin1 = new Scanner(new FileReader("Users.txt"));
			while(fin1.hasNextLine()) {
				users.add(new User(fin1.nextLine()));
			}
			fin1.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void sortUsers() {
		User temp;
		for(int i = 0;i<users.size();i++) {
			for(int j = 1;j<(users.size()-i);j++){
				if(users.get(j-1).id.compareTo(users.get(j).id) > 0) {
					temp = users.get(j-1);
					users.set(j-1,users.get(j));
					users.set(j, temp);
				}
			}
		}
	}
	
	public static void saveUsers() {
		try {
			PrintWriter fout1 = new PrintWriter("Users.txt");
			String s = "";
			for (User u:users) {
				s+=u.toString();
			}
			fout1.print(s);
			fout1.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static User searchForUser(String id) {
		sortUsers();
		int low = 0;
		int high = users.size()-1;
		
		while(low<=high) {
			int middle = (low + high) / 2;
			String idSearch = users.get(middle).id;
			if(id.equals(idSearch)) {
				return users.get(middle);
			} else if(id.compareTo(idSearch)<0) {
				high = middle-1;
			} else if(id.compareTo(idSearch)>0) {
				low = middle+1;
			}
		}
		return null;
	}
	
	public void initiate() {
		if(initiative1==null || initiative2 == null) {
			if(initiative1==null) {
				initiative1 = new Initiative(this);
			} else if (initiative2 == null) {
				initiative2 = new Initiative(this);
			}
		} else if(initiative1.getStatus() == "expired" || initiative2.getStatus() == "expired") {
			if(initiative1.getStatus() == "expired") {
				initiative1 = new Initiative(this);
			} else if (initiative2.getStatus() == "expired") {
				initiative2 = new Initiative(this);
			}
		} else {
			//temporary
			JOptionPane.showMessageDialog(new JFrame(),"You do not have a free initiative. Do you want to delete one?");
		}
		saveUsers();
		Initiative.saveInitiatives();
		
	}
	public void volunteer(Initiative i) {
		volunteeringJobs.add(i);
		points+=i.getCredit();
		saveUsers();
		Initiative.saveInitiatives();
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
			JOptionPane.showMessageDialog(new JFrame(),"You did not volunteer in this initiative."); 
		}
		saveUsers();
		Initiative.saveInitiatives();
	}
	public void terminate(Initiative i) {
		if(i.equals(initiative1)) {
			initiative1 = null;
		} else if (i.equals(initiative1)) {
			initiative2 = null;
		} else {
			JOptionPane.showMessageDialog(new JFrame(),"This is not your initiative.");
		}
		saveUsers();
		Initiative.saveInitiatives();
	}
	
	public static String createID() {
		User.sortUsers();
		if (users.size()>0) {
			return String.format("%10.0f", (float)(Integer.parseInt(users.get(users.size()-1).id) + 1));
		} else {
			return String.format("%10.0f",1.0f);
		}
	}
	
	public String getId() {return id;}
	public void setId(String id) {
		if(!id.matches(".*[^0-9].*")) {
			this.id = id;
		}
	}
	public String getName() {return name;}
	public void setName(String name) {
		if(!name.matches(".*[^a-zA-Z].*")) {	
			this.name = name;
		} else {
			this.name = "John Smith";
		}
	}	
	public Date getDob() {return dob;}
	public String getDobAsString() {
		return format.format(dob);
	}
	public void setDob(String dob) {
		try {
			this.dob = format.parse(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getEmail() {return email;}
	public void setEmail(String email) {
		if(email.contains("@")&&email.contains(".")) {
			this.email = email;
		} else {
			this.email = "email@ku.ac.ae";
		}
	}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {
		if(!phone.matches(".*[a-z].*")) {
			this.phone = phone;
		}  else {
			this.phone = "+971555555555";
		}
	}
	public String getAddress() {return address;}
	public void setAddress(String address) {
		this.address = address;
		}
	public String getPassword() {return password;}
	public void setPassword(String password) {
		if(password.length()>8 && password.length()<20) {
			this.password = password;
		} else {
			this.password = "password";
		}
	}
	public Initiative getInitiative1() {return initiative1;}
	public void setInitiative1(Initiative initiative) {
		this.initiative1 = initiative;
		}
	public Initiative getInitiative2() {return initiative2;}
	public void setInitiative2(Initiative initiative) {
		this.initiative2 = initiative;
		}
	public List<Initiative> getVolunteeringJobs() {return volunteeringJobs;}
	public void setVolunteeringJobs(List<Initiative> volunteeringJobs) {this.volunteeringJobs = volunteeringJobs;}
	public int getPoints() {return points;}
	public void setPoints(int points) {this.points=points;}
}
	
