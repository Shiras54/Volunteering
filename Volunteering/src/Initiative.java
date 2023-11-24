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
		setName("1");
		setDate("11/11/1111 11:11:11");
		setDescription("111");
		setStatus("pending");
		pendingInitiatives.add(this);
	}
	public Initiative(String name, String date, String description, String status, int credit, int time, List<User> volunteer, User initiator) {
		setName(name);
		setDate(date);
		setDescription(description);
		setStatus("pending");
		setTime(time);
		pendingInitiatives.add(this);
	}
	public Initiative(Scanner fin) {
		readFromLine(fin.nextLine());
	}
	
	public String toString(String file) {
		String s = String.format("%s %s %s %s [%s] %d %s ",id, name, time, status, description, credit, getDateAsString(),initiator.getId());
		for(User x:volunteers) {
			s+=x.getId() + " ";
		}
		s+="\n";
		return s;
	}
	
	public static void saveInitiatives() {
		try {
			PrintWriter fout1 = new PrintWriter("pendingInitiatives.txt");
			PrintWriter fout2 = new PrintWriter("activeInitiatives.txt");
			PrintWriter fout3 = new PrintWriter("expiredInitiatives.txt");
			String s1 = "";
			String s2 = "";
			String s3 = "";
			for (Initiative p:pendingInitiatives) {
				s1+=p;
			}			
			for (Initiative p:activeInitiatives) {
				s2+=p;
			}			
			for (Initiative p:expiredInitiatives) {
				s3+=p;
			}
			fout1.print(s1);
			fout2.print(s2);
			fout3.print(s3);
			fout1.close();
			fout2.close();
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
		setDescription(fin.next());
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

	
	public String createID() {
		sortInitiatives(activeInitiatives);
		sortInitiatives(pendingInitiatives);
		sortInitiatives(expiredInitiatives);
		int newID = Integer.parseInt(activeInitiatives.get(activeInitiatives.size()-1).id);
		newID = Math.max(newID,Integer.parseInt(pendingInitiatives.get(pendingInitiatives.size()-1).id));
		newID = Math.max(newID,Integer.parseInt(expiredInitiatives.get(expiredInitiatives.size()-1).id));
		return String.format("%10.0f", newID + 1);
	}
	
	public int getTime() {return time;}
	public void setTime(int time) {this.time = time;}
	public String getStatus() {return status;}
	public int getCredit() {return credit;}
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
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
	public void setStatus(String status) {this.status = status;}
	public void setCredit(int credit) {this.credit = credit;}
	
}
