import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Initiative {
	private String id,name,description,status;
	private int credit,time;
	private List<User> volunteers = new ArrayList<User>();
	private User initiator;
	private LocalDateTime date;
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	static List<Initiative> pendingInitiatives = new ArrayList<Initiative>();
	static List<Initiative> activeInitiatives = new ArrayList<Initiative>();
	static List<Initiative> expiredInitiatives = new ArrayList<Initiative>();

	
	public Initiative() {
		setId(createID());
		setName("1");
		setDate("11/11/1111 11:11:11");
		setDescription("111");
		setStatus("pending");
		setTime(2);
		setInitiator(new User());
		pendingInitiatives.add(this);
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	public Initiative(User u) {
		setId(createID());
		setName("1");
		setDate("11/11/1111 11:11:11");
		setDescription("111");
		setStatus("pending");
		setTime(2);
		setCredit(10);
		setInitiator(u);
		pendingInitiatives.add(this);
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	public Initiative(String name, String date, String description, int credit, int time, User initiator) {
		setId(createID());
		setName(name);
		setDate(date);
		setDescription(description);
		setStatus("pending");
		setTime(time);
		setInitiator(initiator);
		setCredit(credit);
		pendingInitiatives.add(this);
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	public Initiative(String id,String name, String date, String status, String description, int credit, int time, User initiator) {
		setId(id);
		setName(name);
		setDate(date);
		setDescription(description);
		setStatus(status);
		setTime(time);
		setInitiator(initiator);
		User.saveUsers();
		Initiative.saveInitiatives();
	}
	public Initiative(Scanner fin) {
		readFromLine(fin.nextLine());
	}
	
	public String toString() {
		String s = String.format("%s\t%s\t%s\t%s\t[ %s ]\t%d\t%s\t",id, name, time, status, description, credit, getDateAsString(),initiator.getId());
		for(User x:volunteers) {
			s+=x.getId() + "/t";
		}
		s+="\n";
		return s;
	}
	
	
	public static void saveInitiatives() {
		try {
			PrintWriter fout1 = new PrintWriter("pendingInitiatives.txt");
			String s1 = "";
			for (Initiative p:pendingInitiatives) {
				s1+=p.toString();
			}	
			fout1.print(s1);
			fout1.close();
			
			PrintWriter fout2 = new PrintWriter("activeInitiatives.txt");
			String s2 = "";
			for (Initiative p:activeInitiatives) {
				s2+=p.toString();
			}
			fout2.print(s2);
			fout2.close();
			
			PrintWriter fout3 = new PrintWriter("expiredInitiatives.txt");
			String s3 = "";
			for (Initiative p:expiredInitiatives) {
				s3+=p.toString();
			}
			fout3.print(s3);
			fout3.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void readInitiatives() {
		try {
			Scanner fin1 = new Scanner(new FileReader("pendingInitiatives.txt"));
			Scanner fin2 = new Scanner(new FileReader("activeInitiatives.txt"));
			Scanner fin3 = new Scanner(new FileReader("expiredInitiatives.txt"));
			while(fin1.hasNextLine()) {
				pendingInitiatives.add(new Initiative(fin1));
			}
			while(fin2.hasNextLine()) {
				pendingInitiatives.add(new Initiative(fin2));
			}
			while(fin3.hasNextLine()) {
				pendingInitiatives.add(new Initiative(fin3));
			}
			fin1.close();
			fin2.close();
			fin3.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void readFromLine(String line) {
		Scanner fin = new Scanner(line);
		setId(fin.next());
		setName(fin.next());
		setStatus(fin.next());
		String description = fin.next();
		description = "";
		while(true) {
			if(fin.next().equals("]")) {
				break;
			}else {
				description += fin.next();
			}
		}
		setDescription(description);
		setCredit(fin.nextInt());
		setDate(fin.next());
		setInitiator(User.searchForUser(fin.next()));
		while(fin.hasNext()) {
			volunteers.add(User.searchForUser(fin.next()));
		}
		fin.close();
	}
	
	public static Initiative searchForInitiative(List<Initiative> i,String id) {
		sortInitiatives(i);
		int low = 0;
		int high = i.size()-1;
		
		while(low<=high) {
			int middle = (low + high) / 2;
			String idSearch = i.get(middle).id;
			if(id.equals(idSearch)) {
				return i.get(middle);
			} else if(id.compareTo(idSearch)<0) {
				high = middle-1;
			} else if(id.compareTo(idSearch)>0) {
				low = middle+1;
			} else if(!id.equals(idSearch) && low==high) {
				break;
			}
		}
		return null;
	}

	public void checkTime() {
		if(LocalDateTime.now().compareTo((date.plusHours(time))) > 0) {
			setStatus("expired");
			activeInitiatives.remove(activeInitiatives.indexOf(this));
			expiredInitiatives.add(this);
		}
	}

	public static void sortInitiatives(List<Initiative> k) {
		Initiative temp;
		if(k.size()>1) {
			for(int i = 0;i<k.size();i++) {
				for(int j = 1;j<(k.size()-i);j++){
					if(k.get(j-1).id.compareTo(k.get(j).id) > 0) {
						temp = k.get(j-1);
						k.set(j-1,k.get(j));
						k.set(j, temp);
					}
				}
			}
		}
	}
	
	
	

	
	public static String createID() {
		try {
			sortInitiatives(activeInitiatives);
			sortInitiatives(pendingInitiatives);
			sortInitiatives(expiredInitiatives);
			int newID = activeInitiatives.size()>0?Integer.parseInt(activeInitiatives.get(activeInitiatives.size()-1).id):1;
			newID = Math.max(newID,pendingInitiatives.size()>0?Integer.parseInt(pendingInitiatives.get(pendingInitiatives.size()-1).id):newID);
			newID = Math.max(newID,expiredInitiatives.size()>0?Integer.parseInt(expiredInitiatives.get(expiredInitiatives.size()-1).id):newID);
			return String.format("%10.0f", newID + 1.0f);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			return String.format("%10.0f", 1.0f);
		}
	}
	
	public int getTime() {return time;}
	public void setTime(int time) {
		if (time>0) {
			this.time = time;
		} else {
			this.time=1;
		}
	}
	public String getStatus() {return status;}
	public int getCredit() {return credit;}
	public void setCredit(int credit) {
		if (credit>=0) {
			this.credit = credit;
		} else {
			this.credit=0;
		}			
	}
			
	public String getId() {return id;}
	public void setId(String id) {
		if(!id.matches(".*[^0-9].*")) {
			if (id.length()==10) {
				this.id = id;
			} else {
				this.id = String.format("%10.0f", Float.parseFloat(id));
			}
		} else {
			createID();
		}
		}
	public String getName() {return name;}
	public void setName(String name) {
		if(!name.matches(".*[^a-zA-Z].*")) {	
			this.name = name;
		} else {
			this.name = "Volunteering #"+id;
		}
		}
	public LocalDateTime getDate() {return date;}
	public String getDateAsString() {
		return format.format(date);
	}
	public void setDate(String date) {
		this.date = LocalDateTime.parse(date,format);
	}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public List<User> getVolunteers() {return volunteers;}
	public void setVolunteers(List<User> volunteers) {this.volunteers = volunteers;}
	public User getInitiator() {return initiator;}
	public void setInitiator(User initiator) {this.initiator = initiator;}
	public void setStatus(String status) {
		if (status.equals("pending") || status.equals("active") || status.equals("expired"))
			this.status = status;
		} else {
			this.status = "pending";
		}
	

}
