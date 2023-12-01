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
	public static User loggedIn;

	
	public User() {
		setName("abc");
		setDob("12/12/2012");
		setEmail("mm@mm.mm");
		setPhone("0000000");
		setAddress("asdasd");
		setPassword("123");
		setId(createID());
		users.add(this);
		User.saveUsers();
		User.linkInitiatives();
	}
	
	public User(String line) {
		this.readFromLine(line);
		
	}
	
	public User(String name, String dob, String email, String phone, String address, String password) {
		setName(name);
		setDob(dob);
		setEmail(email);
		setPhone(phone);
		setAddress(address);
		setPassword(password);
		setId(createID());
		users.add(this);
		User.saveUsers();
		User.linkInitiatives();
	}
	
	public String toString() {
			String data = String.format("%s\t%s\t%s\t%s\t[ %s ]\t%s\t%d\t%s\t%s\t%s",name, id, email, phone, address, password, points, getDobAsString(),((initiative1!=null)?initiative1.getId():"null"),((initiative2!=null)?initiative2.getId():"null"));
			for(Initiative x:volunteeringJobs) {
				data+="\t"+x.getId();
			}
			data+="\n";
			return data;
	}
	
	public static boolean logIn(String name,String pass) {
		User u = searchForUsername(name.trim());
		if(u!=null && u.getPassword().trim().equals(pass)) {
			loggedIn = u;
			return true;
		}
		return false;
	}
	
	public void readFromLine(String line) {
		Scanner fin = new Scanner(line);
		setName(fin.next()); 
		setId(fin.next());
		setEmail(fin.next());
		setPhone(fin.next());
		String address = fin.next();
		address = "";
		while(true) {
			String text = fin.next();
			if(text.trim().equals("]")) {
				break;
			}else {
				address += text;
			}
		}
		setAddress(address);
		setPassword(fin.next());
		setPoints(fin.nextInt());
		setDob(fin.next());
		fin.close();
	}
	
	public static void linkInitiatives() {
		try {
			Scanner fin = new Scanner(new FileReader("Users.txt"));
			for(int i = 0;i<users.size();i++) {
				Scanner line = new Scanner(fin.nextLine());
				line.next();
				String id = line.next();
				int index = users.indexOf(searchForUser(id.trim()));
				line.next();
				line.next();
				while(true) {
					String text = line.next();
					if(text.trim().equals("]")) {
						break;
					}
				}
				line.next();
				line.next();
				line.next();
				String tempId = line.next().trim();
				if(!tempId.equals("null")) {
					Initiative i1 = Initiative.searchForInitiative(Initiative.activeInitiatives,tempId);
					if (i1==null) {
						i1 = Initiative.searchForInitiative(Initiative.pendingInitiatives,tempId);
					}
					if (i1==null) {
						i1 = Initiative.searchForInitiative(Initiative.expiredInitiatives,tempId);
					}
					users.get(index).setInitiative1(i1);
				} else {
					users.get(index).setInitiative1(null);
					}
				String tempId2 = line.next().trim();
				if(!tempId.equals("null")) {
					Initiative i2 = Initiative.searchForInitiative(Initiative.activeInitiatives,tempId2);
					if (i2==null) {
						i2 = Initiative.searchForInitiative(Initiative.pendingInitiatives,tempId2);
					}
					if (i2==null) {
						i2 = Initiative.searchForInitiative(Initiative.expiredInitiatives,tempId2);
					}
					users.get(index).setInitiative2(i2);
				} else {
					users.get(index).setInitiative2(null);
					}
				while(line.hasNext()) {
					String tempId3 = line.next().trim();
					Initiative k = Initiative.searchForInitiative(Initiative.activeInitiatives,tempId3);
					if (k==null) {
						
						k = Initiative.searchForInitiative(Initiative.pendingInitiatives,tempId3);
					}
					if (k==null) {
						k = Initiative.searchForInitiative(Initiative.expiredInitiatives,tempId3);
					}
					if(k!=null)
						users.get(index).volunteeringJobs.add(k);
				}
				line.close();
			}
			
			fin.close();
		} catch(FileNotFoundException e) {
			
		}
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
		if(users.size()>1) {
			for(int i = 0;i<users.size();i++) {
				for(int j = 1;j<(users.size()-i);j++){
					if(users.get(j-1).id == null)
						try {
							users.get(j-1).id = String.format("%10.0f",Float.parseFloat(users.get(users.size()-1).id.trim()+1));
						}	catch(NullPointerException e) {
							e.printStackTrace();
							users.get(j-1).id = String.format("%10.0f",(float)(users.get(j-1).name.hashCode()));
						}
					if(users.get(j).id == null)
						try {
							users.get(j).id = String.format("%10.0f",Float.parseFloat(users.get(users.size()-1).id.trim()+1));
						} catch(NullPointerException e) {
							e.printStackTrace();
							users.get(j).id = String.format("%10.0f",(float)(Math.abs(users.get(j).name.hashCode())));
						}
					if(users.get(j-1).id.compareTo(users.get(j).id) > 0) {
						temp = users.get(j-1);
						users.set(j-1,users.get(j));
						users.set(j, temp);
					} else if(users.get(j-1).id.compareTo(users.get(j).id) == 0) {
						users.get(j).id = String.format("%10.0f",Float.parseFloat(users.get(users.size()-1).id.trim()+1));
					}
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
			int middle = low + (high-low) / 2;
			String idSearch = users.get(middle).id.trim();
			if(id.equals(idSearch.trim())) {
				return users.get(middle);
			} else if(id.compareTo(idSearch.trim())<0) {
				high = middle-1;
			} else if(id.compareTo(idSearch.trim())>0) {
				low = middle+1;
			} else if(!id.equals(idSearch.trim()) && low>=high) {
				break;
			}
		}
		return null;
	}
	
	public static User searchForUsername(String name) {
		for(User u: users) {
			if(u.name.equals(name)) {
				return u;
			}
		}
		return null;
	}
	
	public void initiate(String name, String date, String description, int credit, int time) {
		if(initiative1==null || initiative2 == null) {
			if(initiative1==null) {
				initiative1 = new Initiative(name,date,description,credit,time,this);
			} else if (initiative2 == null) {
				initiative2 = new Initiative(name,date,description,credit,time,this);
			}
		} else if(initiative1.getStatus() == "expired" || initiative2.getStatus() == "expired") {
			if(initiative1.getStatus() == "expired") {
				Initiative.checkTime();
				initiative1 = new Initiative(name,date,description,credit,time,this);
			} else if (initiative2.getStatus() == "expired") {
				Initiative.checkTime();
				initiative2 = new Initiative(name,date,description,credit,time,this);
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(),"You do not have a free initiative. You can remove an active ");
		}
		saveUsers();
		Initiative.saveInitiatives();
		
	}
	
	public void changeInitiative1(String name,String date,String time,String credit,String description) {
		if(!name.equals("")) {
			initiative1.setName(name);}
		if(!date.equals("__/__/____ __:__:__")) {
			initiative1.setDate(date);}
		if(!time.equals("")) {
			initiative1.setTime(Integer.parseInt(time));}
		if(!credit.equals("")) {
			initiative1.setCredit(Integer.parseInt(credit));}
		if(!description.equals("")) {
			initiative1.setDescription(description);}
		Initiative.saveInitiatives();
	}
	
	public void changeInitiative2(String name,String date,String time,String credit,String description) {
		if(!name.equals("")) {
			initiative2.setName(name);}
		if(!date.equals("__/__/____ __:__:__")) {
			initiative2.setDate(date);}
		if(!time.equals("")) {
			initiative2.setTime(Integer.parseInt(time));}
		if(!credit.equals("")) {
			initiative2.setCredit(Integer.parseInt(credit));}
		if(!description.equals("")) {
			initiative2.setDescription(description);}
		Initiative.saveInitiatives();
	}
	
	public void changeInfo(String name,String dob,String email,String phone,String address,String password) {
		if(!name.equals("")) {
			setName(name);}
		if(!dob.equals("__/__/____")) {
			setDob(dob);}
		if(!email.equals("")) {
			setEmail(email);}
		if(!phone.equals("")) {
			setPhone(phone);}
		if(!address.equals("")) {
			setAddress(address);}
		if(!password.equals("")) {
			setPassword(password);}
		saveUsers();
	}
	
	
	public void volunteer(Initiative i) {
		if(!volunteeringJobs.contains(i)){
			volunteeringJobs.add(i);
			points+=i.getCredit();
			i.getVolunteers().add(this);
			saveUsers();
			Initiative.saveInitiatives();
		}
	}
	public void withdraw(Initiative i) {
		boolean found = false;
		for(int j = 0;j<volunteeringJobs.size();j++) {
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
			return String.format("%.0f", (Float.parseFloat(users.get(users.size()-1).id) + 1.0f));
		} else {
			return String.format("%.0f",1.0f);
		}
	}
	
	public String getId() {return id;}
	public void setId(String id) {
		if(id.trim().matches("\\d+")) {
			this.id = id;
		} else {
			String.format("%.0f",(float)(name.hashCode()));
		}
	}
	public String getName() {return name;}
	public void setName(String name) {
		if(name.matches("[a-zA-Z]+")) {	
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
		if(phone.matches("\\d+")) {
			this.phone = phone;
		}  else {
			this.phone = "0555555555";
		}
	}
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
	public Initiative getInitiative2() {return initiative2;}
	public void setInitiative2(Initiative initiative) {
		this.initiative2 = initiative;
		}
	public List<Initiative> getVolunteeringJobs() {return volunteeringJobs;}
	public void setVolunteeringJobs(List<Initiative> volunteeringJobs) {this.volunteeringJobs = volunteeringJobs;}
	public int getPoints() {return points;}
	public void setPoints(int points) {this.points=points;}
}
	
