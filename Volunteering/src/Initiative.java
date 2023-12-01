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
	static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	static List<Initiative> pendingInitiatives = new ArrayList<Initiative>();
	static List<Initiative> activeInitiatives = new ArrayList<Initiative>();
	static List<Initiative> expiredInitiatives = new ArrayList<Initiative>();

	
	
	public Initiative() {
		setName("abcc");
		setDate("11/11/1111 11:11:11");
		setDescription("111");
		setStatus("pending");
		setTime(2);
		setCredit(10);
		setInitiator(new User());
		setId(createID());
		pendingInitiatives.add(this);
		Initiative.saveInitiatives();
	}
	public Initiative(User u) {
		setName("abcc");
		setDate("11/11/1111 11:11:11");
		setDescription("111");
		setStatus("pending");
		setTime(2);
		setCredit(10);
		setInitiator(u);
		setId(createID());
		pendingInitiatives.add(this);
		Initiative.saveInitiatives();
	}
	public Initiative(String name, String date, String description, int credit, int time, User initiator) {
		setName(name);
		setDate(date);
		setDescription(description);
		setStatus("pending");
		setTime(time);
		setInitiator(initiator);
		setCredit(credit);
		setId(createID());
		pendingInitiatives.add(this);
		Initiative.saveInitiatives();
	}
	public Initiative(String id,String name, String date, String status, String description, int credit, int time, User initiator) {
		setName(name);
		setId(id);
		setDate(date);
		setDescription(description);
		setStatus(status);
		setTime(time);
		setInitiator(initiator);
		Initiative.saveInitiatives();
	}
	public Initiative(String line) {
		readFromLine(line);
	}
	
	public String toString() {
		String s = String.format("%s\t%s\t%d\t%s\t[ %s ]\t%d\t%s\t%s",name,((id==null)?createID():id), time, status, description, credit,getDateAsString(),initiator.getId().trim());
		for(User x:volunteers) {
			s+="\t"+x.getId();
		}
		s+="\n";
		return s;
	}
	
	public void removeVolunteer(User v) {
		if(volunteers.contains(v)) {
			v.setPoints(v.getPoints()-credit);
			volunteers.remove(volunteers.indexOf(v));
			v.getVolunteeringJobs().remove(v.getVolunteeringJobs().indexOf(this));
			User.saveUsers();
			saveInitiatives();
		}
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
			while(fin1.hasNextLine()) {
				String line = fin1.nextLine();
				pendingInitiatives.add(new Initiative(line));
			}
			fin1.close();
			Scanner fin2 = new Scanner(new FileReader("activeInitiatives.txt"));
			while(fin2.hasNextLine()) {
				activeInitiatives.add(new Initiative(fin2.nextLine()));
			}
			fin2.close();
			Scanner fin3 = new Scanner(new FileReader("expiredInitiatives.txt"));
			while(fin3.hasNextLine()) {
				expiredInitiatives.add(new Initiative(fin3.nextLine()));
			}
			fin3.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void readFromLine(String line) {
		Scanner fin = new Scanner(line);
		setName(fin.next());
		setId(fin.next());
		setTime(fin.nextInt());
		setStatus(fin.next());
		String description = fin.next();
		description = "";
		while(true) {
			String text = fin.next();
			if(text.trim().equals("]")) {
				break;
			}else {
				description += text;
			}
		}
		setDescription(description);
		setCredit(fin.nextInt());
		setDate(fin.next()+" "+fin.next());
		fin.close();
	}
	public static void linkUsers() {
		try {
			Scanner fin11 = new Scanner(new FileReader("pendingInitiatives.txt"));
			for(int j = 0;j<pendingInitiatives.size();j++) {
				Scanner fin1 = new Scanner(fin11.nextLine());
				fin1.next();
				String id = fin1.next();
				int index = pendingInitiatives.indexOf(searchForInitiative(pendingInitiatives,id));
				while(fin1.hasNext()) {
					String text = fin1.next();
					if(text.trim().equals("]")) {
						break;
					}else {
						continue;
					}
				}
				fin1.next();
				fin1.next();
				fin1.next();
				pendingInitiatives.get(index).setInitiator(User.searchForUser(fin1.next().trim()));
				while(fin1.hasNext()) {
					pendingInitiatives.get(index).volunteers.add(User.searchForUser(fin1.next()));
				}
				fin1.close();
			}
			fin11.close();
			
			Scanner fin22 = new Scanner(new FileReader("activeInitiatives.txt"));
			for(int j = 0;j<activeInitiatives.size();j++) {
				Scanner fin2 = new Scanner(fin22.nextLine());
				fin2.next();
				int index = activeInitiatives.indexOf(searchForInitiative(activeInitiatives,fin2.next()));
				while(fin2.hasNext()) {
					String text = fin2.next();
					if(text.trim().equals("]")) {
						break;
					}else {
						continue;
					}
				}
				fin2.next();
				fin2.next();
				fin2.next();
				activeInitiatives.get(index).setInitiator(User.searchForUser(fin2.next()));
				while(fin2.hasNext()) {
					activeInitiatives.get(index).volunteers.add(User.searchForUser(fin2.next()));
				}
				fin2.close();
			}
			fin22.close();
			
			Scanner fin33 = new Scanner(new FileReader("expiredInitiatives.txt"));
			for(int j = 0;j<expiredInitiatives.size();j++) {
				Scanner fin3 = new Scanner(fin33.nextLine());
				fin3.next();
				int index = expiredInitiatives.indexOf(searchForInitiative(expiredInitiatives,fin3.next()));
				while(fin3.hasNext()) {
					String text = fin3.next();
					if(text.trim().equals("]")) {
						break;
					}else {
						continue;
					}
				}
				fin3.next();
				fin3.next();
				fin3.next();
				expiredInitiatives.get(index).setInitiator(User.searchForUser(fin3.next()));
				while(fin3.hasNext()) {
					expiredInitiatives.get(index).volunteers.add(User.searchForUser(fin3.next()));
				}
				fin3.close();
			}
			fin33.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Initiative searchForInitiative(List<Initiative> i,String id) {
		sortInitiatives(i);
		int low = 0;
		int high = i.size()-1;
		id=id.trim();
		while(low<=high) {
			int middle = low + (high-low) / 2;
			String idSearch = i.get(middle).id.trim();
			if(id.equals(idSearch.trim())) {
				return i.get(middle);
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


	
	public static void checkTime() {
		List<String> s = new ArrayList<String>();
		for(Initiative i: activeInitiatives) {
			if(LocalDateTime.now().compareTo((i.date.plusHours(i.time))) >= 0) {
				s.add(i.getId());
			}
		}
		for(int i=0;i<s.size();i++) {
			Initiative j = searchForInitiative(activeInitiatives,s.get(i));
			j.setStatus("expired");
			activeInitiatives.remove(activeInitiatives.indexOf(j));
			expiredInitiatives.add(j);
			j.getInitiator().terminate(j);
			}
	}
	
	public static String returnNow() {
		return format.format(LocalDateTime.now());
	}

	public static void sortInitiatives(List<Initiative> k) {
		Initiative temp;
		if(k.size()>1) {
			for(int i = 0;i<k.size();i++) {
				for(int j = 1;j<(k.size()-i);j++){
					if(k.get(j-1).id == null)
						try {
							k.get(j-1).id = String.format("%10.0f",Float.parseFloat(k.get(k.size()-1).id.trim())+1.0f);
						} catch(Throwable e) {
							e.printStackTrace();
							System.out.println("test");
							k.get(j-1).id = String.format("%10.0f",(float)(k.get(j-1).name.hashCode()));
						}
					if(k.get(j).id == null)
						try {
							k.get(j).id = String.format("%10.0f",Float.parseFloat(k.get(k.size()-1).id.trim())+1f);
						} catch(NullPointerException e) {
							e.printStackTrace();
							k.get(j).id = String.format("%10.0f",(float)(Math.abs(k.get(j).name.hashCode())));
						}
					if(k.get(j-1).id.compareTo(k.get(j).id) > 0) {
						temp = k.get(j-1);
						k.set(j-1,k.get(j));
						k.set(j, temp);
					} else if(k.get(j-1).id.compareTo(k.get(j).id) == 0) {
						k.get(j).id = String.format("%10.0f",Float.parseFloat(k.get(k.size()-1).id.trim())+1f);
					}
				}
			}
		}
	}
	
	
	

	
	public static String createID() {
		
			sortInitiatives(activeInitiatives);
			sortInitiatives(pendingInitiatives);
			sortInitiatives(expiredInitiatives);
			int newID = 0;
			if (activeInitiatives.size()>0) {
				if(activeInitiatives.get(activeInitiatives.size()-1).id!=null) {
					newID = Integer.parseInt(activeInitiatives.get(activeInitiatives.size()-1).id.trim());
				}
			}
			if (pendingInitiatives.size()>0) {
				if(pendingInitiatives.get(pendingInitiatives.size()-1).id!=null) {
					newID = Math.max(newID,Integer.parseInt(pendingInitiatives.get(pendingInitiatives.size()-1).id.trim()));
				}
			}
			if (expiredInitiatives.size()>0) {
				if(expiredInitiatives.get(expiredInitiatives.size()-1).id!=null) {
					newID = Math.max(newID,Integer.parseInt(expiredInitiatives.get(expiredInitiatives.size()-1).id.trim()));
				}
			}
			return String.format("%.0f", (float)(newID+1));
		
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
		if(id.matches("\\d+")) {
			if (id.length()==10) {
				this.id = id;
			} else {
				this.id = String.format("%.0f", Float.parseFloat(id));
			}
		} else {
			createID();
		}
		}
	public String getName() {return name;}
	public void setName(String name) {
		if(name.matches("[a-zA-Z]+")) {	
			this.name = name;
		} else {
			this.name = "Initiative #"+id;
		}
		}
	public LocalDateTime getDate() {return date;}
	public String getDateAsString() {
		return format.format(date);
	}
	public String getExpirationDateAsString() {
		return format.format(date.plusHours(time));
	}
	public void setDate(String date) {
		try {
		this.date = LocalDateTime.parse(date,format);
		}catch(DateTimeParseException e) {
			e.printStackTrace();
			this.date = LocalDateTime.now();
		}
	}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public List<User> getVolunteers() {return volunteers;}
	public void setVolunteers(List<User> volunteers) {this.volunteers = volunteers;}
	public User getInitiator() {return initiator;}
	public void setInitiator(User initiator) {
		this.initiator = initiator;
		}
	public void setStatus(String status) {
		if (status.equals("pending") || status.equals("active") || status.equals("expired")) {
			this.status = status;
		} else {
			this.status = "pending";
		}
	}
	

}
